package main.java.Models;

import Controller.ServicoBancoLancamento;
import Controller.Utils;
import com.orsoncharts.Chart3DFactory;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;


public class GraficoPeriodo extends JFrame {

    Utils utils = new Utils();

    ServicoBancoLancamento sbl = new ServicoBancoLancamento();

    public GraficoPeriodo(int inicio, int fim, int ano, String nome) {
        this.JFrameCenterPositionTest(inicio, fim, ano, nome);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void JFrameCenterPositionTest(int inicio, int fim, int ano, String nome) {
        setTitle("Tabela de Consultas!!!");
        add(new JLabel("", SwingConstants.CENTER), BorderLayout.CENTER);
        setSize(800, 530);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        this.gerarGrafico(inicio, fim, ano, nome);
        setVisible(true);
    }

    public void centerValues(JFreeChart grafico) {
        CategoryItemRenderer render = ((CategoryPlot) grafico.getPlot()).getRenderer();

        render.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        render.setBaseItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,
                TextAnchor.TOP_CENTER);

        render.setBasePositiveItemLabelPosition(position);
    }

    private String tituloGrafico(String nome) {
        if (!nome.equals(null)) {
            return "Salarios de " + nome;
        }
        return "Consulta de salarios por Periodo";
    }

    private ArrayList<ObjetoAuxiliar> listaObjeto(int inicio, int fim, int ano, String nome) {
        ArrayList<ObjetoAuxiliar> dados = new ArrayList<>();
        try {

            if (inicio != 0 && fim != 0) {
                return dados = sbl.getDadosByFilter(nome, inicio, fim, ano);

            } else if (!nome.equals(null) && !nome.equals("")) {
                return dados = sbl.getDadosByFilterByPerson(nome, inicio, fim);
            } else if (!nome.equals(null) && nome.equals("")
                    && inicio == 0 && fim <= 12
                    && ano > 0) {
                return dados = sbl.filterByYear(ano);
            } else {
                return dados = sbl.getDadosByQuery();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GraficoPeriodo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public void gerarGrafico(int inicio, int fim, int ano, String nome) {
        ArrayList<ObjetoAuxiliar> dados = this.listaObjeto(inicio, fim, ano, nome);
        DefaultCategoryDataset barra = new DefaultCategoryDataset();

        for (int i = 0; i < dados.size(); i++) {
            barra.setValue((int) dados.get(i).getValor(),
                    utils.mes(dados.get(i).getNome()), utils.mes(dados.get(i).getNome()));
        }

        JFreeChart grafico = ChartFactory.createBarChart(this.tituloGrafico(nome), "MESES", "SALARIOS MÊS", barra,
                PlotOrientation.VERTICAL, true, true, true);
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);

        this.centerValues(grafico);
    }

    public static void main(String[] args, int inicio, int fim, int ano, String nome) {
        new GraficoPeriodo(inicio, fim, ano, nome);
    }

}
