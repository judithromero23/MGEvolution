<%-- 
    Document   : allService
    Created on : 28-nov-2021, 18:14:57
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
        <link rel="stylesheet" href="../assets/css/tables.css">
        <!--Icon and Name-->
        <link rel="shortcut icon" href="../assets/images/LOGO_1_FINAL_PNG.png">
        <title><fmt:message key="servicios" bundle="${text}"/></title>
        <script>
            function deleteService() {
                return confirm('¿Está seguro que desea eliminar el servicio?');
            }
            function recargar() {
                location.reload();
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
            <button type="button" class="btn btn-success" id="addButton" onclick="window.location.href = 'addService.jsp'"><fmt:message key="nuevoServicio" bundle="${text}"/></button>
            <form id="formBuscar">
                <input id="inputBuscar" name="inputSearch" type="search" placeholder="Buscar...">
                <i class="fa fa-search"></i>
            </form>
            <%
                
                Statement smt;
                ResultSet rs = null;
                String inputSearch = request.getParameter("inputSearch");

                try {
                    Conexion con = new Conexion();
                    smt = con.getConnection().createStatement();
                    if (inputSearch != null) {

                        rs = smt.executeQuery("SELECT service.*, stylist.*, client.* FROM service "
                                + "INNER JOIN stylist ON service.STYLIST_ID=stylist.ID INNER JOIN client ON "
                                + "service.CLIENT_DNI=client.DNI WHERE(service.STYLIST_ID = '" + inputSearch + "') OR "
                                + "(service.CLIENT_DNI LIKE '" + inputSearch + "%')OR (service.ID='" + inputSearch + "') "
                                + "OR (client.NAME LIKE '" + inputSearch + "%') OR (stylist.NAME LIKE '" + inputSearch + "%') OR (service.DATE='" + inputSearch + "') "
                                + "ORDER BY `DATE` DESC");
                    } else {
                        rs = smt.executeQuery("SELECT service.*, stylist.*, client.* FROM service INNER "
                                + "JOIN stylist ON service.STYLIST_ID=stylist.ID INNER JOIN client ON "
                                + "service.CLIENT_DNI=client.DNI ORDER BY `DATE` DESC");
                    }
                } catch (java.sql.SQLException sqle) {
                    System.out.println("Error: " + sqle);
                    throw (sqle);
                }

            %>
            <table class="table table-hover">
                <thead class="thead-light">
                    <tr>
                        <th scope="col"><fmt:message key="tableDateService" bundle="${text}"/></th>
                        <th scope="col"><fmt:message key="tableStylist" bundle="${text}"/></th>
                        <th scope="col"><fmt:message key="tableDNI" bundle="${text}"/></th>
                        <th scope="col"><fmt:message key="tableClient" bundle="${text}"/></th>
                        <th scope="col"></th>

                    </tr>
                </thead>
                <tbody>
                    <%   while (rs.next()) {%>
                    <tr>
                        <%--  <fmt:formatDate type = "both" dateStyle = "medium" var="date" timeStyle = "medium" value = "<%= rs.getDate("DATE")%>" />--%>
                        <th scope="col"><%= rs.getString("DATE")%></th>
                        <td><%= rs.getString("STYLIST.NAME")%></td>
                        <td><%= rs.getString("DNI")%></td>
                        <td><%= rs.getString("CLIENT.NAME")%></td>
                        <td>
                            <form action="../detailService/allDetail.jsp" method="POST" style="margin-bottom: 3px">
                                <input type="hidden"  name="idService" value=<%= rs.getLong("SERVICE.ID")%>>
                                <input type="hidden" name="nameClient" value=<%= rs.getString("CLIENT.NAME")%>>
                                <input type="submit" value="Detalles" class="btn btn-secondary" onclick="return recargar()">
                            </form>

                            <form action="../editService" method="POST">
                                <input type="hidden"  name="idService" value=<%= rs.getLong("SERVICE.ID")%>>
                                <input type="submit" name="eliminar" value="Eliminar" class="borrar btn btn-danger" onclick="return deleteService()"/>
                            </form>
                        </td>
                    </tr>
                    <%  }%>
                </tbody>
            </table>
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