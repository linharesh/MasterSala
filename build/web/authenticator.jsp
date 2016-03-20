
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="DefaultPackage.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String tipoDeUsuario = (request.getParameter("select"));
        String login = (request.getParameter("login"));
        String senha = (request.getParameter("senha"));
        
        
        out.println(tipoDeUsuario);
        out.println(login);
        out.println(senha);
        
        out.print(AuthenticatorBean.autenticar(tipoDeUsuario,login ,senha));
        %>
    </body>
</html>
