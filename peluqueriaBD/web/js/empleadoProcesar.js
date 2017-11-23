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
        data: {crearProducto: "true", nombre: nombre, apellido: apellido, cedula: cedula, direccion: direccion, telefono: telefono, correo: correo,fecha: fecha}
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
