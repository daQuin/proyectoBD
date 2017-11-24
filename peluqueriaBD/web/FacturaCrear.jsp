
<%@page import="DTO.ClienteDTO"%>
<%@page import="servlets.clienteServlet"%>
<%@page import="DTO.ProductoDTO"%>
<%@page import="servlets.productoServlet"%>
<%@page import="DTO.ServicioDTO"%>
<%@page import="java.util.ArrayList"%>
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

            <%
                servicioServlet con = new servicioServlet();
                ArrayList<ServicioDTO> s = new ArrayList<ServicioDTO>();
                s = con.listarServicios(request);

                productoServlet pro = new productoServlet();
                ArrayList<ProductoDTO> prod = new ArrayList<ProductoDTO>();
                prod = pro.listarProductos(request);

                clienteServlet cli = new clienteServlet();
                ArrayList<ClienteDTO> clie = new ArrayList<ClienteDTO>();
                clie = cli.listarClientes(request);
            %>


            <div class="content" style=" background-color: #fcfcfc; padding: 5em;">

                <div style="text-align: center;">
                    <h1 style=" font-size: 24px; color:#696969;">CREAR FACTURA<br /><br />
                    </h1>
                </div> 


                <form align="center" class="login" name="formagregar" onSubmit="registrarFactura();
                        return false" >



                    <table align="center" border="0" class="table-responsive table-condensed table-hover">


                        <tr>
                            <td>
                                <div style="text-align: left;" >Cliente :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>
                            <td>
                                <%
                                    if (clie != null && !clie.isEmpty()) {
                                %>
                                <select id="cliente" name="cliente" class="ufps-input " style="height: 34px;">
                                    <%
                                        for (ClienteDTO c : clie) {
                                    %>
                                    <option value="<%=c.getId()%>"><%=c.getNombres() + " " + c.getApellidos()%></option> 
                                    <%
                                        }
                                    %>
                                </select>
                                <%} else {%>
                                <h1>NO EXISTEN SERVICIOS REGISTRADOS...</h1>
                                <%}%>
                            </td>
                        </tr>                   

                        <tr>
                            <td>
                                <div style="text-align: left;" >Servicio :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>
                            <td>
                                <%
                                    if (s != null && !s.isEmpty()) {
                                %>
                                <select id="servicio" name="servicio" class="ufps-input " style="height: 34px;">
                                    <option value="ninguno">Ninguno</option> 
                                    <%
                                        for (ServicioDTO serv : s) {
                                    %>
                                    <option value="<%=serv.getId()%>"><%=serv.getNombre()%></option> 
                                    <%
                                        }
                                    %>
                                </select>
                                <%} else {%>
                                <h1>NO EXISTEN SERVICIOS REGISTRADOS...</h1>
                                <%}%>
                            </td>
                        </tr>

                    </table>
                    <br>
                    <table align="center" border="0" class="table-responsive table-condensed table-hover">
                        <tr>
                            <td>
                                <div style="text-align: left;" >Producto :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>
                                <%
                                    if (prod != null && !prod.isEmpty()) {
                                %>
                                <select id="producto" name="producto" class="ufps-input " style="height: 34px;">
                                    <option value="ninguno">Ninguno</option> 
                                    <%
                                        for (ProductoDTO p : prod) {
                                    %>
                                    <option value="<%=p.getId()%>"><%=p.getNombre()%></option> 
                                    <%
                                        }
                                    %>
                                </select>
                                <%} else {%>
                                <h1>NO EXISTEN PRODUCTOS REGISTRADOS...</h1>
                                <%}%>
                            </td>
                        </tr>
                        <tr>
                            <td> 
                                <div style="text-align: left;">Cantidad : </div>  
                            </td>
                            <td> 

                                <input class="ufps-input" id="cantidad" name="cantidad" placeholder="Cantidad" type="number"required autofocus>


                            </td>

                        </tr>

                        <tr>
                            <td> 
                                <div style="text-align: left;">Tipo pago : </div>  
                            </td>
                            <td> 
                                <select id="pago" name="pago" class="ufps-input " style="height: 34px;">
                                    <option value="efectivo">Efectivo</option>
                                    <option value="tarjeta">Tarjeta</option>
                                </select>
                            </td>

                        </tr>



                    </table>
                    <div style="display: none; color: red;" class="text-center" id="msj"></div>
                    <br/>
                    <button class="ufps-btn-light" type="submit" id="btnGuardar">Guardar</button><br/><br/> 
                </form>     


            </div>                             


            <!-- Section -->


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
<script src="js/FacturaProcesar.js"></script>
</body>
</html>