<%-- 
    Document   : logout
    Created on : 21/03/2016, 20:59:39
    Author     : HenriqueLinhares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGOUT</title>
    </head>
    <body>
        <h1>LOGOUT</h1>
        <%
            session.invalidate();
            out.println("<script>document.location.href='index.jsp';</script>");
        %>
    </body>
</html>
