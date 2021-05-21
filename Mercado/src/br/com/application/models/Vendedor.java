package br.com.application.models;


public class Vendedor {
    private int codigo;
    private String email;
    private double salario;
    private String nome;
    private String telefone;
    
    public Vendedor() {
    }

    public Vendedor(int codigo, String email, double salario, String nome, String telefone) {
        this.codigo = codigo;
        this.email = email;
        this.salario = salario;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }    
}
