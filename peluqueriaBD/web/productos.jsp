<%@page import="DTO.ProductoDTO"%>
<%@page import="java.util.ArrayList"%>
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
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/productos.css">
    </head>
    <body>


        <%
            productoServlet con = new productoServlet();
            ArrayList<ProductoDTO> p = new ArrayList<ProductoDTO>();
            p = con.listarProductos(request);
        %>



        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Peluqueria PelosNecios</a>
                </div>
                <ul class="nav navbar-nav">
                    <!--Boton Inicio -->
                    <li class="active"><a href="index.jsp">Inicio</a></li>
                    <!--Boton Productos -->
                    <li><a href="productos.jsp">Productos</a></li>
                    <!--Boton Servicios -->
                    <li><a href="servicios.jsp">Servicios</a></li>
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
        <%           if (p != null && !p.isEmpty()) {
                for (ProductoDTO prod : p) {
                    prod.toString();
        %>

        <div class="col-sm-3">
            <article class="col-item">
                <div class="photo">
                    <a href="#"> <img src="https://unsplash.it/500/300?image=0" class="img-responsive" alt="Product Image" /> </a>
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price-details col-md-6">
                            <p class="details">
                                <%=prod.getDescripcion()%>
                            </p>
                            <h1>  <%=prod.getNombre()%> </h1>
                            <span class="price-new"> <%=prod.getValor()%> </span>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="#" class="hidden-sm">Add to cart</a>
                        </p>
                        <p class="btn-details">
                            <a href="#" class="hidden-sm" data-toggle="tooltip" data-placement="top" title="Add to wish list"><i class="fa fa-heart"></i></a>
                            <a href="#" class="hidden-sm" data-toggle="tooltip" data-placement="top" title="Compare"><i class="fa fa-exchange"></i></a>
                        </p>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </article>
        </div>

                            <%
                                }
                            } else {
                            %>


                            <h1>NO EXISTEN PRODUCTOS REGISTRADOS</h1>


                            <%
                                }
                            %>
        
        
        <script>
            $(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>
    </body>
</html>