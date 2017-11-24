/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function registrarEmpleado() {
    nombre = $("#nombreempleado").val();
    apellido = $("#apellidoempleado").val();
    cedula = $("#cedulaempleado").val();
    direccion = $("#direccionempleado").val();
    telefono = $("#telefonoempleado").val();
    correo = $("#correoempleado").val();
    fecha = $("#fechaingresoempleado").val();

    $.ajax({
        url: 'empleadoServlet',
        type: 'POST',
        data: {crearEmpleado: "true", nombre: nombre, apellido: apellido, cedula: cedula, direccion: direccion, telefono: telefono, correo: correo, fecha: fecha}
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
    $("#nombreempleado").val("");
    $("#apellidoempleado").val("");
    $("#cedulaempleado").val("");
    $("#direccionempleado").val("");
    $("#telefonoempleado").val("");
    $("#correoempleado").val("");
    $("#fechaingresoempleado").val("");
}


function eliminarEmpleado(id) {
   
    $.ajax({
        url: 'empleadoServlet',
        type: 'POST',
        data: {eliminarEmpleado: "true", idempleado: id}
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