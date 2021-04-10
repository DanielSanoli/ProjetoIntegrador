
package br.com.application.models;

public class Produto {
    private String descricao;
    private String departamento;
    private String dataDeValidade;
    private double valor;
    private int codigo;
    private int estoqueAtual;

    public Produto(String descricao, String departamento, String dataDeValidade, double valor, int codigo, int estoqueAtual) {
        this.descricao = descricao;
        this.departamento = departamento;
        this.dataDeValidade = dataDeValidade;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
