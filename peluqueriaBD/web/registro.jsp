<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
         <!--Metaetiqueta para el uso del conjunto de caracteres adecuado-->
        <meta charset="utf-8">
        <!--Metaetiqueta para corregir compatibilidad con navegador Microsft-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!--Metaetiqueta para la correcta visualización en dispositivos moviles-->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=0">
        <title>Visitas empresariales</title>

        <link rel="shortcut icon" href="img/VISITAS.ico">

        <!--Añada primero el estilo de la libreria (ufps.css o ufps.min.css) y luego sus estilos propios-->

        <link  rel="stylesheet" href="css/ufps.min.css">
        <link rel="stylesheet" href="lib/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/main2.css">
        <link rel="stylesheet" href="css/estilo_1.css">


        <script src="js/Jscript.js"></script>
        <script src="Jquery/jquery-1.6.3.min.js"></script>

    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Peluqueria PelosNecios</a>
                </div>
                <ul class="nav navbar-nav">
                    <!--Boton Inicio -->
                    <li class="active"><a href="index.jsp">Inicio</a></li>
                    <!--Boton Productos -->
                    <li><a href="productos.html">Productos</a></li>
                    <!--Boton Servicios -->
                    <li><a href="servicio.html">Servicios</a></li>
                    <!--Boton Citas -->
                    <li><a href="cita.html">Citas</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <a class="navbar">Ya tienes una cuenta?</a>
                    <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Ingresate</a></li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <div class="row" style="margin-left: 40%; margin-top: 50px;">
                  <form action="" id="" onSubmit="inscribirce();
                                    return false" >
                               
                                <h2 style="text-align: center; margin: 0px;"> INSCRIPCION</h2>
                                <br>
                                <input type="text" id="nombrecliente" name="nombrecliente" placeholder="Nombres">
                                <input type="text" id="apellidocliente" name="apellidocliente" placeholder="Apellidos">
                                <input type="text" id="telefono" name="telefono" placeholder="Telefono">
                                <input type="email" id="correo" name="correo" placeholder="Correo">
                                <input type="text" id="direccioncliente" name="direccioncliente" placeholder="Direccion">

                                <div style="display: none; color: red;" class="text-center" id="msj"></div>
                                <div style="display: none; color: red;" class="text-center" id="msj2"></div>
                                <br/>
                                <input type="submit" style="background-color: #7d7d7d; color: white;" value ="Aceptar">
                            </form>
            </div>
        </div>
        <div class="navbar  navbar-inverse navbar-fixed-bottom"> 
            <div class="container">
                <div class="navbar-text pull-left">
                    <p> © PelosNecios SA 2016.</p>
                </div>
            </div>
        </div>
        
          <!-- Scripts -->
        <script src="js/jquery.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
        <script src="lib/js/bootstrap.min.js"></script>
        <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
        <script src="js/main.js"></script>
        <script src="js/Iniciosesion.js"></script>
        <script src="js/AsistentesProcesar.js"></script>

    </body>
</html>
