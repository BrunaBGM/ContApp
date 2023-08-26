package br.com.fiap.contapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.contapp.repository.ExercicioRepository;
import br.com.fiap.contapp.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import br.com.fiap.contapp.models.Exercicio;
import br.com.fiap.contapp.exception.RestNotFoundException;

@RestController
@RequestMapping("/api/exercicios")
public class ExercicioController {
    Logger log = LoggerFactory.getLogger(ExercicioController.class);

    @Autowired
    ExercicioRepository exercicioRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    // @GetMapping
    // public PagedModel<EntityModel<Object>> listarPage(@RequestParam(required = false) String busca,
    //         @ParameterObject @PageableDefault(size = 5) Pageable pageable) {
    //     Page<Exercicio> exercicios = (busca == null) ? exercicioRepository.findAll(pageable)
    //             : exercicioRepository.findByDescricaoContaining(busca, pageable);

    //     return assembler.toModel(exercicios.map(Exercicio::toModel));
    // }

    // assembler

    @GetMapping
    public Page<Exercicio> listar(@RequestParam(required = false) String descricao,
            @PageableDefault(size = 5) Pageable pageable) {
        if (descricao == null)
            return exercicioRepository.findAll(pageable);
        return exercicioRepository.findByDescricaoContaining(descricao, pageable);

    }

    @PostMapping
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "exercicio cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "erro na validação dos dados da requisição")
    })

    public ResponseEntity<Object> cadastrar(@RequestBody @Valid Exercicio exercicio) {
        log.info("cadastrando exercicio: " + exercicio);
        exercicioRepository.save(exercicio);
        exercicio.setUsuario(usuarioRepository.findById(exercicio.getUsuario().getUsuarioId()).get());
        return ResponseEntity
                .created(exercicio.toModel().getRequiredLink("self").toUri())
                .body(exercicio.toModel());
    }

    @GetMapping("{exercicioId}")
    @Operation(summary = "Detalhes Exercicio", description = "Retorna os dados de um exercicio com id especificado")
    public EntityModel<Exercicio> mostrarDetalhe(@PathVariable Long exercicioId) {
        log.info("Buscando exercicio pelo id " + exercicioId);
        var exercicioEncontrado = exercicioRepository.findById(exercicioId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "exercicio não encontrado"));

        return exercicioEncontrado.toModel();
    }

    @DeleteMapping("{exercicioId}")
    public ResponseEntity<Exercicio> apagar(@PathVariable Long exercicioId) {
        log.info("Deletando exercicio " + exercicioId);
        var exercicioEncontrado = exercicioRepository.findById(exercicioId)
                .orElseThrow(() -> new RestNotFoundException("exercicio não encontrado"));

        exercicioRepository.delete(exercicioEncontrado);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("{exercicioId}")
    public EntityModel<Exercicio> atualizar(@PathVariable Long exercicioId,
            @RequestBody @Valid Exercicio exercicio) {
        log.info("Alterando exercicio pelo id" + exercicioId);
        exercicioRepository.findById(exercicioId)
                .orElseThrow(() -> new RestNotFoundException("exercicio não encontrado"));

        exercicio.setExercicioId(exercicioId);
        exercicioRepository.save(exercicio);
        return exercicio.toModel();
    }
}
