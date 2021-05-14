package br.com.application.dao;


import br.com.application.models.Cliente;
import br.com.application.models.Venda;
import br.com.application.utils.UtilsDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jamile
 */
public class VendaDAO {
    
    
    //Insert
     public static boolean cadastrar(Venda venda, Cliente pCliente) {

        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("insert into venda(DataDeVenda,Quantidade, ValorUnitario,"
                    + "ValorTotal, CodigoVenda,Codigo  ) values (\n"
                    + "?,?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            
            instrucaoSQL.setString(1, venda.getDataDeVenda());
            instrucaoSQL.setInt(2, venda.getQuantidade());
            instrucaoSQL.setDouble(3, venda.getValorUnitario());
            instrucaoSQL.setDouble(4, venda.getValorTotal());
            instrucaoSQL.setInt(5, venda.getCodigoVenda());
            instrucaoSQL.setInt(6, pCliente.getCodigo());
          
            
   
          resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return resultado;
    }
   //Update
    public static boolean alterar(Venda venda) {
        
        
        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("update venda set "
                    + "dataVenda = ?,"
                    + "quantidade = ?,"
                    + "valorTotal = ?,"
                    + "valorUnitario = ?"
                    + "where codigo = ?;");

            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        
        return resultado;
        
       
    }


    public static Venda consultarPorCodigo(int vendaCodigo) {

       
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        Venda vendas = new Venda();
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE cod_venda=?");

            instrucaoSQL.setInt(1, vendaCodigo);

            rs = instrucaoSQL.executeQuery();
 
                     
            while (rs.next()) {
                Venda venda = new Venda();   
                venda.setCodigoVenda(rs.getInt("cVenda"));
                venda.setDataDeVenda(rs.getString("dataDeVenda"));
                venda.setQuantidade(rs.getInt("Quantidade"));
                venda.setValorUnitario(rs.getDouble("ValorUnitario"));
                venda.setValorTotal(rs.getDouble("ValorTotal"));
               
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
           vendas = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return vendas;
    }
   
    public static Venda consultarData(String dataDeVenda) {

       Venda venda = new Venda();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE dataVenda=?");

            instrucaoSQL.setString(1, dataDeVenda);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
               
                venda.setCodigoVenda(rs.getInt("cVenda"));
                venda.setDataDeVenda(rs.getString("dataDeVenda"));
                venda.setQuantidade(rs.getInt("Quantidade"));
                venda.setValorUnitario(rs.getDouble("ValorUnitario"));
                venda.setValorTotal(rs.getDouble("ValorTotal"));
              
                
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
          venda = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return venda;
    }
   public static Venda consultarQuantidade(int quantidade) {

       Venda venda = new Venda();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE quantidade=?");

            instrucaoSQL.setInt(1, quantidade);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
               
                venda.setCodigoVenda(rs.getInt("cVenda"));
                venda.setDataDeVenda(rs.getString("dataDeVenda"));
                venda.setQuantidade(rs.getInt("Quantidade"));
                venda.setValorUnitario(rs.getDouble("ValorUnitario"));
                venda.setValorTotal(rs.getDouble("ValorTotal"));
              
                
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
          venda = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return venda;
    }
       public static Venda consultarValorTotal(double valorTotal) {

       Venda venda = new Venda();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE valorTotal=?");

            instrucaoSQL.setDouble(1, valorTotal);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
               
                venda.setCodigoVenda(rs.getInt("cVenda"));
                venda.setDataDeVenda(rs.getString("dataDeVenda"));
                venda.setQuantidade(rs.getInt("Quantidade"));
                venda.setValorUnitario(rs.getDouble("ValorUnitario"));
                venda.setValorTotal(rs.getDouble("ValorTotal"));
              
                
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
          venda = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return venda;
    }
       public static Venda consultarValorUnitario(double valorUnitario) {

       Venda venda = new Venda();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE valorUnitario=?");

            instrucaoSQL.setDouble(1, valorUnitario);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
               
                venda.setCodigoVenda(rs.getInt("cVenda"));
                venda.setDataDeVenda(rs.getString("dataDeVenda"));
                venda.setQuantidade(rs.getInt("Quantidade"));
                venda.setValorUnitario(rs.getDouble("ValorUnitario"));
                venda.setValorTotal(rs.getDouble("ValorTotal"));
              
                
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
          venda = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return venda;
    }
}