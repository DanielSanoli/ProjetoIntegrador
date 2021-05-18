package br.com.application.controller;

import br.com.application.dao.OperadorDAO;
import br.com.application.models.Operador;
import java.util.ArrayList;

public class OperadorController {
    
     // Insert
    public static boolean cadastrar(int pUsuario, int pSenha) {

        Operador operador = new Operador();
        
        operador.setUsuario(pUsuario);
        operador.setSenha(pSenha);
        
        return OperadorDAO.cadastrarOperador(operador);
        //Teste

    }
    
    //Update
    public static boolean alterar(int pCodigo, int pUsuario, int Senha) {
        
        Operador operador = new Operador();
        
        operador.setCodigo(pCodigo);
        operador.setUsuario(pUsuario);
        operador.setSenha(Senha);
        
        return OperadorDAO.alterar(operador);
        
    }
    
    //Delete
    public static boolean excluir(int pCodigo) {
        
        return OperadorDAO.excluirPorCodigo(pCodigo);
        
    }
    
    //Select 
    
    public static ArrayList<String[]> consultarTodos() {
        ArrayList<Operador> listaRecebida = OperadorDAO.consultarTodos();
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        for (Operador operador : listaRecebida) {
            listaRetorno.add(new String[]{
                String.valueOf(operador.getCodigo()),                
                Integer.toString(operador.getUsuario()),
                Integer.toString(operador.getSenha())});
        }
        return listaRetorno;           
    }
    
    public static String[] consultarPorCodigo(int pCodigo) {
        Operador operadorRecebido = OperadorDAO.consultarPorCodigo(pCodigo);
        String[] operadorRetorno = null;
        if (operadorRecebido != null) {
            operadorRetorno = new String[]{
                String.valueOf(operadorRecebido.getCodigo()),
                String.valueOf(operadorRecebido.getUsuario()),
                String.valueOf(operadorRecebido.getSenha())
            };        
        }
        return operadorRetorno;
    }
    
    public static String[] consultarPorUsuario(int pUsuario) {
        Operador operadorRecebido = OperadorDAO.consultarPorUsuario(pUsuario);
        String[] operadorRetorno = null;
        if (operadorRecebido != null) {
            operadorRetorno = new String[]{
                String.valueOf(operadorRecebido.getCodigo()),
                String.valueOf(operadorRecebido.getUsuario()),
                String.valueOf(operadorRecebido.getSenha())
            };        
        }
        return operadorRetorno;
    }
    
}


