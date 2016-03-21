package AppModel;

import static AppModel.DatabaseConnection.DATABASE_PASSWORD;
import static AppModel.DatabaseConnection.DATABASE_URL;
import static AppModel.DatabaseConnection.DATABASE_USERNAME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HenriqueLinhares
 */
public class AuthenticatorBean {

    public static boolean autenticar(String tipoDeUsuario, String login, String senha) {

        if (tipoDeUsuario.equalsIgnoreCase("Professor")) {
            return autenticaProfessor(login, senha);
        }

        if (tipoDeUsuario.equalsIgnoreCase("AssistenteDeRecursos")) {
            return autenticaAssistenteDeRecursos(login, senha);
        }

        if (tipoDeUsuario.equalsIgnoreCase("GerenteDeRecursos")) {
            try {
                return autenticaGerenteDeRecursos(login, senha);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AuthenticatorBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AuthenticatorBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;

    }

    private static boolean autenticaProfessor(String login, String senha) {
        if (login.equals("professor") && senha.equals("professor")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean autenticaAssistenteDeRecursos(String login, String senha) {
        if (login.equals("assistentederecursos") && senha.equals("assistentederecursos")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean autenticaGerenteDeRecursos(String login, String senha) throws ClassNotFoundException, SQLException {

        String query = "select * from GerenteDeRecursos where login = '" + login + "' AND senha = '" + senha + "' ;";
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("Database connection established");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database connection terminated");
                } catch (Exception e) {
                    /* ignore close errors */ }
            }
        }
        return false ;
    }
}

