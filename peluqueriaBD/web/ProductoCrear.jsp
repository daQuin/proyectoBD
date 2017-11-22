
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
                    <h1 style=" font-size: 24px; color:#696969;">REGISTRAR PRODUCTO<br /><br />
                    </h1>
                </div> 


                <form align="center" class="login" name="formagregar" onSubmit="registrarProducto();
                        return false" >

                    <h4 class="align-left">Ingrese la informacion del producto</h4>

                    <table align="center" border="0" class="table-responsive table-condensed table-hover">
                        <tr>
                            <td>
                                <div style="text-align: left;" >Nombre :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="Nombre" id="nombreproducto" name="nombreproducto" class="ufps-input"  type="text" required autofocus></input>

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

                        <tr>
                            <td>
                                <div style="text-align: left;" >Cantidad :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="Cantidad" id="cantidadproducto" name="cantidadproducto" class="ufps-input "  type="text" required autofocus></input>

                            </td>
                        </tr>

                        <tr>
                            <td>
                                <div style="text-align: left;" >valor :&nbsp; &nbsp; &nbsp;&nbsp;</div>

                            </td>

                            <td>

                                <input  placeholder="Valor" id="valorproducto" name="valorproducto" class="ufps-input "  type="text" required autofocus></input>

                            </td>
                        </tr>
                    </table>
                    <br>
                    <table align="center" border="0" class="table-responsive table-condensed table-hover">
                        <tr>
                            <td>
                                <div style="text-align: left;">Imagen :&nbsp; &nbsp; &nbsp;&nbsp; </div>
                            </td>
                            <td> 
                                <input  type="file" class="ufps-input" placeholder="Imagen" name="file1" id="file1" required autofocus>

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
<script src="js/ProductoProcesar.js"></script>
</body>
</html>