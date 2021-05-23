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
            instrucaoSQL = conexao.prepareStatement("insert into item_venda(qtd_produto,preco_unitario,sub_total,fk_codigo_produto,fk_num_venda) values (?,?,?,?,?);");
            instrucaoSQL.setInt(1, iv.getQuantidadeProduto());
            instrucaoSQL.setDouble(2, iv.getPrecoUnitario());
            instrucaoSQL.setDouble(3, iv.getSubTotal());
            instrucaoSQL.setInt(4, iv.getCodigoProduto());
            instrucaoSQL.setInt(5, iv.getNumeroVenda());
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
            InstrucaoSQL = conexao.prepareStatement("SELECT * FROM item_venda where fk_num_venda = ?");
            InstrucaoSQL.setInt(1, pNumeroVenda);
            rs = InstrucaoSQL.executeQuery();
            while (rs.next()) {
                ItemVenda iv = new ItemVenda();
                iv.setNumeroVenda(rs.getInt("fk_num_venda"));
                iv.setCodigoProduto(rs.getInt("fk_codigo_produto"));
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
