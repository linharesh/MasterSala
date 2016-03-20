package DefaultPackage;



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
            return autenticaGerenteDeRecursos(login, senha);
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

    private static boolean autenticaGerenteDeRecursos(String login, String senha) {
        if (login.equals("gerentederecursos") && senha.equals("gerentederecursos")) {
            return true;
        } else {
            return false;
        }
    }
}
