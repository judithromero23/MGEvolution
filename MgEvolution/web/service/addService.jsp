<%-- 
    Document   : addService
    Created on : 30-nov-2021, 19:15:52
    Author     : judith
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.*"%>
<%@page import="models.Conexion"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<fmt:setBundle basename="bundles.text" var="text"/>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <!--Font Awesome-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <!--GoogleFont-->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Crimson+Pro:wght@200&family=Lexend+Mega&family=Quicksand:wght@500&display=swap" rel="stylesheet">
        <!--Bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <!--CSS-->
        <link rel="stylesheet" href="../assets/css/add.css">
        <!--Icon and Name-->
        <link rel="shortcut icon" href="../assets/images/LOGO_1_FINAL_PNG.png">
        <title><fmt:message key="servicios" bundle="${text}"/></title>
        <script>
            function deleteService() {
                return confirm('¿Está seguro que desea eliminar el servicio?');
            }

        </script>
    </head>
    <body>
        <header>
            <!--Encabezado con Logotipo y seguidamente de una barra de navegación que se convertirá en botón hamburguesa-->
            <nav class="navbar navbar-expand-lg navbar-light bg-dark container-fluid">
                <!--Imagenes del encabezado-->
                <div id="divEncabezado" class="navbar-brand">
                    <a href="#"><img id="logotipoEncabezado" class="navbar-brand" src="../assets/images/LOGO_2.png" alt="Mg-Evolution Logo"></a>
                    <a href="#"><img id="logotipoEncabezado2" class="navbar-brand" src="../assets/images/MGEvolution.png" alt="Mg-Evolution"></a>
                </div>
                <button id="btnHamburguesa" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon" id="icon"></span>
                </button>
                <!--Links del encabezado justificados a la derecha-->
                <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="../adminOption.jsp"><i class="fa fa-caret-square-o-left"></i> <fmt:message key="atras" bundle="${text}"/></a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <section class="container letraQuicksand">
            <h2><fmt:message key="servicios" bundle="${text}"/></h2>
            <h5><fmt:message key="listaServicios" bundle="${text}"/></h5>
            <%
                Statement smtStylist;
                ResultSet rsStylist = null;

                Statement smtClient;
                ResultSet rsClient = null;
                try {
                    Conexion conStylist = new Conexion();
                    Conexion conClient = new Conexion();

                    smtStylist = conStylist.getConnection().createStatement();

                    rsStylist = smtStylist.executeQuery("SELECT stylist.* FROM stylist");

                    smtClient = conClient.getConnection().createStatement();

                    rsClient = smtClient.executeQuery("SELECT client.* FROM client");

                } catch (java.sql.SQLException sqle) {
                    System.out.println("Error: " + sqle);
                    throw (sqle);
                }
            %>
            <form action="../addService" method="POST">

                <label for="date"><fmt:message key="inputDate" bundle="${text}"/></label>
                <input type="datetime-local" id="date" value="2018-06-12T19:30" name="date" required max="2018-06-14T00:00">
                <br>
                <label for="stylist"><fmt:message key="inputStylist" bundle="${text}"/></label>
                <label for="stylist"><fmt:message key="inputStylist" bundle="${text}"/></label>
                <select id="stylist" name="stylist" required>
                    <%   while (rsStylist.next()) {%>
                    <option value=<%= rsStylist.getLong("stylist.ID")%>><%= rsStylist.getString("stylist.NAME")%></option>  
                    <%  }%>
                </select>
                <br>
                <label for="client"><fmt:message key="inputClient" bundle="${text}"/></label>
                <select id="client" name="client" required>
                    <%   while (rsClient.next()) {%>
                    <option value=<%= rsClient.getString("client.DNI")%>><%= rsClient.getString("client.NAME")%></option>  
                    <%  }%>
                </select>
                <br>
                <br>
                <input type="submit" value="Crear Servicio" class="btn btn-success">
                <br>
            </form>

            <br>
            <c:if test="${not empty error}">
                <br>
                <div class="error alert alert-warning">
                    ${error}
                </div>
            </c:if>
        </section>
        <%-- <footer class="container-fluid text-center">
             <h5 class="tipoLetra1"><i class="fa fa-copyright"></i>MGEvolution</h5>
         </footer>--%>


        <!--Bootstrap-->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

    </body>
</html>