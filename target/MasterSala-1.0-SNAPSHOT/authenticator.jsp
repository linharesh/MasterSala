
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="AppModel.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authenticator</title>
    </head>
    <body>
        <h1>Authenticator</h1>
        <%
            String tipoDeUsuario = (request.getParameter("select"));
            String login = (request.getParameter("login"));
            String senha = (request.getParameter("senha"));
            if (AuthenticatorBean.autenticar(tipoDeUsuario, login, senha)) {
                
                session.setAttribute("loginUsuario", login);
                session.setAttribute("senhaUsuario", senha);
                session.setAttribute("tipoDeUsuario", tipoDeUsuario);
                
                if (tipoDeUsuario.equalsIgnoreCase("GerenteDeRecursos")) {
                    
                    out.println("<script>document.location.href='gerenteDeRecursoLogado.jsp';</script>");
                }

                if (tipoDeUsuario.equalsIgnoreCase("Professor")) {
                    out.println("<script>document.location.href='professorLogado.jsp';</script>");
                }

                if (tipoDeUsuario.equalsIgnoreCase("AssistenteDeRecursos")) {
                    out.println("<script>document.location.href='assistenteDeRecursosLogado.jsp';</script>");
                }

            } else {
               out.println("Login ou senha inválidos. <a href='java script:back()'>Voltar</a>");
            }
        %>
    </body>
</html>
