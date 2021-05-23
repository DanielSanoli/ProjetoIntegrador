package br.com.application.dao;

import br.com.application.models.Operador;
import br.com.application.utils.UtilsDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class OperadorDAO {

    // Insert
    public static boolean cadastrar(Operador pOperador) {

        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("insert into operador(usuario, senha) values (\n"
                    + "?,?);", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setInt(1, pOperador.getUsuario());
            instrucaoSQL.setInt(2, pOperador.getSenha());

            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return resultado;
    }

    // Update
    public static boolean alterar(Operador pOperador) {
        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("update operador set usuario = ?, senha = ? where codigo = ?;");
            instrucaoSQL.setInt(1, pOperador.getUsuario());
            instrucaoSQL.setInt(2, pOperador.getSenha());
            instrucaoSQL.setInt(3, pOperador.getCodigo());

            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return resultado;

    }

    // Delete
    public static boolean excluirPorCodigo(int pCodigo) {
        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM operador where codigo = ?");
            instrucaoSQL.setInt(1, pCodigo);
            resultado = instrucaoSQL.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return resultado;
    }

    public static ArrayList<Operador> consultarTodos() {
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Operador> operadores = new ArrayList<>();
        ResultSet rs = null;
        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM operador");
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                Operador operador = new Operador();
                operador.setCodigo(rs.getInt("codigo"));
                operador.setUsuario(rs.getInt("usuario"));
                operador.setSenha(rs.getInt("senha"));
                operadores.add(operador);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            operadores = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return operadores;
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

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM operador WHERE usuario=?");

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
}
