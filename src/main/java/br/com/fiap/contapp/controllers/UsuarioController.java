package br.com.fiap.contapp.controllers;
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
import br.com.fiap.piggybank.exception.RestNotFoundException;

import br.com.fiap.contapp.repository.UsuarioRepository;
import br.com.fiap.contapp.models.RestError;
import jakarta.validation.Valid;
import br.com.fiap.contapp.models.Usuario;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(UsuarioController.class);
    

    @Autowired //IoD IoC
    UsuarioRepository repository;

    @GetMapping 
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid Usuario usuario){
        log.info("cadastrando usuario: " + usuario);
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("{usuarioId}")
    public ResponseEntity<Usuario> mostrarDetalhe(@PathVariable Long usuarioId){
        log.info("Buscando usuario pelo id " + usuarioId);
        var usuarioEncontrado = repository.findById(usuarioId)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "usuário não encontrado"));

        return ResponseEntity.ok(usuarioEncontrado);

    }

    @DeleteMapping("{usuarioId}")
    public ResponseEntity<Usuario> apagar(@PathVariable Long usuarioId){
        log.info("Deletando usuario " + usuarioId);
        var usuarioEncontrado = repository.findById(usuarioId)
                                .orElseThrow(() -> new RestNotFoundException("usuário não encontrado"));

            repository.delete(usuarioEncontrado);

        return ResponseEntity.noContent().build();

    }

        @PutMapping("{usuarioId}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long usuarioId, @RequestBody @Valid Usuario usuario){
        log.info("Alterando usuario pelo id " + usuarioId);
        var usuarioEncontrado = repository.findById(usuarioId)
                                .orElseThrow(() -> new RestNotFoundException("usuário não encontrado"));

        Usuario usuarioAtualizado = usuarioEncontrado.get();
        usuarioAtualizado.setUsuarioId(usuarioId);
       
        repository.save(usuarioAtualizado);
        return ResponseEntity.ok(usuarioAtualizado);
    }

}
