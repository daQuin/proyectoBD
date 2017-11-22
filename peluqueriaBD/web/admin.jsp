<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="InvEstructura/adminheader.jsp"/>



        <!-- Wrapper -->
        <div id="wrapper">

            <!-- Main -->
            <div id="main">
                <div class="inner">

                    <!-- Header -->


                    <!-- Banner -->
                    <section id="banner">
                        <div class="content">

                            <h1>PELOS NECIOS<br />
                            </h1>

                            <p>Para la Facultad, el acercamiento a la empresa es una oportunidad de mejoramiento
                                y una fuente de formación profesional para el estudiante.  La administración es una 
                                ciencia social aplicada y por ende los conocimientos teóricos adquiridos en el aula
                                de clase deben ser contrastados en las organizaciones que tienen vocación internacional.</br>

                                En tal sentido cada semestre con el aval de la Facultad los estudiantes realizan un programa 
                                de visitas empresariales en las asignaturas del componente profesional de cada una de las 
                                disciplinas y en asignaturas referidas a áreas funcionales de la empresa. Estas visitas son acompañadas 
                                por personal docente o directivo de la Facultad  y direccionadas por una guía de trabajo que se entrega
                                previamente.</p>

                        </div>
                        <span class="image object">
                            <img src="img/pic01.jpg" alt="" />
                        </span>
                    </section>

                    <!-- Section -->

                    <div class="row">
                        <div class="col-md-1 col-md-push-5">

                            <p style="cursor: pointer; display: none;" data-toggle="modal" data-target="#myModal" id="ini" class="ufps-navbar-btn"> Iniciar Sesion </p>

                        </div>
                    </div>
                    <!-- Section -->


                    <jsp:include page="InvEstructura/modalAalerta.jsp"/> 
                </div>
            </div>


            <jsp:include page="InvEstructura/menu.jsp"/>  


        </div>

        <jsp:include page="InvEstructura/invfooter.jsp"/>       

        <!-- Scripts -->
        <script src="js/jquery.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
        <script src="lib/js/bootstrap.min.js"></script>
        <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
        <script src="js/main.js"></script>
        <script src="js/Iniciosesion.js"></script>

    </body>
</html>