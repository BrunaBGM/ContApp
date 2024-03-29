package br.com.fiap.contapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.contapp.models.Refeicao;

public interface RefeicaoRepository extends JpaRepository<Refeicao, Long>{

    Page<Refeicao> findByDescricaoContaining(String descricao, Pageable pageable);
}
