package Controller;

import Models.Funcionario;
import Models.Lancamento;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import main.java.View.SearchByTable;

public class Utils {

    private final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat dh = new SimpleDateFormat("hh:mm:ss");
//    private SearchByTable searchByTable = new SearchByTable();
    ServicoBancoFuncionario servicoBancoFuncionario = new ServicoBancoFuncionario();
    ServicoBancoLancamento sbl = new ServicoBancoLancamento();
    
    

    public void visibleButtonTrue(JRadioButton edit, JTextField name, String func) {
        if (edit.isSelected()) {
            name.setVisible(true);
            name.setText(func);
        }
    }

    public boolean verifyContentForButton(JTextField a, JTextField b, JTextField c, JTextField d, JTextField e, JTextField f, JTextField g) {
        if (a.getText().isEmpty()
                && b.getText().isEmpty()
                && c.getText().isEmpty()
                && d.getText().isEmpty()
                && e.getText().isEmpty()
                && f.getText().isEmpty()
                && g.getText().isEmpty()) {
            return false;

        } else if (a.getText().isBlank()
                && b.getText().isBlank()
                && c.getText().isBlank()
                && d.getText().isBlank()
                && e.getText().isBlank()
                && f.getText().isBlank()
                && g.getText().isBlank()) {
            return false;
        }
        return true;
    }

    public void atualizarFuncionario(JComboBox<Funcionario> j, ServicoBancoFuncionario sb) throws SQLException {
        if (j.getItemCount() > 0) {
            j.removeAllItems();
        }

        ArrayList<Funcionario> lista = sb.getFuncionarioByLista();

        for (Funcionario funcionario : lista) {
            j.addItem(funcionario);
        }
        j.setSelectedIndex(-1);
    }

    public void mesFuncionario(JComboBox<Lancamento> j, ServicoBancoLancamento sbl, int cod, String order) throws SQLException {
        this.sbl = sbl;
        if (j.getItemCount() > 0) {
            j.removeAllItems();
        }

        ArrayList<Lancamento> lista = sbl.getDadosBy(cod, order);

        for (Lancamento lancamento : lista) {
            j.addItem(lancamento);
        }
        j.setSelectedIndex(-1);
    }

    public void mesFuncionarioBy(JComboBox<String> j, ServicoBancoLancamento sbl, int cod, int ano) throws SQLException {
        this.sbl = sbl;
        if (j.getItemCount() > 0) {
            j.removeAllItems();
        }

        ArrayList<String> lista = sbl.getMesByFilter(cod, ano);

        for (String mes : lista) {
            j.addItem(mes);
        }
        j.setSelectedIndex(-1);
    }

    public void mesFuncionario(JComboBox<String> j, ServicoBancoLancamento sbl, String order) throws SQLException {
        this.sbl = sbl;
        if (j.getItemCount() > 0) {
            j.removeAllItems();
        }

        ArrayList<String> lista = sbl.getMesBy(order);

        for (String mes : lista) {
            j.addItem(mes);
        }
        j.setSelectedIndex(-1);
    }

    public String removeEpecialChar(JTextField especialChar) {
        if (especialChar.getText().contains("%")) {
            return especialChar.getText().replace("%", "");
        } else {
            return especialChar.getText().replace("[^\\d]", "");
        }
    }

    public String mes(String numMes) {
        String value;
        value = numMes.replace("0", "");
        return switch (value) {
            case "1" ->
                "Janeiro";
            case "2" ->
                "Fevereiro";
            case "3" ->
                "Março";
            case "4" ->
                "Abril";
            case "5" ->
                "Maio";
            case "6" ->
                "Junho";
            case "7" ->
                "Julho";
            case "8" ->
                "Agosto";
            case "9" ->
                "Setembro";
            case "10" ->
                "Outubro";
            case "11" ->
                "Novembro";
            case "12" ->
                "Dezembro";
            default ->
                "Mês invalido!!!";
        };
    }

    public int reverseMonth(String numMes) {
        String value;
        value = numMes.replace("0", "");
        return switch (value) {
            case "Janeiro" ->
                1;
            case "Fevereiro" ->
                2;
            case "Março" ->
                3;
            case "Abril" ->
                4;
            case "Maio" ->
                5;
            case "Junho" ->
                6;
            case "Julho" ->
                7;
            case "Agosto" ->
                8;
            case "Setembro" ->
                9;
            case "Outubro" ->
                10;
            case "Novembro" ->
                11;
            case "Dezembro" ->
                12;
            default ->
                0;
        };
    }

    public String formatTot(float tot) {
        DecimalFormat df = new DecimalFormat("###,###,##0.00");
        return df.format(tot);
    }

    public void getAnoFuncionario(JComboBox j, ServicoBancoLancamento sbl, int cod, String order) throws SQLException {
        if (j.getItemCount() > 0) {
            j.removeAllItems();
        }

        ArrayList<Lancamento> lista = sbl.getDadosBy(cod, order);

        for (Lancamento lancamento : lista) {
            j.addItem(lancamento.getAno());
        }
        j.setSelectedIndex(-1);
    }

    public void anoFuncionario(JComboBox<Integer> j, ServicoBancoLancamento sbl) throws SQLException {
        this.sbl = sbl;
        if (j.getItemCount() > 0) {
            j.removeAllItems();
        }

        ArrayList<Lancamento> lista = sbl.getAnoBy();

        for (Lancamento lancamento : lista) {
            j.addItem(lancamento.getAno());
        }
        j.setSelectedIndex(-1);
    }

    public ArrayList<Lancamento> dadosLancamentos(ServicoBancoLancamento sbl) throws SQLException {
        this.sbl = sbl;

        ArrayList<Lancamento> lista = sbl.dadosLancamento();
        return lista;
    }

    public ArrayList<Funcionario> dadosFuncionario(ServicoBancoLancamento sbl) throws SQLException {
        this.sbl = sbl;

        ArrayList<Funcionario> lista = sbl.dadosFuncionario();
        return lista;
    }

//    public void 
    public Date strToDate(String data) throws ParseException {
        return df.parse(data);
    }

    public Date strToTime(String hora) throws ParseException {
        return dh.parse(hora);
    }

    public String getDataFormatada(Date d) {
        return df.format(d);
    }

    public String getHorFormatada(Date h) {
        return dh.format(h);
    }

    public int verifyContent(String content) {
        int value = 1;
        if (content.equals("")) {
            return value;
        }
        return Integer.parseInt(content);
    }

    public Float verifyValueOfCombo(int cod) throws SQLException {
        return Float.parseFloat(sbl.getValueHour(cod));
    }

    public int verifySumTime(int periodoIni, int periodoFim, int cod, int ano) throws SQLException {
        if (periodoFim > periodoIni) {
            return sbl.getHorasByPeriodo(periodoIni, periodoFim, cod, ano);
        } else {
            return sbl.getHorasByPeriodo(periodoIni, periodoIni, cod, ano);
        }
    }

    public boolean verificaCpf(String input) {
        String cpf = input.replaceAll("\\D", "");

        // considera-se erro cpf's formados por uma sequencia de numeros iguais
        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
                || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
                || cpf.equals("99999999999") || (cpf.length() != 11)) {
            return (false);
        }
        char dig10,
                dig11;
        int sm, i, r, num, peso;
        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do cpf em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = cpf.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }
            // converte no respectivo caractere numerico
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = cpf.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }
            // Verifica se os digitos calculados conferem com os digitos informados.
            return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

}
