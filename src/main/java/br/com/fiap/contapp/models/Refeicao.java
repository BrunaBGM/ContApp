package br.com.fiap.contapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

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
    
}
