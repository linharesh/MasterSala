<%-- 
    Document   : Authenticator
    Created on : 10/02/2016, 18:07:49
    Author     : HenriqueLinhares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%
        System.out.println(request.getParameter("login"));
        System.out.println(request.getParameter("senha"));
        %>
        
    </body>
</html>
