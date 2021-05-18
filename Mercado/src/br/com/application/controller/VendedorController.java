package br.com.application.controller;

import br.com.application.dao.VendedorDAO;
import br.com.application.models.Vendedor;
import java.util.ArrayList;

public class VendedorController {
     public static boolean cadastrar(String nome, String email, double salario, String Telefone) {

        Vendedor vendedor = new Vendedor();
        vendedor.setNome(nome);
        vendedor.setEmail(email);
        vendedor.setSalario(salario);
        vendedor.setTelefone(Telefone);
      
        return VendedorDAO.cadastrar(vendedor);

    }

    public static ArrayList<String[]> buscarTodos() {
        ArrayList<Vendedor> listaRecebida = VendedorDAO.consultarTodos();
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        for (Vendedor vendedor : listaRecebida) {
            listaRetorno.add(new String[]{
                String.valueOf(vendedor.getCodigo()),
                vendedor.getNome(),
                vendedor.getEmail(),
                String.valueOf(vendedor.getSalario()),
                vendedor.getTelefone(),
                });
        }
        return listaRetorno;
    }

    public static String[] buscarPorCodigo(int Codigo) {
        Vendedor vendedorRecebido = VendedorDAO.consultarPorCodigo(Codigo);
        String[] vededorRetorno = null;
        if (vendedorRecebido != null) {
            vededorRetorno = new String[]{
                String.valueOf(vendedorRecebido.getCodigo()),
                vendedorRecebido.getNome(),
                vendedorRecebido.getEmail(),
                String.valueOf(vendedorRecebido.getSalario()),
                vendedorRecebido.getTelefone()};
        }
        return vededorRetorno;
    }
    
    public static boolean alterar(String nome, String email, double salario, String telefone) {
        
        Vendedor vendedor = new Vendedor();
        
       
        vendedor.setNome(nome);
        vendedor.setEmail(email);
        vendedor.setSalario(salario);
        vendedor.setTelefone(telefone);
        
        return VendedorDAO.alterar(vendedor);    
    }
     public static boolean excluir(int Codigo) {
        return VendedorDAO.excluirPorCodigo(Codigo);
    }
     
    
     public static ArrayList<String[]> buscarPorNome(String nome) {
        ArrayList<Vendedor> listaRecebida = VendedorDAO.consultarPorNome(nome);
        ArrayList<String[]> listaRetorno = new ArrayList<>();
        for (Vendedor vendedor : listaRecebida) {
            listaRetorno.add(new String[]{
                String.valueOf(vendedor.getCodigo()),
                vendedor.getNome(),
                vendedor.getEmail(),
                String.valueOf(vendedor.getSalario()),
                vendedor.getTelefone(),
                });
        }
        return listaRetorno;
    }
}
