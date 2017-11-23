
function inscribirce() {
    nombre = $("#nombrecliente").val();
    apellido = $("#apellidocliente").val();
    tel = $("#telefono").val();
    correo = $("#correo").val();
    direccion = $("#direccioncliente").val();
   

    $.ajax({
        url: 'clienteServlet',
        type: 'POST',
        data: {inscribirce: "true", nombre: nombre, apellido: apellido, tel: tel, correo: correo, direccion: direccion}
    }).done(function (sub) {

        if ((sub.indexOf('exito') >= 0)) {
            $("#msj2").html("<br> Registro Exitoso");
            $("#msj2").slideDown("slow").delay(1000).slideUp("fast");
            $("#cerrar").click();
        } else {
            $("#msj").html("<br> Registro Erroneo  " + idcon+".");
            $("#msj").slideDown("slow").delay(1000).slideUp("fast");
        }
       

    });
    vaciar();
    
}

function vaciar() {
    $("#nombre").val("");
    $("#apellido").val("");
    $("#cod").val("");
    $("#correo").val("");
    $("#semestre").val("");
    

}


function consultarAsist() {

    conv = $("#idConv").val();


    $.ajax({
        url: 'AsistServlet',
        type: 'POST',
        data: {consultarAsist: "true", conv: conv},
        dataType: 'JSON'
    }).done(function (sub) {


        if ((sub[0] == undefined)) {

            $("div").remove("#fallo1");
            $('#fallo').append("<div id='fallo1'><font color='red'>" + 'No se encuentraron datos' + "</font></h3>");

        } else if (sub[0]['ErrorFalta'] == "ErrorFalta") {

            $('#fallo').append("<div id='fallo1'><font color='red'>" + 'Faltan fechas por seleccionar' + "</font></h3>");

        } else {

            $('#tablaconsultar').append("<table id='tabla2' > <tr ><th> <font color='#0ac986'>"
                    + 'Id' + "</font></th><th> <font color='#0ac986'>"
                    + 'Descripción' + "</font></th><th><font color='#0ac986'>"
                    + 'Fecha' + "</font></th><th><font color='#0ac986'>"
                    + 'Hora' + "</th></font></tr>"
                    + " </table>");

            for (i = 0; i < sub.length; i++) {
                $('#tabla2').append("<tr ><td>"
                        + sub[i]['Id'] + "</td><td>"
                        + sub[i]['Descripcion'] + "</td><td>"
                        + sub[i]['Fecha'] + "</td><td>"
                        + sub[i]['Hora'] + "</td></tr>");

            }
        }

    });
}
