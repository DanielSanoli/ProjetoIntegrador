package br.com.application.dao;


import br.com.application.models.Venda;
import br.com.application.utils.UtilsDB;
import java.sql.Connection;
import java.sql.Date;
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
     public static boolean cadastrar(Venda venda) {

        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("insert into venda(DataDeVenda,"
                    + "ValorTotal, CodigoVenda,Codigo  ) values (\n"
                    + "?,?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            
            instrucaoSQL.setDate(1, venda.getDataDeVenda());
            instrucaoSQL.setDouble(2, venda.getValorTotal());
            instrucaoSQL.setInt(3, venda.getCodigoVenda());
            instrucaoSQL.setInt(4,venda.getCodigo());
          
            
   
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
                    + "codigo = ?,"
                    + "valorTotal = ?,"
                    + "codigoVenda = ?, "                
                    + "where codigo = ?;");

            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        
        return resultado;
        
       
    }


    public static Venda consultarPorCodigo(int pCodigo) {

       
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        Venda vendas = new Venda();
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE cod_venda=?");

            instrucaoSQL.setInt(1, pCodigo);

            rs = instrucaoSQL.executeQuery();
 
                     
            while (rs.next()) {
                Venda venda = new Venda();   
                venda.setCodigoVenda(rs.getInt("cVenda"));
                venda.setDataDeVenda(rs.getDate("dataDeVenda"));
                venda.setCodigo(rs.getInt("Codigo"));
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
   
    public static Venda consultarData(Date dataDeVenda) {

       Venda venda = new Venda();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE dataVenda=?");

            instrucaoSQL.setDate(1, dataDeVenda);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
               
                venda.setCodigoVenda(rs.getInt("cVenda"));
                venda.setDataDeVenda(rs.getDate("dataDeVenda"));            
                venda.setValorTotal(rs.getDouble("ValorTotal"));
                venda.setCodigo(rs.getInt("Codigo"));
                
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
                venda.setDataDeVenda(rs.getDate("dataDeVenda"));             
                venda.setValorTotal(rs.getDouble("ValorTotal"));
                venda.setCodigo(rs.getInt("Codigo"));
                
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
