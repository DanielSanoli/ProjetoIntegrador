package br.com.application.controller;

import br.com.application.dao.OperadorDAO;
import br.com.application.models.Operador;

public class OperadorController {
    
     // Insert
    public static boolean cadastrar(int pCodigo, int pUsuario, int pSenha) {

        Operador operador = new Operador();
        
        operador.setCodigo(pCodigo);
        operador.setUsuario(pUsuario);
        operador.setSenha(pSenha);
        
        return OperadorDAO.cadastrarOperador(operador);

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
    public static int[] consultarPorCodigo(int pCodigo) {
        Operador operadorRecebido = OperadorDAO.consultarPorCodigo(pCodigo);
        int[] operadorRetorno = null;
        if (operadorRecebido != null) {
            operadorRetorno = new int[]{
                operadorRecebido.getCodigo(),
                operadorRecebido.getUsuario(),
                operadorRecebido.getSenha()
            };        
        }
        return operadorRetorno;
    }
    
    public static int[] consultarPorUsuario(int pUsuario) {
        Operador operadorRecebido = OperadorDAO.consultarPorUsuario(pUsuario);
        int[] operadorRetorno = null;
        if (operadorRecebido != null) {
            operadorRetorno = new int[]{
                operadorRecebido.getCodigo(),
                operadorRecebido.getUsuario(),
                operadorRecebido.getSenha()
            };        
        }
        return operadorRetorno;
    }
    
}
