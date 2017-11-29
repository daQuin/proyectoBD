
function registrarProducto() {
    nombre = $("#nombreproducto").val();
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

function vaciar() {
    $("#nombreproducto").val("");
    $("#textArea").val("");
    $("#cantidadproducto").val("");
    $("#valorproducto").val("");
    

}

function ActualizarProducto(id) {
    nombre = $("#nombreproducto").val();
    valor = $("#valorproducto").val(); 
    descripcion = $("#textArea").val();
    cantidad=$("#cantidadproducto").val();
    $.ajax({
        url: 'productoServlet',
        type: 'POST',
        data: {actualizarProducto: "true", id: id, nombre: nombre,valor: valor, descripcion: descripcion,cantidad:cantidad}
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