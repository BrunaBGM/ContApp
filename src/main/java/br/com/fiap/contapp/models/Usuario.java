package br.com.fiap.contapp.models;

import java.time.LocalDate;

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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;
    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull @Size(min = 6, max = 20)
    private String senha;
    @NotNull @Pattern(regexp = "^(feminino|masculino)$", message = "Escolha entre as opções: feminino ou masculino")
    private String genero;
    private int idade;
    @NotNull
    private Double peso;
    @NotNull
    private Double altura;
    @NotNull
    private LocalDate data;

}