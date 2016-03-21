/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppModel;

import static AppModel.DatabaseConnection.DATABASE_PASSWORD;
import static AppModel.DatabaseConnection.DATABASE_URL;
import static AppModel.DatabaseConnection.DATABASE_USERNAME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

/**
 *
 * @author HenriqueLinhares
 */
public class UserCreator {

    public static boolean podeCriarUsuario(String login, String tipoDeUsuario) {

        String query = "select * from " + tipoDeUsuario + " where login = '" + login + "'";
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("Database connection established");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()) {
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

    public static void criarUsuario(String nome, String login, String senha, String tipoDeUsuario) {
        
        int ID = idGenerator(tipoDeUsuario);

        String query = "INSERT INTO `sql5111604`.`"+tipoDeUsuario+"`"
                + "(`id"+tipoDeUsuario+"`,"
                + "`login`,"
                + "`senha`,"
                + "`nome`)"
                + "VALUES ('"
                + ID + "', '"
                + login + "' , '"
                + senha + "' , '"
                + nome + "') ;";
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("Database connection established");

            Statement stmt = conn.createStatement();
            stmt.execute(query);
            
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
    }

    private static int idGenerator(String tipoDeUsuario) {
        boolean continua = true;
        Connection conn = null;
        int random = 0;
        try {

            do {
                Random randomGenerator = new Random();
                random = randomGenerator.nextInt(Integer.MAX_VALUE - 1);
                String query = "select * from "+tipoDeUsuario+" where idProfessor = " + random;

                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                System.out.println("Database connection established");

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if (!rs.next()) {
                    continua = false;
                }

            } while (continua);

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
        return random;
    }

}
