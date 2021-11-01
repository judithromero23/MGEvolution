<%-- 
    Document   : allStylist
    Created on : 01-nov-2021, 20:19:10
    Author     : judith
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="hairdresser" class="models.Hairdresser"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Estilistas</title>
    </head>
    <body>
        <header>
            <!--Encabezado con Logotipo y seguidamente de una barra de navegación que se convertirá en botón hamburguesa-->
            <nav class="navbar navbar-expand-lg navbar-light bg-dark container-fluid">
                <!--Imagenes del encabezado-->
                <div id="divEncabezado" class="navbar-brand">
                    <a href="index.html"><img id="logotipoEncabezado" class="navbar-brand" src="../assets/images/LOGO_2.png" alt="Mg-Evolution Logo"></a>
                    <a href="index.html"><img id="logotipoEncabezado2" class="navbar-brand" src="../assets/images/MGEvolution.png" alt="Mg-Evolution"></a>
                </div>
                <button id="btnHamburguesa" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon" id="icon"></span>
                </button>
                <!--Links del encabezado justificados a la derecha-->
                <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="../adminOption.jsp"><i class="fa fa-caret-square-o-left"></i> Atr&aacute;s</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <section class="container letraQuicksand">
            <h2>Estilistas</h2>
            <h5>Lista de todos los estilistas contratados.</h5>
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Usuario</th>
                        <th scope="col">Correo</th>
                        <th scope="col">Especialidad/es</th>
                        <th scope="col">Salario</th>
                        <th scope="col">¿Es Admin?</th>
                        <th scope="col">Modificar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="stylist" items="${hairdresser.stylist}">
                        <tr>
                            <th scope="row">${stylist.id}</th>
                            <td>${stylist.name}</td>
                            <td>${stylist.login}</td>
                            <td>${stylist.email}</td>
                            <td>${stylist.area}</td>
                            <td>${stylist.salary}</td>
                            <td>${stylist.admin}</td>
                            <td><button type="button" class="btn btn-warning">Editar</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <c:if test="${not empty error}">
                <br>
                <div class="error">
                    ${error}
                </div>
            </c:if>
        </section>
        <footer class="container-fluid text-center">
            <h5 class="tipoLetra1"><i class="fa fa-copyright"></i>MGEvolution</h5>
        </footer>


        <!--Bootstrap-->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

    </body>
</html>