/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.models;

import java.util.ArrayList;

/**
 *
 * @author Jamile
 */
public class ItemVenda {
    
    private int codigoItem;
    private int quantidade;
    private double valorUnitario;
    private int codigo;
    private int codigoP;
    private ArrayList<ItemVenda> listaItens = new ArrayList<>();

    
   public ItemVenda(){
 
   } 
   
   public ItemVenda(int codigoItem, int quantidade, double valorUnitario,ArrayList<ItemVenda> listaItens ) {
        this.codigoItem = codigoItem;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
       
        this.listaItens = listaItens;
       
   }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(int codigoP) {
        this.codigoP = codigoP;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
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
   
   public ArrayList<ItemVenda> getListaItens() {
        return listaItens;
    }

    public void setListaItens(ArrayList<ItemVenda> listaItens) {
        this.listaItens = listaItens;
    }
   
   
    
    
}
