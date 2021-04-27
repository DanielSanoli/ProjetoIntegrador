package br.com.application;

import br.com.application.view.LoginView;
import br.com.application.dao.Conexao;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        
        // Teste de conexão com a base de dados...        
        Conexao.getConnection();
        
        LoginView lg = new LoginView();
        lg.setVisible(true);
    }
}
