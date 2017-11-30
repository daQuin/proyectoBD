
<%@page import="DTO.EmpleadoDTO"%>
<%@page import="servlets.empleadoServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="InvEstructura/adminheader.jsp"/>

<!-- Wrapper -->
<div id="wrapper">

    <!-- Main -->
    <div id="main">
        <div class="inner">

            <!-- Header -->


            <!-- Banner -->


            <!-- Section -->
            <%
                String idEmpleado = request.getParameter("id");
                int id = Integer.parseInt(idEmpleado);
                empleadoServlet sv = new empleadoServlet();
                EmpleadoDTO s = new EmpleadoDTO();
                s = sv.buscarEmpleado(request, id);


            %>


            <div class="content" style="background-color: #fcfcfc; padding: 5em;">

                <div style="text-align: center;">
                    <h1 style=" font-size: 24px; color:#696969;">ACTUALIZAR EMPLEADO<br /><br />
                    </h1>
                </div> 



                <div id="consulta" style="">
                    <form align="center" class="login" name="formagregar" onSubmit="ActualizarEmpleado(<%=s.getId()%>);
                            return false" >


                        <table align="center" border="0" class="table-responsive table-condensed table-hover">
                            <tr>
                                <td>
                                    <div style="text-align: left;" >Nombre :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                                </td>

                                <td>

                                    <input  value="<%=s.getNombres()%>" id="nombreempleado" name="nombre" class="ufps-input"  type="text" required autofocus></input>

                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div style="text-align: left;" >Apellidos:&nbsp; &nbsp; &nbsp;&nbsp;</div>

                                </td>

                                <td>

                                    <input  value="<%=s.getApellidos()%>" id="Apellidoempleado" name="nombre" class="ufps-input"  type="text" required autofocus></input>

                                </td>
                            </tr>
                            <tr>
                                <td> 
                                    <div style="text-align: left;">Cedula : </div>  
                                </td>
                                <td> 

                                    <input value="<%=s.getCedula()%> "class="ufps-input" id="cedulaempleado" name="cedula" placeholder="cedula" type="number"required autofocus>


                                </td>

                            </tr>

                            <tr>
                            <tr>
                                <td>
                                    <div style="text-align: left;" >Direccion :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                                </td>

                                <td>

                                    <input  value="<%=s.getDireccion()%>" id="direccionempleado" name="direccion" class="ufps-input "  type="text" required autofocus></input>

                                </td>
                            </tr>
                            <tr>
                                <td> 
                                    <div style="text-align: left;">Telefono : </div>  
                                </td>
                                <td> 

                                    <input value="<%=s.getTelefono()%>" class="ufps-input" id="telefonoempleado" name="telefono" placeholder="telefono" type="number"required autofocus>


                                </td>

                            </tr>
                            
                            <tr>
                                <td>
                                    <div style="text-align: left;" >Correo :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                                </td>

                                <td>

                                    <input  placeholder="example@gmail.com"  id="correoempleado" name="correo" class="ufps-input "  type="text" required autofocus value="<%=s.getCorreo()%>"></input>

                                </td>
                            </tr>

                        </table>
                        <br>

                        <div style="display: none; color: red;" class="text-center" id="msj"></div>
                        <br/>

                        <button class="ufps-btn-light" type="submit" id="btnGuardar" >Actualizar</button><br/><br/> 
                    </form> 
                </div>

            </div>                                                   

            <!-- Section -->


        </div>
    </div>

    <!-- Sidebar -->
    <jsp:include page="InvEstructura/menu.jsp"/>  

</div>

<jsp:include page="InvEstructura/invfooter.jsp"/>       

<!-- Scripts -->
<script src="js/jquery.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/util.js"></script>
<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
<script src="js/main.js"></script>

<script src="js/jquery.min.js"></script>

<script src="js/ProductoProcesar.js"></script>
</body>
</html>
