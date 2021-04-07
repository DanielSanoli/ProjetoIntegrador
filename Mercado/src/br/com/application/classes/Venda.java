
package br.com.application.classes;

public class Venda {

    private String dataDeVenda;
    private int quantidade;
    private double valorUnitario;
    private double valorTotal;
    
    public Venda() {
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
    
    
}
