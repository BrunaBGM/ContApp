package br.com.fiap.contapp.models;

public class Refeicao {
    
    private Long refeicaoId;
    private String categoriaRefeicao;
    private String nome;
    private String categoriaAlimento;
    private String descricao;
    private int calorias;
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
