package br.com.fiap.contapp.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.contapp.models.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    
}
