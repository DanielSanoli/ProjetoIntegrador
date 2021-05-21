package br.com.application.controller;

import br.com.application.dao.ItemVendaDAO;
import br.com.application.models.ItemVenda;
import java.util.ArrayList;

/**
 *
 * @author Jamile
 */
public class ItemVendaController {

    public static boolean cadastrar(int pNumeroVenda, int pCodigoProduto, int pQuantidade, double pPrecoUnitario, double pSubTotal) {

        ItemVenda iv = new ItemVenda();
        iv.setNumeroVenda(pNumeroVenda);
        iv.setCodigoProduto(pCodigoProduto);
        iv.setQuantidadeProduto(pQuantidade);
        iv.setPrecoUnitario(pPrecoUnitario);
        iv.setSubTotal(pSubTotal);

        return ItemVendaDAO.cadastrar(iv);
    }

    public static boolean cadastrar(ArrayList<String[]> itens) {
        boolean res = false;
        for (String[] item : itens) {
            ItemVenda iv = new ItemVenda();
            iv.setNumeroVenda(Integer.parseInt(item[0]));
            iv.setCodigoProduto(Integer.parseInt(item[1]));
            iv.setQuantidadeProduto(Integer.parseInt(item[2]));
            iv.setPrecoUnitario(Double.parseDouble(item[3]));
            iv.setSubTotal(Double.parseDouble(item[4]));
            res = ItemVendaDAO.cadastrar(iv);
        }
        return res;
    }

    public static ArrayList<String[]> consultarItens(int pNumeroVenda) {
        ArrayList<ItemVenda> listaRecebida = ItemVendaDAO.consultarItens(pNumeroVenda);
        ArrayList<String[]> listaRetorno = new ArrayList<>();

        listaRecebida.forEach((item) -> {
            String codigo = String.valueOf(item.getCodigoProduto());
            String qtd = String.valueOf(item.getQuantidadeProduto());
            String produto = ProdutoController.consultarPorCodigo(codigo).getDescricao();
            String valor = String.valueOf(item.getPrecoUnitario());
            String subTotal = String.valueOf(item.getSubTotal());
            listaRetorno.add(new String[]{
                codigo,
                qtd,
                produto,
                valor,
                subTotal
            });
        });

        return listaRetorno;
    }
}
