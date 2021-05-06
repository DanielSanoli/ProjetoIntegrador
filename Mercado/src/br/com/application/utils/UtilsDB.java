package br.com.application.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilsDB {

    public static void fecharConexao(PreparedStatement instrucaoSQL, Connection conexao) {
        try {
            if (instrucaoSQL != null) {
                instrucaoSQL.close();
            }
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Falha ao fechar conexão. (xMotivo: " + ex.getMessage() + ")");
        }
    }
}
