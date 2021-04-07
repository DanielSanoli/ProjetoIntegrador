
package br.com.application.classes;

public class Produto {
    private String desccricao;
    private String departamento;
    private String dataDeValidade;
    private int quantidade;
    private double valor;

    public Produto() {
    }

    public String getDesccricao() {
        return desccricao;
    }

    public void setDesccricao(String desccricao) {
        this.desccricao = desccricao;
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
