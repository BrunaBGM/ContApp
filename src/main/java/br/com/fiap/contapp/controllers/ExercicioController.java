package br.com.fiap.contapp.controllers;

import java.util.ArrayList;
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

@RestController
@RequestMapping("/api/exercicios")
public class ExercicioController {
    Logger log = LoggerFactory.getLogger(ExercicioController.class);
    
    List<Exercicio> exercicios = new ArrayList<>();

    @Autowired
    ExercicioRepository repository;

    @GetMapping
    public List<Exercicio> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Exercicio> cadastrar(@RequestBody Exercicio exercicio){
        log.info("cadastrando exercicio: " + exercicio);
        repository.save(exercicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(exercicio);
    }

    @GetMapping("{exercicioId}")
    public ResponseEntity<Exercicio> mostrarDetalhe(@PathVariable Long exercicioId){
        log.info("Buscando exercicio pelo id " + exercicioId);
        var exercicioEncontrado = repository.findById(exercicioId);

        if (exercicioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(exercicioEncontrado.get());

    }

    @DeleteMapping("{exercicioId}")
    public ResponseEntity<Exercicio> apagar(@PathVariable Long exercicioId){
        log.info("Deletando exercicio " + exercicioId);
        var exercicioEncontrado = repository.findById(exercicioId);

        if (exercicioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            repository.delete(exercicioEncontrado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


        @PutMapping("{exercicioId}")
    public ResponseEntity<Exercicio> atualizar(@PathVariable Long exercicioId, @RequestBody Exercicio exercicio){
        log.info("Alterando exercicio pelo id" + exercicioId);
        var exercicioEncontrado = repository.findById(exercicioId);

        if (exercicioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Exercicio exercicioAtualizado = exercicioEncontrado.get();
        exercicioAtualizado.setExercicioId(exercicioId);

        repository.save(exercicioAtualizado);
        return ResponseEntity.ok(exercicioAtualizado);
    }
}
