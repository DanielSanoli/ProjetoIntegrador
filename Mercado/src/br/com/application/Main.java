package br.com.application;

import br.com.application.controller.ItemVendaController;
import br.com.application.controller.VendaController;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

//        Random random = new Random();
//        DecimalFormat df = new DecimalFormat("###,##0.00");
//
//        // Teste de venda
//        int numeroVenda = VendaController.cadastrar(new Date(System.currentTimeMillis()), 1, 1, Double.parseDouble(df.format(random.nextDouble() * 100).replace(",", ".")));
//
//        for (int i = 1; i <= 10; i++) {
//
//            System.out.println("Iniciando teste número #" + i);
//
//            // Teste de itemVenda
//            boolean res = ItemVendaController.cadastrar(numeroVenda, 1, 20);
//
//            System.out.println("Finalizando teste... Resultado: " + (res ? "Sucesso" : "Falha"));
//
//        }
    }
}
