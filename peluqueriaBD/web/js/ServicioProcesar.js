/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function registrarServicio() {
    nombre = $("#nombreservicio").val();
    valor = $("#valorservicio").val();   
    $.ajax({
        url: 'servicioServlet',
        type: 'POST',
        data: {crearServicio: "true", nombre: nombre,valor: valor}
    }).done(function (sub) {

        if ((sub.indexOf('exito') >= 0)) {
            $("#msj").html("<br> Registro Exitoso");
            $("#msj").slideDown("slow").delay(1000).slideUp("fast");

        } else {
            $("#msj").html("<br> Error de registro");
            $("#msj").slideDown("slow").delay(1000).slideUp("fast");
        }
        vaciar();

    });
}
