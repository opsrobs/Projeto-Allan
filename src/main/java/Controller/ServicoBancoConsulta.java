package Controller;

import Models.Lancamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServicoBancoConsulta {
    
        
private final Conexao conexao = new Conexao();
 

  public ArrayList getCompromissoByLista()throws SQLException{
      ArrayList lista = new ArrayList();
     try (Statement st = conexao.getConexao().createStatement(); 
            ResultSet rs = st.executeQuery
             ("select * from controle_horas.lancamento,"
                     + " controle_horas.funcionario")) {
         
        while (rs.next()){
          lista.add(new String[]{rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9),
                            rs.getString(10),
                            rs.getString(11)});
        }
    }
    
     return lista;
 }

    
}
