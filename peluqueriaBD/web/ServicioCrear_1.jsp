
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
                    <h1 style=" font-size: 24px; color:#696969;">REGISTRAR SERVICIO<br /><br />
                    </h1>
                </div> 


                <form align="center" class="login" name="formagregar" onSubmit="registrarConv();
                        return false" >



                    <table align="center" border="0" class="table-responsive table-condensed table-hover">


                        <tr>
                            <td>
                                <div style="text-align: left;" >Nombre :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="nombre"  id="nombreservicio" name="nombre" class="ufps-input "  type="text" required autofocus></input>

                            </td>
                        </tr>
                        <!--- Select que puede servir para otra cosa
                        <tr>
                            <td>
                                <div style="text-align: left;" >Tipo:&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>
                                <select id="tipo" name="tipo" class="ufps-input ">
                                    <option value="Corte">Corte</option>
                                    <option value="Corte">Tintura</option>
                                    <option value="Corte">Peinado</option>
                                    <option value="Corte">Pedicura</option> 
                                    <option value="Corte">Depilacion</option>
                                    <option value="Corte">Manicura</option>

                                </select>
                            </td>
                        </tr>-->
                        <!-- Fecha que sirve para otra plantilla
                        <tr>
                            <td>
                                <div style="text-align: left;" >Fecha inicio de la visita :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="Fecha inicio de la visita" id="fechainiciovisita" name="fechainiciovisita" class="ufps-input "  type="date" required autofocus></input>
                            </td>
                        </tr>
                        -->

                        <tr>
                            <td> 
                                <div style="text-align: left;">Valor del servicio : </div>  
                            </td>
                            <td> 

                                <input class="ufps-input" id="valorservicio" name="valor" placeholder="Valor del servicio" type="number"required autofocus>


                            </td>

                        </tr>

                        <tr>
                            <td>
                                <div style="text-align: left;" >Descripcion :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="descripcion"  id="descripcionservicio" name="descripcion" class="ufps-input "  type="text" required autofocus></input>

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
<script src="js/ConvPorcesar.js"></script>
</body>
</html>