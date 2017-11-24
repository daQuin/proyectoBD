/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function registrarServicio() {
    nombre = $("#nombreservicio").val();
    valor = $("#valorservicio").val(); 
    descripcion = $("#textArea").val();
    $.ajax({
        url: 'servicioServlet',
        type: 'POST',
        data: {crearServicio: "true", nombre: nombre,valor: valor, descripcion: descripcion}
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
function vaciar() {
    $("#nombreservicio").val("");
    $("#valorservicio").val("");
    $("#textArea").val("");
      

}

function eliminarServicio(id) {
     $.ajax({
        url: 'servicioServlet',
        type: 'POST',
        data: {eliminarServicio: "true", idservicio: id}
    }).done(function (sub) {

       if ((sub.indexOf('exito') >= 0)) {

            var table = $('#table2').DataTable();
            table.destroy();

            $("#myModalEliminar" + id).click();

            setTimeout(function () {
                $('.tooltip').remove();
                $("#fila" + id).remove();
                $("#table2").DataTable();

            }, 300);


        } else {
            $("div").remove("#mensajeAlerta");
            $('#mensaje').append("<br/><div id='mensajeAlerta'><font color='#d61117'>" + sub + "</font></div><br/>");


            setTimeout(function () {
                $("h3").remove("#mensajeAlerta");
            }, 2000);
        }

    });
}

function ActualizarServicio(id) {
    nombre = $("#nombreservicio").val();
    valor = $("#valorservicio").val(); 
    descripcion = $("#textArea").val();
    $.ajax({
        url: 'servicioServlet',
        type: 'POST',
        data: {actualizarServicio: "true", id: id, nombre: nombre,valor: valor, descripcion: descripcion}
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