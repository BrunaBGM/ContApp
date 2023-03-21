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
import br.com.fiap.contapp.Repositorio.UsuarioRepository;
import br.com.fiap.contapp.models.Usuario;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(UsuarioController.class);
    
    List<Usuario> usuarios = new ArrayList<>();

    @Autowired //IoD IoC
    UsuarioRepository repository;

    @GetMapping 
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
        log.info("cadastrando usuario: " + usuario);
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("{usuarioId}")
    public ResponseEntity<Usuario> mostrarDetalhe(@PathVariable Long usuarioId){
        log.info("Buscando usuario pelo id " + usuarioId);
        var usuarioEncontrado = repository.findById(usuarioId);

        if (usuarioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(usuarioEncontrado.get());

    }

    @DeleteMapping("{usuarioId}")
    public ResponseEntity<Usuario> apagar(@PathVariable Long usuarioId){
        log.info("Deletando usuario " + usuarioId);
        var usuarioEncontrado = repository.findById(usuarioId);

        if (usuarioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            repository.delete(usuarioEncontrado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

        @PutMapping("{usuarioId}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long usuarioId, @RequestBody Usuario usuario){
        log.info("Alterando usuario pelo id " + usuarioId);
        var usuarioEncontrado = repository.findById(usuarioId);

        if (usuarioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Usuario usuarioAtualizado = usuarioEncontrado.get();
        usuarioAtualizado.setUsuarioId(usuarioId);
       
        repository.save(usuarioAtualizado);
        return ResponseEntity.ok(usuarioAtualizado);
    }

}
