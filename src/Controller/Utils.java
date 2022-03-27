package Controller;

import Models.Funcionario;
import Models.Lancamento;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Utils {

    private final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat dh = new SimpleDateFormat("hh:mm:ss");
    ServicoBancoFuncionario servicoBancoFuncionario = new ServicoBancoFuncionario();
    ServicoBancoLancamento sbl = new ServicoBancoLancamento();

    public void atualizarFuncionario(JComboBox j, ServicoBancoFuncionario sb) throws SQLException {
        if (j.getItemCount() > 0) {
            j.removeAllItems();
        }

        ArrayList<Funcionario> lista = sb.getFuncionarioByLista();

        for (Funcionario funcionario : lista) {
            j.addItem(funcionario);
        }
        j.setSelectedIndex(-1);
    }

    public void mesFuncionario(JComboBox j, ServicoBancoLancamento sbl, int cod, String order) throws SQLException {
        if (j.getItemCount() > 0) {
            j.removeAllItems();
        }

        ArrayList<Lancamento> lista = sbl.getDadosBy(cod, order);

        for (Lancamento lancamento : lista) {
            j.addItem(lancamento);
        }
        j.setSelectedIndex(-1);
    }

    public String formatTot(float tot) {
        DecimalFormat df = new DecimalFormat("###,###,##0.00");
        System.out.println(df.format(tot));
        return df.format(tot);
    }

    public void anoFuncionario(JComboBox j, ServicoBancoLancamento sbl, int cod, String order) throws SQLException {
        if (j.getItemCount() > 0) {
            j.removeAllItems();
        }

        ArrayList<Lancamento> lista = sbl.getDadosBy(cod, order);

        for (Lancamento lancamento : lista) {
            j.addItem(lancamento.getAno());
        }
        j.setSelectedIndex(-1);
    }

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
        System.out.println(periodoIni);
        System.out.println(periodoFim);
        if (periodoIni > periodoFim) {
            return sbl.getHorasByPeriodo(periodoIni, periodoIni, cod, ano);
        } else if (periodoFim != periodoIni && periodoFim > periodoIni) {
            return sbl.getHorasByPeriodo(periodoIni, periodoFim, cod, ano);
        } else {
            return sbl.getHorasByPeriodo(periodoIni, periodoIni, cod, ano);
        }
    }

    public boolean verificaCpf(String input) {
        String cpf = input.replaceAll("\\D", "");
        if (cpf == null) {
            return false;
        }

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
                num = (int) (cpf.charAt(i) - 48);
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
                num = (int) (cpf.charAt(i) - 48);
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
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

}
