/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.controller;

import br.com.application.dao.VendaDAO;
import br.com.application.models.Venda;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jamile
 */
public class VendaController {

    public static int cadastrar(Date pDataVenda,
            int pCodigoCliente,
            int pCodigoVendedor,
            double pValorTotal) {

        Venda venda = new Venda();
        venda.setDataVenda(pDataVenda);
        venda.setCodigoCliente(pCodigoCliente);
        venda.setCodigoVendedor(pCodigoVendedor);
        venda.setValorTotal(pValorTotal);

        return VendaDAO.cadastrar(venda);
    }

    public static Venda consultar(int pNumeroVenda) {
        return VendaDAO.consultar(pNumeroVenda);
    }

    public static ArrayList<Venda> consultarVendas(Date dataInicial, Date dataFinal) {
        return VendaDAO.consultarVendas(dataInicial,dataFinal);
    }
}