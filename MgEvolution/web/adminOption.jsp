<%-- 
    Document   : adminOption
    Created on : 31-oct-2021, 21:14:40
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
        <!--Bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <!--SweetAlert-->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <!--CSS-->
        <link rel="stylesheet" href="assets/css/adminOption.css">
        <!--Icon and Name-->
        <link rel="shortcut icon" href="assets/images/LOGO_1_FINAL_PNG.png">
        <title><fmt:message key="indice" bundle="${text}"/></title>
        <c:if test="${!empty param.mensaje}">
            <script>
                alert("${param.mensaje}");
            </script>
        </c:if>
    </head>
    <body>
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
                            <a class="nav-link" id="close" href="#">
                                <fmt:message key="salir" bundle="${text}"/> <i class="fas fa-sign-out-alt"></i> </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <section class="container letraQuicksand">
            <c:if test="${stylist.admin}">
                <h2><fmt:message key="bienvenido" bundle="${text}"/> <c:out value="${stylist.name}"/></h2>
                <h5><fmt:message key="seleccioneOpcion" bundle="${text}"/></h5>
                <div class="d-flex justify-content-around row marginbottom">
                    <button type="button" class="btn btn-secondary col-sm margin10px btnsize" onclick="window.location.href = 'stylist/allStylist.jsp'">
                        <i class="fas fa-cut paddingRight"></i> <fmt:message key="estilistas" bundle="${text}"/></button>
                    <button type="button" class="btn btn-secondary col-sm margin10px btnsize" onclick="window.location.href = 'client/allClient.jsp'">
                        <i class="fas fa-users paddingRight"></i> <fmt:message key="clientes" bundle="${text}"/></button>
                    <button type="button" class="btn btn-secondary col-sm margin10px btnsize" onclick="window.location.href = 'product/allProduct.jsp'">
                        <i class="fas fa-info paddingRight"></i> <fmt:message key="productos" bundle="${text}"/></button>
                </div>

                <div class="d-flex justify-content-around row marginbottom">
                    <button type="button" class="btn btn-secondary col-sm margin10px btnsize" onclick="window.location.href = 'service/allService.jsp'">
                        <i class="far fa-calendar-alt paddingRight"></i> <fmt:message key="servicios" bundle="${text}"/></button>
                    <button type="button" class="btn btn-secondary col-sm margin10px btnsize" onclick="window.location.href = 'supplier/allSupplier.jsp'">
                        <i class="far fa-id-badge paddingRight"></i> <fmt:message key="proveedores" bundle="${text}"/></button>
                </div>

               
            </section>
        </c:if>
        <footer class="container-fluid text-center">
            <h5 class="tipoLetra1"><i class="fa fa-copyright"></i>MGEvolution</h5>
        </footer>


        <!--Bootstrap-->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
        <script>
                        //Busco por el id, lo guardo en un avariable y lo asocio al elemento "click"
                        var btnCerrar = document.getElementById("close");
                         btnCerrar.addEventListener("click", () => {
                        //Espera a que termine la promesa y nos redirige a login.jsp
                        let timerInterval
                        Swal.fire({
                        title: '¿Está seguro que desea cerrar sesión?',
                                icon: 'warning',
                                showCancelButton: true,
                                confirmButtonColor: '#3085d6',
                                cancelButtonColor: '#d33',
                                confirmButtonText: 'Salir'
                        }).then((result) => {
                        if (result.isConfirmed) {
                        
                                
                                Swal.fire({
                                title: 'Cerrando sesión',
                                        timer: 5000,
                                        timerProgressBar: true,
                                        didOpen: () => {
                                Swal.showLoading()
                                        const b = Swal.getHtmlContainer().querySelector('b')
                                        timerInterval = setInterval(() => {
                                        b.textContent = Swal.getTimerLeft()
                                        }, 600)
                                },
                                        willClose: () => {
                                clearInterval(timerInterval)
                                }
                                }).then((result) => {})
                                location.href = "index.jsp";
                        };
                        })
                        }
                        );


        </script>
    </body>
</html>