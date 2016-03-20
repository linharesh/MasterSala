<%-- 
    Document   : authenticator
    Created on : 20/03/2016, 15:07:40
    Author     : HenriqueLinhares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="" %>

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
