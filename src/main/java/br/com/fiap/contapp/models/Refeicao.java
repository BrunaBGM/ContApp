package br.com.fiap.contapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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

    public Refeicao(Long refeicaoId, String categoriaRefeicao, String nome, String categoriaAlimento, String descricao, int calorias, int quantidade) {
        this.refeicaoId = refeicaoId;
        this.categoriaRefeicao = categoriaRefeicao;
        this.nome = nome;
        this.categoriaAlimento = categoriaAlimento;
        this.descricao = descricao;
        this.calorias = calorias;
        this.quantidade = quantidade;
    }

    public Long getRefeicaoId() {
        return refeicaoId;
    }

    public void setRefeicaoId(Long refeicaoId) {
        this.refeicaoId = refeicaoId;
    }

    public String getCategoriaRefeicao() {
        return categoriaRefeicao;
    }

    public void setCategoriaRefeicao(String categoriaRefeicao) {
        this.categoriaRefeicao = categoriaRefeicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoriaAlimento() {
        return categoriaAlimento;
    }

    public void setCategoriaAlimento(String categoriaAlimento) {
        this.categoriaAlimento = categoriaAlimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Refeicao[refeicaoId=" + refeicaoId +
                ", categoriaRefeicao='" + categoriaRefeicao + '\'' +
                ", nome='" + nome + '\'' +
                ", categoriaAlimento='" + categoriaAlimento + '\'' +
                ", descricao='" + descricao + '\'' +
                ", calorias=" + calorias +
                ", quantidade=" + quantidade +
                ']';
    }
}
