<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/ingreso.css">
    </head>
    <body>
        <!--Barra Top -->
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Peluqueria PelosNecios</a>
                </div>
                <ul class="nav navbar-nav">
                    <!--Boton Inicio -->
                    <li class="active"><a href="index.html">Inicio</a></li>
                    <!--Boton Productos -->
                    <li><a href="productos.html">Productos</a></li>
                    <!--Boton Servicios -->
                    <li><a href="servicio.html">Servicios</a></li>
                    <!--Boton Citas -->
                    <li><a href="cita.html">Citas</a></li>
                </ul>
                <!--Barra de Registro y Ingreso -->
                <ul class="nav navbar-nav navbar-right">
                    <!--Boton Registro -->
                    <li><a href="registro.jsp"><span class="glyphicon glyphicon-user"></span> Registrate</a></li>
                    <!--Boton Ingreso -->
                    <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Ingresate</a></li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="pr-wrap">
                        <div class="pass-reset">
                            <label>
                                Enter the email you signed up with</label>
                            <input type="email" placeholder="Email" />
                            <input type="submit" value="Submit" class="pass-reset-submit btn btn-success btn-sm" />
                        </div>
                    </div>
                    <div class="wrap">
                        <p class="form-title">
                            Inicia Sesión</p>
                          <form method="post" onsubmit="iniciarSesion();
                                return false"  >
                         <div style="display: none; color: red;" class="text-center" id="msjInicio"></div>
                            <input type="text" placeholder="User" id="usu" name="usu" required autofocus>
                            <input type="password" placeholder="Pass" id="pass" name="pass" required autofocus>

                            <input type="submit" value="Aceptare" id="boton" >
                        </form>
                    </div>
                </div>
            </div>
            <div class="posted-by">Posted By: <a href="http://www.jquery2dotnet.com">Bhaumik Patel</a></div>
        </div>
        <!--Barra del fondo -->
        <div class="navbar  navbar-inverse navbar-fixed-bottom"> 
            <div class="container">
                <div class="navbar-text pull-left">
                    <!--Texto del fondo -->
                    <p> © PelosNecios SA 2016.</p>
                </div>
            </div>
        </div>
        
          <!-- Scripts -->
        <script src="js/jquery.min.js"></script>
        <script src="js/Jscript.js"></script>
        <script src="lib/js/bootstrap.min.js"></script>

        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
        <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
        <script src="js/main.js"></script>
        <script src="js/procesarSesion.js"></script>
        
    </body>
</html>
