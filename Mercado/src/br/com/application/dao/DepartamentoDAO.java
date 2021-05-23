package br.com.application.dao;

import br.com.application.models.Departamento;
import br.com.application.utils.UtilsDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Anna
 */
public class DepartamentoDAO {

    public static boolean cadastrar(Departamento departamento) {

        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("insert into departamento(descricao) values (?);");

            instrucaoSQL.setString(1, departamento.getDescricao());

            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return resultado;
    }

    public static boolean alterar(Departamento departamento) {
        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("update departamento set descricao = ? where codigo = ?;");
            instrucaoSQL.setString(1, departamento.getDescricao());
            instrucaoSQL.setInt(2, departamento.getCodigo());

            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
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
            instrucaoSQL = conexao.prepareStatement("delete from departamento where codigo = ?;");
            instrucaoSQL.setInt(1, pCodigo);
            resultado = instrucaoSQL.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return resultado;
    }

    public static Departamento consultarPorCodigo(int pCodigo) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        Departamento retorno = new Departamento();

        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM departamento WHERE codigo=?");
            instrucaoSQL.setInt(1, pCodigo);
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                retorno.setCodigo(rs.getInt("codigo"));
                retorno.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return retorno;
    }

    public static Departamento consultarPorDescricao(String pDescricao) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        Departamento retorno = new Departamento();

        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM departamento WHERE descricao=?");
            instrucaoSQL.setString(1, pDescricao);
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                retorno.setCodigo(rs.getInt("codigo"));
                retorno.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return retorno;
    }

    public static ArrayList<Departamento> consultarTodos() {
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Departamento> departamentos = new ArrayList<>();
        ResultSet rs = null;
        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM departamento");
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                Departamento departamento = new Departamento();
                departamento.setCodigo(rs.getInt("codigo"));
                departamento.setDescricao(rs.getString("descricao"));
                departamentos.add(departamento);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            departamentos = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return departamentos;
    }
}
