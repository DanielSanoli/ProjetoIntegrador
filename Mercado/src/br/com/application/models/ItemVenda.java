package br.com.application.models;

/**
 *
 * @author Jamile
 */
public class ItemVenda {

    private int numeroVenda;
    private int codigoProduto;
    private int quantidadeProduto;

    public ItemVenda() {

    }

    public ItemVenda(int numeroVenda, int codigoProduto, int quantidadeProduto) {
        this.numeroVenda = numeroVenda;
        this.codigoProduto = codigoProduto;
        this.quantidadeProduto = quantidadeProduto;
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

}
