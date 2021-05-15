/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.controller;

import br.com.application.dao.VendaDAO;
import br.com.application.models.ItemVenda;
import br.com.application.models.Venda;
import java.sql.Date;
import java.util.ArrayList;
import br.com.application.dao.ItemVendaDAO;

/**
 *
 * @author Jamile
 */
public class VendaController {
    
    
    
    public static boolean cadastrar(Date dataDeVenda,  double valorTotal, int codigo, ArrayList<String[]> ItensVenda) {

        Venda vendas = new Venda();
        vendas.setDataDeVenda(dataDeVenda);
        vendas.setValorTotal(valorTotal);
        
        ArrayList <ItemVenda> listaItens = new ArrayList <ItemVenda>();
        for(String [] item : ItensVenda ){
            ItemVenda venda = new ItemVenda(); 
            venda.setCodigoItem(Integer.parseInt(item[0]));
            listaItens.add(venda);
            
        }
        vendas.setListaItens(listaItens);

        return VendaDAO.cadastrar(vendas);

    }

    // Update
    public static boolean alterar(Date dataDeVenda,  double valorTotal ) {

         Venda venda = new Venda();
        venda.setDataDeVenda(dataDeVenda);
        venda.setValorTotal(valorTotal);

        return VendaDAO.cadastrar(venda);
        

    }


    public static String[] consultarPorCodigo(int pCodigo) {
       Venda vendaRecebido = VendaDAO.consultarPorCodigo(pCodigo);
        String[] vendaRetorno = null;
        if (vendaRecebido != null) {
            vendaRetorno = new String[]{
                String.valueOf(vendaRecebido.getCodigo()),
                String.valueOf(vendaRecebido.getCodigoVenda()),
                String.valueOf(vendaRecebido.getDataDeVenda()),
                String.valueOf(vendaRecebido.getValorTotal()),
        };
                    }
        return vendaRetorno;
    }
        
        
    public static String[] consultarData(Date dataDeVenda) {
      Venda vendaRecebido = VendaDAO.consultarData(dataDeVenda);
        String[] vendaRetorno = null;
        if (vendaRecebido != null) {
            vendaRetorno = new String[]{
                String.valueOf(vendaRecebido.getCodigo()),
                String.valueOf(vendaRecebido.getCodigoVenda()),
                String.valueOf(vendaRecebido.getDataDeVenda()),
                String.valueOf(vendaRecebido.getValorTotal()),
            };  
        }
        return vendaRetorno;
    }

    public static String[] consultarValorTotal(double valorTotal) {
        Venda vendaRecebido = VendaDAO.consultarValorTotal(valorTotal);
        String[] vendaRetorno = null;
        if (vendaRecebido != null) {
            vendaRetorno = new String[]{
                String.valueOf(vendaRecebido.getCodigo()),
                String.valueOf(vendaRecebido.getCodigoVenda()),
                String.valueOf(vendaRecebido.getDataDeVenda()),
                String.valueOf(vendaRecebido.getValorTotal()),
            };
        }
        return vendaRetorno;
    }

}

    

