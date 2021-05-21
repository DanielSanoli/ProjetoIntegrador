/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.dao;

import br.com.application.models.Departamento;
import br.com.application.utils.UtilsDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Anna
 */
public class DepartamentoDAO {

    public static boolean cadastrar(Departamento iv) {

        boolean resultado = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = Conexao.getConnection();
            instrucaoSQL = conexao.prepareStatement("insert into departamento (descricao) values (?);");
            instrucaoSQL.setString(1, iv.getDescricao());

            resultado = instrucaoSQL.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            UtilsDB.fecharConexao(instrucaoSQL, conexao);
        }
        return resultado;
    }

    public static boolean cadastrarDepartamento(String descricao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean alterar(int pCodigo, int pDescricao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean excluirPorCodigo(int pCodigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ArrayList<Departamento> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Departamento consultarPorCodigo(int pCodigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
