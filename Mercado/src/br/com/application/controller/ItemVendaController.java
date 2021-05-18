/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.controller;

import br.com.application.dao.ItemVendaDAO;
import br.com.application.models.ItemVenda;

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

}
