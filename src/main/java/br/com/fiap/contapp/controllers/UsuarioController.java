package br.com.fiap.contapp.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.contapp.models.Usuario;
import java.util.Date;

@RestController
public class UsuarioController {

    @GetMapping("/api/usuario")
    public Usuario show() {
        
        var usuario = new Usuario(
            1,
            "Fulano de Tal",
            "fulano@example.com",
            "minhaSenha",
            "Masculino",
            30,
            70.5f,
            1.75f,
            new Date()
        );
    
        return usuario;
    
    }
}
