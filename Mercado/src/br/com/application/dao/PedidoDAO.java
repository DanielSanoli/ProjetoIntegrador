package br.com.application.dao;

import br.com.application.models.Pedido;
import br.com.application.models.Produto;
import br.com.application.utils.UtilsDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDAO {

    public static boolean cadastrar(Pedido pedido) {

        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("insert into pedido (data_pedido,fk_cod_cliente,fk_cod_vendedor) values (?,?,?);");
            instrucaoSQL.setDate(1, new Date(123123123));
            instrucaoSQL.setInt(2, pedido.getCodigoCliente());
            instrucaoSQL.setInt(3, pedido.getCodigoVendedor());

            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }

        return resultado;
    }

    public static Pedido getUltimoPedido() {

        Pedido retorno = new Pedido();
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM pedido ORDER BY num_pedido DESC LIMIT 1");
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                retorno.setNumeroPedido(rs.getInt("num_pedido"));
                retorno.setCodigoCliente(rs.getInt("fk_cod_cliente"));
                retorno.setCodigoVendedor(rs.getInt("fk_cod_vendedor"));
//                retorno.setDataDoPedido(rs.getDate("data_pedido"));
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
