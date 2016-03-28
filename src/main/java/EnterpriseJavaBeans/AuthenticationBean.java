package EnterpriseJavaBeans;

import static AppModel.DatabaseConnection.DATABASE_PASSWORD;
import static AppModel.DatabaseConnection.DATABASE_URL;
import static AppModel.DatabaseConnection.DATABASE_USERNAME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ejb.Stateless;

/**
 *
 * @author HenriqueLinhares
 */
@Stateless
public class AuthenticationBean {

    public boolean autentica(String tipoDeUsuario, String login, String senha) {
        String query = "select * from " + tipoDeUsuario + " where login = '" + login + "' AND senha = '" + senha + "' ;";
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
        return false;
    }

}
