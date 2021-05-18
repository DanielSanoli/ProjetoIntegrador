package br.com.application.dao;

import br.com.application.models.Venda;
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
public class VendaDAO {

    public static int cadastrar(Venda v) {
        int resultado = 0;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("insert into venda (data_venda,codigo_cliente, codigo_vendedor, valor_total) values (?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            instrucaoSQL.setDate(1, new java.sql.Date(v.getDataVenda().getTime()));
            instrucaoSQL.setInt(2, v.getCodigoCliente());
            instrucaoSQL.setInt(3, v.getCodigoVendedor());
            instrucaoSQL.setDouble(4, v.getValorTotal());
            instrucaoSQL.executeUpdate();

            ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();

            if (generatedKeys.next()) {
                resultado = generatedKeys.getInt(1);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return resultado;
    }

    public static Venda consultar(int pNumeroVenda) {

        Venda v = new Venda();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda WHERE num_venda = ?");
            instrucaoSQL.setInt(1, pNumeroVenda);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                v.setNumeroVenda(rs.getInt("num_venda"));
                v.setDataVenda(rs.getDate("data_venda"));
                v.setCodigoCliente(rs.getInt("codigo_cliente"));
                v.setCodigoVendedor(rs.getInt("codigo_vendedor"));
                v.setValorTotal(rs.getDouble("valor_total"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            v = null;
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return v;
    }

}
