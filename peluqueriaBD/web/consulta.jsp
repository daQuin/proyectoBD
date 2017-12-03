<%@page import="DTO.FacturaDTO"%>
<%@page import="servlets.facturaServlet"%>
<%@page import="DTO.EmpleadoDTO"%>
<%@page import="servlets.empleadoServlet"%>
<%@page import="DTO.ProductoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servlets.productoServlet"%>
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
                facturaServlet fac = new facturaServlet();
                ArrayList<FacturaDTO> fact = fac.listarFactura(request);

            %>
            <!-- Section -->





            <div class="content" style=" background-color: #fcfcfc; padding: 5em;">

                <div style="text-align: center;">
                        <h1 style=" font-size: 24px; color:#696969;">CONSULTAR FACTURAS<br /><br />
                    </h1>
                </div> 


                <%                    if (fact == null || fact.isEmpty()) {
                %>



                <div align="center">
                    <font color='#d61117'> No se encontraron Facturas registrados.</font>
                </div>



                <%
                } else {
                %>

                <div class="row" style="height: 50px"></div>




                <div class="table-responsive">
                    <table id="table2" class="table table-bordered table-hover">
                        <thead style="background: #f7f7f7">
                            <tr >
                                <th class="text-center">ID</th>
                                <th class="text-center">Cliente</th>
                                <th class="text-center">Apellido</th>
                                <th class="text-center">Fecha</th>
                                <th class="text-center">Servicio</th>
                                <th class="text-center">Producto</th>
                                <th class="text-center">Cantidad</th>
                             


                            </tr>
                        </thead>
                        <tbody>

                            <%
                                FacturaDTO e = new FacturaDTO();
                               
                                    for (int i = 0; i < fact.size(); i++) {
                                        e = fact.get(i);
                            %>
                            <tr id="fila<%=e.getId()%>">
                                <%}
                                    %>
                            </tr>
                        </tbody>
                    </table>
                    <div style="display: none; color: red;" class="text-center" id="msj"></div>
                </div>





                <%}%>



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

<script src="js/empleadoProcesar.js"></script>
<!-- DataTables -->
<script src="plugins/bootstrap.min.js" type="text/javascript"></script>
<script src="plugins/jquery-1.10.2.js" type="text/javascript"></script>
<script src="plugins/datatables/jquery.dataTables.min.js"></script>
<script src="plugins/datatables/dataTables.bootstrap.min.js"></script>

<script>


                                                                    $(function () {
                                                                        $("#table2").DataTable();
                                                                    });

</script>
<script>


</script>



</body>
</html>
