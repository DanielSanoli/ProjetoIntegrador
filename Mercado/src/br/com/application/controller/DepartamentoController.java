package br.com.application.controller;

import br.com.application.dao.DepartamentoDAO;
import br.com.application.models.Departamento;
import java.util.ArrayList;

public class DepartamentoController {

    public static boolean cadastrar(String descricao) {

        Departamento departamento = new Departamento();
        departamento.setDescricao(descricao);
        return DepartamentoDAO.cadastrar(departamento);
    }

    //Update
    public static boolean alterar(int pCodigo, String pDescricao) {
        Departamento departamento = new Departamento();
        departamento.setCodigo(pCodigo);
        departamento.setDescricao(pDescricao);
        return DepartamentoDAO.alterar(departamento);
    }

    public static boolean excluir(int pCodigo) {
        return DepartamentoDAO.excluirPorCodigo(pCodigo);
    }

    public static String[] consultarPorCodigo(int pCodigo) {
        Departamento departamentoRecebido = DepartamentoDAO.consultarPorCodigo(pCodigo);
        String[] operadorRetorno = null;
        if (departamentoRecebido != null) {
            operadorRetorno = new String[]{
                String.valueOf(departamentoRecebido.getCodigo()),
                departamentoRecebido.getDescricao()};
        }
        return operadorRetorno;
    }

    public static String[] consultarPorDescricao(String pDescricao) {
        Departamento departamentoRecebido = DepartamentoDAO.consultarPorDescricao(pDescricao);
        String[] operadorRetorno = null;
        if (departamentoRecebido != null) {
            operadorRetorno = new String[]{
                String.valueOf(departamentoRecebido.getCodigo()),
                departamentoRecebido.getDescricao()};
        }
        return operadorRetorno;
    }

    public static ArrayList<String[]> buscarTodos() {
        ArrayList<Departamento> listaRecebida = DepartamentoDAO.consultarTodos();
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        for (Departamento departamento : listaRecebida) {
            listaRetorno.add(new String[]{
                String.valueOf(departamento.getCodigo()),
                departamento.getDescricao()});
        }
        return listaRetorno;
    }

}
