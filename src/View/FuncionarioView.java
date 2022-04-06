package View;

import Controller.ServicoBancoFuncionario;
import Controller.Utils;
import Models.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PremierSoft
 */
public class FuncionarioView extends javax.swing.JFrame {

    Utils utils = new Utils();
    ServicoBancoFuncionario sb = new ServicoBancoFuncionario();
    private final ImageIcon icon = new ImageIcon("C:\\Users\\PremierSoft\\Documents\\NetBeansProjects\\Projeto-Allan\\src\\images\\1140-error-outline.gif");
    private final ImageIcon defaultIcon = new ImageIcon("C:\\Users\\PremierSoft\\Documents\\NetBeansProjects\\Projeto-Allan\\src\\images\\55-error-outline.gif");

    public FuncionarioView() {
        initComponents();
        this.JFrameCenterPositionTest();
    }

    public void JFrameCenterPositionTest() {
        setTitle("JFrameCenter Position");
        add(new JLabel("JFrame set to center of the screen", SwingConstants.CENTER), BorderLayout.CENTER);
        setSize(670, 530);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        setVisible(true);
    }

    private void clearScreen() {
        TxtName.setText("");
        MaskCpf.setText("");
        TxtRg.setText("");
        TxtGener.setText("");
        TxtValor.setText("");
        TxtStatus.setText("");
        MaskData.setText("");
        requiredCpf.setIcon(defaultIcon);

        JbtnLimpar.setEnabled(false);
        JbtnSalvar.setEnabled(false);
        JbtnSalvar.setVisible(false);
    }

    private void colorMask() {
        if (MaskCpf.isFocusable()) {
            MaskCpf.setSelectionColor(Color.red);
        }
    }

    private void verifyCpf() {

        if (utils.verificaCpf(MaskCpf.getText())) {
            requiredCpf.setVisible(false);
        } else {
            requiredCpf.setIcon(icon);
            this.colorMask();
            return;
        }
        requiredCpf.setVisible(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLabel jLabel1 = new JLabel();
        JLabel lblName = new JLabel();
        JLabel lblCpf = new JLabel();
        JLabel lblRg = new JLabel();
        JLabel lblGenero = new JLabel();
        TxtName = new javax.swing.JTextField();
        TxtRg = new javax.swing.JTextField();
        TxtGener = new javax.swing.JTextField();
        JLabel lblValor = new JLabel();
        TxtValor = new javax.swing.JTextField();
        MaskCpf = new javax.swing.JFormattedTextField();
        JbtnSalvar = new javax.swing.JButton();
        JbtnLimpar = new javax.swing.JButton();
        requiredCpf = new javax.swing.JLabel();
        JLabel lblData_Nasc = new JLabel();
        MaskData = new javax.swing.JFormattedTextField();
        JLabel lblStatus = new JLabel();
        TxtStatus = new javax.swing.JTextField();
        JMenuBar jMenuBar1 = new JMenuBar();
        JMenu jMenu1 = new JMenu();
        JMenu jMenu2 = new JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated();
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", Font.ITALIC, 24)); // NOI18N
        jLabel1.setText("CADASTRO DE FUNCIONARIOS!!!");

        lblName.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18)); // NOI18N
        lblName.setText("Nome:");

        lblCpf.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18)); // NOI18N
        lblCpf.setText("CPF:");

        lblRg.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18)); // NOI18N
        lblRg.setText("RG:");

        lblGenero.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18)); // NOI18N
        lblGenero.setText("Genero:");

        lblValor.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18)); // NOI18N
        lblValor.setText("Valor por hora:");

        TxtValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtValorFocusGained();
            }
        });

        try {
            MaskCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        MaskCpf.setFont(new java.awt.Font("Dialog", Font.PLAIN, 14)); // NOI18N
        MaskCpf.setMinimumSize(new java.awt.Dimension(5, 18));
        MaskCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MaskCpfFocusLost();
            }
        });
        MaskCpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MaskCpfMouseClicked();
            }
        });

        JbtnSalvar.setText("SALVAR INFORMAÇÕES");
        JbtnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbtnSalvarMouseClicked();
            }
        });

        JbtnLimpar.setText("LIMPAR DADOS");
        JbtnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbtnLimparMouseClicked();
            }
        });

        requiredCpf.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/images/55-error-outline.gif")))); // NOI18N

        lblData_Nasc.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18)); // NOI18N
        lblData_Nasc.setText("Data nascimento:");

        try {
            MaskData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        MaskData.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15)); // NOI18N

        lblStatus.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18)); // NOI18N
        lblStatus.setText("Status:");

        TxtStatus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtStatusFocusGained();
            }
        });

        jMenu1.setText("Menu de Sistemas");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(JbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(JbtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblData_Nasc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MaskData, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRg)
                        .addGap(21, 21, 21)
                        .addComponent(TxtRg))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(TxtName, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGenero)
                            .addComponent(lblCpf))
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtGener, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MaskCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(requiredCpf)
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(TxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData_Nasc)
                    .addComponent(MaskData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRg)
                    .addComponent(TxtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCpf)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MaskCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblStatus)
                                .addComponent(TxtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblGenero)
                                    .addComponent(TxtGener, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblValor)
                                    .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(requiredCpf))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbtnSalvar)
                    .addComponent(JbtnLimpar))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbtnSalvarMouseClicked() {//GEN-FIRST:event_JbtnSalvarMouseClicked
        if (TxtName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe um nome!");
            TxtName.requestFocus();
            return;
        }
        if (!utils.verificaCpf(MaskCpf.getText())) {
            JOptionPane.showMessageDialog(null, "Informe um CPF válido!");
            MaskCpf.requestFocus();
            return;

        }
        if (TxtRg.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe um RG!");
            TxtRg.requestFocus();
            return;
        }
        if (TxtGener.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe O genero!");
            TxtGener.requestFocus();
            return;
        }
        if (TxtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o Valor!");
            TxtValor.requestFocus();
            return;
        }
        if (MaskData.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma data!");
            TxtValor.requestFocus();
            return;
        }
        if (TxtStatus.getText().isEmpty() || !(TxtStatus.getText().equalsIgnoreCase("Ativo"))) {
            if (TxtStatus.getText().equalsIgnoreCase("Inativo")) {
                JOptionPane.showMessageDialog(null, "Informe um status valido!\n\tATIVO \n\tINATIVO");
                TxtValor.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(null, "Informe um status valido!\n\tATIVO \n\tINATIVO");
            TxtValor.requestFocus();
            return;
        }

        try {
            Funcionario funcionario = new Funcionario(TxtName.getText(),
                    MaskCpf.getText(), TxtRg.getText(),
                    TxtGener.getText(), Float.parseFloat(TxtValor.getText()),
                    utils.strToDate(MaskData.getText()), TxtStatus.getText());
            sb.insert(funcionario);
            JOptionPane.showMessageDialog(
                    null, "Cadastrado com sucesso",
                    "Cadastro!!!", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("C:\\Users\\PremierSoft\\IdeaProjects\\Campeonatos_Futebol\\src\\View\\Cadastro.gif"));
            this.clearScreen();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(FuncionarioView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_JbtnSalvarMouseClicked

    private void formWindowActivated() {//GEN-FIRST:event_formWindowActivated
        this.colorMask();
    }//GEN-LAST:event_formWindowActivated

    private void JbtnLimparMouseClicked() {//GEN-FIRST:event_JbtnLimparMouseClicked
        this.clearScreen();
    }//GEN-LAST:event_JbtnLimparMouseClicked

    private void MaskCpfFocusLost() {//GEN-FIRST:event_MaskCpfFocusLost
        JbtnLimpar.setEnabled(true);
        JbtnSalvar.setEnabled(false);
        JbtnSalvar.setVisible(false);
        this.verifyCpf();

    }//GEN-LAST:event_MaskCpfFocusLost

    private void TxtValorFocusGained() {//GEN-FIRST:event_TxtValorFocusGained
        JbtnSalvar.setEnabled(true);
        JbtnSalvar.setVisible(true);

    }//GEN-LAST:event_TxtValorFocusGained

    private void MaskCpfMouseClicked() {//GEN-FIRST:event_MaskCpfMouseClicked
        this.verifyCpf();
    }//GEN-LAST:event_MaskCpfMouseClicked

    private void TxtStatusFocusGained() {//GEN-FIRST:event_TxtStatusFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtStatusFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FuncionarioView().setVisible(true));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbtnLimpar;
    private javax.swing.JButton JbtnSalvar;
    private javax.swing.JFormattedTextField MaskCpf;
    private javax.swing.JFormattedTextField MaskData;
    private javax.swing.JTextField TxtGener;
    private javax.swing.JTextField TxtName;
    private javax.swing.JTextField TxtRg;
    private javax.swing.JTextField TxtStatus;
    private javax.swing.JTextField TxtValor;
    private javax.swing.JLabel requiredCpf;
    // End of variables declaration//GEN-END:variables

}
