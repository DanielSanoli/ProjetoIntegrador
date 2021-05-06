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

    public static boolean cadastrar(Cliente cliente) {

        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();

            instrucaoSQL = conexao.prepareStatement("insert into cliente(cpf,nome,email,telefone,enderecoLogradouro,enderecoNumero,enderecoComplemento,sexo) values (\n"
                    + "?,?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, cliente.getCPF());
            instrucaoSQL.setString(2, cliente.getNome());
            instrucaoSQL.setString(3, cliente.getEmail());
            instrucaoSQL.setString(4, cliente.getTelefone());
            instrucaoSQL.setString(5, cliente.getEnderecoLogradouro());
            instrucaoSQL.setString(6, cliente.getEnderecoNumero());
            instrucaoSQL.setString(7, cliente.getEnderecoComplemento());
            instrucaoSQL.setString(8, cliente.getSexo());

            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return resultado;
    }

    public static boolean alterar(Cliente cliente) {
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

            instrucaoSQL.setString(1, cliente.getCPF());
            instrucaoSQL.setString(2, cliente.getNome());
            instrucaoSQL.setString(3, cliente.getEmail());
            instrucaoSQL.setString(4, cliente.getTelefone());
            instrucaoSQL.setString(5, cliente.getEnderecoLogradouro());
            instrucaoSQL.setString(6, cliente.getEnderecoNumero());
            instrucaoSQL.setString(7, cliente.getEnderecoComplemento());
            instrucaoSQL.setString(8, cliente.getSexo());
            instrucaoSQL.setInt(9, cliente.getCodigo());

            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return resultado;
    }

    public static ArrayList<Cliente> consultarTodos() {
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Cliente> clientes = new ArrayList<>();
        ResultSet rs = null;
        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente");
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEnderecoLogradouro(rs.getString("enderecoLogradouro"));
                cliente.setEnderecoNumero(rs.getString("enderecoNumero"));
                cliente.setEnderecoComplemento(rs.getString("enderecoComplemento"));
                cliente.setSexo(rs.getString("sexo"));
                clientes.add(cliente);
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

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE cpf = ?");

            instrucaoSQL.setString(1, pCpf);

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

            instrucaoSQL.setString(1, pNome);

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

    public static boolean excluirPorCodigo(int codigo) {
        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("DELETE FROM cliente where codigo = ?");
            instrucaoSQL.setInt(1, codigo);
            resultado = instrucaoSQL.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return resultado;
    }
}
