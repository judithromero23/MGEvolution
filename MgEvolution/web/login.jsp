<%-- 
    Document   : index
    Created on : 30-oct-2021, 16:35:42
    Author     : judith
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setBundle basename="bundles.text" var="text"/>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <!--Font Awesome-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <!--Link a GoogleFont-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Crimson+Pro:wght@200&family=Lexend+Mega&family=Quicksand:wght@500&display=swap" rel="stylesheet">
    <!--Link Bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <!--Link a mi propio CSS-->
    <link rel="stylesheet" href="assets/css/login.css">
    <!--Icono y nombre del sitio Web-->
    <link rel="shortcut icon" href="assets/images/LOGO_1_FINAL_PNG.png">
    <title><fmt:message key="accesoAdmin" bundle="${text}"/></title>
</head>
<body class="letraQuicksand">
<header>
    <!--Encabezado con Logotipo y seguidamente de una barra de navegación que se convertirá en botón hamburguesa-->
    <nav class="navbar navbar-expand-lg navbar-light bg-dark container-fluid">
        <!--Imagenes del encabezado-->
        <div id="divEncabezado" class="navbar-brand">
            <a href="index.jsp"><img id="logotipoEncabezado" class="navbar-brand" src="assets/images/LOGO_2.png" alt="Mg-Evolution Logo"></a>
            <a href="index.jsp"><img id="logotipoEncabezado2" class="navbar-brand" src="assets/images/MGEvolution.png" alt="Mg-Evolution"></a>
        </div>
        <button id="btnHamburguesa" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon" id="icon"></span>
        </button>
        <!--Links del encabezado justificados a la derecha-->
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp"><i class="fa fa-caret-square-o-left"></i> <fmt:message key="atras" bundle="${text}"/></a>
                </li>
            </ul>
        </div>
    </nav>
</header>
<section class="marginbottom">
    <div id="formulario">
    <h1 class="text-center tipoLetra1 marginbottom"><fmt:message key="acessoAdmin" bundle="${text}"/></h1>
    <div class="container">
        <form action="login" method="post">
            <div class="form-group">
                <label for="login"><fmt:message key="inputName" bundle="${text}"/></label>
                <input type="text" name="login" class="form-control" id="login" placeholder="Escriba su nombre..." required>
            </div>
            <div class="form-group">
                <label for="password"><fmt:message key="inputPass" bundle="${text}"/></label>
                <input type="password" name="password" class="form-control" id="password" placeholder="Escriba su contraseña..."  required>
            </div>
            <br>
            </div>
            <input type="submit" value="Iniciar Sesión" id="btnCrearCuenta" class="btn btn-primary">
        </form>
    </div>
    </div>
</section>
    <c:if test="${!empty error}">
            <br>
            <div class="error">
                ${error}
            </div>
        </c:if>
<footer class="container-fluid text-center">
    <h5 class="tipoLetra1"><i class="fa fa-copyright"></i>MGEvolution</h5>
</footer>

<!--Link de Bootstrap-->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
</body>
</html>
