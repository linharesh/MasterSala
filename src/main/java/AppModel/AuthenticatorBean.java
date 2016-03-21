package AppModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

        Connection conn = null;

        try {

            String url = "jdbc:mysql://sql5.freemysqlhosting.net:3306/sql5111604";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "sql5111604", "HHVMrYrI6A");
            System.out.println("Database connection established");

            Statement stmt = conn.createStatement();
            String query = "select * from GerenteDeRecursos where login = '" + login + "' AND senha = '"+ senha + "' ;" ;
            ResultSet rs = stmt.executeQuery(query);
            
            if (rs.next()){
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
