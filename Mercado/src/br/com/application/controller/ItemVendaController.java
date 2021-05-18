/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.controller;

import br.com.application.dao.ItemVendaDAO;
import br.com.application.models.ItemVenda;
import java.util.ArrayList;

/**
 *
 * @author Jamile
 */
public class ItemVendaController {
    
    public static boolean cadastrar(int pNumeroVenda, int pCodigoProduto, int pQuantidade) {
        
        ItemVenda iv = new ItemVenda();
        iv.setNumeroVenda(pNumeroVenda);
        iv.setCodigoProduto(pCodigoProduto);
        iv.setQuantidadeProduto(pQuantidade);
        
        return ItemVendaDAO.cadastrar(iv);
    }
    
    public static boolean cadastrar(ArrayList<String[]> itens) {
        
        for (String[] item : itens) {
            ItemVenda iv = new ItemVenda();
            iv.setNumeroVenda(Integer.parseInt(item[0]));
            iv.setCodigoProduto(Integer.parseInt(item[1]));
            iv.setQuantidadeProduto(Integer.parseInt(item[2]));
            ItemVendaDAO.cadastrar(iv);
        }        
        return false;
    }
    
}
