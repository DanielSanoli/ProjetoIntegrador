package br.com.application.dao;

import br.com.application.models.Operador;
import br.com.application.utils.UtilsDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class OperadorDAO {
    
    // Insert
    public static boolean cadastrarOperador(Operador pOperador){
        
        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
         try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("insert into operador(codigo, login, senha) values (\n"
                    + "?,?,?);", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setInt(1, pOperador.getCodigo());
            instrucaoSQL.setInt(2, pOperador.getUsuario());
            instrucaoSQL.setInt(2, pOperador.getSenha());

            resultado = instrucaoSQL.executeUpdate() > 0;
            
         }catch(SQLException | ClassNotFoundException erro){
             JOptionPane.showMessageDialog(null, erro.getMessage());
         }finally{
             UtilsDB.fecharConexao(instrucaoSQL, conexao);
         }  
        
        return resultado;
    }
    
    // Update
    public static boolean alterar(Operador pOperador){
        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("update cliente set "
                    + "login = ?,"
                    + "senha = ?,"
                    + "where codigo = ?;");

            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        
        return resultado;
        
    }
    
    // Delete
    public static boolean excluirPorCodigo(int pOperador) {
        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM operador where codigo = ?");
            instrucaoSQL.setInt(1, pOperador);
            resultado = instrucaoSQL.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return resultado;
    }
    
     public static Operador consultarPorCodigo(int pCodigo) {
         
        ResultSet rs = null; 
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        Operador retorno = new Operador();

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM operador WHERE codigo=?");
            
            instrucaoSQL.setInt(1, pCodigo);

            //executa uma consulta
            rs = instrucaoSQL.executeQuery();

            //enquanto houver linhas...
            while (rs.next()) {
               
                retorno.setCodigo(rs.getInt("codigo"));
                retorno.setUsuario(rs.getInt("usuario"));
                retorno.setSenha(rs.getInt("senha"));
               
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return retorno;
    }
     
    public static Operador consultarPorUsuario(int pUsuario) {

        Operador retorno = new Operador();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM operador WHERE usuario usuario=?");

            instrucaoSQL.setInt(1, pUsuario);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                retorno.setCodigo(rs.getInt("codigo"));
                retorno.setUsuario(rs.getInt("usuario"));
                retorno.setSenha(rs.getInt("senha"));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return retorno;
    } 

    public static boolean cadastrar(Operador operador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
