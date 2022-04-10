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
public class ConsultaDadosGraphicView extends javax.swing.JFrame {

    ServicoBancoFuncionario sb = new ServicoBancoFuncionario();
    ServicoBancoLancamento sbl = new ServicoBancoLancamento();
    private int codFun = 0;
    Utils utils = new Utils();
    Funcionario funcionario = new Funcionario();

    public void JFrameCenterPositionTest() {
        setTitle("Consultar Funcionarios!!!");
        add(new JLabel("JFrame set to center of the screen", SwingConstants.CENTER), BorderLayout.CENTER);
        setSize(580, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        setVisible(true);
    }

    public ConsultaDadosGraphicView() {
        initComponents();
        this.JFrameCenterPositionTest();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lblFuncionario = new javax.swing.JLabel();
        ComboFuncionarios = new javax.swing.JComboBox<>();
        LbPeriodoInicial = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        LbPeriodoFinal = new javax.swing.JLabel();
        ComboAno = new javax.swing.JComboBox<>();
        ComboMesInicio = new javax.swing.JComboBox<>();
        ComboMesFim = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 24)); // NOI18N
        jLabel1.setText("CONSULTA DE FUNCIONARIOS!!!");

        lblFuncionario.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        lblFuncionario.setText("Funcionario");

        ComboFuncionarios.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        ComboFuncionarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboFuncionariosItemStateChanged(evt);
            }
        });

        LbPeriodoInicial.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        LbPeriodoInicial.setText("Periodo inicial:");

        lblAno.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        lblAno.setText("Ano:");

        LbPeriodoFinal.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        LbPeriodoFinal.setText("Final do Periodo");

        ComboAno.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        ComboAno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboAnoItemStateChanged(evt);
            }
        });

        ComboMesInicio.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        ComboMesInicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboMesInicioItemStateChanged(evt);
            }
        });

        ComboMesFim.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        ComboMesFim.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboMesFimItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LbPeriodoInicial)
                            .addComponent(LbPeriodoFinal)
                            .addComponent(lblFuncionario))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ComboFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboAno, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ComboMesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ComboMesFim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblFuncionario))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ComboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAno)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbPeriodoInicial)
                    .addComponent(ComboMesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbPeriodoFinal)
                    .addComponent(ComboMesFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(354, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearScreen() {
        if (ComboFuncionarios.isDisplayable()) {
            ComboFuncionarios.setSelectedIndex(-1);
        }
        ComboMesInicio.setSelectedIndex(-1);
        ComboMesFim.setSelectedIndex(-1);
        this.invisibleScreenInit(false);
        this.invisibleScreenEnd(false);
    }

    private void invisibleScreenEnd(boolean status) {
        LbPeriodoFinal.setVisible(status);
        ComboMesFim.setVisible(status);

    }

    private void invisibleScreenInit(boolean status) {
        LbPeriodoInicial.setVisible(status);
        ComboMesInicio.setVisible(status);

    }

    private void clearTotal() {
        ComboMesFim.setSelectedIndex(-1);
        ComboAno.setSelectedIndex(-1);
    }


    private void ComboFuncionariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboFuncionariosItemStateChanged
        if (ComboFuncionarios.getItemCount() <= 0) {
            return;
        }
        if (ComboFuncionarios.getSelectedIndex() < 0) {
            return;
        }
        funcionario = (Funcionario) ComboFuncionarios.getSelectedItem();

        try {
            utils.getAnoFuncionario(ComboAno, sbl, funcionario.getCod_funcionario(), " ano");

        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDadosGraphicView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ComboFuncionariosItemStateChanged

    private void verifyMonths() {
        try {
            utils.mesFuncionarioBy(ComboMesInicio, sbl, funcionario.getCod_funcionario(), (int) ComboAno.getSelectedItem());
            utils.mesFuncionarioBy(ComboMesFim, sbl, funcionario.getCod_funcionario(), (int) ComboAno.getSelectedItem());

            if (ComboMesInicio.getItemCount() == 0
                    || ComboMesInicio.getItemCount() == 1) {
                System.err.println(ComboMesInicio.getSelectedObjects().length + " Count while");

                this.invisibleScreenInit(true);
            } else {
                System.err.println(ComboMesInicio.getSelectedObjects().length + " Count while +");
                this.invisibleScreenInit(true);
                this.invisibleScreenEnd(true);

                utils.mesFuncionarioBy(ComboMesInicio, sbl, funcionario.getCod_funcionario(), (int) ComboAno.getSelectedItem());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDadosGraphicView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void formWindowActivated(WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        try {
            utils.atualizarFuncionario(ComboFuncionarios, sb);

        } catch (SQLException ex) {
            Logger.getLogger(LancamentoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.clearScreen();

    }//GEN-LAST:event_formWindowActivated


    private void ComboMesInicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboMesInicioItemStateChanged
        if (ComboMesInicio.getItemCount() <= 0) {
            return;
        }
        if (ComboMesInicio.getSelectedIndex() < 0) {
            return;
        }
        String lancamento = (String) ComboMesInicio.getSelectedItem();
//        st.screenTable(utils.reverseMonth(Objects.requireNonNull(ComboMes.getSelectedItem()).toString()));
        assert lancamento != null;
    }//GEN-LAST:event_ComboMesInicioItemStateChanged

    private void ComboMesFimItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboMesFimItemStateChanged
        if (ComboMesFim.getItemCount() <= 0) {
            return;
        }
        if (ComboMesFim.getSelectedIndex() < 0) {
            return;
        }
        String lancamento = (String) ComboMesFim.getSelectedItem();
//        this.screenTable(utils.reverseMonth(Objects.requireNonNull(ComboMes.getSelectedItem()).toString()));
        assert lancamento != null;
    }//GEN-LAST:event_ComboMesFimItemStateChanged

    private void ComboAnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboAnoItemStateChanged
        if (ComboAno.getItemCount() <= 0) {
            return;
        }
        if (ComboAno.getSelectedIndex() < 0) {
            return;
        }
        this.invisibleScreenInit(false);
        this.invisibleScreenEnd(false);
        if (ComboAno.isValid()) {
            this.verifyMonths();
        }

    }//GEN-LAST:event_ComboAnoItemStateChanged

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
            java.util.logging.Logger.getLogger(ConsultaDadosGraphicView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ConsultaDadosGraphicView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Lancamento> ComboAno;
    private javax.swing.JComboBox<Funcionario> ComboFuncionarios;
    private javax.swing.JComboBox<String> ComboMesFim;
    private javax.swing.JComboBox<String> ComboMesInicio;
    private javax.swing.JLabel LbPeriodoFinal;
    private javax.swing.JLabel LbPeriodoInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblFuncionario;
    // End of variables declaration//GEN-END:variables
}
