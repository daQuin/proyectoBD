
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
                                <div style="text-align: left;" >Fecha inicio :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="Fecha inicio"  id="fechainicio" name="fechainicio" class="ufps-input "  type="date" required autofocus></input>

                            </td>
                        </tr>


                        <tr>
                            <td>
                                <div style="text-align: left;" >Fecha cierre :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="Fecha cierre" id="fechafin" name="fechafin" class="ufps-input "  type="date" required autofocus></input>

                            </td>
                        </tr>



                        <tr>
                            <td>
                                <div style="text-align: left;" >Tipo:&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>
                                <select id="tipo" name="tipo" class="ufps-input ">
                                    <option value="Regional">Regional</option> 
                                    <option value="Nacional">Nacional</option> 
                                    <option value="Internacional">Internacional</option> 
                                   
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <div style="text-align: left;" >Fecha inicio de la visita :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="Fecha inicio de la visita" id="fechainiciovisita" name="fechainiciovisita" class="ufps-input "  type="date" required autofocus></input>
                            </td>
                        </tr>


                        <tr>
                            <td>
                                <div style="text-align: left;" >Fecha fin de la visita :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="Fecha fin de la visita" id="fechafinvisita" name="fechafinvisita" class="ufps-input "  type="date" required autofocus></input>

                            </td>
                        </tr>

                        <tr>
                            <td>
                                <div style="text-align: left;" >Cupos :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="cupos" id="cupos" name="cupos" class="ufps-input "  type="number" required autofocus></input>

                            </td>
                        </tr>

                        <tr>
                            <td> 
                                <div style="text-align: left;">Inversion por estudiante : </div>  
                            </td>
                            <td> 

                                <input class="ufps-input" id="inversionestudiante" name="inversionestudiante" placeholder="Inversion por estudiante" type="number" id="fecha" required autofocus>


                            </td>

                        </tr>

                    </table><br/>
                    <h2 style=" font-size: 24px; color:#696969;">Informacion de la empresa</h2>
                    <table align="center" border="0" class="table-responsive table-condensed table-hover">
                        <tr>
                            <td>
                                <div style="text-align: left;" >Nombre :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="Nombre" id="nombreempresa" name="nombreempresa" class="ufps-input"  type="text" required autofocus></input>

                            </td>
                        </tr>

                        <tr>
                            <td>
                                <div style="text-align: left;" >Pais: :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input placeholder="Pais" id="pais" name="pais" class="ufps-input"  type="text" required autofocus></input>

                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div style="text-align: left;" >Ciudad :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="Ciudad" id="ciudad" name="ciudad" class="ufps-input "  type="text" required autofocus></input>

                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div style="text-align: left;" >Direccion :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="Direccion" id="direccion" name="direccion" class="ufps-input "  type="text" required autofocus></input>

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