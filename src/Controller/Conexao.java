package Controller;


        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;
        import javax.swing.JOptionPane;

public class Conexao {
    // criar variável conexao
    public Connection connection;
    //driver, DRIVER = banco de dados, URL referente ao caminho
    public Connection getConexao(){
        final String DRIVER = "com.mysql.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/controle_horas";
        // tenta a conexao, root e root como usuário e senha
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, "root","root");
            return connection;
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Driver não encontrado: " + e);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Problemas na fonte de dados." + e);
        }
        return null;
    }
    //fechar conexão
    public void close(){
        try{
            connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Problemas ao fechar conexão" + e);
        }
    }
}