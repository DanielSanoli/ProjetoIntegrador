package br.com.application.models;

import java.sql.Date;

public class Pedido {

    private int numeroPedido;
    private Date dataDoPedido;
    private int codigoVendedor;
    private int codigoCliente;

    public Pedido() {
    }

    public Pedido(int numeroPedido, Date dataDoPedido, int codigoVendedor, int codigoCliente) {
        this.numeroPedido = numeroPedido;
        this.dataDoPedido = dataDoPedido;
        this.codigoVendedor = codigoVendedor;
        this.codigoCliente = codigoCliente;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getDataDoPedido() {
        return dataDoPedido;
    }

    public void setDataDoPedido(Date dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }

    public int getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

}
