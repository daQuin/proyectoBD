
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


                <form align="center" class="login" name="formagregar" onSubmit="registrarServicio();
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
                                <div style="text-align: left;">Descripcion :&nbsp; &nbsp; &nbsp;&nbsp; </div>  
                            </td>
                            <td> 
                                <div>
                                    <textarea  name="textArea" id="textArea"   placeholder="Escriba Aqui su mensaje.."></textarea>
                                </div>

                            </td>

                        </tr>

                    </table>
                    <div style="display: none; color: red;" class="text-center" id="msj"></div>
                    <br/>
                    <button class="ufps-btn-light" type="submit" id="btnGuardar">Guardar</button><br/><br/> 
                </form>     


            </div>                             


            <!-- Section -->


            <!-- Section xd-->


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
</body>
</html>
