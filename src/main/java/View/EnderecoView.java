/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.java.View;

import Models.Funcionario;
import com.google.gson.Gson;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import main.java.Controller.ServicoBancoEndereco;
import main.java.Models.Endereco;

/**
 *
 * @author PremierSoft
 */
public class EnderecoView extends javax.swing.JFrame {

    ServicoBancoEndereco sbe = new ServicoBancoEndereco();

    public EnderecoView() {
        initComponents();
        this.JFrameCenterPositionTest();
    }

    public void JFrameCenterPositionTest() {
        setTitle("JFrameCenter Position");
        add(new JLabel("JFrame set to center of the screen", SwingConstants.CENTER), BorderLayout.CENTER);
        setSize(670, 530);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        setVisible(true);
    }
    public void clearScreen(){
        TxtBairro.setText("");
        TxtCep.setText("");
        TxtCidade.setText("");
        TxtComplmento.setText("");
        TxtEstado.setText("");
        TxtNumero.setText("");
        TxtRua.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LblName = new javax.swing.JLabel();
        TxtCep = new javax.swing.JTextField();
        LblData_Nasc = new javax.swing.JLabel();
        TxtEstado = new javax.swing.JTextField();
        LblCpf = new javax.swing.JLabel();
        LblGenero = new javax.swing.JLabel();
        TxtBairro = new javax.swing.JTextField();
        TxtCidade = new javax.swing.JTextField();
        LblGenero1 = new javax.swing.JLabel();
        LblGenero2 = new javax.swing.JLabel();
        LblGenero3 = new javax.swing.JLabel();
        TxtRua = new javax.swing.JTextField();
        TxtNumero = new javax.swing.JTextField();
        TxtComplmento = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LblName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LblName.setText("CEP:");

        LblData_Nasc.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LblData_Nasc.setText("Estado:");

        LblCpf.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LblCpf.setText("Cidade:");

        LblGenero.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LblGenero.setText("Bairro:");

        LblGenero1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LblGenero1.setText("Rua:");

        LblGenero2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LblGenero2.setText("Complemento:");

        LblGenero3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LblGenero3.setText("Número:");

        jButton1.setText("Limpar");

        jButton2.setText("Cadastrar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jMenu1.setText("Cadastros");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Consultas");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblGenero3)
                    .addComponent(LblName, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton3))
                    .addComponent(TxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(LblGenero2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addComponent(TxtComplmento, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LblGenero)
                        .addComponent(LblCpf)
                        .addComponent(LblGenero1)
                        .addComponent(LblData_Nasc, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(498, 498, 498)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblName)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(TxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblGenero3)
                    .addComponent(LblGenero2)
                    .addComponent(TxtComplmento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(108, 108, 108)
                    .addComponent(LblData_Nasc)
                    .addGap(16, 16, 16)
                    .addComponent(LblCpf)
                    .addGap(15, 15, 15)
                    .addComponent(LblGenero)
                    .addGap(17, 17, 17)
                    .addComponent(LblGenero1)
                    .addContainerGap(146, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void apiCep()
    {
        try {
            URL url = new URL("https://viacep.com.br/ws/"+TxtCep.getText()+"/json/");
            URLConnection connection = url.openConnection();
            InputStream is = connection.getInputStream();
            
            BufferedReader bf =  new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String cep = "";
            StringBuilder jsonCep = new StringBuilder();
            
            while ( (cep = bf.readLine()) != null){
                jsonCep.append(cep);
            }
            
            Endereco enderecoAux = new Gson().fromJson(jsonCep.toString(), Endereco.class);
            TxtEstado.setText(enderecoAux.getUf());
            TxtBairro.setText(enderecoAux.getBairro());
            TxtCidade.setText(enderecoAux.getLocalidade());
            TxtComplmento.setText(enderecoAux.getComplemento());
            TxtNumero.setText(enderecoAux.getNumero());
            TxtRua.setText(enderecoAux.getLogradouro());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(EnderecoView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EnderecoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if (TxtCep.getText().isEmpty()) {
            return;
        }
        if (TxtEstado.getText().isEmpty()) {
            return;
        }
        if (TxtCidade.getText().isEmpty()) {
            return;
        }
        if (TxtBairro.getText().isEmpty()) {
            return;
        }
        if (TxtRua.getText().isEmpty()) {
            return;
        }
        if (TxtNumero.getText().isEmpty()) {
            return;
        }
        if (TxtComplmento.getText().isEmpty()) {
            return;
        }
        
        try {
            Endereco endereco = new Endereco(TxtCep.getText(),
                    TxtEstado.getText(),
                    TxtCidade.getText(),
                    TxtBairro.getText(),
                    TxtRua.getText(),
                    TxtNumero.getText(),
                    TxtComplmento.getText());
            sbe.insert(endereco);
            JOptionPane.showMessageDialog(
                    null, "Cadastrado com sucesso",
                    "Cadastro!!!", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("C:\\Users\\PremierSoft\\IdeaProjects\\Campeonatos_Futebol\\src\\View\\Cadastro.gif"));
            this.clearScreen();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //sbe.insert(endereco);
        
        JOptionPane.showMessageDialog(null, "kkkkkkkkk");
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        this.apiCep();
    }//GEN-LAST:event_jButton3MouseClicked

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
            java.util.logging.Logger.getLogger(EnderecoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnderecoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnderecoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnderecoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnderecoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblCpf;
    private javax.swing.JLabel LblData_Nasc;
    private javax.swing.JLabel LblGenero;
    private javax.swing.JLabel LblGenero1;
    private javax.swing.JLabel LblGenero2;
    private javax.swing.JLabel LblGenero3;
    private javax.swing.JLabel LblName;
    private javax.swing.JTextField TxtBairro;
    private javax.swing.JTextField TxtCep;
    private javax.swing.JTextField TxtCidade;
    private javax.swing.JTextField TxtComplmento;
    private javax.swing.JTextField TxtEstado;
    private javax.swing.JTextField TxtNumero;
    private javax.swing.JTextField TxtRua;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
