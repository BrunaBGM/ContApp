package br.com.fiap.contapp.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
    private float peso;
    @NotNull
    private float altura;
    @NotNull
    private LocalDate data;


    public Usuario(Long usuarioId,String nome, String email, String senha, String genero, int idade, float peso, float altura, LocalDate data) {
        
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.genero = genero;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.data = data;

    }

    protected Usuario(){

    }
    
    public Long getUsuarioId() {
        return usuarioId;
    }


    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getGenero() {
        return genero;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


    public int getIdade() {
        return idade;
    }


    public void setIdade(int idade) {
        this.idade = idade;
    }


    public float getPeso() {
        return peso;
    }


    public void setPeso(float peso) {
        this.peso = peso;
    }


    public float getAltura() {
        return altura;
    }


    public void setAltura(float altura) {
        this.altura = altura;
    }


    public LocalDate getData() {
        return data;
    }


    public void setData(LocalDate data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Usuario [id=" + usuarioId +", nome=" + nome + ", email=" + email + ", senha=" + senha + ", data de criação=" + data + "]";
    }
    
}