<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
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
                    <li><a href="Ingresar.jsp"><span class="glyphicon glyphicon-log-in"></span> Ingresate</a></li>
                </ul>
            </div>
        </nav>
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
                <li data-target="#myCarousel" data-slide-to="3"></li>
            </ol>
            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">

                <div class="item active">
                    <img src="https://static.miweb.paginasamarillas.es/var/m_a/ac/ac4/3247/49373-peluqueria-enredos-banner.jpg" alt="Chania" width="100%" height="100%">
                    <div class="carousel-caption">
                        <h3>Pelos Necios</h3>
                        <p>Te ofrece los mejores servicios y atención.</p>
                    </div>
                </div>

                <div class="item">
                    <img src="http://files.topbeautysalon.net/200000170-a9994aa94a/peluqueria%20barcelona%20primera%20visita%20est%C3%A9tica%20y%20peluqueria.jpg" alt="Chania" width="100%" height="100%">
                    <div class="carousel-caption">
                        <h3>Chania</h3>
                        <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
                    </div>
                </div>
                <div class="item">
                    <img src="http://www.hombreactual.com/webpac_content/cosmetica-y-moda-para-hombres/ajax/slides-cabecera-servicios/cabecera-2/images/object/Cabecera_Marzo_2013_02.jpg" alt="Chania" width="100%" height="100%">
                    <div class="carousel-caption">
                        <h3>Chania</h3>
                        <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
                    </div>
                </div>
                <div class="item">
                    <img src="http://www.peluqueriaeldorado.co/img/peluqueria.png" alt="Chania" width="100%" height="100%">
                    <div class="carousel-caption">
                        <h3>Chania</h3>
                        <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
                    </div>
                </div>
            </div>
            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </body>
</html>
