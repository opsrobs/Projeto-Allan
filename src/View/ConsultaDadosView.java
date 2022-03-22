package View;

import Controller.ServicoBancoFuncionario;
import Controller.ServicoBancoLancamento;
import Controller.Utils;
import Models.Funcionario;
import Models.Lancamento;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author PremierSoft
 */
public class ConsultaDadosView extends javax.swing.JFrame {

    Funcionario funcionario = new Funcionario();
    Lancamento lancamento = new Lancamento();
    ServicoBancoFuncionario sb = new ServicoBancoFuncionario();
    ServicoBancoLancamento sbl = new ServicoBancoLancamento();
    private int codFun = 0;
    Utils utils = new Utils();

    public void JFrameCenterPositionTest() {
        setTitle("JFrameCenter Position");
        add(new JLabel("JFrame set to center of the screen", SwingConstants.CENTER), BorderLayout.CENTER);
        setSize(670, 530);
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        ComboInicio = new javax.swing.JComboBox<>();
        ComboFim = new javax.swing.JComboBox<>();
        ComboAno = new javax.swing.JComboBox<>();

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

        TxtRG.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel3.setText("RG:");

        TxtCPF.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        TxtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCPFActionPerformed(evt);
            }
        });

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

        ComboInicio.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        ComboInicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboInicioItemStateChanged(evt);
            }
        });

        ComboFim.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        ComboFim.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboFimItemStateChanged(evt);
            }
        });

        ComboAno.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        ComboAno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboAnoItemStateChanged(evt);
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
                        .addComponent(jLabel2)
                        .addGap(96, 96, 96)
                        .addComponent(TxtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addGap(104, 104, 104)
                        .addComponent(TxtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblHoras)
                        .addGap(1, 1, 1)
                        .addComponent(TxtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(JbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(JbtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
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
                                .addComponent(ComboAno, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFuncionario)
                                .addGap(54, 54, 54)
                                .addComponent(ComboFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 45, Short.MAX_VALUE))
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
                    .addComponent(ComboFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMes1)
                            .addComponent(ComboFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblAno))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblHoras))
                    .addComponent(TxtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JbtnSalvar)
                    .addComponent(JbtnLimpar))
                .addContainerGap(46, Short.MAX_VALUE))
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
        this.codFun= funcionario.getCod_funcionario();
        try {
            utils.mesFuncionario(ComboInicio, sbl, funcionario.getCod_funcionario(), " mes");
            utils.mesFuncionario(ComboFim, sbl, funcionario.getCod_funcionario()," mes");
            utils.anoFuncionario(ComboAno, sbl, funcionario.getCod_funcionario()," ano");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDadosView.class.getName()).log(Level.SEVERE, null, ex);
        }
        JbtnSalvar.setVisible(true);
        JbtnSalvar.setEnabled(true);
        JbtnLimpar.setEnabled(true);
    }//GEN-LAST:event_ComboFuncionariosItemStateChanged

    private void JbtnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JbtnSalvarMouseClicked

    }//GEN-LAST:event_JbtnSalvarMouseClicked

    private void JbtnLimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JbtnLimparMouseClicked
        this.clearScreen();
    }//GEN-LAST:event_JbtnLimparMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            utils.atualizarFuncionario(ComboFuncionarios, sb);
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.clearScreen();
    }//GEN-LAST:event_formWindowActivated

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

    private void horasTotais(){
        int value = 0;
        try {
            value = utils.verifySumTime(Integer.parseInt(
                    ComboInicio.getSelectedItem().toString()),
                    Integer.parseInt(ComboFim.getSelectedItem().toString()), codFun,Integer.parseInt(ComboAno.getSelectedItem().toString()));
            TxtHoras.setText(String.valueOf(value));
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDadosView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void TxtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCPFActionPerformed

    private void ComboAnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboAnoItemStateChanged
       if (ComboInicio.getSelectedIndex() >= 0 &&
            ComboFim.getSelectedIndex() >= 0 &&
               ComboAno.getSelectedIndex() >= 0) {
                    this.horasTotais();
        } 
    }//GEN-LAST:event_ComboAnoItemStateChanged

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
            java.util.logging.Logger.getLogger(ConsultaDadosView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaDadosView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaDadosView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaDadosView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaDadosView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Lancamento> ComboAno;
    private javax.swing.JComboBox<Lancamento> ComboFim;
    private javax.swing.JComboBox<Funcionario> ComboFuncionarios;
    private javax.swing.JComboBox<Lancamento> ComboInicio;
    private javax.swing.JButton JbtnLimpar;
    private javax.swing.JButton JbtnSalvar;
    private javax.swing.JTextField TxtCPF;
    private javax.swing.JTextField TxtHoras;
    private javax.swing.JTextField TxtRG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblMes1;
    // End of variables declaration//GEN-END:variables
}
