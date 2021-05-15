package br.com.application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection CONEXAO;
    public static String URL = "";

    public static String STATUS = "Não conectado";
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String SERVER = "localhost";
    public static final String DATABASE = "mercadodb";

    public static final String LOGIN = "root";
    public static final String SENHA = "Jamilca168";

    public Conexao() {
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        URL = "jdbc:mysql://"
                + SERVER
                + ":3306/"
                + DATABASE
                + "?useTimezone=true&serverTimezone=UTC&useSSL=false";

        if (CONEXAO == null) {
            try {
                // Tentativa de inicialização do driver (com.mysql.cj.jdbc.Driver).            
                Class.forName(DRIVER);

                // Tentativa de conexão com a base de dados.            
                CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);

                if (CONEXAO != null) {
                    STATUS = "Conexão estabelecida com êxito!";
                } else {
                    STATUS = "Falha a coexão com a base de dados.";
                }

            } catch (ClassNotFoundException e) {
                throw new ClassNotFoundException("O driver informado não foi encontrado!");
            } catch (SQLException e) {
                throw new SQLException("Erro ao estabelecer a conexão. (Ex: Usuário/Senha inválido)");
            }
        } else {
            try {
                if (CONEXAO.isClosed()) {
                    CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);
                }
            } catch (SQLException e) {
                throw new SQLException("Erro ao estabelecer a conexão. Msg: " + e.getMessage());
            }
        }
        return CONEXAO;
    }
}
