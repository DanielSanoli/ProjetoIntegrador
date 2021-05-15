/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.controller;

import br.com.application.dao.ItemVendaDAO;
import br.com.application.models.ItemVenda;
import java.sql.SQLException;

/**
 *
 * @author Jamile
 */
public class ItemVendaController {
    
    public static boolean cadastrar(int quantidade,  double valorUnitario) throws SQLException {

        ItemVenda itemvenda = new ItemVenda();
        itemvenda.setQuantidade(quantidade);
        itemvenda.setValorUnitario(valorUnitario);

        return ItemVendaDAO.cadastrar(itemvenda);

    }
    // Update
    public static boolean alterar(int quantidade,  double valorUnitario ) throws SQLException {

         ItemVenda itemvenda = new ItemVenda();
        itemvenda.setQuantidade(quantidade);
        itemvenda.setValorUnitario(valorUnitario);

        return ItemVendaDAO.cadastrar(itemvenda);
    }
    
    //Delete
    public static boolean excluir(int pCodigo) {
        return ItemVendaDAO.excluirPorCodigo(pCodigo);
    }
    
     public static String[] consultarPorCodigo(int pCodigo) {
       ItemVenda itemvendaRecebido = ItemVendaDAO.consultarPorCodigo(pCodigo);
        String[] itemvendaRetorno = null;
        if (itemvendaRecebido != null) {
            itemvendaRetorno = new String[]{
                String.valueOf(itemvendaRecebido.getCodigo()),
                String.valueOf(itemvendaRecebido.getCodigoItem()),
                String.valueOf(itemvendaRecebido.getQuantidade()),
                String.valueOf(itemvendaRecebido.getValorUnitario()),
                String.valueOf(itemvendaRecebido.getCodigoP())
        };
                    }
        return itemvendaRetorno;
    }
     public static String[] consultarQuantidade(int quantidade) {
       ItemVenda itemvendaRecebido = ItemVendaDAO.consultarQuantidade(quantidade);
        String[] itemvendaRetorno = null;
        if (itemvendaRecebido != null) {
            itemvendaRetorno = new String[]{
                String.valueOf(itemvendaRecebido.getCodigo()),
                String.valueOf(itemvendaRecebido.getCodigoItem()),
                String.valueOf(itemvendaRecebido.getQuantidade()),
                String.valueOf(itemvendaRecebido.getValorUnitario()),
                String.valueOf(itemvendaRecebido.getCodigoP())
        };
                    }
        return itemvendaRetorno;
    }
    
}
