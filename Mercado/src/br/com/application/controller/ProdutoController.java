package br.com.application.controller;

import br.com.application.dao.ClienteDAO;
import br.com.application.dao.ProdutoDAO;
import br.com.application.models.Cliente;
import br.com.application.models.Produto;
import java.util.ArrayList;

public class ProdutoController {

    // Insert
    public static boolean cadastrar(String pDepartamento,
            String pDescricao, int pEstoqueAtual, Double pValor) {

        Produto produto = new Produto();
        produto.setDepartamento(pDepartamento);
        produto.setDescricao(pDescricao);
        produto.setEstoqueAtual(pEstoqueAtual);
        produto.setValor(pValor);

        return ProdutoDAO.cadastrar(produto);

    }

    // Update
    public static boolean alterar(int pCodigo, String pDepartamento,
            String pDescricao, int pEstoqueAtual, double pValor) {

        Produto produto = new Produto();
        produto.setCodigo(pCodigo);
        produto.setDepartamento(pDepartamento);
        produto.setDescricao(pDescricao);
        produto.setEstoqueAtual(pEstoqueAtual);
        produto.setValor(pValor);

        return ProdutoDAO.alterar(produto);

    }

    // Delete
    public static boolean excluir(int pCodigo) {
        return ProdutoDAO.excluirPorCodigo(pCodigo);
    }

    // Select
    public static ArrayList<String[]> consultarTodos() {
        ArrayList<Produto> listaRecebida = ProdutoDAO.consultarTodos();
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        for (Produto produto : listaRecebida) {
            listaRetorno.add(new String[]{
                String.valueOf(produto.getCodigo()),
                produto.getDescricao(),
                produto.getDepartamento(),
                String.valueOf(produto.getValor()),
                String.valueOf(produto.getEstoqueAtual())});
        }
        return listaRetorno;
    }

    public static String[] consultarPorCodigo(int pCodigo) {
        Produto produtoRecebido = ProdutoDAO.consultarPorCodigo(pCodigo);
        String[] produtoRetorno = null;
        if (produtoRecebido != null) {
            produtoRetorno = new String[]{
                String.valueOf(produtoRecebido.getCodigo()),
                produtoRecebido.getDescricao(),
                produtoRecebido.getDepartamento(),
                String.valueOf(produtoRecebido.getValor()),
                String.valueOf(produtoRecebido.getEstoqueAtual())};
        }
        return produtoRetorno;
    }

    public static ArrayList<String[]> consultarPorDescricao(String pDescricao) {
        ArrayList<Produto> listaRecebida = ProdutoDAO.consultarPorDescricao(pDescricao);
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        for (Produto produto : listaRecebida) {
            listaRetorno.add(new String[]{
                String.valueOf(produto.getCodigo()),
                produto.getDescricao(),
                produto.getDepartamento(),
                String.valueOf(produto.getValor()),
                String.valueOf(produto.getEstoqueAtual())});
        }
        return listaRetorno;
    }

    public static ArrayList<String[]> consultarPorDepartamento(String pDepartamento) {
        ArrayList<Produto> listaRecebida = ProdutoDAO.consultarPorDepartamento(pDepartamento);
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        for (Produto produto : listaRecebida) {
            listaRetorno.add(new String[]{
                String.valueOf(produto.getCodigo()),
                produto.getDescricao(),
                produto.getDepartamento(),
                String.valueOf(produto.getValor()),
                String.valueOf(produto.getEstoqueAtual())});
        }
        return listaRetorno;
    }
}
