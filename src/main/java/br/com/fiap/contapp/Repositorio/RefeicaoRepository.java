package br.com.fiap.contapp.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.contapp.models.Refeicao;

public interface RefeicaoRepository extends JpaRepository<Refeicao, Long>{
    
}
