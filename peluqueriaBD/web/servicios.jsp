<%@page import="DTO.ServicioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servlets.servicioServlet"%>
<%@page import="servlets.productoServlet"%>
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
                    <li ><a href="index.jsp">Inicio</a></li>
                    <!--Boton Productos -->
                    <li><a href="productos.jsp">Productos</a></li>
                    <!--Boton Servicios -->
                    <li class="active"><a href="servicios.jsp">Servicios</a></li>
                    <!--Boton Citas -->
                    <li><a href="citas.jsp">Citas</a></li>
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


        <%
            servicioServlet con = new servicioServlet();
            ArrayList<ServicioDTO> s = new ArrayList<ServicioDTO>();
            s = con.listarServicios(request);
        %>



        <div class="container">
            <div class="row text-center"><br>
                <%           if (s != null && !s.isEmpty()) {
                        int contador = 0;
                        for (ServicioDTO ser : s) {
                            contador++;
                            ser.toString();
                            if (contador <= 10) {
                %>


                <div class="col-md-4 col-sm-4">
                    <img src="https://www.lastermasderuham.com/wp-content/uploads/peluqueria-basicos-corte.jpg" alt="" class="img-circle img-thumbnail" width="150" height="150">
                    <h3><%=ser.getNombre()%></h3>
                    <p><%=ser.getDescripcion()%></p>
                </div>

                <%
                        }
                    }
                } else {
                %>

            </div>
        </div>




        <h1>NO EXISTEN PRODUCTOS REGISTRADOS</h1>


        <%
            }
        %>





    </body>
</html>

