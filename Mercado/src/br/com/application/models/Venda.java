
package br.com.application.models;

import java.sql.Date;
import java.util.ArrayList;

public class Venda {

    private Date dataDeVenda;
    private int codigoVenda;
    private int codigo;
    private double valorTotal;
    private ArrayList<ItemVenda> listaItens = new ArrayList<>();
    
    
    public Venda() {
    }

    public Venda(Date dataDeVenda,  double valorTotal, int codigoVenda, ArrayList<ItemVenda> listaItens) {
        this.dataDeVenda = dataDeVenda;
        this.codigoVenda = codigoVenda;
        this.codigo = codigo;
        this.valorTotal = valorTotal;
         this.listaItens = listaItens;
       
    }

    public Date getDataDeVenda() {
        return dataDeVenda;
    }

    public ArrayList<ItemVenda> getListaItens() {
        return listaItens;
    }

    public void setListaItens(ArrayList<ItemVenda> listaItens) {
        this.listaItens = listaItens;
    }

    public void setDataDeVenda(Date dataDeVenda) {
        this.dataDeVenda = dataDeVenda;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
