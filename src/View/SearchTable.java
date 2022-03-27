/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ServicoBancoLancamento;
import Controller.SimpleTableModel;
import Models.Lancamento;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author PremierSoft
 */
public class SearchTable extends javax.swing.JFrame {

    private final Lancamento lancamento = new Lancamento();
    ServicoBancoLancamento sbl = new ServicoBancoLancamento();

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
        JLabel lblMes = new JLabel();
        JLabel lblAno = new JLabel();
        JLabel lblMes1 = new JLabel();
        ComboInicio = new javax.swing.JComboBox<>();
        ComboFim = new javax.swing.JComboBox<>();
        ComboAno = new javax.swing.JComboBox<>();

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

        lblMes.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15)); // NOI18N
        lblMes.setText("Periodo inicial:");

        lblAno.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15)); // NOI18N
        lblAno.setText("Ano:");

        lblMes1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15)); // NOI18N
        lblMes1.setText("Final do Periodo");

        ComboInicio.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15)); // NOI18N
        ComboInicio.addItemListener(this::ComboInicioItemStateChanged);

        ComboFim.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15)); // NOI18N
        ComboFim.addItemListener(this::ComboFimItemStateChanged);

        ComboAno.setFont(new java.awt.Font("Dialog", Font.PLAIN, 15)); // NOI18N
        ComboAno.addItemListener(this::ComboAnoItemStateChanged);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblMes)
                .addGap(35, 35, 35)
                .addComponent(ComboInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblMes1)
                .addGap(6, 6, 6)
                .addComponent(ComboFim, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblAno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboAno, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblMes))
                    .addComponent(ComboInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMes1)
                        .addComponent(ComboFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblAno))
                    .addComponent(ComboAno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboInicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboInicioItemStateChanged
        if (ComboInicio.getItemCount() <= 0) {
            return;
        }
        if (ComboInicio.getSelectedIndex() < 0) {
            return;
        }
        Lancamento lancamento = (Lancamento) ComboInicio.getSelectedItem();
        assert lancamento != null;
    }//GEN-LAST:event_ComboInicioItemStateChanged

    private void ComboFimItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboFimItemStateChanged
        if (ComboFim.getItemCount() <= 0) {
            return;
        }
        if (ComboFim.getSelectedIndex() < 0) {
            return;
        }
        Lancamento lancamento = (Lancamento) ComboFim.getSelectedItem();
        assert lancamento != null;
        //        System.out.println(ComboFim.getSelectedItem());
        //        System.out.println(ComboInicio.getSelectedItem());
    }//GEN-LAST:event_ComboFimItemStateChanged

    private void ComboAnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboAnoItemStateChanged
        if (ComboInicio.getSelectedIndex() >= 0 && ComboFim.getSelectedIndex() >= 0) {
            ComboAno.getSelectedIndex();
        }
    }//GEN-LAST:event_ComboAnoItemStateChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.carregarTabela();
    }//GEN-LAST:event_formWindowActivated

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
    private javax.swing.JComboBox<Lancamento> ComboAno;
    private javax.swing.JComboBox<Lancamento> ComboFim;
    private javax.swing.JComboBox<Lancamento> ComboInicio;
    private javax.swing.JTable JtTabelaSalario;
    // End of variables declaration//GEN-END:variables
}
