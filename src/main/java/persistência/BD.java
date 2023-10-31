package persistência;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {
    static final String URL_DB="jdbc:mysql://localhost:3306/contrataçãoprofessores";
    static final String USUÁRIO="admin";
    static final String SENHA="admin";
    public static Connection conexão = null;
    
    public static void criaConexão() throws SQLException {
        try{
            conexão = DriverManager.getConnection(URL_DB, USUÁRIO, USUÁRIO);
        } catch(SQLException exceção_sql){exceção_sql.printStackTrace();}
    }
    
    public static void fechaConexão() throws SQLException {
        try{
            conexão.close();
        } catch(SQLException exceção_sql){exceção_sql.printStackTrace();}
    }
}
