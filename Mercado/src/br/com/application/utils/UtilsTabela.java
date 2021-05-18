package br.com.application.utils;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UtilsTabela {

    public static boolean atualizarTabela(ArrayList<String[]> lista, JTable tabela) {
        boolean sucesso = true;
        if (lista != null && lista.size() > 0) {
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            modelo.setRowCount(0);
            for (String[] c : lista) {
                modelo.addRow(c);
            }
        } else {
            sucesso = false;
        }                
        return sucesso;        
    }    

    public static boolean atualizarTabela(String[] item, JTable tabela) {
        boolean sucesso = true;
        if (item != null && !item[0].equals("0")) {
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            modelo.setRowCount(0);
            modelo.addRow(item);
        } else {
            sucesso = false;
        }
        return sucesso;
    }
}
