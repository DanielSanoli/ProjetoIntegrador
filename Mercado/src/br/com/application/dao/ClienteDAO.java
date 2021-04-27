package br.com.application.dao;

import br.com.application.controller.ConexaoController;
import br.com.application.models.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO {

    public static boolean cadastrar(Cliente cliente) {

        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoController.getConnection();

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

            resultado = UtilsDB.resultadoQuery(instrucaoSQL.executeUpdate(), "Cadastro");

        } catch (Exception e) {
            System.out.println("Falha: " + e.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return resultado;
    }

    public static boolean alterar(Cliente cliente) {
        return false;
    }

    public static ArrayList<Cliente> buscarTodos() {
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<Cliente> clientes = new ArrayList<>();
        ResultSet rs = null;
        try {
            conexao = ConexaoController.getConnection();
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

        } catch (Exception e) {
            System.out.println(e.getMessage());
            clientes = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return clientes;
    }

    public static Cliente buscarPorCodigo(int codigo) {
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;
        Cliente cliente = new Cliente();
        try {
            conexao = ConexaoController.getConnection();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente where codigo = ?");
            instrucaoSQL.setInt(1, codigo);
            rs = instrucaoSQL.executeQuery();
            if (rs.getInt("codigo") != 0) {
                while (rs.next()) {
                    cliente.setCodigo(rs.getInt("codigo"));
                    cliente.setCPF(rs.getString("cpf"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setEnderecoLogradouro(rs.getString("enderecoLogradouro"));
                    cliente.setEnderecoNumero(rs.getString("enderecoNumero"));
                    cliente.setEnderecoComplemento(rs.getString("enderecoComplemento"));
                    cliente.setSexo(rs.getString("sexo"));
                }
            } else {
                cliente = null;
                return cliente;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            cliente = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return cliente;
    }

    public static boolean excluirTodos(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean excluirPorCodigo(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
