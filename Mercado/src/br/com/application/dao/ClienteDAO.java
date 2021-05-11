package br.com.application.dao;

import br.com.application.utils.UtilsDB;
import br.com.application.models.Cliente;
import br.com.application.utils.UtilsValidacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO {

    // Insert
    public static boolean cadastrar(Cliente pCliente) {

        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("insert into cliente(cpf,nome,email,telefone,enderecoLogradouro,enderecoNumero,enderecoComplemento,sexo) values (\n"
                    + "?,?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, pCliente.getCPF());
            instrucaoSQL.setString(2, pCliente.getNome());
            instrucaoSQL.setString(3, pCliente.getEmail());
            instrucaoSQL.setString(4, pCliente.getTelefone());
            instrucaoSQL.setString(5, pCliente.getEnderecoLogradouro());
            instrucaoSQL.setString(6, pCliente.getEnderecoNumero());
            instrucaoSQL.setString(7, pCliente.getEnderecoComplemento());
            instrucaoSQL.setString(8, pCliente.getSexo());

            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return resultado;
    }

    // Update
    public static boolean alterar(Cliente pCliente) {
        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("update cliente set "
                    + "cpf = ?,"
                    + "nome = ?,"
                    + "email = ?,"
                    + "telefone = ?,"
                    + "enderecoLogradouro = ?,"
                    + "enderecoNumero = ?,"
                    + "enderecoComplemento = ?,"
                    + "sexo = ?"
                    + "where codigo = ?;");

            instrucaoSQL.setString(1, pCliente.getCPF());
            instrucaoSQL.setString(2, pCliente.getNome());
            instrucaoSQL.setString(3, pCliente.getEmail());
            instrucaoSQL.setString(4, pCliente.getTelefone());
            instrucaoSQL.setString(5, pCliente.getEnderecoLogradouro());
            instrucaoSQL.setString(6, pCliente.getEnderecoNumero());
            instrucaoSQL.setString(7, pCliente.getEnderecoComplemento());
            instrucaoSQL.setString(8, pCliente.getSexo());
            instrucaoSQL.setInt(9, pCliente.getCodigo());

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
            instrucaoSQL = conexao.prepareStatement("DELETE FROM cliente where codigo = ?");
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
    public static ArrayList<Cliente> consultarTodos() {
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Cliente> clientes = new ArrayList<>();
        ResultSet rs = null;
        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM vendedor");
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                Cliente vendedor = new Cliente();
                vendedor.setCodigo(rs.getInt("codigo"));
                vendedor.setCPF(rs.getString("cpf"));
                vendedor.setNome(rs.getString("nome"));
                vendedor.setEmail(rs.getString("email"));
                vendedor.setTelefone(rs.getString("telefone"));
                vendedor.setEnderecoLogradouro(rs.getString("enderecoLogradouro"));
                vendedor.setEnderecoNumero(rs.getString("enderecoNumero"));
                vendedor.setEnderecoComplemento(rs.getString("enderecoComplemento"));
                vendedor.setSexo(rs.getString("sexo"));
                clientes.add(vendedor);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            clientes = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return clientes;
    }

    public static Cliente consultarPorCodigo(int pCodigo) {

        Cliente retorno = new Cliente();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE codigo=?");

            instrucaoSQL.setInt(1, pCodigo);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                retorno.setCodigo(rs.getInt("codigo"));
                retorno.setCPF(rs.getString("cpf"));
                retorno.setNome(rs.getString("nome"));
                retorno.setEmail(rs.getString("email"));
                retorno.setTelefone(rs.getString("telefone"));
                retorno.setEnderecoLogradouro(rs.getString("enderecoLogradouro"));
                retorno.setEnderecoNumero(rs.getString("enderecoNumero"));
                retorno.setEnderecoComplemento(rs.getString("enderecoComplemento"));
                retorno.setSexo(rs.getString("sexo"));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return retorno;
    }

    public static Cliente consultarPorCpf(String pCpf) {

        Cliente retorno = new Cliente();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();

            pCpf = UtilsValidacao.removerPontuacaoCPF(pCpf);

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE cpf like ?");

            instrucaoSQL.setString(1, "%" + pCpf + "%");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                retorno.setCodigo(rs.getInt("codigo"));
                retorno.setCPF(rs.getString("cpf"));
                retorno.setNome(rs.getString("nome"));
                retorno.setEmail(rs.getString("email"));
                retorno.setTelefone(rs.getString("telefone"));
                retorno.setEnderecoLogradouro(rs.getString("enderecoLogradouro"));
                retorno.setEnderecoNumero(rs.getString("enderecoNumero"));
                retorno.setEnderecoComplemento(rs.getString("enderecoComplemento"));
                retorno.setSexo(rs.getString("sexo"));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return retorno;
    }

    public static Cliente consultarPorNome(String pNome) {

        Cliente retorno = new Cliente();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE nome like ?");

            instrucaoSQL.setString(1, "%" + pNome + "%");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                retorno.setCodigo(rs.getInt("codigo"));
                retorno.setCPF(rs.getString("cpf"));
                retorno.setNome(rs.getString("nome"));
                retorno.setEmail(rs.getString("email"));
                retorno.setTelefone(rs.getString("telefone"));
                retorno.setEnderecoLogradouro(rs.getString("enderecoLogradouro"));
                retorno.setEnderecoNumero(rs.getString("enderecoNumero"));
                retorno.setEnderecoComplemento(rs.getString("enderecoComplemento"));
                retorno.setSexo(rs.getString("sexo"));
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
