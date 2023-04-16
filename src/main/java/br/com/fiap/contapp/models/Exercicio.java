package br.com.fiap.contapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    
}

