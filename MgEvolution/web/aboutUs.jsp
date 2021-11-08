<%-- 
    Document   : aboutUs
    Created on : 08-nov-2021, 20:16:20
    Author     : judith
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setBundle basename="bundles.text" var="text"/>

<!DOCTYPE html>
<html lang="es">
<head>
    <!--Most important tags-->
    <meta charset="UTF-8">
    <meta name="description" content="Aplicación web de MG Evolution."/>
    <meta name="keywords" content="MGEvolution, peluqueria"/>
    <meta name="author" content="Judith Romero" />
    <meta name="copyright" content="MGEVOLUTION" />
    <meta name="robots" content="index"/>
    <!--Animate.css-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <!--Sweet Alert-->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <!--Font Awesome-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
    <!--Link GoogleFont-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Crimson+Pro:wght@200&family=Lexend+Mega&family=Quicksand:wght@500&display=swap" rel="stylesheet">
    <!--Link Bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <!--Link CSS-->
    <link rel="stylesheet" href="assets/css/aboutUs.css">
    <!--Icon and name of website-->
    <link rel="shortcut icon" href="assets/images/LOGO_1_FINAL_PNG.png">
    <title>MG Evolution</title>
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
                    <a class="nav-link" href="servicios.jsp"><fmt:message key="servicios" bundle="${text}"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" data-toggle="modal" data-target="#dondeEstamos"><fmt:message key="dondeEstamos" bundle="${text}"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" data-toggle="modal" data-target="#contactanos"><fmt:message key="contactanos" bundle="${text}"/></a>
                </li>
                <!--Div divisor-->
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Admin</a>
                </li>
            </ul>
        </div>
    </nav>
</header>
<!--Migas de pan-->
<nav aria-label="breadcrumb" id="migas">
    <div id="subir"></div>
    <ol class="breadcrumb">
        <li class="breadcrumb-item active" aria-current="page"><a href="index.jsp" class="aGris">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page"><a href="quienesSomos.jsp" class="aGris"><fmt:message key="quienesSomos" bundle="${text}"/></a></li>
    </ol>
</nav>
<section class="container">
    <h1 class="textCenter"><fmt:message key="quienesSomos" bundle="${text}"/></h1>
    <div class="row marginSeccion">
    <div id="list-example" class="list-group col-md-3 marginbottom">
        <a class="list-group-item list-group-item-action" href="#list-item-1"><fmt:message key="introduccion" bundle="${text}"/></a>
        <a class="list-group-item list-group-item-action" href="#list-item-2"><fmt:message key="primerosPasos" bundle="${text}"/></a>
        <a class="list-group-item list-group-item-action" href="#list-item-3"><fmt:message key="comienzos" bundle="${text}"/></a>
        <a class="list-group-item list-group-item-action" href="#list-item-4"><fmt:message key="actualidad" bundle="${text}"/></a>
    </div>
    <div data-target="#list-example" data-offset="0" class="col-md-6">
        <div id="list-item-1"></div>
        <div class="borderDiv">
            <h4><fmt:message key="introduccion" bundle="${text}"/></h4>
            <p><fmt:message key="introduccionText" bundle="${text}"/></p>
        </div>
        <div id="list-item-2" class="marginbottom"></div>
        <div class="borderDiv marginSeccion">
        <h4><fmt:message key="primerosPasos" bundle="${text}"/></h4>
        <p><fmt:message key="primerosPasosText" bundle="${text}"/></p>
        </div>
        <div id="list-item-3" class="marginbottom"></div>
        <div class="borderDiv marginSeccion">
        <h4><fmt:message key="comienzos" bundle="${text}"/></h4>
        <p><fmt:message key="comienzosText1" bundle="${text}"/></p>
        <p><fmt:message key="comienzosText2" bundle="${text}"/></p>
        <p><fmt:message key="comienzosText3" bundle="${text}"/></p>
        </div>
        <div id="list-item-4" class="marginbottom"></div>
        <div class="borderDiv marginSeccion">
        <h4><fmt:message key="actualidad" bundle="${text}"/></h4>
        <p><fmt:message key="actualidadText1" bundle="${text}"/></p>
        <p><fmt:message key="actualidadText2" bundle="${text}"/></p>
        </div>
        <div class="textCenter marginSeccion">
            <a href="#subir" class="aGris"><fmt:message key="volverArriba" bundle="${text}"/></a>
        </div>
    </div>
    <div class="col-md-3">
        <img src="assets/images/modelo1.jpg" alt="Modelo peluquera" class="rounded-right w-100">
    </div>
    </div>
</section>
<footer class="container-fluid text-center marginSeccion">
    <h5 class="tipoLetra1"><i class="fa fa-copyright"></i>MGEvolution</h5>
</footer>


<!--Ventanas Modales-->
<!--¿Donde estamos?-->
<div class="modal fade" id="dondeEstamos" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="nombrePestaña" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="nombrePestaña"><i class="fas fa-map-marked-alt"></i> <fmt:message key="dondeEstamos" bundle="${text}"/></h5>
                <button type="button" class="close btnCerrar" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true"><i class="fas fa-times"></i></span>
                </button>
            </div>
            <div class="modal-body">
                <p class="text-center"><fmt:message key="calle" bundle="${text}"/> Dr. Mara&ntilde;on, Guillena (Sevilla)</p>
                <div id="wrapper-9cd199b9cc5410cd3b1ad21cab2e54d3">
                    <div id="map-9cd199b9cc5410cd3b1ad21cab2e54d3"></div>
                    <script>(function () {
                        var setting = {"height":260,"width":578,"zoom":19,"queryString":"MG-Evolution, Calle Doctor Marañón, Guillena, Sevilla, España","place_id":"ChIJgdraE5FAEg0Rd9RonkFwNwo","satellite":false,"centerCoord":[37.54037208418712,-6.053448913483632],"cid":"0xa3770419e68d477","lang":"es","cityUrl":"/spain/seville","cityAnchorText":"Mapa de Sevilla, Andalucía, España","id":"map-9cd199b9cc5410cd3b1ad21cab2e54d3","embed_id":"385166"};
                        var d = document;
                        var s = d.createElement('script');
                        s.src = 'https://1map.com/js/script-for-user.js?embed_id=385166';
                        s.async = true;
                        s.onload = function (e) {
                            window.OneMap.initMap(setting)
                        };
                        var to = d.getElementsByTagName('script')[0];
                        to.parentNode.insertBefore(s, to);
                    })();
                    </script>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">Aceptar</button>
            </div>
        </div>
    </div>
</div>
<!--Contáctanos-->
<div class="modal fade" id="contactanos" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="nombrePestaña1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="nombrePestaña1"><i class="fas fa-address-book"></i> <fmt:message key="contactanos" bundle="${text}"/></h5>
                <button type="button" class="close btnCerrar" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true"><i class="fas fa-times"></i></span>
                </button>
            </div>
            <div class="modal-body m-auto" id="redesSociales">
                <a id="correo" href="https://www.gmail.com/" target="_blank"><img src="assets/images/correo.png" alt="correo" id="imgCorreo">Noliguillen50@gmail.com</a><br>
                <a id="instagram" href="https://www.instagram.com/manoli.guillen.39/?hl=es" target="_blank"><img src="assets/images/instagram.png" alt="instagram" class="modalRedes" id="imgInstagram">Manoli.guillen.39</a><br>
                <a id="facebook" href="https://www.facebook.com/NoliGuillen" target="_blank"><img src="assets/images/facebook.png" alt="facebook" class="modalRedes" id="imgFacebook">MG Evolution</a><br>
                <a id="movil" href="https://web.whatsapp.com/" target="_blank"><img src="assets/images/movil.png" alt="whatsApp" class="modalRedes" id="imgMovil">650 98 69 15</a><br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">Aceptar</button>
            </div>
        </div>
    </div>
</div>



<!--Bootstrap-->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<!--JS-->
<script src="assets/js/index.js"></script>
</body>
</html>
