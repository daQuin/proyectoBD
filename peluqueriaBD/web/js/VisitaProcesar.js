
function registrarVisita(id) {
    
    fechaIniciov = $("#fechainiciov").val();
    inversionTotal = $("#inversionTotal").val();
    asistentes = $("#asistentes").val();
    descripcionv = $("#textArea").val();
    
    tipo = $("#tipo").val();
    idConv = id;
    
    nombreContacto = $("#nombreContacto").val();
    telefono = $("#telefonoContacto").val();
    correoContacto = $("#correoContacto").val();
    tipoContacto = $("#tipoContacto").val();
 
    $.ajax({
        url: 'visitaServlet',
        type: 'POST',
        data: {crearVisita: "true",  fecahIniciov: fechaIniciov, inversion: inversionTotal,
            asistentes: asistentes , descripcionv: descripcionv, idConv:idConv, tipo: tipo, nombreContacto: nombreContacto, correo: correoContacto,
            tipoContacto: tipoContacto,  telefono: telefono}
    }).done(function (sub) {

        if ((sub.indexOf('exito') >= 0)) {
            $("#msj").html("<br> Registro Exitoso");
            $("#msj").slideDown("slow").delay(1000).slideUp("fast");

        } else {
            $("#msj").html("<br> Error de registro");
            $("#msj").slideDown("slow").delay(1000).slideUp("fast");
        }
  

    });
}



function eliminarVisita(id) {

    $.ajax({
        url: 'visitaServlet',
        type: 'POST',
        data: {eliminarVisita: "true", idvisita: id}
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



