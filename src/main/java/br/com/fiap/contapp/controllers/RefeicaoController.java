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
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;

import br.com.fiap.contapp.repository.RefeicaoRepository;
import br.com.fiap.contapp.exception.RestNotFoundException;
import br.com.fiap.contapp.models.Refeicao;
import br.com.fiap.contapp.models.Usuario;

@RestController
@RequestMapping("/api/refeicoes")
public class RefeicaoController {
    
    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    RefeicaoRepository repository;

    @GetMapping
    public List<Refeicao> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Refeicao> cadastrar(@RequestBody @Valid Refeicao refeicao){
        log.info("cadastrando refeicao: " + refeicao);
        repository.save(refeicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(refeicao);
    }

    @GetMapping("{refeicaoId}")
    public ResponseEntity<Refeicao> mostrarDetalhe(@PathVariable Long refeicaoId){
        log.info("Buscando refeicao pelo id " + refeicaoId);
        var refeicaoEncontrada = repository.findById(refeicaoId)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "refeição não encontrada"));

        return ResponseEntity.ok(refeicaoEncontrada);

    }

    @DeleteMapping("{refeicaoId}")
    public ResponseEntity<Usuario> apagar(@PathVariable Long refeicaoId){
        log.info("Deletando refeicao" + refeicaoId);
        var refeicaoEncontrada = repository.findById(refeicaoId)
                                .orElseThrow(() -> new RestNotFoundException("refeição não encontrada"));

            repository.delete(refeicaoEncontrada);

        return ResponseEntity.noContent().build();

    }


    @PutMapping("{refeicaoId}")
    public ResponseEntity<Refeicao> atualizar(@PathVariable Long refeicaoId, @RequestBody @Valid Refeicao refeicao){
        log.info("alterando refeicao pelo id " + refeicaoId);
            repository.findById(refeicaoId)
                                .orElseThrow(() -> new RestNotFoundException("refeição não encontrada"));

        refeicao.setRefeicaoId(refeicaoId);
            repository.save(refeicao);

        return ResponseEntity.ok(refeicao);
    }
}
