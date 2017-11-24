<%@page import="DTO.ClienteDTO"%>
<%@page import="servlets.clienteServlet"%>
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
                clienteServlet cli = new clienteServlet();
                ArrayList<ClienteDTO> clie = cli.listarClientes(request);

            %>
            <!-- Section -->





            <div class="content" style=" background-color: #fcfcfc; padding: 5em;">

                <div style="text-align: center;">
                    <h1 style=" font-size: 24px; color:#696969;">CONSULTAR CLIENTES<br /><br />
                    </h1>
                </div> 


                <%                    if (clie == null || clie.isEmpty()) {
                %>



                <div align="center">
                    <font color='#d61117'> No se encontraron Clientes registrados.</font>
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
                                <th class="text-center">Apellido</th>
                                <th class="text-center">Telefono</th>
                                <th class="text-center">Correo</th>
                                <th class="text-center">Direccion</th>
                                <th class="text-center">Edicion</th>


                            </tr>
                        </thead>
                        <tbody>

                            <%
                                    ClienteDTO c = new ClienteDTO();

                                for (int i = 0; i < clie.size(); i++) {
                                    c = clie.get(i);
                            %>
                            <tr id="fila<%=c.getId()%>">
                                <td class="align-center"><%=c.getId()%></td>
                                <td class="align-center"><%=c.getNombres()%></td>
                                <td class="align-center"><%=c.getApellidos()%></td>
                                <td class="align-center"><%=c.getTelefono()%></td>
                                <td class="align-center"><%=c.getCorreo()%></td>
                                <td class="align-center"><%=c.getDireccion()%></td>
                             


                                <td>
                                    
                                    <i class="align-center"></i> 

                                    <span id="tooltipEliminar" data-toggle="tooltip" data-placement="top" title="Eliminar">
                                        <button type="button" class="btn btn-danger btn-xs " style="height: 24px; margin-left: 30%;" data-toggle="modal" data-target="#myModalEliminar<%=c.getId()%>" ><i class="fa fa-remove"></i> </button>
                                        <i class="align-center"></i>
                                    </span>




                                    <div class="modal fade" id="myModalEliminar<%=c.getId()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">

                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-body" style="background: #f7f7f7; height:10%; padding-bottom:  0px;">
                                                    <button type="button" class="close btn-xs" style="width: 45px; height: 30px; display: block; float: right; " data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                    <% String cod = "" + c.getId();%>
                                                    <h4 class="modal-title align-center"  id="myModalLabel"><b>¿Estas seguro de eliminar el Cliente <%=c.getNombres()%>?</b></h4>

                                                    <div class="row" style="height: 20px"></div>
                                                    <div class="text-center">


                                                        <form align="center" class="login" method="post" name="formeliminar" onSubmit="eliminarCliente('<%=c.getId()%>');
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

<script src="js/ClienteProcesar.js"></script>
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
