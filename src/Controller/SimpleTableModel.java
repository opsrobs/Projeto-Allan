package Controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PremierSoft
 */
public class SimpleTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = null;

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    @Override
    public int getRowCount() {
        return getLinhas().size();
    }

    @Override
    public int getColumnCount() {
        return getColunas().length;
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] linha = (String[]) getLinhas().get(rowIndex);
        return linha[columnIndex];
    }

    public SimpleTableModel(ArrayList dados, String[] colunas) {
        this.setColunas(colunas);
        this.setLinhas(dados);
    }

}