package Controller;

import Models.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServicoBancoFuncionario {

    private final Conexao conexao = new Conexao();

    public void insert(Funcionario funcionario) throws SQLException {
        Connection con = conexao.getConexao();
        //inserir o nome (o indice começa no 1)
        try ( PreparedStatement pst = con.prepareStatement("INSERT INTO funcionario(cod_funcionaio, nome_Funcionario, CPF, Rg, genero, valor_Hora,data_nasc,status)"
                + "VALUES (0,?,?,?,?,?,?,?) ")) {
//        pst.setInt(1,funcionario.getCod_funcionario());
            pst.setString(1, funcionario.getNome_funcionario());
            pst.setString(2, funcionario.getCpf());
            pst.setString(3, funcionario.getRg());
            pst.setString(4, funcionario.getGenero());
            pst.setDouble(5, funcionario.getValor_hora());
            pst.setDate(6, new java.sql.Date(funcionario.getData_nasc().getTime()));
            pst.setString(7, funcionario.getStatus());

            //usar sempre pra inserir ou modificar dado na tabela
            pst.executeUpdate();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select last_insert_id()");

            if (rs.next()) {
                funcionario.setCod_funcionario(rs.getInt(1));
            }
        }
        conexao.close();
    }

    public void update(Funcionario funcionario) throws SQLException {
        try ( PreparedStatement pst = conexao.getConexao().prepareStatement("update funcionario set nome_Funcionario = ?, CPF = ?, Rg = ?, genero =?, valor_Hora =?,data_nasc=?, status = ? where (cod_funcionaio = ?)")) {
            pst.setString(1, funcionario.getNome_funcionario());
            pst.setString(2, funcionario.getCpf());
            pst.setString(3, funcionario.getRg());
            pst.setString(4, funcionario.getGenero());
            pst.setDouble(5, funcionario.getValor_hora());
            pst.setDate(6, new java.sql.Date(funcionario.getData_nasc().getTime()));
            pst.setString(7, funcionario.getStatus());
            pst.setInt(8, funcionario.getCod_funcionario());
            pst.executeUpdate();
        }
        conexao.close();
    }

    public void delete(Funcionario funcionario) throws SQLException {
        try ( PreparedStatement pst = conexao.getConexao().prepareStatement("delete from funcionario where (cod_funcionaio = ?)")) {
            pst.setInt(1, funcionario.getCod_funcionario());
            pst.executeUpdate();
        }
        conexao.close();
    }

    public Funcionario getFuncionarioByNome(int cod) throws SQLException {
        try ( Statement st = conexao.getConexao().createStatement();  ResultSet rs = st.executeQuery("select * from funcionario where (cod_funcionaio = " + cod + ")")) {

            rs.first();
            return new Funcionario(rs.getInt("cod_funcionaio"),
                    rs.getString("nome_Funcionario"),
                    rs.getString("CPF"),
                    rs.getString("Rg"),
                    rs.getString("genero"),
                    rs.getDouble("valor_Hora"),
                    rs.getDate("data_nasc"),
                    rs.getString("status"));
        }
    }

    public ArrayList<Funcionario> getFuncionarioByLista() throws SQLException {
        ArrayList<Funcionario> lista = new ArrayList<>();
        try ( Statement st = conexao.getConexao().createStatement();  ResultSet rs = st.executeQuery("select * from funcionario order by nome_Funcionario")) {

            while (rs.next()) {
                lista.add(new Funcionario(rs.getInt("cod_funcionaio"),
                        rs.getString("nome_Funcionario"),
                        rs.getString("CPF"),
                        rs.getString("Rg"),
                        rs.getString("genero"),
                        rs.getDouble("valor_Hora"),
                        rs.getDate("data_nasc"),
                        rs.getString("status")));
            }
        }

        return lista;
    }

}
