<%-- 
    Document   : editStylist
    Created on : 06-nov-2021, 23:09:37
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
        <!--GoogleFont-->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Crimson+Pro:wght@200&family=Lexend+Mega&family=Quicksand:wght@500&display=swap" rel="stylesheet">
        <!--SweetAlert-->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <!--Bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <!--CSS-->
        <link rel="stylesheet" href="../assets/css/add.css">
        <!--Icon and Name-->
        <link rel="shortcut icon" href="assets/images/LOGO_1_FINAL_PNG.png">
        <title><fmt:message key="estilistas" bundle="${text}"/></title>
        <script>
            function deleteStylist() {
                return confirm('¿Está seguro que desea eliminar al estilista?');
            }
            function actualizar() {
                return confirm('Estilista actualizad@');
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
                <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="allStylist.jsp"><i class="fa fa-caret-square-o-left"></i> <fmt:message key="atras" bundle="${text}"/></a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <section class="container letraQuicksand">
            <h2><fmt:message key="editarEstilista" bundle="${text}"/><c:out value="${id}"/></h2>
            <h5><fmt:message key="completarEditStylist" bundle="${text}"/></h5>
            
            <form action="../editStylist" method="POST">
                
                <input type="hidden" name="id" id="id" value="${id}">
                <label for="name">Nombre:</label>
                <input type="text" name="name" id="name" maxlength="35" value="${name}">
                <br>
                <label for="login">Usuario:</label>
                <input type="text" name="login" id="login" maxlength="35" value="${login}" disabled="true">
                <br>
                <label for="password">Contraseña</label>
                <input type="password" name="password" id="password" maxlength="40" value="${password}">
                <br>
                <label for="email">Correo:</label>
                <input type="email" name="email" id="email" maxlength="50" value="${correo}">
                <br>
                <label for="area">Especialidad:</label>
                <input type="text" name="area" id="area" maxlength="35" value="${area}">
                <br>
                <label for="salary">Sueldo:</label>
                <input type="number" name="salary" id="salary" value="${salary}">
                <br>
                <label for="admin">Administrador</label>
                <input type="checkbox" name="admin" id="admin" value="true" ${checked} style="left: 15rem">

                <input type="submit" name="actualizar" value="Actualizar" class="btn btn-success" onclick="return actualizar()">
                <input type="submit" name="eliminar" value="Eliminar" class="borrar btn btn-danger" onclick="return deleteStylist()"/>
                <br>
            </form>
        </section>
        <c:if test="${not empty error}">
            <br>
            <div class="error alert alert-warning">
                ${error}
            </div>
        </c:if>
        <footer class="container-fluid text-center">
            <h5 class="tipoLetra1"><i class="fa fa-copyright"></i>MGEvolution</h5>
        </footer>


        <!--Bootstrap-->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

    </body>
</html>