package br.com.fiap.contapp.models;

public class Exercicio {

    private Long exercicioId;
    private String nome;
    private String descricao;
    private String categoria;
    private int duracao; 
    private int distancia;  
    private int peso;
    private int repeticoes;

    public Exercicio(Long exerciocioId,String nome, String descricao, String categoria,int duracao,int distancia,int peso,int repeticoes) {
        this.exercicioId = exerciocioId;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.duracao = duracao;
        this.distancia = distancia;
        this.peso = peso;
        this.repeticoes = repeticoes;
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

    @Override
    public String toString() {
        return "Exercicio [id=" + exercicioId + ", nome=" + nome + ", descrição =" + descricao + ", categoria=" + categoria + ", duração=" + duracao + ", distância=" + distancia + ", peso=" + peso +", repetições=" + repeticoes +"]";
    }
    
}

