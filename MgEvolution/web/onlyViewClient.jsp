<%-- 
    Document   : onlyViewClient
    Created on : 28-nov-2021, 0:04:47
    Author     : judith
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="hairdresser" class="models.Hairdresser"/>
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
        <!--SweetAlert-->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <!--Bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <!--CSS-->
        <link rel="stylesheet" href="assets/css/view.css">
        <!--Icon and Name-->
        <link rel="shortcut icon" href="assets/images/LOGO_1_FINAL_PNG.png">
        <title><fmt:message key="clientes" bundle="${text}"/></title>
    </head>
    <body onload="alertSwicht()">
        <header>
            <!--Encabezado con Logotipo y seguidamente de una barra de navegación que se convertirá en botón hamburguesa-->
            <nav class="navbar navbar-expand-lg navbar-light bg-dark container-fluid">
                <!--Imagenes del encabezado-->
                <div id="divEncabezado" class="navbar-brand">
                    <a href="#"><img id="logotipoEncabezado" class="navbar-brand" src="assets/images/LOGO_2.png" alt="Mg-Evolution Logo"></a>
                    <a href="#"><img id="logotipoEncabezado2" class="navbar-brand" src="assets/images/MGEvolution.png" alt="Mg-Evolution"></a>
                </div>
                <button id="btnHamburguesa" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon" id="icon"></span>
                </button>
                <!--Links del encabezado justificados a la derecha-->
                <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="client/allClient.jsp"><i class="fa fa-caret-square-o-left"></i> <fmt:message key="atras" bundle="${text}"/></a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <section class="container letraQuicksand">
            <h2><fmt:message key="proveedores" bundle="${text}"/></h2>
            <h5><fmt:message key="listaProveedores" bundle="${text}"/></h5>
           
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th scope="col"><fmt:message key="tableDNI" bundle="${text}"/></th>
                        <th scope="col"><fmt:message key="tableNombre" bundle="${text}"/></th>
                        <th scope="col"><fmt:message key="tableLastName" bundle="${text}"/></th>
                        <th scope="col"><fmt:message key="tableFechaNacimiento" bundle="${text}"/></th>
                        <th scope="col"><fmt:message key="tablePhone" bundle="${text}"/></th>
                        <th scope="col"><fmt:message key="tableCity" bundle="${text}"/></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="client" items="${hairdresser.getClientAlfabeticamente()}">
                        <tr>
                            <th scope="col">${client.DNI}</th>
                            <td>${client.name}</td>
                            <td>${client.lastName}</td>
                            <fmt:formatDate  value="${client.birthDate}" pattern="dd-MM-yyyy" var="fechaNac"/>
                            <td>${fechaNac}</td>
                            <td>${client.phone}</td>
                            <td>${client.city}</td>
                        </tr>
                    </c:forEach>
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
        <!-- <footer class="container-fluid text-center">
             <h5 class="tipoLetra1"><i class="fa fa-copyright"></i>MGEvolution</h5>
         </footer>-->


        <!--Bootstrap-->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
       <script>

        function alertSwicht() {
        <!--función que coge los parametros de la url y deoendiendo del numero aparecerá un mensaje u otro-->
        var queryString = window.location.search;
        var urlParams = new URLSearchParams(queryString);
        var optionSwitch = urlParams.get('option');
        console.log(optionSwitch);
        var action;
        
        switch (optionSwitch) {
                case '1': action = 'Cliente creado correctamente';
                break;
                case '2': action = 'Cliente modificado correctamente';
                console.log('Cliente modificado correctamente');
                break;
                case '3': action = 'Cliente eliminado correctamente';
                console.log('Cliente eliminado correctamente');
                break;
                default: action = 'Acción realizada con éxito';
                break;
        }
        
        sweetAlert(action);
        }
        
        function sweetAlert(action) {
                Swal.fire({
                position: 'top-start',
                icon:
                'success',
                title: action,
                showConfirmButton: false,
                timer: 1500
            })
            }
        </script>
    </body>
</html>