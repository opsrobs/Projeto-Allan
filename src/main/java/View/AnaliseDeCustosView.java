package main.java.View;

import Controller.ServicoBancoLancamento;
import Controller.Utils;
import Models.Funcionario;
import Models.Lancamento;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author PremierSoft
 */
public class AnaliseDeCustosView extends javax.swing.JFrame {

    private Lancamento lancamento = new Lancamento();

    private Utils utils = new Utils();
    private ServicoBancoLancamento sbl = new ServicoBancoLancamento();

    private void setDefaultValue() {
//        ComboMes.setSelectedIndex(0);

        EdtFatHora.setText("");
        EdtFatMaquina.setText("");
        EdtQtdMaquina.setText("");
        EdtAumento.setText("");
        EdtCustoOperacional.setText("");
        EdtPercentMaqNova.setText("");
        EdtCustoOpMaquinaNova.setText("");
//        this.verifyButton();

    }

    private void JFrameCenterPositionTest() {
        setTitle("Análise de custos!");
        add(new JLabel("", SwingConstants.CENTER), BorderLayout.CENTER);
        setSize(600, 850);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        setVisible(true);
    }

    private ArrayList<Lancamento> dadosLancamento() {
        ArrayList<Lancamento> dados = new ArrayList<>();
        try {
            ArrayList<Lancamento> lista = utils.dadosLancamentos(sbl);
            for (int i = 0; i < lista.size(); i++) {
                dados.add((new Lancamento(
                        lista.get(i).getCodFuncionario(),
                        lista.get(i).getHorasTrabalhadas(),
                        lista.get(i).getMes(),
                        lista.get(i).getAno())));
            }
            return dados;
        } catch (SQLException ex) {
            Logger.getLogger(AnaliseDeCustosView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }

    private ArrayList<Funcionario> dadosFuncionario() {
        ArrayList<Funcionario> dados = new ArrayList<>();
        try {
            ArrayList<Funcionario> lista = utils.dadosFuncionario(sbl);
            for (int i = 0; i < lista.size(); i++) {
                dados.add((new Funcionario(
                        lista.get(i).getNome_funcionario(),
                        lista.get(i).getCpf(),
                        lista.get(i).getRg(),
                        lista.get(i).getGenero(),
                        lista.get(i).getValor_hora(),
                        lista.get(i).getData_nasc(),
                        lista.get(i).getStatus())));
            }
            return dados;
        } catch (SQLException ex) {
            Logger.getLogger(AnaliseDeCustosView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }

    private void validarLucros(int fat_hora, int fat_maquina) {
        EdtLucroSemContratar.setBackground(Color.white);
        EdtLucroContratando.setBackground(Color.WHITE);
        EdtLucroContratando.setBackground(Color.WHITE);
        if (this.lucroSemContratar(fat_hora, fat_maquina) > this.lucroAtual(fat_hora, fat_maquina)
                && this.lucroSemContratar(fat_hora, fat_maquina) > this.lucroContratando(fat_hora, fat_maquina)) {
            EdtLucroSemContratar.setBackground(Color.GREEN);
        } else if (this.lucroContratando(fat_hora, fat_maquina) > this.lucroSemContratar(fat_hora, fat_maquina)
                && this.lucroContratando(fat_hora, fat_maquina) > this.lucroAtual(fat_hora, fat_maquina)) {
            EdtLucroContratando.setBackground(Color.GREEN);
        } else {
            EdtLucroContratando.setBackground(Color.GREEN);
        }

    }

    private float lucroSemContratar(int fat_hora, int fat_maquina) {
        return (this.FaturamentoReal(fat_hora, fat_maquina)
                + this.fatMaqNova(fat_hora, fat_maquina))
                - this.custoOperacionalTotal(fat_hora, fat_maquina)
                - this.operacionalMaquinaNova(fat_hora, fat_maquina)
                - this.custoTotalComAumento();

    }

    private float lucroContratando(int fat_hora, int fat_maquina) {
        return (this.FaturamentoReal(fat_hora, fat_maquina)
                + this.fatMaqNova(fat_hora, fat_maquina))
                - this.custoOperacionalTotal(fat_hora, fat_maquina)
                - this.operacionalMaquinaNova(fat_hora, fat_maquina)
                - this.custoContratando();
    }

    private float lucroAtual(int fat_hora, int fat_maquina) { //-----------
        return this.FaturamentoReal(fat_hora, fat_maquina)
                - this.custoMaoDeObraTotal()
                - this.custoOperacionalTotal(fat_hora, fat_maquina);
    }

    private float totalSalarios() {
        int value = 0;
        for (int i = 0; i < this.dadosLancamento().size(); i++) {
            value += this.dadosLancamento().get(i).getHorasTrabalhadas();
        }
        return value;
    }

    private float mediaHorasTrabalhadasMes() {
        return this.mediaHorasTrabalhadas();
    }

    private float percent(JTextField text) {
        return Float.parseFloat(utils.removeEpecialChar(text)) / 100;
    }

    private float FaturamentoReal(int fat_hora, int fat_maquina) {
        return fat_maquina * (this.mediaHorasTrabalhadas() / fat_hora);
    }

    private float custoMaoDeObraTotal() {
        return this.totalSalarios() * this.mediaSalarial();
    }

    private float custoMaquina() {
        float valueCost = this.totalSalarios() * this.mediaSalarial();
        int qtdMaquina = Integer.parseInt(EdtQtdMaquina.getText());
        return valueCost / qtdMaquina;
    }

    private float custoOperacionalTotal(int fat_hora, int fat_maquina) {
        return this.FaturamentoReal(fat_hora, fat_maquina) * this.percent(EdtCustoOperacional);
    }

    private float custoMaquinaVelha(int fat_hora, int fat_maquina) {
        return this.custoOperacionalTotal(fat_hora, fat_maquina) / Integer.parseInt(EdtQtdMaquina.getText());
    }

    private float fatMaquinaVelha(int fat_hora, int fat_maquina) {
        return this.FaturamentoReal(fat_hora, fat_maquina) / Integer.parseInt(EdtQtdMaquina.getText());
    }

    private float fatMaqNova(int fat_hora, int fat_maquina) {

        return (this.fatMaquinaVelha(fat_hora, fat_maquina) * this.percent(EdtPercentMaqNova)) + this.fatMaquinaVelha(fat_hora, fat_maquina);
    }

    private float operacionalMaquinaNova(int fat_hora, int fat_maquina) {
        return this.custoMaquinaVelha(fat_hora, fat_maquina) - (this.custoMaquinaVelha(fat_hora, fat_maquina) * this.percent(EdtCustoOpMaquinaNova));
    }

    private float custoComAumento() {
        return (this.custoMaquina() * this.percent(EdtAumento)) + this.custoMaquina();
    }

    private float custoTotalComAumento() {
        return this.custoComAumento() * Integer.parseInt(EdtQtdMaquina.getText());
    }

    private float custoContratando() {
        return (this.mediaHorasTrabalhadasMes() * this.mediaSalarial()) + this.custoMaoDeObraTotal();
    }

    private int sizeOfListLancamento() {
        return this.dadosLancamento().size();

    }

    private int sizeOfListFuncionario() {
        return this.dadosFuncionario().size();

    }

    private float mediaSalarial() {
        float salario = 0;
        for (int i = 0; i < this.dadosFuncionario().size(); i++) {
            salario += this.dadosFuncionario().get(i).getValor_hora();
        }
        salario = salario / this.sizeOfListFuncionario();
        return salario;
    }

    private void preencherDados(int fat_hora, int fat_maquina) {
//        EdtMediaHoras.setText(utils.formatTot(this.mediaHorasTrabalhadasMes()));
//        EdtFatReal.setText(utils.formatTot(this.FaturamentoReal(fat_hora, fat_maquina)));
//        EdtCustoMaquina.setText(utils.formatTot(this.custoMaquina()));
//        EdtMaoObra.setText(utils.formatTot(this.custoMaoDeObraTotal()));
//        EdtCustoOpTotal.setText(utils.formatTot(this.custoOperacionalTotal(fat_hora, fat_maquina)));
//        EdtCustoMaquinaVelha.setText(utils.formatTot(this.custoMaquinaVelha(fat_hora, fat_maquina)));
//        EdtFaturamentoPorMaquiuna.setText(utils.formatTot(this.fatMaquinaVelha(fat_hora, fat_maquina)));
//        EdtFaturamentoMaqNova.setText(utils.formatTot(this.fatMaqNova(fat_hora, fat_maquina)));
//        EdtCustoOpMaqNova.setText(utils.formatTot(this.operacionalMaquinaNova(fat_hora, fat_maquina)));
//        EdtCustoComAumento.setText(utils.formatTot(this.custoComAumento()));
//        EdtCustoObraComAumento.setText(utils.formatTot(this.custoTotalComAumento()));
//        EdtCustoContratando.setText(utils.formatTot(this.custoContratando()));

        EdtLucroSemContratar.setText(utils.formatTot(this.lucroSemContratar(fat_hora, fat_maquina)));
        EdtLucroContratando.setText(utils.formatTot(this.lucroContratando(fat_hora, fat_maquina)));
        EdtLucroAtual.setText(utils.formatTot(this.lucroAtual(fat_hora, fat_maquina)));
//
//        this.validarLucros(fat_hora, fat_maquina);
    }

    public AnaliseDeCustosView() {
        initComponents();
        this.JFrameCenterPositionTest();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lBMedia = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        EdtMediaHoras = new javax.swing.JTextField();
        ComboMes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        EdtFatHora = new javax.swing.JTextField();
        EdtFatReal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        EdtFatMaquina = new javax.swing.JTextField();
        EdtMaoObra = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        EdtCustoOperacional = new javax.swing.JTextField();
        EdtCustoMaquina = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        EdtQtdMaquina = new javax.swing.JTextField();
        EdtCustoOpTotal = new javax.swing.JTextField();
        EdtCustoMaquinaVelha = new javax.swing.JTextField();
        EdtFaturamentoPorMaquiuna = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        EdtPercentMaqNova = new javax.swing.JTextField();
        EdtFaturamentoMaqNova = new javax.swing.JTextField();
        EdtCustoOpMaqNova = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        EdtCustoOpMaquinaNova = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        EdtAumento = new javax.swing.JTextField();
        EdtCustoComAumento = new javax.swing.JTextField();
        EdtCustoObraComAumento = new javax.swing.JTextField();
        EdtCustoContratando = new javax.swing.JTextField();
        jBtnCalcular = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        EdtLucroSemContratar = new javax.swing.JTextField();
        EdtLucroContratando = new javax.swing.JTextField();
        EdtLucroAtual = new javax.swing.JTextField();
        ButtonReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lBMedia.setBackground(new java.awt.Color(255, 255, 204));
        lBMedia.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        lBMedia.setText("Média Hrs Trab.");

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel2.setText("Fat. Real");

        jLabel3.setBackground(new java.awt.Color(255, 255, 204));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel3.setText("Custo Mão Obra Total");

        jLabel4.setBackground(new java.awt.Color(255, 255, 204));
        jLabel4.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel4.setText("Média Custo Mão Obra Maquina");

        jLabel5.setBackground(new java.awt.Color(255, 255, 204));
        jLabel5.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel5.setText("Custo Operacional Total");

        jLabel6.setBackground(new java.awt.Color(255, 255, 204));
        jLabel6.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel6.setText("Custo Operacional por Maquina Velha");

        jLabel7.setBackground(new java.awt.Color(255, 255, 204));
        jLabel7.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel7.setText("Faturamento por Maquina velha");

        jLabel8.setBackground(new java.awt.Color(255, 255, 204));
        jLabel8.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel8.setText("Faturamento Maquina Nova");

        jLabel9.setBackground(new java.awt.Color(255, 255, 204));
        jLabel9.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel9.setText("Média Custo Mão Obra Maquina com Aumento");

        jLabel10.setBackground(new java.awt.Color(255, 255, 204));
        jLabel10.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel10.setText("Custo Mão Obra Total com Aumento");

        jLabel11.setBackground(new java.awt.Color(255, 255, 204));
        jLabel11.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel11.setText("Custo Mão Obra Contratando");

        jLabel12.setBackground(new java.awt.Color(255, 255, 204));
        jLabel12.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel12.setText("Custo Operacional Maquina Nova");

        EdtMediaHoras.setEditable(false);

        ComboMes.setEditable(true);
        ComboMes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ComboMes.setEnabled(false);
        ComboMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboMesItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Fat. por Hora");

        EdtFatHora.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        EdtFatHora.setText("200");

        EdtFatReal.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setText("Fat. Maquina");

        EdtFatMaquina.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        EdtFatMaquina.setText("48000");

        EdtMaoObra.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setText("Custo Operacional");

        EdtCustoOperacional.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        EdtCustoOperacional.setText("30");

        EdtCustoMaquina.setEditable(false);

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setText("Qtd. Maquina");

        EdtQtdMaquina.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        EdtQtdMaquina.setText("8");
        EdtQtdMaquina.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EdtQtdMaquinaFocusLost(evt);
            }
        });

        EdtCustoOpTotal.setEditable(false);

        EdtCustoMaquinaVelha.setEditable(false);

        EdtFaturamentoPorMaquiuna.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setText("Perc. Fat Maq. Nova");

        EdtPercentMaqNova.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        EdtPercentMaqNova.setText("10");

        EdtFaturamentoMaqNova.setEditable(false);

        EdtCustoOpMaqNova.setEditable(false);

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setText("Custo Op. Maquina nova");

        EdtCustoOpMaquinaNova.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        EdtCustoOpMaquinaNova.setText("40");
        EdtCustoOpMaquinaNova.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EdtCustoOpMaquinaNovaFocusLost(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel18.setText("Aumento");

        EdtAumento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        EdtAumento.setText("22.50");

        EdtCustoComAumento.setEditable(false);

        EdtCustoObraComAumento.setEditable(false);

        EdtCustoContratando.setEditable(false);

        jBtnCalcular.setText("Calcular..");
        jBtnCalcular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnCalcularMouseClicked(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(255, 255, 204));
        jLabel19.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel19.setText("a) Lucro sem Contratar");

        jLabel20.setBackground(new java.awt.Color(255, 255, 204));
        jLabel20.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel20.setText("b) Lucro contratando");

        jLabel21.setBackground(new java.awt.Color(255, 255, 204));
        jLabel21.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jLabel21.setText("c) Lucro Atual");

        EdtLucroSemContratar.setEditable(false);

        EdtLucroContratando.setEditable(false);

        EdtLucroAtual.setEditable(false);

        ButtonReset.setText("RESET");
        ButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(23, 23, 23))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addGap(21, 21, 21)))
                                        .addGap(30, 30, 30))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(52, 52, 52)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(EdtFatHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(EdtQtdMaquina)
                                        .addComponent(EdtFatMaquina, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jBtnCalcular))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ButtonReset)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(EdtCustoOperacional))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel18))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EdtPercentMaqNova)
                                    .addComponent(EdtAumento)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboMes, javax.swing.GroupLayout.Alignment.TRAILING, 0, 1, Short.MAX_VALUE)
                                    .addComponent(EdtCustoOpMaquinaNova, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))))
                        .addGap(20, 20, 20))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lBMedia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EdtMediaHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EdtFatReal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EdtMaoObra, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EdtCustoMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EdtCustoOpTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EdtCustoMaquinaVelha, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EdtFaturamentoPorMaquiuna, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EdtFaturamentoMaqNova, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EdtCustoOpMaqNova, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EdtCustoComAumento, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EdtCustoObraComAumento, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EdtCustoContratando, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator2)))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EdtLucroSemContratar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EdtLucroContratando, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EdtLucroAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(EdtFatHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(EdtFatMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(EdtQtdMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(EdtAumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(EdtPercentMaqNova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(EdtCustoOpMaquinaNova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(EdtCustoOperacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCalcular)
                    .addComponent(ButtonReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lBMedia)
                                    .addComponent(EdtMediaHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(EdtFatReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(EdtMaoObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4))
                            .addComponent(EdtCustoMaquina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(EdtCustoOpTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(EdtCustoMaquinaVelha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(EdtFaturamentoPorMaquiuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addComponent(EdtFaturamentoMaqNova, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(EdtCustoOpMaqNova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(EdtCustoComAumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(EdtCustoObraComAumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(EdtCustoContratando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(EdtLucroSemContratar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EdtLucroContratando, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EdtLucroAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private float mediaHorasTrabalhadas() {
        return (this.totalSalarios() / this.sizeOfListLancamento());
    }

    private void ComboMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboMesItemStateChanged
        if (ComboMes.getItemCount() <= 0) {
            return;
        }
        if (ComboMes.getSelectedIndex() < 0) {
            return;
        }
        String lancamento = (String) ComboMes.getSelectedItem();
        this.custoMaoDeObraTotal();
        this.mediaHorasTrabalhadasMes();

//        this.preencherDados();
        assert lancamento != null;
    }//GEN-LAST:event_ComboMesItemStateChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ComboMes.setVisible(false);

        try {
            utils.dadosLancamentos(sbl);
            utils.mesFuncionario(ComboMes, sbl, "mes");
        } catch (SQLException ex) {
            Logger.getLogger(AnaliseDeCustosView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowActivated

    private void jBtnCalcularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnCalcularMouseClicked

        if (utils.verifyContentForButton(EdtAumento, EdtMaoObra, EdtAumento, EdtAumento, EdtAumento, EdtFatHora, EdtAumento)) {
            int fat_hora = Integer.parseInt(EdtFatHora.getText());
            int fat_maquina = Integer.parseInt(EdtFatMaquina.getText());
            
            this.preencherDados(fat_hora, fat_maquina);
            return;
        }
        JOptionPane.showMessageDialog(null, "TODOS OS CAMPOS DEVEM SER PREENCHIDOS!!!");
    }//GEN-LAST:event_jBtnCalcularMouseClicked

    private void verifyButton() {
        if (EdtFatMaquina.getText().isBlank()
                || EdtFatMaquina.getText().isEmpty()) {
            jBtnCalcular.setEnabled(false);
            return;
        }
        jBtnCalcular.setEnabled(true);

    }
    private void ButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonResetActionPerformed
        this.setDefaultValue();

    }//GEN-LAST:event_ButtonResetActionPerformed

    private void EdtQtdMaquinaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EdtQtdMaquinaFocusLost
        if (utils.verifyContentForButton(EdtAumento, EdtMaoObra, EdtAumento, EdtAumento, EdtAumento, EdtFatHora, EdtAumento)) {
            jBtnCalcular.setEnabled(false);

        } else {
            jBtnCalcular.setEnabled(true);
        }

    }//GEN-LAST:event_EdtQtdMaquinaFocusLost

    private void EdtCustoOpMaquinaNovaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EdtCustoOpMaquinaNovaFocusLost
        if (utils.verifyContentForButton(EdtAumento, EdtMaoObra, EdtAumento, EdtAumento, EdtAumento, EdtFatHora, EdtAumento)) {
            jBtnCalcular.setEnabled(false);

        } else {
            jBtnCalcular.setEnabled(true);
        }
    }//GEN-LAST:event_EdtCustoOpMaquinaNovaFocusLost

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
            java.util.logging.Logger.getLogger(AnaliseDeCustosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaliseDeCustosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaliseDeCustosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaliseDeCustosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaliseDeCustosView().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonReset;
    private javax.swing.JComboBox<String> ComboMes;
    private javax.swing.JTextField EdtAumento;
    private javax.swing.JTextField EdtCustoComAumento;
    private javax.swing.JTextField EdtCustoContratando;
    private javax.swing.JTextField EdtCustoMaquina;
    private javax.swing.JTextField EdtCustoMaquinaVelha;
    private javax.swing.JTextField EdtCustoObraComAumento;
    private javax.swing.JTextField EdtCustoOpMaqNova;
    private javax.swing.JTextField EdtCustoOpMaquinaNova;
    private javax.swing.JTextField EdtCustoOpTotal;
    private javax.swing.JTextField EdtCustoOperacional;
    private javax.swing.JTextField EdtFatHora;
    private javax.swing.JTextField EdtFatMaquina;
    private javax.swing.JTextField EdtFatReal;
    private javax.swing.JTextField EdtFaturamentoMaqNova;
    private javax.swing.JTextField EdtFaturamentoPorMaquiuna;
    private javax.swing.JTextField EdtLucroAtual;
    private javax.swing.JTextField EdtLucroContratando;
    private javax.swing.JTextField EdtLucroSemContratar;
    private javax.swing.JTextField EdtMaoObra;
    private javax.swing.JTextField EdtMediaHoras;
    private javax.swing.JTextField EdtPercentMaqNova;
    private javax.swing.JTextField EdtQtdMaquina;
    private javax.swing.JButton jBtnCalcular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lBMedia;
    // End of variables declaration//GEN-END:variables
}
