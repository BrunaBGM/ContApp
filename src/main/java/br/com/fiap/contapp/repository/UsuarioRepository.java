package br.com.fiap.contapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.contapp.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Page<Usuario> findByDescricaoContaining(String descricao, Pageable pageable);
}