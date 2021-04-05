package br.com.application.utils;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class UtilsView {

    public static void configuracaoInicialJFrame(JFrame frame) {
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setFocusableWindowState(true);
    }

    public static void configuracaoInicialJDialog(JDialog dialog) {
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setFocusableWindowState(true);
        dialog.setModal(true);
    }
    
}
