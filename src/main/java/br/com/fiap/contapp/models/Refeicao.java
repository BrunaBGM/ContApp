package br.com.fiap.contapp.models;

import java.time.LocalDate;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Refeicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refeicaoId;
    @NotNull @Pattern(regexp = "^(café da manhã|almoço|jantar)$", message = "Escolha entre as opções: café da manhã, almoço ou jantar")
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
}
