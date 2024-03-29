package main.java.View;

import Controller.ServicoBancoFuncionario;
import Controller.ServicoBancoLancamento;
import Controller.Utils;
import Models.Funcionario;
import Models.Lancamento;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class LancamentoView extends javax.swing.JFrame {

    Lancamento lancamento = new Lancamento();
    Utils utils = new Utils();
    ServicoBancoFuncionario sb = new ServicoBancoFuncionario();
    ServicoBancoLancamento sbl = new ServicoBancoLancamento();

    private void JFrameCenterPositionTest() {
        setTitle("JFrameCenter Position");
        add(new JLabel("JFrame set to center of the screen", SwingConstants.CENTER), BorderLayout.CENTER);
        setSize(670, 530);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        setVisible(true);
    }

    public LancamentoView() {
        initComponents();
        this.JFrameCenterPositionTest();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxtHoras = new javax.swing.JTextField();
        lblFuncionario = new javax.swing.JLabel();
        ComboFuncionarios = new javax.swing.JComboBox<>();
        lblMes = new javax.swing.JLabel();
        TxtName = new javax.swing.JTextField();
        lblHoras = new javax.swing.JLabel();
        TxtMes = new javax.swing.JTextField();
        lblAno = new javax.swing.JLabel();
        TxtAno = new javax.swing.JTextField();
        JbtnSalvar = new javax.swing.JButton();
        JbtnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 24)); // NOI18N
        jLabel1.setText("CADASTRO DE LANÇAMENTOS!!!");

        TxtHoras.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lblFuncionario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFuncionario.setText("Funcionario");

        ComboFuncionarios.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ComboFuncionarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboFuncionariosItemStateChanged(evt);
            }
        });

        lblMes.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblMes.setText("Mês:");

        TxtName.setEditable(false);
        TxtName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lblHoras.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblHoras.setText("Horas Trabalhadas:");

        TxtMes.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lblAno.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblAno.setText("Ano:");

        TxtAno.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        JbtnSalvar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        JbtnSalvar.setText("SALVAR INFORMAÇÕES");
        JbtnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbtnSalvarMouseClicked(evt);
            }
        });

        JbtnLimpar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        JbtnLimpar.setText("LIMPAR DADOS");
        JbtnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbtnLimparMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(102, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(JbtnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFuncionario)
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboFuncionarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TxtName)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHoras)
                                    .addComponent(lblMes))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TxtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblAno)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TxtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(TxtHoras))))))
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(ComboFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFuncionario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblHoras))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMes)
                    .addComponent(TxtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAno)
                    .addComponent(TxtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbtnSalvar)
                    .addComponent(JbtnLimpar))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            utils.atualizarFuncionario(ComboFuncionarios, sb);
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.clearScreen();
    }//GEN-LAST:event_formWindowActivated

    private void JbtnSalvarMouseClicked(MouseEvent evt) {//GEN-FIRST:event_JbtnSalvarMouseClicked
        if (TxtName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe um nome!");
            TxtName.requestFocus();
            return;
        }
        if (TxtHoras.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe um CPF válido!");
            TxtHoras.requestFocus();
            return;

        }
        if (TxtMes.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe um RG!");
            TxtMes.requestFocus();
            return;
        }
        if (TxtAno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe O genero!");
            TxtAno.requestFocus();
            return;
        }

        try {
            if (ComboFuncionarios.getSelectedIndex() >= 0) {

                Funcionario funcionario = (Funcionario) ComboFuncionarios.getSelectedItem();
                assert funcionario != null;
                funcionario.setNome_funcionario(TxtName.getText());
                sb.update(funcionario);

                lancamento = new Lancamento(funcionario.getCod_funcionario(),
                        Float.parseFloat(TxtHoras.getText()),
                        Integer.parseInt(TxtMes.getText()),
                        Integer.parseInt(TxtAno.getText()));
                sbl.insert(lancamento);
            }
            utils.atualizarFuncionario(ComboFuncionarios, sb);
            clearScreen();
            JOptionPane.showMessageDialog(
                    null, "Cadastrado com sucesso",
                    "Cadastro!!!", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("C:\\Users\\PremierSoft\\IdeaProjects\\Campeonatos_Futebol\\src\\View\\Cadastro.gif"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_JbtnSalvarMouseClicked

    private void JbtnLimparMouseClicked(MouseEvent evt) {//GEN-FIRST:event_JbtnLimparMouseClicked
        this.clearScreen();
    }//GEN-LAST:event_JbtnLimparMouseClicked

    private void ComboFuncionariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboFuncionariosItemStateChanged
        if (ComboFuncionarios.getItemCount() <= 0) {
            return;
        }
        if (ComboFuncionarios.getSelectedIndex() < 0) {
            return;
        }
        Funcionario funcionario = (Funcionario) ComboFuncionarios.getSelectedItem();
        assert funcionario != null;
        TxtName.setText(funcionario.getNome_funcionario());
        JbtnSalvar.setVisible(true);
        JbtnSalvar.setEnabled(true);
        JbtnLimpar.setEnabled(true);
    }//GEN-LAST:event_ComboFuncionariosItemStateChanged

    private void clearScreen() {
        if (ComboFuncionarios.isDisplayable()) {
            ComboFuncionarios.setSelectedIndex(-1);
        }

        TxtName.setText("");
        TxtHoras.setText("");
        TxtMes.setText("");
        TxtAno.setText("");

        JbtnLimpar.setEnabled(false);
        JbtnSalvar.setEnabled(false);
        JbtnSalvar.setVisible(false);

    }

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
            java.util.logging.Logger.getLogger(LancamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new LancamentoView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Funcionario> ComboFuncionarios;
    private javax.swing.JButton JbtnLimpar;
    private javax.swing.JButton JbtnSalvar;
    private javax.swing.JTextField TxtAno;
    private javax.swing.JTextField TxtHoras;
    private javax.swing.JTextField TxtMes;
    private javax.swing.JTextField TxtName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JLabel lblMes;
    // End of variables declaration//GEN-END:variables
}
