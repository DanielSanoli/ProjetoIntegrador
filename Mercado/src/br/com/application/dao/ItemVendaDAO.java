package br.com.application.dao;

import br.com.application.models.ItemVenda;
import br.com.application.utils.UtilsDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
            instrucaoSQL = conexao.prepareStatement("insert into itemVenda (num_venda,codigo_produto,qtd_produto,preco_unitario,sub_total) values (?,?,?,?,?);");
            instrucaoSQL.setInt(1, iv.getNumeroVenda());
            instrucaoSQL.setInt(2, iv.getCodigoProduto());
            instrucaoSQL.setInt(3, iv.getQuantidadeProduto());
            instrucaoSQL.setDouble(4, iv.getPrecoUnitario());
            instrucaoSQL.setDouble(5, iv.getSubTotal());

            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return resultado;
    }

    public static ArrayList<ItemVenda> consultarItens(int pNumeroVenda) {
        Connection conexao = null;
        PreparedStatement InstrucaoSQL = null;
        ArrayList<ItemVenda> itens = new ArrayList<>();
        ResultSet rs = null;

        try {
            conexao = Conexao.getConnection();
            InstrucaoSQL = conexao.prepareStatement("SELECT * FROM itemVenda where num_venda = ?");
            InstrucaoSQL.setInt(1, pNumeroVenda);
            rs = InstrucaoSQL.executeQuery();
            while (rs.next()) {
                ItemVenda iv = new ItemVenda();
                iv.setNumeroVenda(rs.getInt("num_venda"));
                iv.setCodigoProduto(rs.getInt("codigo_produto"));
                iv.setPrecoUnitario(rs.getDouble("preco_unitario"));
                iv.setQuantidadeProduto(rs.getInt("qtd_produto"));
                iv.setSubTotal(rs.getDouble("sub_total"));
                itens.add(iv);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            itens = null;
        } finally {
            UtilsDB.fecharConexao(InstrucaoSQL, conexao);
        }
        return itens;
    }

}
