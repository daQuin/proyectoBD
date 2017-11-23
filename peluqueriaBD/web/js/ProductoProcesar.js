
function registrarProducto() {
    nombre = $("#nombreservicio").val();
    descripcion = $("#textArea").val();
    cantidad = $("#cantidadproducto").val();
    valor = $("#valorproducto").val();
    
    $.ajax({
        url: 'productoServlet',
        type: 'POST',
        data: {crearProducto: "true", nombre: nombre, descripcion: descripcion, cantidad: cantidad, valor: valor}
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





function consultarConv() {

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
    $("#fechainicio").val("");
    $("#fechafin").val("");
    $("#tipo").val("");
    $("#fechainiciovisita").val("");
    $("#fechafinvisita").val("");
    $("#cupos").val("");
    $("#inversionestudiante").val("");
    $("#nombreEmpresa").val("");
    $("#ciudad").val("");
    $("#direccion").val("");

}


function eliminarProducto(id) {
     idconvocatoria= id;
    $.ajax({
        url: 'productoServlet',
        type: 'POST',
        data: {eliminarProd: "true", idproducto: id}
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


function ActualizarConv(id) {
    idConv= id;
    fechainicio = $("#fechainicio").val();
    fechafin = $("#fechafin").val();
    tipo = $("#tipo").val();
    fechainiciovisita = $("#fechainiciovisita").val();
    fechafinvisita = $("#fechafinvisita").val();
    cupos = $("#cupos").val();
    invercionestudiante = $("#inversionestudiante").val();
    nombreempresa = $("#nombreempresa").val();
    ciudad = $("#ciudad").val();
    direccion = $("#direccion").val();
    pais = $("#pais").val();

    $.ajax({
        url: 'convServlet',
        type: 'POST',
        data: {ActualizarConv: "true", idConv:idConv, fechainicio: fechainicio, fechafin: fechafin, tipo: tipo, fechainiciovisita: fechainiciovisita,
            fechafinvisita: fechafinvisita, cupos: cupos, invercionestudiante: invercionestudiante, nombreempresa: nombreempresa, pais: pais, ciudad: ciudad, direccion: direccion}
    }).done(function (sub) {

        if ((sub.indexOf('exito') >= 0)) {
            $("#msj").html("<br> Actuaizacion Exitosa");
            $("#msj").slideDown("slow").delay(1000).slideUp("fast");

        } else {
            $("#msj").html("<br> Error de registro");
            $("#msj").slideDown("slow").delay(1000).slideUp("fast");
        }
        vaciar();

    });
}