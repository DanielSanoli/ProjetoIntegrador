package br.com.application.controller;

import br.com.application.dao.DepartamentoDAO;
import br.com.application.models.Departamento;
import java.util.ArrayList;

public class DepartamentoController {

    // Insert
    /**
     *
     * @param descricao
     * @return
     */
    public static boolean cadastrar(String descricao) {

        Departamento departamento = new Departamento();

        departamento.setDescricao(descricao);

        return DepartamentoDAO.cadastrarDepartamento(descricao);

    }

    //Update
    public static boolean alterar(int pCodigo, int pDescricao) {

        Departamento departamento = new Departamento();

        departamento.setCodigo(pCodigo);
        departamento.setDescricao(pDescricao);

        return DepartamentoDAO.alterar(pCodigo, pDescricao);

    }

    //Delete
    public static boolean excluir(int pCodigo) {

        return DepartamentoDAO.excluirPorCodigo(pCodigo);

    }

//    //Select 
//    public static ArrayList<String[]> consultarTodos() {
//        ArrayList<Departamento> listaRecebida = DepartamentoDAO.consultarTodos();
//        ArrayList<String[]> listaRetorno = new ArrayList<>();
//        listaRecebida.forEach((Departamento departamento) -> {
//            listaRetorno.add(new String[]{
//                String.valueOf(departamento.getCodigo())
//
//            });
//            return listaRetorno;
//        }
//        /**
//         *
//         * @param pCodigo
//         * @return
//         */
//
//    public static String[] consultarPorCodigo(int pCodigo) {
//        Departamento departamentoRecebido = DepartamentoDAO.consultarPorCodigo(pCodigo);
//        String[] operadorRetorno = null;
//        if (departamentoRecebido != null) {
//            String[] departamentoRetorno = new String[]{
//                String.valueOf(departamentoRecebido.getCodigo()),
//                String.valueOf(departamentoRecebido.getDescricao()),};
//        }
//        String[] departamentoRetorno = null;
//        return departamentoRetorno;
//    }
//
//    public static String[] consultarPorUsuario(int pUsuario) {
//        Departamento departamentoRecebido;
//        departamentoRecebido = DepartamentoDAO.consultarPorDescricao(pDescricao);
//        String[] departamentoRetorno = null;
//        if (departamentoRecebido != null) {
//            departamentoRetorno = new String[]{
//                String.valueOf(departamentoRecebido.getCodigo()),
//                String.valueOf(departamentoRecebido.getDescricao()),};
//        }
//        return departamentoRetorno;
//    }

    private static class istringdescricao {

        public istringdescricao() {
        }
    }

    private static class istring {

        public istring() {
        }
    }

}
