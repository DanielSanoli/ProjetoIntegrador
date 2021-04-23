package br.com.application;

import br.com.application.controller.ConexaoController;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        
        // Teste de conexão com a base de dados...        
        ConexaoController.getConnection();
        
        LoginView lg = new LoginView();
        lg.setVisible(true);
    }
}
