<%-- 
    Document   : editClient
    Created on : 27-nov-2021, 22:57:09
    Author     : judith
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<fmt:setBundle basename="bundles.text" var="text"/>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <!--Font Awesome-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <!--GoogleFont-->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Crimson+Pro:wght@200&family=Lexend+Mega&family=Quicksand:wght@500&display=swap" rel="stylesheet">
        <!--SweetAlert-->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <!--Bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <!--CSS-->
        <link rel="stylesheet" href="../assets/css/edit.css">
        <!--Icon and Name-->
        <link rel="shortcut icon" href="../assets/images/LOGO_1_FINAL_PNG.png">
        <title><fmt:message key="clientes" bundle="${text}"/></title>
        <script>
            function deleteStylist() {
                return confirm('?Est? seguro que desea eliminar a el cliente?');
            }
            function actualizar() {
                return confirm('Cliente actualizado');
            }
        </script>
    </head>
    <body>
        <header>
            <!--Encabezado con Logotipo y seguidamente de una barra de navegaci?n que se convertir? en bot?n hamburguesa-->
            <nav class="navbar navbar-expand-lg navbar-light bg-dark container-fluid">
                <!--Imagenes del encabezado-->
                <div id="divEncabezado" class="navbar-brand">
                    <a href="#"><img id="logotipoEncabezado" class="navbar-brand" src="../assets/images/LOGO_2.png" alt="Mg-Evolution Logo"></a>
                    <a href="#"><img id="logotipoEncabezado2" class="navbar-brand" src="../assets/images/MGEvolution.png" alt="Mg-Evolution"></a>
                </div>
                <button id="btnHamburguesa" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon" id="icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="allClient.jsp"><i class="fa fa-caret-square-o-left"></i> <fmt:message key="atras" bundle="${text}"/></a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <section class="container letraQuicksand">
            <h2><fmt:message key="editarCliente" bundle="${text}"/></h2>
            <h5><fmt:message key="completarEditClient" bundle="${text}"/> <strong><%out.print(request.getParameter("dni"));%></strong> </h5>

            <form action="../editClient" method="POST" id="form">
                <input type="hidden" name="dni" id="dni" value=<%out.print(request.getParameter("dni"));%>>
                <label for="name"><fmt:message key="inputName" bundle="${text}"/></label>
                <input type="text" name="name" id="name" maxlength="35" required value=<%out.print(request.getParameter("name"));%>>
                <br>
                <label for="lastName"><fmt:message key="inputLastName" bundle="${text}"/></label>
                <input type="text" name="lastName" id="lastName" maxlength="35" required value=<%out.print(request.getParameter("lastName"));%>>
                <br>
                <label for="bithDate"><fmt:message key="inputFechaNacimiento" bundle="${text}"/></label>
                <input type="date" name="bithDate" id="bithDate" required value=<%out.print(request.getParameter("bithDate"));%>>
                <br>
                <label for="phone"><fmt:message key="inputPhone" bundle="${text}"/></label>
                <input type="number" name="phone" id="phone"  required value=<%out.print(request.getParameter("phone"));%>>
                <br>
                <label for="city"><fmt:message key="inputCity" bundle="${text}"/></label>
                <input type="text" name="city" id="city"  required value=<%out.print(request.getParameter("city"));%>>
                <br>
                <div class="buttonsLeft">
                <input type="submit" name="actualizar" value="Actualizar" class="btn btn-success" onclick="return actualizar()">
                <input type="submit" name="eliminar" value="Eliminar" class="borrar btn btn-danger" onclick="return deleteStylist()"/>
                </div>
                <br>
            </form>
        </section>
        <c:if test="${not empty error}">
            <br>
            <div class="error alert alert-warning">
                ${error}
            </div>
        </c:if>
        <%--<footer class="container-fluid text-center">
            <h5 class="tipoLetra1"><i class="fa fa-copyright"></i>MGEvolution</h5>
        </footer>--%>


        <!--Bootstrap-->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

    </body>
</html>