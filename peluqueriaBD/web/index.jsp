

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <!--Metaetiqueta para el uso del conjunto de caracteres adecuado-->
        <meta charset="utf-8">
        <!--Metaetiqueta para corregir compatibilidad con navegador Microsft-->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!--Metaetiqueta para la correcta visualización en dispositivos moviles-->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=0">
        <title>Visitas empresariales</title>

        <link rel="shortcut icon" href="img/VISITAS.ico">

        <!--Añada primero el estilo de la libreria (ufps.css o ufps.min.css) y luego sus estilos propios-->
        <link href="css/ufps.min.css" rel="stylesheet">
        <link rel="stylesheet" href="lib/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/main2.css">
        <link rel="stylesheet" href="css/estilo.css">
        <link rel="stylesheet" href="css/estilo_1.css">

    </head>
    <body style="background-color: #F4F3F3">
        <!--Contenido-->


        <div class="ufps-navbar">
            <div class="ufps-container-fluid">
                <div class="ufps-navbar-brand">

                </div>

                <div class="ufps-navbar-left">

                </div>
                <div class="ufps-navbar-right">
                    <div class="ufps-navbar-corporate">
                        <img src="img/logo_ingsistemas_vertical_invertido.png" alt="Logo ingeniería de sistemas">
                        <img src="img/logo_ufps_inverted.png" alt="Logo UFPS">
                    </div>
                </div>
                <div class="ufps-navbar-right">


                    <p>
                    <p style="cursor: pointer;" data-toggle="modal" data-target="#myModal" id="iniciarSesion" class="ufps-navbar-btn"> Iniciar Sesion </p>
                    </p>
                </div>


            </div> 

        </div>



        <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog modal-sm">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title" style="text-align: center;">Formulario de ingreso</h4>
                    </div>
                    <div class="modal-body">
                        <form method="post" onsubmit="iniciarSesion();
                                return false"  >
                            <div style="display: none; color: red;" class="text-center" id="msjInicio"></div>
                            <input type="text" placeholder="User" id="usu" name="usu" required autofocus>
                            <input type="password" placeholder="Pass" id="pass" name="pass" required autofocus>

                            <input type="submit" value="Aceptar" id="boton" >
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>

        <div id="wrapper" class="ufps-container" style="background-color: white">

            <%
                visitaServlet con = new visitaServlet();
                evidenciaServlet evidencia = new evidenciaServlet();
                convServlet conv = new convServlet();
                ArrayList<VisitaDTO> v = new ArrayList<VisitaDTO>();
                ArrayList<EvidenciaDTO> evi = new ArrayList<EvidenciaDTO>();

                v = con.listar(request);
                ConvocatoriaDTO c = new ConvocatoriaDTO();
                
                int aux = 0;
                String cad1 = "";
                String cad2 = "";

            %>


            <!-- Header -->
            <header id="header">
                <div class="inner">

                    <!-- Logo -->

                    <a href="index.jsp" class="logo">
                        <span class="symbol"><img src="img/logo_ingsistemas.png" alt="" /></span><span class="title">VISITAS EMPRESARIALES</span>
                    </a>

            </header>



            <!-- Main -->
            <div id="main">

                <div class="inner">
                    <header>
                        <br>
                    </header>    
                    <p id="per" class="text-justify">El Programa Ingenieria de sistemas, el acercamiento a la empresa es una oportunidad de mejoramiento
                        y una fuente de formación profesional para el estudiante.  La administración es una 
                        ciencia social aplicada y por ende los conocimientos teóricos adquiridos en el aula
                        de clase deben ser contrastados en las organizaciones que tienen vocación internacional.</br>

                        En tal sentido cada semestre con el aval de la Facultad los estudiantes realizan un programa 
                        de visitas empresariales en las asignaturas del componente profesional de cada una de las 
                        disciplinas y en asignaturas referidas a áreas funcionales de la empresa. Estas visitas son acompañadas 
                        por personal docente o directivo de la Facultad  y direccionadas por una guía de trabajo que se entrega
                        previamente.</p>




                    <div style="margin: 0px;">
                        <div class="row" style="height: 15px;"></div>
                        <div class="row">

                            <div  class="col-md-8">
                                <input type="radio" name="radio" id="radio2" onclick="cerrarVentana()" > 
                                <label for="radio2">Departamentales</label>

                                <input type="radio"s name="radio" id="radio1" onclick="abrirVentana()" > 
                                <label for="radio1" >Nacionales</label>

                                <input type="radio" name="radio" id="radio3" onclick="cerrarVentana()" > 
                                <label for="radio3">Internacionales</label>
                            </div>
                            <div  class="col-md-4 text-right">

                                <% if (conv.buscarUltimaConv(request)!=null && !conv.compararFecha(request, conv.buscarUltimaConv(request).getFechaFinConvocatoria())) {%>
                                <a type="button" class="btn btn-warning" href="Inscripcion.jsp"> Inscripcion Disponible</a>
                                <% } %>
                            </div>

                        </div>

                        <div class="row" style="height: 25px;"></div>
                    </div>

                    <div class="row">
                        <div class="col-sm-12">

                            <section class="tiles">
                                <%
                                    evi= evidencia.listarEvidencia(request, v.get(v.size()-1).getId());

                                    c = con.buscarConv(request, v.get(v.size()-1).getIdConvocatoria());
                                    if (!c.getEstado().equalsIgnoreCase("No Registro")) {
                                        cad1 = c.getFechaFinVisita();
                                        cad2 = v.get(v.size()-1).getInfoempresa().getCiudad();
                                    } else {
                                        cad1 = "";
                                        cad2 = "";
                                    }
                                %>
                                <article class="style2">
                                    <span class="image">
                                    <%
                                    if(evi!=null && !evi.isEmpty()){
                                    %>    
                                    <img src="<%= evi.get(0).getRuta() %>" alt="" />
                                        <%}else{%>
                                         <img src="img/pic01.jpg" alt="" />
                                        <%}%>
                                    </span>
                                    <a href="infVisita.jsp?id=<%=v.get(v.size()-1).getId()%>">
                                        <h2><%=v.get(v.size()-1).getInfoempresa().getNombre()%></h2>
                                        <div class="content">
                                            <p> <%=cad1%> - <%=cad2%></p>
                                        </div>
                                    </a>
                                    <%
                                        evi= evidencia.listarEvidencia(request, v.get(v.size()-2).getId());
                                        c = con.buscarConv(request, v.get(v.size()-2).getIdConvocatoria());
                                         if (!c.getEstado().equalsIgnoreCase("No Registro")) {
                                        cad1 = c.getFechaFinVisita();
                                        cad2 = v.get(v.size()-2).getInfoempresa().getCiudad();
                                    } else {
                                        cad1 = "";
                                        cad2 = "";
                                    }
                                    %>
                                </article>
                                <article class="style2">
                                    <span class="image">
                                         <%
                                    if(evi!=null && !evi.isEmpty()){
                                    %>    
                                    <img src="<%= evi.get(0).getRuta() %>" alt="" />
                                        <%}else{%>
                                         <img src="img/pic01.jpg" alt="" />
                                        <%}%>
                                    </span>
                                    <a href="infVisita.jsp?id=<%=v.get(v.size()-2).getId()%>">
                                        <h2><%=v.get(v.size()-2).getInfoempresa().getNombre()%></h2>
                                        <div class="content">
                                             <p> <%=cad1%> - <%=cad2%></p>
                                        </div>
                                    </a>
                                </article>
                                <%
                                    evi= evidencia.listarEvidencia(request, v.get(v.size()-3).getId());
                                    c = con.buscarConv(request, v.get(v.size()-3).getIdConvocatoria());
                                     if (!c.getEstado().equalsIgnoreCase("No Registro")) {
                                        cad1 = c.getFechaFinVisita();
                                        cad2 = v.get(v.size()-3).getInfoempresa().getCiudad();
                                    } else {
                                        cad1 = "";
                                        cad2 = "";
                                    }
                                %>
                                <article class="style2">
                                    <span class="image">
                                         <%
                                    if(evi!=null && !evi.isEmpty()){
                                    %>    
                                    <img src="<%= evi.get(0).getRuta() %>" alt="" />
                                    <%  System.out.println("rutaa daniel: "+evi.get(0).getRuta()); }else{%>
                                         <img src="img/pic01.jpg" alt="" />
                                        <%}%>
                                    </span>
                                    <a href="infVisita.jsp?id=<%=v.get(v.size()-3).getId()%>">
                                        <h2><%=v.get(v.size()-3).getInfoempresa().getNombre()%></h2>
                                        <div class="content">
                                             <p> <%=cad1%> - <%=cad2%></p>
                                        </div>
                                    </a>
                                </article>


                            </section>


                        </div>
                    </div>

                </div>
            </div>

            <!-- Footer -->


        </div>


        <jsp:include page="InvEstructura/invfooter.jsp"/>         

        <!-- Scripts -->
        <script src="js/jquery.min.js"></script>
        <script src="js/Jscript.js"></script>
        <script src="lib/js/bootstrap.min.js"></script>

        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
        <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
        <script src="js/main.js"></script>
        <script src="js/procesarOperacion.js"></script>

    </body>
</html>