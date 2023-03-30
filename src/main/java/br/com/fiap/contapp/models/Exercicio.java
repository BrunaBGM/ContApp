package br.com.fiap.contapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

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
    @NotNull
    private LocalDate data;

    public Exercicio(Long exerciocioId,String nome, String descricao, String categoria,int duracao,int distancia,int peso,int repeticoes,LocalDate data) {
        this.exercicioId = exerciocioId;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.duracao = duracao;
        this.distancia = distancia;
        this.peso = peso;
        this.repeticoes = repeticoes;
        this.data = data;
    }
    
    public Long getExercicioId() {
        return exercicioId;
    }



    public void setExercicioId(Long exercicioId) {
        this.exercicioId = exercicioId;
    }

    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getDescricao() {
        return descricao;
    }



    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getCategoria() {
        return categoria;
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
    public int getDuracao() {
        return duracao;
    }


    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getDistancia() {
        return distancia;
    }


    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getPeso() {
        return peso;
    }


    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }
    
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Exercicio [id=" + exercicioId + ", nome=" + nome + ", descrição =" + descricao + ", categoria=" + categoria + ", duração=" + duracao + ", distância=" + distancia + ", peso=" + peso +", repetições=" + repeticoes +", exercício realizado em=" + data="]";
    }
    
}

