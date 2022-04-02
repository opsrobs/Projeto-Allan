/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ServicoBancoLancamento;
import Controller.SimpleTableModel;
import Controller.Utils;
import Models.Lancamento;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author PremierSoft
 */
public class SearchTable extends javax.swing.JFrame {

    private final Lancamento lancamento = new Lancamento();
    private final ServicoBancoLancamento sbl = new ServicoBancoLancamento();
    Utils utils = new Utils();

    public SearchTable() {
        this.JFrameCenterPositionTest();
        initComponents();
    }

    private void JFrameCenterPositionTest() {
        setTitle("JFrameCenter Position");
        add(new JLabel("", SwingConstants.CENTER), BorderLayout.CENTER);
        setSize(670, 530);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JScrollPane jScrollPane1 = new JScrollPane();
        JtTabelaSalario = new javax.swing.JTable();
        JLabel lblAno = new JLabel();
        ComboMes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        JtTabelaSalario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JtTabelaSalario);

        lblAno.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15)); // NOI18N
        lblAno.setText("Mês:");

        ComboMes.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15)); // NOI18N
        ComboMes.addItemListener(this::ComboMesItemStateChanged);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblAno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAno))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            utils.mesFuncionario(ComboMes, sbl,"mes");
        } catch (SQLException ex) {
            Logger.getLogger(SearchTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.carregarTabela();
        ComboMes.setSelectedIndex(0);

    }//GEN-LAST:event_formWindowActivated

    private void ComboMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboMesItemStateChanged
//        this.clearTotal();
//        TxtNome.setVisible(false);

        if (ComboMes.getItemCount() <= 0) {
            return;
        }
        if (ComboMes.getSelectedIndex() < 0) {
            return;
        }
        String lancamento = (String) ComboMes.getSelectedItem();
        assert lancamento != null;
    }//GEN-LAST:event_ComboMesItemStateChanged

    private void carregarTabela() {
        try {
            ArrayList<String[]> dados = sbl.getTabelaByQuery();
            String[] colunas = new String[]{
                "Nome",
                "Horas Trabalhadas",
                "Mês",
                "Valor por \nhora",
                "Total a receber",
                "Status"
            };
            SimpleTableModel table = new SimpleTableModel(dados, colunas);
            JtTabelaSalario.setModel(table);
            JtTabelaSalario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        } catch (SQLException ignored) {
        }
    }
    
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
            java.util.logging.Logger.getLogger(SearchTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new SearchTable().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboMes;
    private javax.swing.JTable JtTabelaSalario;
    // End of variables declaration//GEN-END:variables
}
