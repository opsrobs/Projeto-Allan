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
        setTitle("JFrameCenter Position");
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JSeparator jSeparator1 = new JSeparator();
        JLabel jLabel1 = new JLabel();
        JLabel lblFuncionario = new JLabel();
        ComboFuncionarios = new javax.swing.JComboBox<>();
        JLabel jLabel2 = new JLabel();
        TxtRG = new javax.swing.JTextField();
        JLabel jLabel3 = new JLabel();
        TxtCPF = new javax.swing.JTextField();
        JbtnSalvar = new javax.swing.JButton();
        JbtnLimpar = new javax.swing.JButton();
        JLabel lblMes = new JLabel();
        JLabel lblHoras = new JLabel();
        JLabel lblAno = new JLabel();
        TxtHoras = new javax.swing.JTextField();
        JLabel lblMes1 = new JLabel();
        ComboInicio = new javax.swing.JComboBox<>();
        ComboFim = new javax.swing.JComboBox<>();
        ComboAno = new javax.swing.JComboBox<>();
        JLabel lblTotal = new JLabel();
        txtTotal = new javax.swing.JTextField();
        RbEditar = new javax.swing.JRadioButton();
        TxtNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", ITALIC, 24)); // NOI18N
        jLabel1.setText("CONSULTA DE FUNCIONARIOS!!!");

        lblFuncionario.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N
        lblFuncionario.setText("Funcionario");

        ComboFuncionarios.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N
        ComboFuncionarios.addItemListener(this::ComboFuncionariosItemStateChanged);

        jLabel2.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N
        jLabel2.setText("CPF:");

        TxtRG.setEditable(false);
        TxtRG.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N
        TxtRG.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N
        jLabel3.setText("RG:");

        TxtCPF.setEditable(false);
        TxtCPF.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N
        TxtCPF.setEnabled(false);

        JbtnSalvar.setFont(new java.awt.Font("Dialog", PLAIN, 18)); // NOI18N
        JbtnSalvar.setText("SALVAR INFORMAÇÕES");
        JbtnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbtnSalvarMouseClicked(evt);
            }
        });

        JbtnLimpar.setFont(new java.awt.Font("Dialog", PLAIN, 18)); // NOI18N
        JbtnLimpar.setText("LIMPAR DADOS");
        JbtnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbtnLimparMouseClicked(evt);
            }
        });

        lblMes.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N
        lblMes.setText("Periodo inicial:");

        lblHoras.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N




        lblHoras.setText("Horas Trabalhadas:");

        lblAno.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N

        lblAno.setText("Ano:");

        TxtHoras.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N

        lblMes1.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N
        lblMes1.setText("Final do Periodo");

        ComboInicio.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N
        ComboInicio.addItemListener(this::ComboInicioItemStateChanged);

        ComboFim.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N
        ComboFim.addItemListener(this::ComboFimItemStateChanged);

        ComboAno.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N
        ComboAno.addItemListener(this::ComboAnoItemStateChanged);

        lblTotal.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N
        lblTotal.setText("Total a Receber:");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N

        RbEditar.setText("EDITAR");
        RbEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RbEditarMouseClicked(evt);
            }
        });

        TxtNome.setEditable(false);
        TxtNome.setFont(new java.awt.Font("Dialog", PLAIN, 15)); // NOI18N
        TxtNome.setEnabled(false);

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
                                .addComponent(lblMes)
                                .addGap(35, 35, 35)
                                .addComponent(ComboInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMes1)
                                    .addComponent(lblTotal))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ComboFim, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(lblAno)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ComboAno, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(96, 96, 96)
                                .addComponent(TxtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(104, 104, 104)
                                .addComponent(TxtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(JbtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblHoras)
                                .addGap(1, 1, 1)
                                .addComponent(TxtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFuncionario)
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtNome)
                                    .addComponent(ComboFuncionarios, 0, 248, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(RbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblFuncionario))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(RbEditar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2))
                    .addComponent(TxtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addComponent(TxtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblMes))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(ComboInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblMes1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblAno))
                            .addComponent(ComboAno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblHoras))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTotal)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JbtnSalvar)
                    .addComponent(JbtnLimpar))
                .addContainerGap(67, Short.MAX_VALUE))
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
        ComboInicio.setSelectedIndex(-1);
        ComboFim.setSelectedIndex(-1);
        txtTotal.setText("");
        JbtnSalvar.setEnabled(false);
        JbtnSalvar.setVisible(false);

    }

    private void clearTotal() {
        TxtHoras.setText("");
        txtTotal.setText("");
        ComboFim.setSelectedIndex(-1);
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
            utils.mesFuncionario(ComboInicio, sbl, funcionario.getCod_funcionario(), " mes");
            utils.mesFuncionario(ComboFim, sbl, funcionario.getCod_funcionario(), " mes");
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
        JOptionPane.showMessageDialog(rootPane, TxtNome.getText());
        try {
            Funcionario funcionario = new Funcionario(TxtNome.getText());
            sb.update(funcionario);
            JOptionPane.showMessageDialog(
                    null, "Cadastrado com sucesso",
                    "Cadastro!!!", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("C:\\Users\\PremierSoft\\IdeaProjects\\Campeonatos_Futebol\\src\\View\\Cadastro.gif"));
            this.clearScreen();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JbtnSalvarMouseClicked

    private void JbtnLimparMouseClicked(MouseEvent evt) {//GEN-FIRST:event_JbtnLimparMouseClicked
        this.clearScreen();
    }//GEN-LAST:event_JbtnLimparMouseClicked

    private void formWindowActivated(WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            utils.atualizarFuncionario(ComboFuncionarios, sb);
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.clearScreen();
    }//GEN-LAST:event_formWindowActivated

    private void ComboInicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboInicioItemStateChanged
        this.clearTotal();
                TxtNome.setVisible(false);

        if (ComboInicio.getItemCount() <= 0) {
            return;
        }
        if (ComboInicio.getSelectedIndex() < 0) {
            return;
        }
        Lancamento lancamento = (Lancamento) ComboInicio.getSelectedItem();
        assert lancamento != null;
    }//GEN-LAST:event_ComboInicioItemStateChanged

    private float totalAReceber(int value) throws SQLException {
        return utils.verifyValueOfCombo(codFun) * value;
    }

    private void ComboFimItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboFimItemStateChanged
        TxtHoras.setText("");
        txtTotal.setText("");
        ComboAno.setSelectedIndex(-1);
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

    private void horasTotais() {
        int value;
        try {
            value = utils.verifySumTime(Integer.parseInt(
                    Objects.requireNonNull(ComboInicio.getSelectedItem()).toString()),
                    Integer.parseInt(Objects.requireNonNull(ComboFim.getSelectedItem()).toString()), codFun, Integer.parseInt(Objects.requireNonNull(ComboAno.getSelectedItem()).toString()));

            txtTotal.setText("R$ " + utils.formatTot(this.totalAReceber(value)));
            TxtHoras.setText(String.valueOf(value));
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDadosView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ComboAnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboAnoItemStateChanged
        TxtHoras.setText("");
        if (ComboInicio.getSelectedIndex() >= 0
                && ComboFim.getSelectedIndex() >= 0
                && ComboAno.getSelectedIndex() >= 0) {
            this.horasTotais();
        }
    }//GEN-LAST:event_ComboAnoItemStateChanged

    private void RbEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RbEditarMouseClicked
        if (RbEditar.isSelected()) {
            ComboInicio.setEnabled(false);
            ComboFim.setEnabled(false);
            ComboAno.setEnabled(false);
            TxtHoras.setEnabled(false);
            txtTotal.setEnabled(false);
            TxtNome.setEditable(true);
            TxtNome.setEnabled(true);
        }
    }//GEN-LAST:event_RbEditarMouseClicked

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
    private javax.swing.JComboBox<Lancamento> ComboFim;
    private javax.swing.JComboBox<Funcionario> ComboFuncionarios;
    private javax.swing.JComboBox<Lancamento> ComboInicio;
    private javax.swing.JButton JbtnLimpar;
    private javax.swing.JButton JbtnSalvar;
    private javax.swing.JRadioButton RbEditar;
    private javax.swing.JTextField TxtCPF;
    private javax.swing.JTextField TxtHoras;
    private javax.swing.JTextField TxtNome;
    private javax.swing.JTextField TxtRG;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
