package br.com.fiap.contapp.models;

import java.time.LocalDate;


import org.springframework.hateoas.EntityModel;
import org.springframework.data.domain.Pageable;
import br.com.fiap.contapp.controllers.RefeicaoController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Refeicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refeicaoId;
    @NotNull @Pattern(regexp = "^(cafe da manha|almoco|jantar|lanche)$", message = "Escolha entre as opções: café da manhã, almoço ou jantar")
    private String categoriaRefeicao;
    @NotNull
    private String nome;
    @NotNull
    private String categoriaAlimento;
    @Size(min = 5, max = 255)
    private String descricao;
    @NotNull
    private int calorias;
    @NotNull
    private int quantidade;
    @NotNull
    private LocalDate data;

    @NotNull
    @ManyToOne
    private Usuario usuario;

    public EntityModel<Refeicao> toModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(RefeicaoController.class).mostrarDetalhe(refeicaoId)).withSelfRel(),
            linkTo(methodOn(RefeicaoController.class).apagar(refeicaoId)).withRel("delete"),
            linkTo(methodOn(RefeicaoController.class).listar(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(RefeicaoController.class).mostrarDetalhe(this.getUsuario().getUsuarioId())).withRel("usuario")
        );
    }

}
