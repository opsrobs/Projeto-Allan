package main.java.View;

import Controller.ServicoBancoFuncionario;
import Controller.ServicoBancoLancamento;
import Controller.Utils;
import Models.Funcionario;
import Models.Lancamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.awt.Font.*;
import java.text.ParseException;

/**
 *
 * @author PremierSoft
 */
public class ConsultaDadosView extends javax.swing.JFrame {

    ServicoBancoFuncionario sb = new ServicoBancoFuncionario();
    ServicoBancoLancamento sbl = new ServicoBancoLancamento();
    Funcionario funcionario = new Funcionario();
    Utils utils = new Utils();

    public void JFrameCenterPositionTest() {
        setTitle("Consultar Funcionarios!!!");
        add(new JLabel("JFrame set to center of the screen", SwingConstants.CENTER), BorderLayout.CENTER);
        setSize(670, 530);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        setVisible(true);
    }

    public ConsultaDadosView() {
        initComponents();
        this.JFrameCenterPositionTest();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lblFuncionario = new javax.swing.JLabel();
        ComboFuncionarios = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        TxtRG = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtCPF = new javax.swing.JTextField();
        JbtnSalvar = new javax.swing.JButton();
        JbtnLimpar = new javax.swing.JButton();
        lblMes = new javax.swing.JLabel();
        lblHoras = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        TxtHoras = new javax.swing.JTextField();
        lblMes1 = new javax.swing.JLabel();
        ComboAno = new javax.swing.JComboBox<>();
        LblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        RbEditar = new javax.swing.JRadioButton();
        TxtNome = new javax.swing.JTextField();
        JbExcluir = new javax.swing.JButton();
        ComboMesInicio = new javax.swing.JComboBox<>();
        ComboMesFim = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 24)); // NOI18N
        jLabel1.setText("CONSULTA DE FUNCIONARIOS!!!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(101, 24, 393, 56);

        lblFuncionario.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        lblFuncionario.setText("Funcionario");
        getContentPane().add(lblFuncionario);
        lblFuncionario.setBounds(30, 198, 76, 20);

        ComboFuncionarios.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        ComboFuncionarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboFuncionariosItemStateChanged(evt);
            }
        });
        getContentPane().add(ComboFuncionarios);
        ComboFuncionarios.setBounds(160, 188, 248, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel2.setText("CPF:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 232, 34, 20);

        TxtRG.setEditable(false);
        TxtRG.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        TxtRG.setEnabled(false);
        getContentPane().add(TxtRG);
        TxtRG.setBounds(370, 230, 132, 28);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel3.setText("RG:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(300, 230, 26, 20);

        TxtCPF.setEditable(false);
        TxtCPF.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        TxtCPF.setEnabled(false);
        getContentPane().add(TxtCPF);
        TxtCPF.setBounds(160, 224, 132, 28);

        JbtnSalvar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        JbtnSalvar.setText("SALVAR INFORMAÇÕES");
        JbtnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbtnSalvarMouseClicked(evt);
            }
        });
        getContentPane().add(JbtnSalvar);
        JbtnSalvar.setBounds(30, 444, 201, 32);

        JbtnLimpar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        JbtnLimpar.setText("LIMPAR DADOS");
        JbtnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbtnLimparMouseClicked(evt);
            }
        });
        getContentPane().add(JbtnLimpar);
        JbtnLimpar.setBounds(290, 444, 218, 32);

        lblMes.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        lblMes.setText("Periodo inicial:");
        getContentPane().add(lblMes);
        lblMes.setBounds(30, 312, 94, 20);

        lblHoras.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        lblHoras.setText("Horas Trabalhadas:");
        getContentPane().add(lblHoras);
        lblHoras.setBounds(30, 390, 128, 20);

        lblAno.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        lblAno.setText("Ano:");
        getContentPane().add(lblAno);
        lblAno.setBounds(30, 270, 29, 20);

        TxtHoras.setEditable(false);
        TxtHoras.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        getContentPane().add(TxtHoras);
        TxtHoras.setBounds(160, 390, 46, 28);

        lblMes1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        lblMes1.setText("Final do Periodo");
        getContentPane().add(lblMes1);
        lblMes1.setBounds(30, 348, 105, 20);

        ComboAno.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        ComboAno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboAnoItemStateChanged(evt);
            }
        });
        getContentPane().add(ComboAno);
        ComboAno.setBounds(160, 260, 130, 30);

        LblTotal.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        LblTotal.setText("Total a Receber:");
        getContentPane().add(LblTotal);
        LblTotal.setBounds(240, 390, 108, 20);

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        getContentPane().add(txtTotal);
        txtTotal.setBounds(390, 390, 105, 28);

        RbEditar.setText("EDITAR");
        RbEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RbEditarMouseClicked(evt);
            }
        });
        getContentPane().add(RbEditar);
        RbEditar.setBounds(426, 190, 88, 28);

        TxtNome.setEditable(false);
        TxtNome.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        getContentPane().add(TxtNome);
        TxtNome.setBounds(160, 160, 248, 28);

        JbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/java/images/delete.png"))); // NOI18N
        JbExcluir.setBorder(null);
        JbExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbExcluirMouseClicked(evt);
            }
        });
        getContentPane().add(JbExcluir);
        JbExcluir.setBounds(243, 452, 35, 24);

        ComboMesInicio.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        ComboMesInicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboMesInicioItemStateChanged(evt);
            }
        });
        getContentPane().add(ComboMesInicio);
        ComboMesInicio.setBounds(160, 307, 132, 30);

        ComboMesFim.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        ComboMesFim.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboMesFimItemStateChanged(evt);
            }
        });
        getContentPane().add(ComboMesFim);
        ComboMesFim.setBounds(160, 343, 132, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearScreen() {
        if (ComboFuncionarios.isDisplayable()) {
            ComboFuncionarios.setSelectedIndex(-1);
        }
        if (ComboAno.isDisplayable()) {
            ComboAno.setSelectedIndex(-1);
        }

        TxtCPF.setText("");
        TxtRG.setText("");
        TxtHoras.setText("");
        ComboMesInicio.setSelectedIndex(-1);
        ComboMesFim.setSelectedIndex(-1);
        txtTotal.setText("");
        TxtNome.setText("");
        TxtNome.setVisible(false);
        RbEditar.setSelected(false);
        JbtnSalvar.setEnabled(false);
        JbtnSalvar.setVisible(false);
        this.invisibleScreenInit(false);
        this.invisibleScreenEnd(false);

    }


    private void ComboFuncionariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboFuncionariosItemStateChanged
        if (ComboFuncionarios.getItemCount() <= 0) {
            return;
        }
        if (ComboFuncionarios.getSelectedIndex() < 0) {
            return;
        }
        funcionario = (Funcionario) ComboFuncionarios.getSelectedItem();
        assert funcionario != null;
        TxtCPF.setText(funcionario.getCpf());
        TxtRG.setText(funcionario.getRg());
        try {
            utils.getAnoFuncionario(ComboAno, sbl, funcionario.getCod_funcionario(), " ano");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDadosView.class.getName()).log(Level.SEVERE, null, ex);
        }
        JbtnSalvar.setVisible(true);
        JbtnSalvar.setEnabled(true);
        JbtnLimpar.setEnabled(true);
        utils.visibleButtonTrue(RbEditar, TxtNome, funcionario.getNome_funcionario());
    }//GEN-LAST:event_ComboFuncionariosItemStateChanged

    private void verifyMonths() {
        if (ComboAno.getSelectedItem() == null) {
            return;
        } else {
            try {

                utils.mesFuncionarioBy(ComboMesInicio, sbl, funcionario.getCod_funcionario(), (int) ComboAno.getSelectedItem());
                utils.mesFuncionarioBy(ComboMesFim, sbl, funcionario.getCod_funcionario(), (int) ComboAno.getSelectedItem());

                if (ComboMesInicio.getItemCount() == 0
                        || ComboMesInicio.getItemCount() == 1) {
                    this.invisibleScreenInit(true);
                    if (ComboMesInicio.isValid()) {
                        this.horasTotais();
                    }
                } else {
                    this.invisibleScreenInit(true);
                    this.invisibleScreenEnd(true);

                    utils.mesFuncionarioBy(ComboMesInicio, sbl, funcionario.getCod_funcionario(), (int) ComboAno.getSelectedItem());
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaDadosView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void invisibleScreenEnd(boolean status) {
        lblMes1.setVisible(status);
        ComboMesFim.setVisible(status);

    }

    private void invisibleScreenInit(boolean status) {
        lblMes.setVisible(status);
        ComboMesInicio.setVisible(status);

    }

    private void JbtnSalvarMouseClicked(MouseEvent evt) {//GEN-FIRST:event_JbtnSalvarMouseClicked
        if (TxtNome.getText().isBlank() | TxtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome válido");
            TxtNome.requestFocus();
            return;
        }

        try {
            if (ComboFuncionarios.getSelectedIndex() >= 0) {

                Funcionario funcionario = (Funcionario) ComboFuncionarios.getSelectedItem();
                assert funcionario != null;

                funcionario.setNome_funcionario(TxtNome.getText());
                sb.update(funcionario);

                JOptionPane.showMessageDialog(rootPane, funcionario.getNome_funcionario());
                JOptionPane.showMessageDialog(rootPane, funcionario.getCod_funcionario());

                JOptionPane.showMessageDialog(
                        null, "Cadastrado com sucesso",
                        "Cadastro!!!", JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon("C:\\Users\\PremierSoft\\IdeaProjects\\Campeonatos_Futebol\\src\\View\\Cadastro.gif"));

                this.clearScreen();
            }

        } catch (SQLException ex) {
            Logger.getLogger(main.java.View.FuncionarioView.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_JbtnSalvarMouseClicked

    private void JbtnLimparMouseClicked(MouseEvent evt) {//GEN-FIRST:event_JbtnLimparMouseClicked
        this.clearScreen();
    }//GEN-LAST:event_JbtnLimparMouseClicked

    private void formWindowActivated(WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            this.edit();
            utils.atualizarFuncionario(ComboFuncionarios, sb);

        } catch (SQLException ex) {
            Logger.getLogger(main.java.View.LancamentoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.clearScreen();
    }//GEN-LAST:event_formWindowActivated

    private float totalAReceber(int value) throws SQLException {
        return utils.verifyValueOfCombo(funcionario.getCod_funcionario()) * value;
    }

    private int validateMonth() {
        if (ComboMesFim.getSelectedIndex() > -1) {
            return utils.reverseMonth(Objects.requireNonNull(ComboMesFim.getSelectedItem()).toString());
        }
        return utils.reverseMonth(Objects.requireNonNull(ComboMesInicio.getSelectedItem()).toString());

    }

    private void horasTotais() {
        int value;
        int firstMonth = utils.reverseMonth(Objects.requireNonNull(ComboMesInicio.getSelectedItem()).toString());
        System.err.println(firstMonth);
        try {
            value = utils.verifySumTime(Integer.parseInt(String.valueOf(firstMonth)), this.validateMonth(),
                    funcionario.getCod_funcionario(),
                    Integer.parseInt(Objects.requireNonNull(ComboAno.getSelectedItem()).toString()));

            txtTotal.setText("R$ " + utils.formatTot(this.totalAReceber(value)));
            TxtHoras.setText(String.valueOf(value));
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDadosView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ComboAnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboAnoItemStateChanged
        TxtHoras.setText("");
        this.invisibleScreenInit(false);
        this.invisibleScreenEnd(false);
        if (ComboAno.isValid()) {
            this.verifyMonths();
        }

    }//GEN-LAST:event_ComboAnoItemStateChanged

    private void RbEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RbEditarMouseClicked
        this.edit();
    }//GEN-LAST:event_RbEditarMouseClicked

    private void JbExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JbExcluirMouseClicked
        if (ComboFuncionarios.getItemCount() <= 0) {
            return;
        }
        if (ComboFuncionarios.getSelectedIndex() < 0) {
            return;
        }
        Funcionario funcionario = (Funcionario) ComboFuncionarios.getSelectedItem();
        assert funcionario != null;
        TxtNome.setText(funcionario.getNome_funcionario());
        int del = JOptionPane.showConfirmDialog(null, "Você deseja exlcuir o registro "
                + funcionario + "?", "Excluir...",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon("C:\\Users\\PremierSoft\\Documents\\NetBeansProjects\\Projeto-Allan\\src\\images\\39-trash-solid.gif"));

        if (del == JOptionPane.YES_OPTION) {
            try {
                sb.delete(funcionario);
                utils.atualizarFuncionario(ComboFuncionarios, sb);
                this.clearScreen();
                JOptionPane.showMessageDialog(null, "Excluido com sucesso!!!",
                        "Cadastro!!!", JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon("C:\\Users\\PremierSoft\\Documents\\NetBeansProjects\\Projeto-Allan\\src\\images\\18-autorenew-outline.gif"));
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaDadosView.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (del == JOptionPane.NO_OPTION) {
            this.clearScreen();
        }
    }//GEN-LAST:event_JbExcluirMouseClicked

    private void ComboMesInicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboMesInicioItemStateChanged
        if (ComboMesInicio.getItemCount() <= 0) {
            return;
        }
        if (ComboMesInicio.getSelectedIndex() < 0) {
            return;
        }
        String lancamento = (String) ComboMesInicio.getSelectedItem();
        assert lancamento != null;
        if (ComboMesInicio.isValid()) {
            this.horasTotais();
        }
    }//GEN-LAST:event_ComboMesInicioItemStateChanged

    private void ComboMesFimItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboMesFimItemStateChanged
        if (ComboMesFim.getItemCount() <= 0) {
            return;
        }
        if (ComboMesFim.getSelectedIndex() < 0) {
            return;
        }
        String lancamento = (String) ComboMesFim.getSelectedItem();
        if (ComboMesFim.isValid()) {
            this.horasTotais();
        }
        assert lancamento != null;
    }//GEN-LAST:event_ComboMesFimItemStateChanged

    private void edit() {
        if (RbEditar.isSelected()) {
            TxtNome.setVisible(true);
            ComboMesInicio.setEnabled(false);
            ComboMesFim.setEnabled(false);
            ComboAno.setEnabled(false);
            TxtHoras.setEnabled(false);
            txtTotal.setEnabled(false);
            TxtNome.setEditable(true);
            TxtNome.setEnabled(true);
        } else if (!RbEditar.isSelected()) {
            TxtNome.setVisible(false);
            ComboMesInicio.setEnabled(true);
            ComboFuncionarios.setSelectedIndex(-1);
            ComboMesFim.setEnabled(true);
            ComboAno.setEnabled(true);
            TxtHoras.setEnabled(true);
            txtTotal.setEnabled(true);
            TxtNome.setEnabled(false);
            TxtNome.setEditable(false);
        }
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
            java.util.logging.Logger.getLogger(ConsultaDadosView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ConsultaDadosView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Lancamento> ComboAno;
    private javax.swing.JComboBox<Funcionario> ComboFuncionarios;
    private javax.swing.JComboBox<String> ComboMesFim;
    private javax.swing.JComboBox<String> ComboMesInicio;
    private javax.swing.JButton JbExcluir;
    private javax.swing.JButton JbtnLimpar;
    private javax.swing.JButton JbtnSalvar;
    private javax.swing.JLabel LblTotal;
    private javax.swing.JRadioButton RbEditar;
    private javax.swing.JTextField TxtCPF;
    private javax.swing.JTextField TxtHoras;
    private javax.swing.JTextField TxtNome;
    private javax.swing.JTextField TxtRG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblMes1;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
