package br.com.fiap.contapp.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.contapp.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}