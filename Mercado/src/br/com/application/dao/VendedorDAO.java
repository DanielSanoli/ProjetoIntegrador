/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.dao;

import br.com.application.models.Vendedor;
import br.com.application.utils.UtilsDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author yurim
 */
public class VendedorDAO {
     public static boolean cadastrar(Vendedor vendedor) {

        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("insert into vendedor(nome,email,salario,telefone) "
                    + "values (?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, vendedor.getNome());
            instrucaoSQL.setString(2, vendedor.getEmail());
            instrucaoSQL.setDouble(3, vendedor.getSalario());
            instrucaoSQL.setString(4, vendedor.getTelefone());
         

            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return resultado;
    }

 

    public static ArrayList<Vendedor> consultarTodos() {
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        ResultSet rs = null;
        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM vendedor");
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setCodigo(rs.getInt("codigo"));
                vendedor.setNome(rs.getString("nome"));
                vendedor.setEmail(rs.getString("email"));
                vendedor.setSalario(rs.getDouble("salario"));
                vendedor.setTelefone(rs.getString("telefone"));  
                
                vendedores.add(vendedor);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            vendedores = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return vendedores;
    }

    public static Vendedor consultarPorCodigo(int Codigo) {

        Vendedor retorno = new Vendedor();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM vendedor WHERE cod_vendedor=?");

            instrucaoSQL.setInt(1, Codigo);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                retorno.setCodigo(rs.getInt("codigo"));
                retorno.setNome(rs.getString("nome"));
                retorno.setEmail(rs.getString("email"));
                retorno.setSalario(rs.getDouble("salario"));
                retorno.setTelefone(rs.getString("telefone"));  
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return retorno;
    }

        public static boolean alterar (Vendedor vendedor) {
       boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("update vendedor set "
                    + "nome = ?,"
                    + "email = ?,"
                    + "salario = ?"
                    + "telefone = ?,");

            instrucaoSQL.setString(1, vendedor.getNome());
            instrucaoSQL.setString(2, vendedor.getEmail());
            instrucaoSQL.setDouble(3, vendedor.getSalario());
            instrucaoSQL.setString(4, vendedor.getTelefone());


            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return resultado;
    }
}
