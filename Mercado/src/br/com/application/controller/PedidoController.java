package br.com.application.controller;

import br.com.application.dao.PedidoDAO;
import br.com.application.models.Pedido;
import java.sql.Date;

public class PedidoController {

    public static boolean cadastrar(Date pDataPedido, int pCodigoCliente, int pCodigoVendedor) {
        Pedido pedido = new Pedido();
        pedido.setDataDoPedido(pDataPedido);
        pedido.setCodigoCliente(pCodigoCliente);
        pedido.setCodigoVendedor(pCodigoVendedor);
        return PedidoDAO.cadastrar(pedido);
    }
    
    public static Pedido getUltimoPedido(){
        return PedidoDAO.getUltimoPedido();
    }

}
