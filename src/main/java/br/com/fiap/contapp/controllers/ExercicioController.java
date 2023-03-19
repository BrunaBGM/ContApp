package br.com.fiap.contapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fiap.contapp.models.Exercicio;

public class ExercicioController {
    Logger log = LoggerFactory.getLogger(ExercicioController.class);
    
    List<Exercicio> exercicios = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Exercicio>> listar() {
        return ResponseEntity.ok(exercicios);
    }

    @PostMapping("/api/exercicios")
    public ResponseEntity<Exercicio> cadastrar(@RequestBody Exercicio exercicio){
        log.info("cadastrando exercicio: " + exercicio);
        exercicio.setExercicioId(exercicios.size() + 1l);
        exercicios.add(exercicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(exercicio);
    }

    @GetMapping("/api/exercicios/{exercicioId}")
    public ResponseEntity<Exercicio> mostrarDetalhe(@PathVariable Long exercicioId){
        log.info("Buscando exercicio pelo id " + exercicioId);
        var exercicioEncontrado = exercicios.stream().filter(d -> d.getExercicioId().equals(exercicioId)).findFirst();

        if (exercicioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(exercicioEncontrado.get());

    }

    @DeleteMapping("/api/exercicios/{exercicioId}")
    public ResponseEntity<Exercicio> apagar(@PathVariable Long exercicioId){
        log.info("Deletando exercicio " + exercicioId);
        var exercicioEncontrado = exercicios.stream().filter(d -> d.getExercicioId().equals(exercicioId)).findFirst();

        if (exercicioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            exercicios.remove(exercicioEncontrado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


        @PutMapping("/api/exercicios/{exercicioId}")
    public ResponseEntity<Exercicio> atualizar(@PathVariable Long exercicioId, @RequestBody Exercicio exercicio){
        log.info("Alterando exercicio pelo id" + exercicioId);
        var exercicioEncontrado = exercicios.stream().filter(d -> d.getExercicioId().equals(exercicioId)).findFirst();

        if (exercicioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Exercicio exercicioAtualizado = exercicioEncontrado.get();
        exercicioAtualizado.setExercicioId(exercicioId);

        exercicios.remove(exercicioEncontrado.get());
        exercicios.add(exercicioAtualizado);

        return ResponseEntity.ok(exercicioAtualizado);
    }
}
