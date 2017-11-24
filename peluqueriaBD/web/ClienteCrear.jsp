
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="InvEstructura/adminheader.jsp"/>



<!-- Wrapper -->
<div id="wrapper">

    <!-- Main -->
    <div id="main">
        <div class="inner">

            <!-- Header -->


            <!-- Banner -->




            <div class="content" style=" background-color: #fcfcfc; padding: 5em;">

                <div style="text-align: center;">
                    <h1 style=" font-size: 24px; color:#696969;">REGISTRAR CLIENTE<br /><br />
                    </h1>
                </div> 


                <form align="center" class="login" name="formagregar" onSubmit="inscribirce();
                        return false" >

                    <h4 class="align-left">Ingrese los datos del Cliente</h4>

                    <table align="center" border="0" class="table-responsive table-condensed table-hover">
                        <tr>
                            <td>
                                <div style="text-align: left;" >Nombre :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="Nombre" id="nombrecliente" name="nombrecliente" class="ufps-input"  type="text" required autofocus></input>

                            </td>
                        </tr>


                        <tr>
                            <td>
                                <div style="text-align: left;" >Apellido :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="Apellido" id="apellidocliente" name="apellidocliente" class="ufps-input "  type="text" required autofocus></input>

                            </td>
                        </tr>


                        <tr>
                            <td>
                                <div style="text-align: left;" >Telefono :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="Telefono" id="telefono" name="telefono" class="ufps-input "  type="text" required autofocus></input>

                            </td>
                        </tr>

                        <tr>
                            <td>
                                <div style="text-align: left;" >Correo :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="Email" id="correo" name="correo" class="ufps-input "  type="text" required autofocus></input>

                            </td>
                        </tr>

                        <tr>
                            <td>
                                <div style="text-align: left;" >Direccion :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="Direccion" id="direccioncliente" name="direccioncliente" class="ufps-input "  type="text" required autofocus></input>

                            </td>
                        </tr>


                    </table>
                    <div style="display: none; color: red;" class="text-center" id="msj2"></div>
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
<script src="js/ClienteProcesar.js"></script>
</body>
</html>