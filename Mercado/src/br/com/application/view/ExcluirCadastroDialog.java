/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.view;

import br.com.application.controller.ClienteController;
import br.com.application.controller.DepartamentoController;
import br.com.application.controller.OperadorController;
import br.com.application.controller.ProdutoController;
import br.com.application.controller.VendedorController;
import static br.com.application.utils.UtilsConstantes.CLASS_CLIENTE;
import static br.com.application.utils.UtilsConstantes.CLASS_DEPARTAMENTO;
import static br.com.application.utils.UtilsConstantes.CLASS_OPERADOR;
import static br.com.application.utils.UtilsConstantes.CLASS_PRODUTO;
import static br.com.application.utils.UtilsConstantes.CLASS_VENDEDOR;
import static br.com.application.utils.UtilsConstantes.EXCLUSAO_REALIZADA;
import static br.com.application.utils.UtilsConstantes.FALHA_NA_EXCLUSAO;
import br.com.application.utils.UtilsValidacao;
import br.com.application.utils.UtilsView;
import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 *
 * @author Matheus Castro
 */
public final class ExcluirCadastroDialog extends javax.swing.JDialog {

    private int codigo;
    public static String className;
    public static int retorno = 0;

    public int getQuantidade() {
        return codigo;
    }

    public void setQuantidade(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Creates new form NovoClienteDialog
     */
    public ExcluirCadastroDialog(java.awt.Frame parent, boolean modal, String className, int retorno) {
        super(parent, modal);
        initComponents();
        ExcluirCadastroDialog.className = className;
        ExcluirCadastroDialog.retorno = retorno;
        UtilsView.configuracaoInicialJDialog(this);
        setTitle(className);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        edtCodigo = new javax.swing.JTextField();
        btnCofirmar = new javax.swing.JButton();
        btnCofirmar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Excluir Cadastro");

        jPanel1.setBackground(new java.awt.Color(27, 59, 108));

        txtTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(255, 255, 255));
        txtTitle.setText("Remover Cadastro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(txtTitle)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtTitle)
                .addGap(10, 10, 10))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informe o c??digo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        edtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCodigoActionPerformed(evt);
            }
        });
        edtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtCodigoKeyTyped(evt);
            }
        });

        btnCofirmar.setBackground(new java.awt.Color(204, 255, 204));
        btnCofirmar.setText("Confirmar");
        btnCofirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCofirmarActionPerformed(evt);
            }
        });

        btnCofirmar1.setBackground(new java.awt.Color(255, 204, 204));
        btnCofirmar1.setText("Cancelar");
        btnCofirmar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCofirmar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCodigo)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCofirmar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCofirmar)
                        .addContainerGap())))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCofirmar, btnCofirmar1});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(edtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCofirmar)
                            .addComponent(btnCofirmar1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCodigoActionPerformed

    private void btnCofirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCofirmarActionPerformed

        if (UtilsValidacao.isNullOuVazio(edtCodigo.getText())) {
            new AvisosDialog(null, true, "Informe o c??digo do " + className, true);
            edtCodigo.setBackground(Color.YELLOW);
            return;
        } else {
            setQuantidade(Integer.parseInt(edtCodigo.getText()));
            dispose();
        }

        int codigo = Integer.parseInt(edtCodigo.getText());
        boolean res = false;
        switch (className) {
            case CLASS_CLIENTE:
                // Realizar exclus??o do cliente
                System.out.println("CLASS_CLIENTE");
                res = ClienteController.excluir(codigo);
                break;
            case CLASS_DEPARTAMENTO:
                System.out.println("CLASS_DEPARTAMENTO");
                res = DepartamentoController.excluir(codigo);
                break;
            case CLASS_OPERADOR:
                System.out.println("CLASS_DEPARTAMENTO");
                res = OperadorController.excluir(codigo);
                break;
            case CLASS_PRODUTO:
                System.out.println("CLASS_PRODUTO");
                res = ProdutoController.excluir(codigo);
                break;
            case CLASS_VENDEDOR:
                System.out.println("CLASS_VENDEDOR");
                res = VendedorController.excluir(codigo);
                break;
        }

        if (res) {
            AvisosDialog av = new AvisosDialog(null, true, EXCLUSAO_REALIZADA, false);
            retorno = 1;
            dispose();
        } else {
            retorno = 0;
            AvisosDialog av = new AvisosDialog(null, true, FALHA_NA_EXCLUSAO, true);
        }
    }//GEN-LAST:event_btnCofirmarActionPerformed

    private void edtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCodigoKeyTyped
        if (edtCodigo.getText().length() > 10) {
            evt.consume();
            new AvisosDialog(null, true, "M??ximo de 10 caracteres atingidos.", true);
        }

        char c = evt.getKeyChar();

        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            new AvisosDialog(null, true, "O campo quantidade s?? aceita valores n??mericos.", true);
        }
    }//GEN-LAST:event_edtCodigoKeyTyped

    private void btnCofirmar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCofirmar1ActionPerformed
        dispose();
    }//GEN-LAST:event_btnCofirmar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExcluirCadastroDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExcluirCadastroDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExcluirCadastroDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExcluirCadastroDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ExcluirCadastroDialog dialog = new ExcluirCadastroDialog(new javax.swing.JFrame(), true, className, retorno);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void setTitle(String v) {
        if (v != null) {
            txtTitle.setText("Excluir " + v);
        } else {
            txtTitle.setText("Excluir Cadastro");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCofirmar;
    private javax.swing.JButton btnCofirmar1;
    private javax.swing.JTextField edtCodigo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
