/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnterpriseJavaBeans;

import static AppModel.DatabaseConnection.DATABASE_PASSWORD;
import static AppModel.DatabaseConnection.DATABASE_URL;
import static AppModel.DatabaseConnection.DATABASE_USERNAME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.ejb.Stateless;

/**
 *
 * @author HenriqueLinhares
 */
@Stateless
public class SolicitacaoDeSalaBean {

    public int novaSolicitacaoDeSala(int idSala, String idProfessor, String horarioInicio, String horarioFim, String data) {
        int id = idGenerator();

        String query = "INSERT INTO `sql5111604`.`Reserva` (`ID`, `Salas_idSalas`, `horarioInicio`, `horarioFim`, `aprovada`, `data`, `Professor_login`) "
                + "VALUES ("+ id +", "+idSala+", '"+horarioInicio+"', '"+horarioFim+"', FALSE, '"+data+"', '"+idProfessor+"');";
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
        
        return id;
    }

    private static int idGenerator() {
        boolean continua = true;
        Connection conn = null;
        int random = 0;
        try {

            do {
                Random randomGenerator = new Random();
                random = randomGenerator.nextInt(Integer.MAX_VALUE - 1);
                String query = "select * from Reserva where ID = " + random;

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
