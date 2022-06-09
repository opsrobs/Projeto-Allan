package main.java.Controller;

import Controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import main.java.Models.Endereco;

public class ServicoBancoEndereco {

    private final Conexao conexao = new Conexao();

    public void insert(Endereco endereco) throws SQLException {
        Connection con = conexao.getConexao();
        //inserir o nome (o indice começa no 1)
        try ( PreparedStatement pst = con.prepareStatement("INSERT INTO endereco(idEndereco,"
                + " cep,"
                + " estado,"
                + " cidade,"
                + " bairro,"
                + " rua,"
                + " numero,"
                + "complemento)"
                + "VALUES (0,?,?,?,?,?,?,?) ")) {
//        pst.setInt(1,endereco.getCod_endereco());
            pst.setString(1, endereco.getCep());
            pst.setString(2, endereco.getUf());
            pst.setString(3, endereco.getLocalidade());
            pst.setString(4, endereco.getBairro());
            pst.setString(5, endereco.getLogradouro());
            pst.setString(6, endereco.getNumero());
            pst.setString(7, endereco.getComplemento());

            //usar sempre pra inserir ou modificar dado na tabela
            pst.executeUpdate();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select last_insert_id()");

            if (rs.next()) {
                endereco.setIdEndereco(rs.getInt(1));
            }
        }
        conexao.close();
    }

}
