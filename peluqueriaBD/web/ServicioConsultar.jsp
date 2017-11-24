
<%@page import="DTO.ServicioDTO"%>
<%@page import="servlets.servicioServlet"%>
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
                servicioServlet ser = new servicioServlet();
                ArrayList<ServicioDTO> serv = ser.listarServicios(request);

            %>
            <!-- Section -->





            <div class="content" style=" background-color: #fcfcfc; padding: 5em;">

                <div style="text-align: center;">
                    <h1 style=" font-size: 24px; color:#696969;">CONSULTAR SERVICIO<br /><br />
                    </h1>
                </div> 


                <%                    if (serv == null || serv.isEmpty()) {
                %>



                <div align="center">
                    <font color='#d61117'> No se encontraron Servicios registrados.</font>
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
                                <th class="text-center">Nombre</th>
                                <th class="text-center">Descripcion</th>
                                <th class="text-center">Valor</th>
                                <th class="text-center">Edicion</th>


                            </tr>
                        </thead>
                        <tbody>

                            <%
                                ServicioDTO s = new ServicioDTO();

                                for (int i = 0; i < serv.size(); i++) {
                                    s = serv.get(i);
                                    
                            %>
                            <tr id="fila<%=s.getId()%>">
                                <td class="align-center"><%=s.getId()%></td>
                                <td class="align-center"><%=s.getNombre()%></td>
                                <td class="align-left" style="width: 340px;"><%=s.getDescripcion()%></td>
                                <td class="align-center"><%=s.getValor()%></td>


                                <td><a type="button" class="btn btn-info btn-xs " data-toggle="modal" href="ServicioActualizar.jsp?id=<%=s.getId()%>" title="Editar"><i class="fa fa-wrench"></i> </a>
                                    <i class="align-center"></i> 

                                    <span id="tooltipEliminar" data-toggle="tooltip" data-placement="top" title="Eliminar">
                                        <button type="button" class="btn btn-danger btn-xs " style="height: 24px;" data-toggle="modal" data-target="#myModalEliminar<%=s.getId()%>" ><i class="fa fa-remove"></i> </button>
                                        <i class="align-center"></i>
                                    </span>




                                    <div class="modal fade" id="myModalEliminar<%=s.getId()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">

                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-body" style="background: #f7f7f7; height:10%; padding-bottom:  0px;">
                                                    <button type="button" class="close btn-xs" style="width: 45px; height: 30px; display: block; float: right; " data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                    <% String cod = "" + s.getId();%>
                                                    <h4 class="modal-title align-center"  id="myModalLabel"><b>¿Estas seguro de eliminar el Servicio con ID <%=cod%>?</b></h4>

                                                    <div class="row" style="height: 20px"></div>
                                                    <div class="text-center">


                                                        <form align="center" class="login" method="post" name="formeliminar" onSubmit="eliminarServicio('<%=cod%>');
                                                                return false" >



                                                            <button type="submit" class="btn btn-danger btn-xs" style="margin-right: 18px; height: 35px;">Eliminar</button>

                                                            <div id="mensaje<%=cod%>"></div>

                                                        </form>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>




                                </td>

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

<script src="js/ServicioProcesar.js"></script>
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
