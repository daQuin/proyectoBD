
<%@page import="DTO.ProductoDTO"%>
<%@page import="servlets.productoServlet"%>
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
                String idProducto = request.getParameter("id");
                int id = Integer.parseInt(idProducto);
                productoServlet sv = new productoServlet();
                ProductoDTO s = new ProductoDTO();
                s = sv.buscarProducto(request, id);


            %>


            <div class="content" style="background-color: #fcfcfc; padding: 5em;">

                <div style="text-align: center;">
                    <h1 style=" font-size: 24px; color:#696969;">ACTUALIZAR PRODUCTO<br /><br />
                    </h1>
                </div> 



                <div id="consulta" style="">
                    <form align="center" class="login" name="formagregar" onSubmit="ActualizarProducto(<%=s.getId()%>);
                            return false" >


                        <table align="center" border="0" class="table-responsive table-condensed table-hover">
                            <tr>
                                <td>
                                    <div style="text-align: left;" >Nombre :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                                </td>

                                <td>

                                    <input  value="<%=s.getNombre()%>" id="nombreproducto" name="nombreproducto" class="ufps-input"  type="text" required autofocus></input>

                                </td>
                            </tr>

                            <tr>
                                <td> 
                                    <div style="text-align: left;">Descripcion :&nbsp; &nbsp; &nbsp;&nbsp; </div>  
                                </td>
                                <td> 
                                    <div>
                                        <textarea  name="textArea" id="textArea"><%=s.getDescripcion()%> </textarea>
                                    </div>

                                </td>

                            </tr>

                            <tr>
                                <td>
                                    <div style="text-align: left;" >Cantidad :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                                </td>

                                <td>

                                    <input  value="<%=s.getCantidad()%>" id="cantidadproducto" name="cantidadproducto" class="ufps-input "  type="text" required autofocus></input>

                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <div style="text-align: left;" >valor :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                                </td>

                                <td>

                                    <input  value="<%=s.getValor()%>" id="valorproducto" name="valorproducto" class="ufps-input "  type="text" required autofocus></input>

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
