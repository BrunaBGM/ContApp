package br.com.fiap.contapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.contapp.models.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    
    Page<Exercicio> findByDescricaoContaining(String descricao, Pageable pageable);
}
