<%@page import="DTO.ServicioDTO"%>
<%@page import="servlets.servicioServlet"%>
<%@page import="DTO.ProductoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servlets.productoServlet"%>
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
        <link rel="shortcut icon" href="img/VISITAS.ico">
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
        <link rel="stylesheet" href="lib/css/bootstrap.min.css">
        <link  rel="stylesheet" href="css/ufps.min.css">
        <link rel="stylesheet" href="css/main.css" />
        <link rel="stylesheet" href="css/estilo_2.css" />


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
                    <li><a href="productos.jsp">Productos</a></li>
                    <!--Boton Servicios -->
                    <li><a href="servicios.jsp">Servicios</a></li>
                    <!--Boton Citas -->
                    <li><a href="citas.jsp">Citas</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <a class="navbar-brand">Ya tienes una cuenta?</a>
                    <li><a href="Ingresar.jsp"><span class="glyphicon glyphicon-log-in"></span> Ingresate</a></li>
                </ul>
            </div>
        </nav>

        <%
            servicioServlet con = new servicioServlet();
            ArrayList<ServicioDTO> s = new ArrayList<ServicioDTO>();
            s = con.listarServicios(request);
        %>




        <div class="content" style=" background-color: #fcfcfc; padding: 5em;">

            <div style="text-align: center;">
                <h1 style=" font-size: 24px; color:#696969;">Agenda una Cita<br /><br />
                </h1>
            </div> 

   <%
   
    if (s != null && !s.isEmpty()) {
   %>
            <form align="center" class="login" name="formagregar" onSubmit="registrarCita();
                    return false" >

              
                <table align="center" border="0" style="width: 500px; margin-left: 30%;" class="table-responsive table-condensed table-hover">
                    <tr>
                        <td>
                            <div style="text-align: left;" >Nombre :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                        </td>

                        <td>

                            <input  placeholder="Nombre" id="nombre" name="nombre" class="ufps-input"  type="text" required autofocus></input>

                        </td>
                    </tr>

                    <tr>
                        <td> 
                            <div style="text-align: left;">Correo :&nbsp; &nbsp; &nbsp;&nbsp; </div>  
                        </td>
                        <td> 
                            <div>
                                <input  placeholder="Email" id="pass" name="pass" class="ufps-input"  type="text" required autofocus></input>

                            </div>

                        </td>

                    </tr>

                    <tr>
                        <td>
                            <div style="text-align: left;" >Servicio :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                        </td>

                        <td>

                            <select id="servicio" name="servicio" class="ufps-input " style="height: 34px;">

                                <%       
                                        for (ServicioDTO serv : s) {

                                %>
                                <option value="<%=serv.getNombre()%>"><%=serv.getNombre()%></option> 
                                <%
                                        }
                                    
                                %>
                            </select>

                        </td>
                    </tr>

                    <tr>
                        <td>
                            <div style="text-align: left;" >fecha :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                        </td>

                        <td>

                            <input  placeholder="Valor" id="fecha" name="fecha" class="ufps-input "  type="date" required autofocus></input>

                        </td>
                    </tr>



                </table>

                <div style="display: none; color: red;" class="text-center" id="msj"></div>

                <button class="ufps-btn-light" type="submit" id="btnGuardar">Guardar</button><br/><br/> 
            </form>     


                            <%
                            }else{
                            %>
                            
                            <h1>NO EXISTEN SERVICIOS PARA AGENDAR</h1>
                            
                            <%
                            }
                            %>
                            
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
        <script src="js/Jscript.js"></script>
        <script src="lib/js/bootstrap.min.js"></script>

        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
        <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
        <script src="js/main.js"></script>
        <script src="js/CitaProcesar.js"></script>
                            
    </body>
</html>

