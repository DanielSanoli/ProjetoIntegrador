package br.com.application.models;

/**
 *
 * @author Jamile
 */
public class ItemVenda {

    private int numeroVenda;
    private int codigoProduto;
    private int quantidadeProduto;
    private Double precoUnitario;
    private Double subTotal;

    public ItemVenda() {
    }

    public ItemVenda(int numeroVenda, int codigoProduto, int quantidadeProduto, Double precoUnitario, Double subTotal) {
        this.numeroVenda = numeroVenda;
        this.codigoProduto = codigoProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.precoUnitario = precoUnitario;
        this.subTotal = subTotal;
    }

    public int getNumeroVenda() {
        return numeroVenda;
    }

    public void setNumeroVenda(int numeroVenda) {
        this.numeroVenda = numeroVenda;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

}
