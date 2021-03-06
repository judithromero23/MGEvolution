<%-- 
    Document   : index
    Created on : 08-nov-2021, 20:14:54
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
    <!--Link Animate.css-->
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
    <link rel="stylesheet" href="assets/css/index.css">
    <!--Icon and name of website-->
    <link rel="shortcut icon" href="assets/images/LOGO_1_FINAL_PNG.png">
    <title>MG Evolution</title>
</head>
<body class="letraQuicksand">
<header>
    <!--Header with Logo followed by a navigation bar-->
    <nav class="navbar navbar-expand-lg navbar-light bg-dark container-fluid">
        <!--Image-->
        <div id="divEncabezado" class="navbar-brand">
        <a href="index.jsp"><img id="logotipoEncabezado" class="navbar-brand" src="assets/images/LOGO_2.png" alt="Mg-Evolution Logo"></a>
        <a href="index.jsp"><img id="logotipoEncabezado2" class="navbar-brand" src="assets/images/MGEvolution.png" alt="Mg-Evolution"></a>
        </div>
        <button id="btnHamburguesa" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon" id="icon"></span>
        </button>
        <!--Links-->
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="servicios.jsp"><fmt:message key="servicios" bundle="${text}"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" data-toggle="modal" data-target="#dondeEstamos"><fmt:message key="dondeEstamos" bundle="${text}"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="aboutUs.jsp"><fmt:message key="quienesSomos" bundle="${text}"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" data-toggle="modal" data-target="#contactanos"><fmt:message key="contactanos" bundle="${text}"/></a>
                </li>
                <!--Div divisor-->
                <div class="dropdown-divider"></div>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Admin</a>
                </li>
            </ul>
        </div>
    </nav>
</header>
<section>
    <!--Automatic image carousel with arrows-->
    <div id="carrucelImagenes" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="assets/images/p4_1.jpg" class="d-block imagenesc" alt="Tonos de cabello variado">
                <div class="carousel-caption d-none d-md-block">
                </div>
            </div>
            <div class="carousel-item">
                <img src="assets/images/p2_2_1.jpg" class="d-block imagenesc" alt="Tono del cabello cobre">
                <div class="carousel-caption d-none d-md-block">
                </div>
            </div>
            <div class="carousel-item">
                <img src="assets/images/p3.jpg" class="d-block imagenesc" alt="Pelos con ondas">
                <div class="carousel-caption d-none d-md-block">
                </div>
            </div>
            <div class="carousel-item">
                <img src="assets/images/p5.jpg" class="d-block imagenesc" alt="Corte Bob">
                <div class="carousel-caption d-none d-md-block">
                </div>
            </div>
        </div>
        <a class="carousel-control-prev bg-dark flechac" href="#carrucelImagenes" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        </a>
        <a class="carousel-control-next bg-dark flechac" href="#carrucelImagenes" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
        </a>
    </div>

    <!--Expert section with circles and icons-->
    <div class="container marginSeccion text-center" id="expertos">
        <h1 class="tipoLetra1"><fmt:message key="expertos" bundle="${text}"/></h1>
        <div class="row paddingInterno">
            <div class="col-md-3">
                <a href="servicios.jsp"><img src="assets/images/LogotipoCorte.jpg" alt="Ilustracion de corte y peinado" class="rounded-circle w-25"></a>
                <h3><fmt:message key="cortePeinado" bundle="${text}"/></h3>
                <p><fmt:message key="cortePeinadoText" bundle="${text}"/></p>
            </div>
            <div class="col-md-3">
                <a href="servicios.jsp"><img src="assets/images/ilustracionColormetria%20(2).png" alt="Ilustracion de colorimetria" class="rounded-circle w-25"></a>
                <h3><fmt:message key="colorimetria" bundle="${text}"/></h3>
                <p><fmt:message key="colorimetriaText" bundle="${text}"/></p>
            </div>
            <div class="col-md-3">
                <a href="servicios.jsp"><img src="assets/images/cuticulacapilar.jpg" alt="Ilustracion de Diagnostico capilar" class="rounded-circle w-25"></a>
                <h3><fmt:message key="diagnostico" bundle="${text}"/></h3>
                <p><fmt:message key="diagnosticoText" bundle="${text}"/></p>
            </div>
            <div class="col-md-3">
                <a href="servicios.jsp"><img src="assets/images/Icono%20cabello.png" alt="Ilustracion de cabello" class="rounded-circle w-25"></a>
                <h3><fmt:message key="cuidadoCabello" bundle="${text}"/></h3>
                <p><fmt:message key="cuidadoCabelloText" bundle="${text}"/></p>
            </div>
        </div>
    </div>

    <!--Who we are section with text and lateral image-->
    <div class="container-fluid marginSeccion paddingBottom" id="quienesSomos">
        <div class="row justify-content-center paddingInterno">
            <div class="col-md-6">
                <h3 class="text-center tipoLetra1"><fmt:message key="quienesSomos" bundle="${text}"/></h3><br>
                <p class="text-justify"><fmt:message key="quienesSomosText" bundle="${text}"/><br>
                <a href="quienesSomos.jsp" id="conocerMas">Conocer m&aacute;s...</a>
            </div>
            <div class="col-md-4 text-right">
                <img src="assets/images/modelo1.jpg" alt="Modelo peluquera" class="rounded-right w-100">
            </div>
        </div>
    </div>

    <!--Carrucel of brands we work with-->
    <div id="carrucelMarcas" class="carousel slide" data-ride="carousel">
        <h1 class="tipoLetra1 text-center paddingBottom"><fmt:message key="marcasTrabajamos" bundle="${text}"/></h1>
        <div class="carousel-inner">
            <div class="carousel-item active text-center">
                <img src="assets/images/m1_1.svg" alt="Logotipo Eva Profesional" class="d-inline marginRight width15" id="marcaEva">
                <img src="assets/images/m2.png" alt="Logotipo GHD" class="d-inline width15" id="marcaGHD">
                <div class="carousel-caption d-none d-md-block"></div>
            </div>
            <div class="carousel-item text-center">
                <img src="assets/images/m3.png" alt="Logotipo Indola" class="d-inline marginRight width15" id="marcaIndola">
                <img src="assets/images/m5_5.png" alt="Logotipo bbcos" class="d-inline width15" id="marcaBbcos">
                <div class="carousel-caption d-none d-md-block"></div>
            </div>
            <div class="carousel-item text-center">
                <img src="assets/images/m4.png" alt="Logotipo Salerm" class="d-inline marginRight width15" id="marcaSalerm">
                <img src="assets/images/m8.png" alt="Logotipo Wella" class="d-inline width15" id="marcaWella">
                <div class="carousel-caption d-none d-md-block"></div>
            </div>
            <div class="carousel-item text-center">
                <img src="assets/images/m7.png" alt="Logotipo Sweet Profesional" class="d-inline marginRight width15" id="marcaSweet">
                <img src="assets/images/m6.jpg" alt="Logotipo Termix Profesional" class="d-inline width15" id="marcaTermix">
                <div class="carousel-caption d-none d-md-block"></div>
            </div>
        </div>
        <!--Flechas-->
        <a class="carousel-control-prev flechac" href="#carrucelMarcas" role="button" data-slide="prev">
            <i class="fa fa-arrow-left flechaMarcas"></i>
        </a>
        <a class="carousel-control-next flechac" href="#carrucelMarcas" role="button" data-slide="next">
            <i class="fa fa-arrow-right flechaMarcas"></i>
        </a>
    </div>

</section>
<footer>
    <div class="container-fluid text-center">
        <h5 class="tipoLetra1"><fmt:message key="contactanos" bundle="${text}"/></h5>
        <div class="dropdown-divider"></div>
        <p><i class="far fa-envelope"></i> Noliguillen50@gmail.com</p>
        <p><i class="fab fa-instagram"></i> Manoli.guillen39</p>
        <p><i class="fab fa-facebook"></i> MG Evolution</p>
    </div>
</footer>

<!--Modal Windows-->
<!--Where we are?-->
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
<!--Contact us-->
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
                <a id="instagram" href="https://www.instagram.com/mgevolution_/?hl=es" target="_blank"><img src="assets/images/instagram.png" alt="instagram" class="modalRedes" id="imgInstagram">Mgevolution_</a><br>
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
</body>
</html>