function registrarFactura() {
    cliente = $("#cliente").val();
    servicio = $("#servicio").val();
    producto = $("#producto").val();
    cantidad = $("#cantidad").val();
    pago = $("#pago").val();
   

    $.ajax({
        url: 'facturaServlet',
        type: 'POST',
        data: {registrarFactura: "true", cliente: cliente, servicio: servicio, producto: producto, cantidad: cantidad, pago: pago}
    }).done(function (sub) {

        if ((sub.indexOf('exito') >= 0)) {
            $("#msj").html("<br> Registro Exitoso");
            $("#msj").slideDown("slow").delay(1000).slideUp("fast");
            $("#cerrar").click();
        } else {
            $("#msj").html("<br> Registro Erroneo  " +".");
            $("#msj").slideDown("slow").delay(1000).slideUp("fast");
        }
       

    });
    vaciar();
    
}



function consultarFactura() {

    $("#consulta").slideDown("slow");


    id = $("#id").val();

    $.ajax({
        url: 'convServlet',
        type: 'POST',
        data: {consultarConv: "true", id: id},
        dataType: 'JSON'
    }).done(function (sub) {


        if ((sub.indexOf('fallo') >= 0)) {

            $("#fallo").html("Error en la conversión.");
        } else {


            for (i = 0; i < sub.length; i++) {
                $('#tablaresultado').append(
                        "<tr style='text-align: center'>"

                        + "<td>" + sub[i]['Id'] + "</td>"
                        + "<td>" + sub[i]['Nombre'] + "</td>"
                        + "<td>" + sub[i]['Apellido'] + "</td>"
                        + "<td>" + sub[i]['Correo'] + "</td>"

                        + "<td><input type='checkbox' name='checkbox' id='checkbox" + sub[i]['Id'] + "'><label for='checkbox" + sub[i]['Id'] + "'></label></td>"
                        + "</tr>");
            }
        }

    });

}

function vaciar() {
    $("#nombrecliente").val("");
    $("#apellidocliente").val("");
    $("#telefono").val("");
    $("#correo").val("");
    $("#direccioncliente").val("");

}


function eliminarFactura(id) {
     idconvocatoria= id;
    $.ajax({
        url: 'convServlet',
        type: 'POST',
        data: {eliminarConv: "true", idconvocatoria: id}
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

