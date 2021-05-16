package br.com.application.models;

public class itemPedido {

    // FK's
    private int numeroPedido;
    private int codigoProduto;
    private int quantidadeProduto;

    public itemPedido() {
    }

    public itemPedido(int numeroPedido, int codigoProduto, int quantidadeProduto) {
        this.numeroPedido = numeroPedido;
        this.codigoProduto = codigoProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
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
