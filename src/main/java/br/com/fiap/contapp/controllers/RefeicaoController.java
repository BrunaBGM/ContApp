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

import br.com.fiap.contapp.models.Refeicao;
import br.com.fiap.contapp.models.Usuario;



public class RefeicaoController {
    
    Logger log = LoggerFactory.getLogger(UsuarioController.class);
    
    List<Refeicao> refeicoes = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Refeicao>> listar() {
        return ResponseEntity.ok(refeicoes);
    }

    @PostMapping("/api/refeicoes")
    public ResponseEntity<Refeicao> cadastrar(@RequestBody Refeicao refeicao){
        log.info("cadastrando refeicao: " + refeicao);
        refeicao.setRefeicaoId(refeicoes.size() + 1l);
        refeicoes.add(refeicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(refeicao);
    }

    @GetMapping("/api/refeicoes/{refeicaoId}")
    public ResponseEntity<Refeicao> mostrarDetalhe(@PathVariable Long refeicaoId){
        log.info("Buscando refeicao pelo id " + refeicaoId);
        var refeicaoEncontrada = refeicoes.stream().filter(d -> d.getRefeicaoId().equals(refeicaoId)).findFirst();

        if (refeicaoEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(refeicaoEncontrada.get());

    }

    @DeleteMapping("/api/refeicoes/{refeicaoId}")
    public ResponseEntity<Usuario> apagar(@PathVariable Long refeicaoId){
        log.info("Deletando refeicao" + refeicaoId);
        var refeicaoEncontrada = refeicoes.stream().filter(d -> d.getRefeicaoId().equals(refeicaoId)).findFirst();

        if (refeicaoEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            refeicoes.remove(refeicaoEncontrada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


        @PutMapping("/api/refeicoes/{refeicaoId}")
    public ResponseEntity<Refeicao> atualizar(@PathVariable Long refeicaoId, @RequestBody Refeicao refeicao){
        log.info("alterando refeicao pelo id " + refeicaoId);
        var refeicaoEncontrada = refeicoes.stream().filter(d -> d.getRefeicaoId().equals(refeicaoId)).findFirst();

        if (refeicaoEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Refeicao refeicaoAtualizada = refeicaoEncontrada.get();
        refeicaoAtualizada.setRefeicaoId(refeicaoId);

        refeicoes.remove(refeicaoEncontrada.get());
        refeicoes.add(refeicaoAtualizada);

        return ResponseEntity.ok(refeicaoAtualizada);
    }
}
