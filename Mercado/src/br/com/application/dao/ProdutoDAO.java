package br.com.application.dao;

import br.com.application.utils.UtilsDB;
import br.com.application.models.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {

    // Insert
    public static boolean cadastrar(Produto pProduto) {

        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("insert into produto(descricao,valor,estoque_atual,fk_codigo_departamento) values (?,?,?,?)");

            instrucaoSQL.setString(1, pProduto.getDescricao());
            instrucaoSQL.setDouble(2, pProduto.getValor());
            instrucaoSQL.setInt(3, pProduto.getEstoqueAtual());
            instrucaoSQL.setInt(4, pProduto.getDepartamento());

            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return resultado;
    }

    // Update
    public static boolean alterar(Produto pProduto) {
        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("update produto set fk_codigo_departamento = ?, descricao = ?, valor = ?, estoque_atual = ? where codigo = ?;");

            instrucaoSQL.setInt(1, pProduto.getDepartamento());
            instrucaoSQL.setString(2, pProduto.getDescricao());
            instrucaoSQL.setDouble(3, pProduto.getValor());
            instrucaoSQL.setInt(4, pProduto.getEstoqueAtual());
            instrucaoSQL.setInt(5, pProduto.getCodigo());

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
            instrucaoSQL = conexao.prepareStatement("DELETE FROM produto where codigo = ?");
            instrucaoSQL.setInt(1, pCodigo);
            resultado = instrucaoSQL.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return resultado;
    }

    // Select
    public static ArrayList<Produto> consultarTodos() {
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Produto> produtos = new ArrayList<>();
        ResultSet rs = null;
        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto");
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {

                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setDepartamento(rs.getInt("fk_codigo_departamento"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setEstoqueAtual(rs.getInt("estoque_atual"));
                produto.setValor(rs.getDouble("valor"));
                produtos.add(produto);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            produtos = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return produtos;
    }

    public static Produto consultarPorCodigo(int pCodigo) {

        Produto retorno = new Produto();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE codigo=?");

            instrucaoSQL.setInt(1, pCodigo);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                retorno.setCodigo(rs.getInt("codigo"));
                retorno.setDepartamento(rs.getInt("fk_codigo_departamento"));
                retorno.setDescricao(rs.getString("descricao"));
                retorno.setEstoqueAtual(rs.getInt("estoque_atual"));
                retorno.setValor(rs.getDouble("valor"));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return retorno;
    }

    public static ArrayList<Produto> consultarPorDescricao(String pDescricao) {
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Produto> produtos = new ArrayList<>();
        ResultSet rs = null;
        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto where descricao like ?");
            instrucaoSQL.setString(1, "%" + pDescricao + "%");
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setDepartamento(rs.getInt("fk_codigo_departamento"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setEstoqueAtual(rs.getInt("estoque_atual"));
                produto.setValor(rs.getDouble("valor"));
                produtos.add(produto);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            produtos = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return produtos;
    }

    public static ArrayList<Produto> consultarPorDepartamento(String pDepartamento) {
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Produto> produtos = new ArrayList<>();
        ResultSet rs = null;
        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto where departamento like ?");
            instrucaoSQL.setString(1, "%" + pDepartamento + "%");
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setDepartamento(rs.getInt("fk_codigo_departamento"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setEstoqueAtual(rs.getInt("estoque_atual"));
                produto.setValor(rs.getDouble("valor"));
                produtos.add(produto);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            produtos = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return produtos;
    }

    public static boolean ajustarEstoque(int pCodigoProduto, int pQuantidade) {
        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("update produto set estoque_atual = ? where codigo = ?;");
            instrucaoSQL.setInt(1, pQuantidade);
            instrucaoSQL.setInt(2, pCodigoProduto);
            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return resultado;
    }
}
