package View;

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
    private int codFun = 0;
    Utils utils = new Utils();

    public void JFrameCenterPositionTest() {
        setTitle("Consultar Funcionarios!!!");
        add(new JLabel("JFrame set to center of the screen", SwingConstants.CENTER), BorderLayout.CENTER);
        setSize(580, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        setPreferredSize(new java.awt.Dimension(600, 600));
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

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel2.setText("CPF:");

        TxtRG.setEditable(false);
        TxtRG.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        TxtRG.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel3.setText("RG:");

        TxtCPF.setEditable(false);
        TxtCPF.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        TxtCPF.setEnabled(false);

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

        lblMes.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        lblMes.setText("Periodo inicial:");

        lblHoras.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        lblHoras.setText("Horas Trabalhadas:");

        lblAno.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        lblAno.setText("Ano:");

        TxtHoras.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        lblMes1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        lblMes1.setText("Final do Periodo");

        ComboAno.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        ComboAno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboAnoItemStateChanged(evt);
            }
        });

        LblTotal.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        LblTotal.setText("Total a Receber:");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        RbEditar.setText("EDITAR");
        RbEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RbEditarMouseClicked(evt);
            }
        });

        TxtNome.setEditable(false);
        TxtNome.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        JbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/java/images/delete.png"))); // NOI18N
        JbExcluir.setBorder(null);
        JbExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbExcluirMouseClicked(evt);
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
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblHoras)
                                        .addGap(1, 1, 1)
                                        .addComponent(TxtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JbtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(LblTotal)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblAno)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ComboAno, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(96, 96, 96)
                                            .addComponent(TxtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(lblMes)
                                                .addComponent(lblMes1))
                                            .addGap(25, 25, 25)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(TxtRG, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                                    .addComponent(ComboMesInicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(ComboMesFim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(222, 222, 222))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblFuncionario)
                                            .addGap(54, 54, 54)
                                            .addComponent(ComboFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addComponent(RbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblFuncionario))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(RbEditar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2))
                    .addComponent(TxtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addComponent(TxtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMes)
                    .addComponent(ComboMesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMes1)
                        .addComponent(ComboMesFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAno)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblHoras))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LblTotal)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JbtnSalvar)
                        .addComponent(JbtnLimpar))
                    .addComponent(JbExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearScreen() {
        if (ComboFuncionarios.isDisplayable()) {
            ComboFuncionarios.setSelectedIndex(-1);
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

    }

    private void clearTotal() {
        TxtHoras.setText("");
        txtTotal.setText("");
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
        Funcionario funcionario = (Funcionario) ComboFuncionarios.getSelectedItem();
        assert funcionario != null;
        TxtCPF.setText(funcionario.getCpf());
        TxtRG.setText(funcionario.getRg());
        this.codFun = funcionario.getCod_funcionario();
        try {
            utils.mesFuncionarioBy(ComboMesInicio, sbl, funcionario.getCod_funcionario());
            utils.mesFuncionarioBy(ComboMesFim, sbl, funcionario.getCod_funcionario());
            utils.getAnoFuncionario(ComboAno, sbl, funcionario.getCod_funcionario(), " ano");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDadosView.class.getName()).log(Level.SEVERE, null, ex);
        }
        JbtnSalvar.setVisible(true);
        JbtnSalvar.setEnabled(true);
        JbtnLimpar.setEnabled(true);
        utils.visibleButtonTrue(RbEditar, TxtNome, funcionario.getNome_funcionario());
    }//GEN-LAST:event_ComboFuncionariosItemStateChanged

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
            Logger.getLogger(FuncionarioView.class.getName()).log(Level.SEVERE, null, ex);

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
            Logger.getLogger(LancamentoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.clearScreen();
    }//GEN-LAST:event_formWindowActivated

    private float totalAReceber(int value) throws SQLException {
        return utils.verifyValueOfCombo(codFun) * value;
    }

    private void horasTotais() {
        int value;
        int firstMonth = utils.reverseMonth(Objects.requireNonNull(ComboMesInicio.getSelectedItem()).toString());
        int lastMonth = utils.reverseMonth(Objects.requireNonNull(ComboMesFim.getSelectedItem()).toString());
        try {
            value = utils.verifySumTime(Integer.parseInt(String.valueOf(firstMonth)),
                    Integer.parseInt(String.valueOf(lastMonth)), codFun,
                    Integer.parseInt(Objects.requireNonNull(ComboAno.getSelectedItem()).toString()));

            txtTotal.setText("R$ " + utils.formatTot(this.totalAReceber(value)));
            TxtHoras.setText(String.valueOf(value));
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDadosView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ComboAnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboAnoItemStateChanged
        TxtHoras.setText("");
        if (ComboMesInicio.getSelectedIndex() >= 0
                && ComboMesFim.getSelectedIndex() >= 0
                && ComboAno.getSelectedIndex() >= 0) {
            this.horasTotais();
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
