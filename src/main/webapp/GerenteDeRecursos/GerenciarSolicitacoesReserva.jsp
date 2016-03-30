<%@page import="AppModel.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="EnterpriseJavaBeans.SolicitacaoDeSalaBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if (session.getAttribute("loginUsuario") == null || session.getAttribute("senhaUsuario") == null || !session.getAttribute("tipoDeUsuario").equals("GerenteDeRecursos")) {
        out.println("<script>document.location.href='index.jsp';</script>");
    }
%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="assets/ico/favicon.png">

        <title>Gerenciador de Salas</title>

        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <link href="assets/css/font-awesome.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="assets/css/main.css" rel="stylesheet">


        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>

        <!-- Fixed navbar -->
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="#">HOME</a></li>
                        <li><a href="/MasterSala/Logout">LOGOUT</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>

        <div id="headerwrap">
            <div class="container">
                <div class="row centered">
                    <div class="col-lg-8 col-lg-offset-2">
                        <h1>Gerente de Recursos</h1>
                        <h2>MasterSala - UFF</h2>
                    </div>
                </div><!-- row -->
            </div><!-- container -->
        </div><!-- headerwrap -->


        <div class="container">
            <div class="row centered">

                <form action = /MasterSala/AutorizadorDeReserva method="post">

                    <h3> Autorizar Reserva:   </h3>                

                    <br> <br>

                    ID Reserva :  
                    <input type="number" name="id_reserva">

                    <br> <br>

                    <input type="submit" value ="Autorizar" class ="btn btn-info" >


                </form>


                <br><br>
                <h3> Solicitacoes não autorizadas</h3>
                <br><br>

                <%
                    out.println("<b>ID Reserva | Prof. | Sala | Data | Horario Inicio | Horario Fim | Status </b>");
                    out.println("<br><br>");
                    ArrayList<Reserva> reservas;
                    SolicitacaoDeSalaBean solicitacaoDeSalaBean = new SolicitacaoDeSalaBean();
                    reservas = solicitacaoDeSalaBean.listarReservasNaoAprovadas();
                    for (Reserva res : reservas) {
                        if (!res.isAprovada()) {
                            out.println(res.toString());
                            out.println("<br><br>");
                        }
                    }

                %>


                <br><br>
            </div>
        </div><!-- container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
    </body>
</html>
