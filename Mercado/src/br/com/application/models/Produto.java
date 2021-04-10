
package br.com.application.models;

public class Produto {
    private String descricao;
    private String departamento;
    private String dataDeValidade;
    private int quantidade;
    private double valor;
    private int codigo;
    
    public Produto() {
    }

    public Produto(String descricao, String departamento, String dataDeValidade, int quantidade, double valor, int codigo) {
        this.descricao = descricao;
        this.departamento = departamento;
        this.dataDeValidade = dataDeValidade;
        this.quantidade = quantidade;
        this.valor = valor;
        this.codigo = codigo;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(String dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}