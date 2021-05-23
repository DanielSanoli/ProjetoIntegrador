package br.com.application.models;

public class Produto {
    private String descricao;
    private int departamento;
    private double valor;
    private int codigo;
    private int estoqueAtual;

    public Produto(String descricao, int departamento, double valor, int codigo, int estoqueAtual) {
        this.descricao = descricao;
        this.departamento = departamento;        
        this.valor = valor;
        this.codigo = codigo;
        this.estoqueAtual = estoqueAtual;
    }
    
    public Produto() {
    }    

    public int getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(int estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
