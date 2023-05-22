package br.com.fiap.contapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import org.springframework.hateoas.EntityModel;

import br.com.fiap.contapp.controllers.ExercicioController;

import org.springframework.data.domain.Pageable;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exercicioId;
    @NotNull
    private String nome;
    @Size(min = 5, max = 255)
    private String descricao;
    private String categoria;
    private int duracao;
    private int distancia;
    private int peso;
    private int repeticoes;
    private int series;
    @NotNull
    private LocalDate data;

    @NotNull
    @ManyToOne
    private Usuario usuario;

    public EntityModel<Exercicio> toModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(ExercicioController.class).mostrarDetalhe(exercicioId)).withSelfRel(),
            linkTo(methodOn(ExercicioController.class).apagar(exercicioId)).withRel("delete"),
            linkTo(methodOn(ExercicioController.class).listar(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(ExercicioController.class).mostrarDetalhe(this.getUsuario().getUsuarioId())).withRel("usuario")
        );
    }

    
}

