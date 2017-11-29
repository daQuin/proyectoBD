
<%@page import="DTO.ServicioDTO"%>
<%@page import="servlets.servicioServlet"%>

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
                String idServicio = request.getParameter("id");
                int id = Integer.parseInt(idServicio);
                servicioServlet sv = new servicioServlet();
                ServicioDTO s = new ServicioDTO();
                s=sv.buscarServicio(request, id);


            %>


            <div class="content" style="background-color: #fcfcfc; padding: 5em;">

                <div style="text-align: center;">
                    <h1 style=" font-size: 24px; color:#696969;">ACTUALIZAR SERVICIO<br /><br />
                    </h1>
                </div> 



                <div id="consulta" style="">
                    <form align="center" class="login" name="formagregar" onSubmit="ActualizarServicio(<%=s.getId()%>);
                            return false" >


                    <table align="center" border="0" class="table-responsive table-condensed table-hover">


                        <tr>
                            <td>
                                <div style="text-align: left;" >Nombre :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="nombre"  id="nombreservicio" name="nombre" class="ufps-input " value="<%=s.getNombre()%>" type="text" required autofocus></input>

                            </td>
                        </tr>
                        

                        <tr>
                            <td> 
                                <div style="text-align: left;">Valor del servicio : </div>  
                            </td>
                            <td> 

                                <input class="ufps-input" id="valorservicio" name="valor" placeholder="Valor del servicio" value="<%=s.getValor()%>" type="number"required autofocus>


                            </td>

                        </tr>

                      
                        <tr>
                            <td> 
                                <div style="text-align: left;">Descripcion :&nbsp; &nbsp; &nbsp;&nbsp; </div>  
                            </td>
                            <td> 
                                <div>
                                    < <textarea  name="textArea" id="textArea"><%=s.getDescripcion()%> </textarea>
                                </div>

                            </td>

                        </tr>

                    </table>
                        
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

<script src="js/ServicioProcesar.js"></script>
</body>
</html>