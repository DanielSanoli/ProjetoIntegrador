package br.com.application.utils;

import java.awt.Dialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Utils {

    public static void configuracaoInicial(JFrame frame) {
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setFocusableWindowState(true);
    }
}
