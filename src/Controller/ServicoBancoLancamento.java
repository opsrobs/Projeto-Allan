package Controller;

import Models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServicoBancoLancamento {

    private final Conexao conexao = new Conexao();

    public void insert(Lancamento lancamento) throws SQLException {
        Connection con = conexao.getConexao();
        //inserir o nome (o indice começa no 1)
        try ( PreparedStatement pst = con.prepareStatement("INSERT INTO lancamento(id_Controle, funcionario_cod_funcionaio, hora_trabalhada, mes, ano)"
                + "VALUES (0,?,?,?,?) ")) {
            pst.setInt(1, lancamento.getCodFuncionario());
            pst.setFloat(2, lancamento.getHorasTrabalhadas());
            pst.setInt(3, lancamento.getMes());
            pst.setInt(4, lancamento.getAno());

            //usar sempre pra inserir ou modificar dado na tabela
            pst.executeUpdate();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select last_insert_id()");

            if (rs.next()) {
                lancamento.setId_controle(rs.getInt(1));
            }
        }
        conexao.close();
    }

    public void update(Lancamento lancamento) throws SQLException {
        try ( PreparedStatement pst = conexao.getConexao().prepareStatement("update lancamento set lancamento_cod_funcionio = ?, hora_trabalhada = ?, mes = ?, ano =? (id_Controle = ?)")) {
            pst.setInt(1, lancamento.getCodFuncionario());
            pst.setFloat(2, lancamento.getHorasTrabalhadas());
            pst.setInt(3, lancamento.getMes());
            pst.setInt(4, lancamento.getAno());
            pst.setInt(5, lancamento.getId_controle());
            pst.executeUpdate();
        }
        conexao.close();
    }

    public void delete(Lancamento lancamento) throws SQLException {
        try ( PreparedStatement pst = conexao.getConexao().prepareStatement("delete from lancamento where (id_Controle = ?)")) {
            pst.setInt(1, lancamento.getId_controle());
            pst.executeUpdate();
        }
        conexao.close();
    }

    public Lancamento getLancamentoByNome(int cod) throws SQLException {
        try ( Statement st = conexao.getConexao().createStatement();  ResultSet rs = st.executeQuery("select * from lancamento where (lancamento_cod_funcionio = " + cod + ")")) {

            rs.first();
            return new Lancamento(rs.getInt("id_Controle"),
                    rs.getInt("lancamento_cod_funcionio"),
                    rs.getFloat("hora_trabalhada"),
                    rs.getInt("mes"),
                    rs.getInt("ano"));
        }
    }

    public String getValueHour(int cod) throws SQLException {
        String value = "";
        try ( Statement st = conexao.getConexao().createStatement();  ResultSet rs = st.executeQuery(
                "SELECT funcionario_cod_funcionaio, hora_trabalhada, valor_Hora "
                + "FROM controle_horas.lancamento, controle_horas.funcionario "
                + "where funcionario.cod_funcionaio = " + cod + "")) {

            while (rs.next()) {
                value = rs.getString(3);
            }
            System.out.println(value);

        }

        return value;
    }

    public ArrayList<String> getMesByFilter(int cod) throws SQLException {
        ArrayList<String> dados = new ArrayList<>();
        Utils utils = new Utils();
        try ( Statement st = conexao.getConexao().createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM controle_horas.getquerybyano WHERE cod_funcionaio = "+cod+" group by mes")) {

            while (rs.next()) {
                dados.add(utils.mes(rs.getString(5)));
            }
        }
        return dados;

    }

    public ArrayList<Lancamento> getDadosBy(int cod, String order) throws SQLException {
        ArrayList<Lancamento> lista = new ArrayList<>();
        try ( Statement st = conexao.getConexao().createStatement();  ResultSet rs = st.executeQuery(
                "select * from lancamento where funcionario_cod_funcionaio = " + cod + " group by " + order + "")) {

            while (rs.next()) {
                lista.add(new Lancamento(rs.getInt("id_Controle"),
                        rs.getInt("funcionario_cod_funcionaio"),
                        rs.getFloat("hora_trabalhada"),
                        rs.getInt("mes"),
                        rs.getInt("ano")));
            }
        }

        return lista;
    }

    public ArrayList<Lancamento> getAnoBy() throws SQLException {
        ArrayList<Lancamento> lista = new ArrayList<>();
        try ( Statement st = conexao.getConexao().createStatement();  ResultSet rs = st.executeQuery(
                "select * from lancamento group by ano ")) {

            while (rs.next()) {
                lista.add(new Lancamento(rs.getInt("id_Controle"),
                        rs.getInt("funcionario_cod_funcionaio"),
                        rs.getFloat("hora_trabalhada"),
                        rs.getInt("mes"),
                        rs.getInt("ano")));
            }
        }

        return lista;
    }

    public ArrayList<String> getMesBy(String order) throws SQLException {
        ArrayList<String> dados = new ArrayList<>();
        Utils utils = new Utils();
        try ( Statement st = conexao.getConexao().createStatement();  ResultSet rs = st.executeQuery("SELECT * FROM controle_horas.gettabelabyquery"
                + " group by " + order + ";")) {

            while (rs.next()) {
                dados.add(utils.mes(rs.getString(3)));
            }
        }
        return dados;

    }

    public int getHorasByPeriodo(int periodoIni, int periodoFim, int codFun, int ano) throws SQLException {
        int lista = 0;
        try ( Statement st = conexao.getConexao().createStatement();  ResultSet rs = st.executeQuery(" select sum(hora_trabalhada) "
                + "from controle_horas.lancamento,"
                + " controle_horas.funcionario"
                + " where funcionario_cod_funcionaio = cod_funcionaio and"
                + " cod_funcionaio = " + codFun + " and"
                + " mes between " + periodoIni + " and " + periodoFim + " "
                + "and ano = " + ano + ";")) {
            while (rs.next()) {
                lista = rs.getInt(1);
            }

            return lista;
        }
    }

    public int getHorasByFuncionario(int codFun) throws SQLException {
        int lista = 0;
        try ( Statement st = conexao.getConexao().createStatement();  ResultSet rs = st.executeQuery("select sum(hora_trabalhada)"
                + " from controle_horas.lancamento where funcionario_cod_funcionaio ="
                + " " + codFun + ";")) {

            while (rs.next()) {
                lista = rs.getInt(1);
            }

            return lista;
        }
    }

    public ArrayList<String[]> getTabelaByQuery() throws SQLException {
        ArrayList<String[]> dados = new ArrayList<>();
        Utils utils = new Utils();
        try ( Statement st = conexao.getConexao().createStatement();  ResultSet rs = st.executeQuery("SELECT * FROM controle_horas.gettabelabyquery;")) {

            while (rs.next()) {
                dados.add(new String[]{
                    rs.getString(1),
                    rs.getString(2),
                    utils.mes(rs.getString(3)),
                    rs.getString(4),
                    utils.formatTot(Float.parseFloat(rs.getString(5))),
                    rs.getString(6)});
            }
        }
        return dados;
    }

    public ArrayList<String[]> getTabelaByMes(int order) throws SQLException {
        ArrayList<String[]> dados = new ArrayList<>();
        Utils utils = new Utils();
        try ( Statement st = conexao.getConexao().createStatement();  ResultSet rs = st.executeQuery("SELECT * FROM controle_horas.gettabelabyquery "
                + "where mes = " + order + ";")) {

            while (rs.next()) {
                dados.add(new String[]{
                    rs.getString(1),
                    rs.getString(2),
                    utils.mes(rs.getString(3)),
                    rs.getString(4),
                    utils.formatTot(Float.parseFloat(rs.getString(5))),
                    rs.getString(6)});
            }
        }
        return dados;
    }

}
