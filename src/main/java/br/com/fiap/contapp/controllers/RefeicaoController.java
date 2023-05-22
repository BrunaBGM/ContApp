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
import jakarta.validation.Valid;

import br.com.fiap.contapp.repository.RefeicaoRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import br.com.fiap.contapp.exception.RestNotFoundException;
import br.com.fiap.contapp.models.Refeicao;
import br.com.fiap.contapp.models.Usuario;

@RestController
@RequestMapping("/api/refeicoes")
@SecurityRequirement(name = "bearer-key")
public class RefeicaoController {

    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    RefeicaoRepository refeicaoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> listar(@RequestParam(required = false) String busca,
            @ParameterObject @PageableDefault(size = 5) Pageable pageable) {
        Page<Refeicao> refeicao = (busca == null) ? refeicaoRepository.findAll(pageable)
                : refeicaoRepository.findByDescricaoContaining(busca, pageable);

        return assembler.toModel(refeicao.map(Refeicao::toModel));
    }
    @PostMapping
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "refeicao cadastrada com sucesso"),
        @ApiResponse(responseCode = "400", description = "erro na validação dos dados da requisição")
    })

    public ResponseEntity<Refeicao> cadastrar(@RequestBody @Valid Refeicao refeicao) {
        log.info("cadastrando refeicao: " + refeicao);
        refeicaoRepository.save(refeicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(refeicao);
    }

    @GetMapping("{refeicaoId}")
    public ResponseEntity<Refeicao> mostrarDetalhe(@PathVariable Long refeicaoId) {
        log.info("Buscando refeicao pelo id " + refeicaoId);
        var refeicaoEncontrada = refeicaoRepository.findById(refeicaoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "refeição não encontrada"));

        return ResponseEntity.ok(refeicaoEncontrada);

    }

    @DeleteMapping("{refeicaoId}")
    public ResponseEntity<Usuario> apagar(@PathVariable Long refeicaoId) {
        log.info("Deletando refeicao" + refeicaoId);
        var refeicaoEncontrada = refeicaoRepository.findById(refeicaoId)
                .orElseThrow(() -> new RestNotFoundException("refeição não encontrada"));

        refeicaoRepository.delete(refeicaoEncontrada);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("{refeicaoId}")
    public ResponseEntity<Refeicao> atualizar(@PathVariable Long refeicaoId, @RequestBody @Valid Refeicao refeicao) {
        log.info("alterando refeicao pelo id " + refeicaoId);
        refeicaoRepository.findById(refeicaoId)
                .orElseThrow(() -> new RestNotFoundException("refeição não encontrada"));

        refeicao.setRefeicaoId(refeicaoId);
        refeicaoRepository.save(refeicao);

        return ResponseEntity.ok(refeicao);
    }


}
