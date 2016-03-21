
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="AppModel.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            out.println("<h1>Autenticando..</h1>");
            String tipoDeUsuario = (request.getParameter("select"));
            String login = (request.getParameter("login"));
            String senha = (request.getParameter("senha"));
            if (AuthenticatorBean.autenticar(tipoDeUsuario, login, senha)){
                if (tipoDeUsuario.equalsIgnoreCase("GerenteDeRecursos")){
                    response.sendRedirect("gerenteDeRecursoLogado.jsp");
                }
            } else {
                out.println("<h1>Falha na autenticação !</h1>");
            }
        %>
    </body>
</html>
