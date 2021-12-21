package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {

    public static Connection getConexao() {

        try {
             final String url = "jdbc:postgresql://localhost/Quiosque";
             final String user = "postgres";
             final String password = "326157";
             return  DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }
}
