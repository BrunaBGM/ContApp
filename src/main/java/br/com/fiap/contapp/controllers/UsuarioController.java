package br.com.fiap.contapp.controllers;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.contapp.exception.RestNotFoundException;
import br.com.fiap.contapp.repository.ExercicioRepository;
import br.com.fiap.contapp.repository.RefeicaoRepository;
import br.com.fiap.contapp.repository.UsuarioRepository;
import br.com.fiap.contapp.service.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import br.com.fiap.contapp.models.Credencial;
import br.com.fiap.contapp.models.Usuario;

@RestController
// @RequestMapping("/api/usuarios")
@Tag(name = "auth")
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(UsuarioController.class);
    

    @Autowired //IoD IoC
    UsuarioRepository usuarioRepository;

    @Autowired
    ExercicioRepository exercicioRepository;

    @Autowired
    RefeicaoRepository refeicaoRepository;

    @Autowired
    AuthenticationManager manager;
    
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    TokenService tokenService;

    @PostMapping("/api/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid Usuario usuario){
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PostMapping("/api/login")
    public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial){
        manager.authenticate(credencial.toAuthentication());
        var token = tokenService.generateToken(credencial);
        return ResponseEntity.ok(token);
    }

    @GetMapping("{usuarioId}")
    public ResponseEntity<Usuario> mostrarDetalhe(@PathVariable Long usuarioId){
        log.info("Buscando usuario pelo id " + usuarioId);
        var usuarioEncontrado = usuarioRepository.findById(usuarioId)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "usuário não encontrado"));
                return ResponseEntity.ok(usuarioEncontrado);
    }

    @DeleteMapping("{usuarioId}")
    public ResponseEntity<Usuario> apagar(@PathVariable Long usuarioId){
        log.info("Deletando usuario " + usuarioId);
        var usuarioEncontrado = usuarioRepository.findById(usuarioId)
                                .orElseThrow(() -> new RestNotFoundException("usuário não encontrado"));

          usuarioRepository.delete(usuarioEncontrado);

        return ResponseEntity.noContent().build();  

    }

        @PutMapping("{usuarioId}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long usuarioId, @RequestBody @Valid Usuario usuario){
        log.info("Alterando usuario pelo id " + usuarioId);
        usuarioRepository.findById(usuarioId)
                                .orElseThrow(() -> new RestNotFoundException("usuário não encontrado"));

        usuario.setUsuarioId(usuarioId);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuario);
    }
    
    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum usuário encontrado");
        }
                return ResponseEntity.ok(usuarios);
                                
    }

}
