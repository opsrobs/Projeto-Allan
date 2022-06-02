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
public class FuncionarioView extends javax.swing.JFrame {

    Utils utils = new Utils();
    ServicoBancoFuncionario sb = new ServicoBancoFuncionario();
//    private final ImageIcon icon = new ImageIcon("C:\\Users\\PremierSoft\\Documents\\NetBeansProjects\\Projeto-Allan\\src\\images\\1140-error-outline.gif");
//    private final ImageIcon defaultIcon = new ImageIcon("C:\\Users\\PremierSoft\\Documents\\NetBeansProjects\\Projeto-Allan\\src\\images\\55-error-outline.gif");
    LancamentoView lancamentoView;
    FuncionarioView funcionarioView;

    SearchByTable searchByTable;
//    FuncionarioView funcionarioView = new FuncionarioView();
    ConsultaDadosView consultaDados;
    ConsultaDadosGraphicView consultaDadosGraphicView;
    AnaliseDeCustosView analiseDeCustosView;

    public FuncionarioView() {
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

    private void openTable() {
        if (searchByTable == null) {
            searchByTable = new SearchByTable();
        }
        searchByTable.setVisible(true);

    }

    private void openConsultaDados() {
        if (consultaDados == null) {
            consultaDados = new ConsultaDadosView();
        }
        consultaDados.setVisible(true);
    }

    private void openConsultaGrafico() {
        if (consultaDadosGraphicView == null) {
            consultaDadosGraphicView = new ConsultaDadosGraphicView();
        }
        consultaDadosGraphicView.setVisible(true);
    }

    private void openAnalsie() {
        if (analiseDeCustosView == null) {
            analiseDeCustosView = new AnaliseDeCustosView();
        }
        analiseDeCustosView.setVisible(true);
    }

    private void clearScreen() {
        TxtName.setText("");
        MaskCpf.setText("");
        TxtRg.setText("");
        TxtGener.setText("");
        TxtValor.setText("");
        TxtStatus.setText("");
        MaskData.setText("");
//        requiredCpf.setIcon(defaultIcon);

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
//            requiredCpf.setIcon(icon);
            this.colorMask();
            return;
        }
        requiredCpf.setVisible(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        LblName = new javax.swing.JLabel();
        LblCpf = new javax.swing.JLabel();
        LblRg = new javax.swing.JLabel();
        LblGenero = new javax.swing.JLabel();
        TxtName = new javax.swing.JTextField();
        TxtRg = new javax.swing.JTextField();
        TxtGener = new javax.swing.JTextField();
        LblValor = new javax.swing.JLabel();
        TxtValor = new javax.swing.JTextField();
        MaskCpf = new javax.swing.JFormattedTextField();
        JbtnSalvar = new javax.swing.JButton();
        JbtnLimpar = new javax.swing.JButton();
        requiredCpf = new javax.swing.JLabel();
        LblData_Nasc = new javax.swing.JLabel();
        MaskData = new javax.swing.JFormattedTextField();
        LblStatus = new javax.swing.JLabel();
        TxtStatus = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        LblGenero1 = new javax.swing.JLabel();
        TxtGener1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFuncionarios = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        MenuConsultas = new javax.swing.JMenu();
        MenuConsultaFuncionario = new javax.swing.JMenuItem();
        MenuGraficos = new javax.swing.JMenuItem();
        MenuTabela = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 24)); // NOI18N
        jLabel1.setText("CADASTRO DE FUNCIONARIOS!!!");

        LblName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LblName.setText("Nome:");

        LblCpf.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LblCpf.setText("CPF:");

        LblRg.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LblRg.setText("RG:");

        LblGenero.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LblGenero.setText("Genero:");

        LblValor.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LblValor.setText("Valor por hora:");

        TxtValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtValorFocusGained(evt);
            }
        });

        try {
            MaskCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        MaskCpf.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        MaskCpf.setMinimumSize(new java.awt.Dimension(5, 18));
        MaskCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MaskCpfFocusLost(evt);
            }
        });

        JbtnSalvar.setText("SALVAR INFORMAÇÕES");
        JbtnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbtnSalvarMouseClicked(evt);
            }
        });

        JbtnLimpar.setText("LIMPAR DADOS");
        JbtnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbtnLimparMouseClicked(evt);
            }
        });

        LblData_Nasc.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LblData_Nasc.setText("Data nascimento:");

        try {
            MaskData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        MaskData.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        LblStatus.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LblStatus.setText("Status:");

        jButton1.setText("Endereço");

        LblGenero1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LblGenero1.setText("Cargo:");

        jMenuFuncionarios.setText("Cadastros.");

        jMenuItem1.setText("Cadastro de Lançamentos.");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuFuncionarios.add(jMenuItem1);

        jMenuItem2.setText("Cadastro de Funcionarios.");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuFuncionarios.add(jMenuItem2);

        jMenuItem5.setText("Cadastro de Endereço");
        jMenuFuncionarios.add(jMenuItem5);

        jMenuBar1.add(jMenuFuncionarios);

        MenuConsultas.setText("Consultas.");

        MenuConsultaFuncionario.setText("Consulta Funcionario");
        MenuConsultaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConsultaFuncionarioActionPerformed(evt);
            }
        });
        MenuConsultas.add(MenuConsultaFuncionario);

        MenuGraficos.setText("Graficos");
        MenuGraficos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuGraficosActionPerformed(evt);
            }
        });
        MenuConsultas.add(MenuGraficos);

        MenuTabela.setText("Tabela de funcionarios");
        MenuTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTabelaActionPerformed(evt);
            }
        });
        MenuConsultas.add(MenuTabela);

        jMenuItem4.setText("MenuAnalise");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        MenuConsultas.add(jMenuItem4);

        jMenuBar1.add(MenuConsultas);

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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblGenero)
                                    .addComponent(LblCpf))
                                .addGap(97, 97, 97)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtGener, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MaskCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LblGenero1)
                                .addGap(97, 97, 97)
                                .addComponent(TxtGener1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LblStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LblRg)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LblValor)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblData_Nasc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblName, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MaskData, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TxtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TxtName))))
                .addGap(200, 200, 200)
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
                    .addComponent(LblName)
                    .addComponent(TxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblData_Nasc)
                    .addComponent(MaskData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblRg)
                    .addComponent(TxtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblCpf)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MaskCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LblStatus)
                                .addComponent(TxtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LblGenero)
                                    .addComponent(TxtGener, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LblValor)
                                    .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(requiredCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LblGenero1)
                        .addComponent(TxtGener1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbtnSalvar)
                    .addComponent(JbtnLimpar))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.colorMask();
    }//GEN-LAST:event_formWindowActivated

    private void TxtValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtValorFocusGained
        JbtnSalvar.setEnabled(true);
        JbtnSalvar.setVisible(true);
    }//GEN-LAST:event_TxtValorFocusGained

    private void JbtnLimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JbtnLimparMouseClicked
        this.clearScreen();
    }//GEN-LAST:event_JbtnLimparMouseClicked

    private void JbtnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JbtnSalvarMouseClicked
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

    private void MaskCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MaskCpfFocusLost
        JbtnLimpar.setEnabled(true);
        JbtnSalvar.setEnabled(false);
        JbtnSalvar.setVisible(false);
        this.verifyCpf();
    }//GEN-LAST:event_MaskCpfFocusLost

    private void cadastroLancamento() {
        if (lancamentoView == null) {
            lancamentoView = new LancamentoView();
        }
        System.err.println(":p");
        lancamentoView.setVisible(true);
    }

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked

    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.err.println("2");

        this.cadastroLancamento();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cadastroFuncionarios() {
        if (funcionarioView == null) {
            funcionarioView = new FuncionarioView();
        }
        funcionarioView.setVisible(true);
    }
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.err.println("1");
        this.cadastroLancamento();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void MenuConsultaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConsultaFuncionarioActionPerformed
        this.openConsultaDados();
    }//GEN-LAST:event_MenuConsultaFuncionarioActionPerformed

    private void MenuGraficosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuGraficosActionPerformed
        this.openConsultaGrafico();
    }//GEN-LAST:event_MenuGraficosActionPerformed

    private void MenuTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTabelaActionPerformed
        this.openTable();
    }//GEN-LAST:event_MenuTabelaActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.openAnalsie();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
    private javax.swing.JLabel LblCpf;
    private javax.swing.JLabel LblData_Nasc;
    private javax.swing.JLabel LblGenero;
    private javax.swing.JLabel LblGenero1;
    private javax.swing.JLabel LblName;
    private javax.swing.JLabel LblRg;
    private javax.swing.JLabel LblStatus;
    private javax.swing.JLabel LblValor;
    private javax.swing.JFormattedTextField MaskCpf;
    private javax.swing.JFormattedTextField MaskData;
    private javax.swing.JMenuItem MenuConsultaFuncionario;
    private javax.swing.JMenu MenuConsultas;
    private javax.swing.JMenuItem MenuGraficos;
    private javax.swing.JMenuItem MenuTabela;
    private javax.swing.JTextField TxtGener;
    private javax.swing.JTextField TxtGener1;
    private javax.swing.JTextField TxtName;
    private javax.swing.JTextField TxtRg;
    private javax.swing.JTextField TxtStatus;
    private javax.swing.JTextField TxtValor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFuncionarios;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JLabel requiredCpf;
    // End of variables declaration//GEN-END:variables

}
