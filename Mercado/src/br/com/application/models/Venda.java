
package br.com.application.models;

public class Venda {

    private String dataDeVenda;
    private int codigoVenda;
    private int quantidade;
    private double valorUnitario;
    private double valorTotal;
    
    public Venda() {
    }

    public Venda(String dataDeVenda, int quantidade, double valorUnitario, double valorTotal) {
        this.dataDeVenda = dataDeVenda;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }
    
    

    public String getDataDeVenda() {
        return dataDeVenda;
    }

    public void setDataDeVenda(String dataDeVenda) {
        this.dataDeVenda = dataDeVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }
    
    
    
}
