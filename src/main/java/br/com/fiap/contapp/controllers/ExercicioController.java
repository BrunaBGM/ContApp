package br.com.fiap.contapp.controllers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.contapp.Repositorio.ExercicioRepository;
import br.com.fiap.contapp.models.Exercicio;

import br.com.fiap.contapp.exception.RestNotFoundException;

@RestController
@RequestMapping("/api/exercicios")
public class ExercicioController {
    Logger log = LoggerFactory.getLogger(ExercicioController.class);
    

    @Autowired
    ExercicioRepository repository;

    @GetMapping
    public List<Exercicio> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Exercicio> cadastrar(@RequestBody @Valid Exercicio exercicio){
        log.info("cadastrando exercicio: " + exercicio);
        repository.save(exercicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(exercicio);
    }

    @GetMapping("{exercicioId}")
    public ResponseEntity<Exercicio> mostrarDetalhe(@PathVariable Long exercicioId){
        log.info("Buscando exercicio pelo id " + exercicioId);
        var exercicioEncontrado = repository.findById(exercicioId)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "exercicio não encontrado"));
            
            return ResponseEntity.ok(exercicioEncontrado);

    }

    @DeleteMapping("{exercicioId}")
    public ResponseEntity<Exercicio> apagar(@PathVariable Long exercicioId){
        log.info("Deletando exercicio " + exercicioId);
        var exercicioEncontrado = repository.findById(exercicioId)
                                .orElseThrow(() -> new RestNotFoundException("exercicio não encontrado"));

            repository.delete(exercicioEncontrado);

        return ResponseEntity.noContent().build();

    }


    @PutMapping("{exercicioId}")
    public ResponseEntity<Exercicio> atualizar(@PathVariable Long exercicioId, @RequestBody @Valid Exercicio exercicio){
        log.info("Alterando exercicio pelo id" + exercicioId);
        var exercicioEncontrado = repository.findById(exercicioId)
                                .orElseThrow(() -> new RestNotFoundException("exercicio não encontrado"));


        Exercicio exercicioAtualizado = exercicioEncontrado.get();
        exercicioAtualizado.setExercicioId(exercicioId);

        repository.save(exercicioAtualizado);
        return ResponseEntity.ok(exercicioAtualizado);
    }
}
