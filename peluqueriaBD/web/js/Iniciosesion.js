
            $(document).ready(function () {
                $("#iniciarSesion").click(function () {
                    $("#menuSesion").slideToggle(300);
                });
            });


            function abrirVentana() {
                $(".ventana").slideDown("slow");
            }
            function cerrarVentana() {
                $(".ventana").slideUp("fast");
            }


                         