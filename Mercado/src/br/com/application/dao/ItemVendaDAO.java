package br.com.application.dao;

import br.com.application.models.ItemVenda;
import br.com.application.utils.UtilsDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jamile
 */
public class ItemVendaDAO {

    public static boolean cadastrar(ItemVenda iv) {

        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("insert into itemVenda (num_venda,codigo_produto,qtd_produto) values (?,?,?);");
            instrucaoSQL.setInt(1, iv.getNumeroVenda());
            instrucaoSQL.setInt(2, iv.getCodigoProduto());
            instrucaoSQL.setInt(3, iv.getQuantidadeProduto());
            
            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return resultado;
    }

}
