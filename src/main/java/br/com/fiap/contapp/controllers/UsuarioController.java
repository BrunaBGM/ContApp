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
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.contapp.exception.RestNotFoundException;
import br.com.fiap.contapp.repository.ExercicioRepository;
import br.com.fiap.contapp.repository.RefeicaoRepository;
import br.com.fiap.contapp.repository.UsuarioRepository;
import jakarta.validation.Valid;
import br.com.fiap.contapp.models.Usuario;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(UsuarioController.class);
    

    @Autowired //IoD IoC
    UsuarioRepository usuariorepository;

    @Autowired
    ExercicioRepository exerciciorepository;

    @Autowired
    RefeicaoRepository refeicaorepository;

    @GetMapping 
    public List<Usuario> listar() {
        return usuariorepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid Usuario usuario){
        log.info("cadastrando usuario: " + usuario);
        usuariorepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("{usuarioId}")
    public ResponseEntity<Usuario> mostrarDetalhe(@PathVariable Long usuarioId){
        log.info("Buscando usuario pelo id " + usuarioId);
        var usuarioEncontrado = usuariorepository.findById(usuarioId)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "usuário não encontrado"));

        return ResponseEntity.ok(usuarioEncontrado);

    }

    @DeleteMapping("{usuarioId}")
    public ResponseEntity<Usuario> apagar(@PathVariable Long usuarioId){
        log.info("Deletando usuario " + usuarioId);
        var usuarioEncontrado = usuariorepository.findById(usuarioId)
                                .orElseThrow(() -> new RestNotFoundException("usuário não encontrado"));

            usuariorepository.delete(usuarioEncontrado);

        return ResponseEntity.noContent().build();

    }

        @PutMapping("{usuarioId}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long usuarioId, @RequestBody @Valid Usuario usuario){
        log.info("Alterando usuario pelo id " + usuarioId);
        usuariorepository.findById(usuarioId)
                                .orElseThrow(() -> new RestNotFoundException("usuário não encontrado"));

        usuario.setUsuarioId(usuarioId);
        usuariorepository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

}
