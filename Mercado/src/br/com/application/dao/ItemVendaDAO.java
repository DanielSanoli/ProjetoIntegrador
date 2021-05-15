/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.dao;

import br.com.application.models.ItemVenda;
import br.com.application.utils.UtilsDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jamile
 */
public class ItemVendaDAO {
    
    
    public static boolean cadastrar(ItemVenda v) throws SQLException {

        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();

            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if(linhasAfetadas>0)
            return true;
            
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                        v.setCodigo(generatedKeys.getInt(1));
                         instrucaoSQL = conexao.prepareStatement("insert into itemvenda(,"
                    + "ValorUnitario, CodigoItemVenda, Codigo, CodigoProduto, Quantidade  ) values (\n"
                    + "?,?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            
             for(ItemVenda item :v.getListaItens()){

            
            instrucaoSQL.setInt(1, v.getCodigoItem());
            instrucaoSQL.setInt(2, item.getCodigo());
            instrucaoSQL.setInt(3, item.getCodigoP());
            instrucaoSQL.setInt(4,item.getQuantidade());
            instrucaoSQL.setDouble(5,item.getValorUnitario());
            {
                resultado = true;
            }
             }
                }
                else {
                    throw new SQLException("Falha ao obter o ID do cliente.");
                }
           
        return false;
        }
            
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            resultado = false;
        } finally{
            
            //Libero os recursos da memória
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
//                GerenciadorConexao.fecharConexao();
                conexao.close();
                
              } catch (SQLException ex) {
             }
        }
 
        return resultado;
    }
   //Update
    public static boolean alterar(ItemVenda iVenda) {
        
        
        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("update itemvenda set "
                    + "Quantidade = ?,"
                    + "codigo = ?,"
                    + "valorUnitario = ?,"
                    + "codigoItemVenda = ?, "  
                    + "codigoProduto = ?"
                    + "where codigo = ?;");

            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        
        return resultado;
        
       
    }
    public static boolean excluirPorCodigo(int pCodigo) {
        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM itemvenda where codigo = ?");
            instrucaoSQL.setInt(1, pCodigo);
            resultado = instrucaoSQL.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return resultado;
    }

    
    public static ItemVenda consultarQuantidade(int quantidade) {

       ItemVenda itemvenda = new ItemVenda();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM itemvenda WHERE quantidade=?");

            instrucaoSQL.setInt(1, quantidade);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
               
                itemvenda.setQuantidade(rs.getInt("quantidade"));
                itemvenda.setCodigo(rs.getInt("codigo"));
                itemvenda.setCodigoItem(rs.getInt("codigoItem"));             
                itemvenda.setValorUnitario(rs.getDouble("ValorUnitario"));
                itemvenda.setCodigoP(rs.getInt("CodigoProduto"));
                
                      }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
          itemvenda = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return itemvenda;
    }
    public static ItemVenda consultarPorCodigo(int codigoItem) {

       ItemVenda itemvenda = new ItemVenda();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM itemvenda WHERE cod_Item=?");

            instrucaoSQL.setInt(1, codigoItem);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
               
                itemvenda.setQuantidade(rs.getInt("quantidade"));
                itemvenda.setCodigo(rs.getInt("codigo"));
                itemvenda.setCodigoItem(rs.getInt("codigoItem"));             
                itemvenda.setValorUnitario(rs.getDouble("ValorUnitario"));
                itemvenda.setCodigoP(rs.getInt("CodigoProduto"));
                
           }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
          itemvenda = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return itemvenda;
}
}
