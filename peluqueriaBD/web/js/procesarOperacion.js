/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    buscarCon();

});

function buscarCon() {

    $("#consulta").slideDown("slow");



    $.ajax({
        url: 'convServlet',
        type: 'POST',
        data: {seleccionasistentes: "true"},
        dataType: 'JSON'
    }).done(function (sub) {


        if ((sub.indexOf('fallo') >= 0)) {

            $("#fallo").html("Error en la conversión.");
            $("#msj").html("<br> Error de registro");
            $("#fallo").slideDown("slow").delay(1000).slideUp("fast");
        } else {

            for (i = 0; i < sub.length; i++) {
                $("#msj").html("<br> exito de registro");
                $("#msj").slideDown("slow").delay(1000).slideUp("fast");
                $('#tablaresultado').append(
                        "<tr style='text-align: center'>"

                        + "<td>" + sub[i]['Id'] + "</td>"
                        + "<td>" + sub[i]['Nombre'] + "</td>"
                        + "<td>" + sub[i]['Apellido'] + "</td>"
                        + "<td>" + sub[i]['Correo'] + "</td>"
                        + "<td>" + sub[i]['Semestre'] + "</td>"


                        + "<td><input type='checkbox' value='" + sub[i]['Id'] + "' name='checkbox' id='checkbox" + sub[i]['Id'] + "'><label for='checkbox" + sub[i]['Id'] + "'></label></td>"
                        + "</tr>");
            }
        }

    });
}

function enviarBoton() {
    var listaAsistentes = document.getElementsByName("checkbox");
    var auxiliar = "";
    for (var i = 0; i < listaAsistentes.length; i++) {
        if (listaAsistentes[i].checked) {
            auxiliar += listaAsistentes[i].value + ",";
        }
    }
    $("#formagregar").submit("admin.jsp");
    $.ajax({
        url: 'convServlet',
        type: 'POST',
        data: {asistentesSeleccionados: auxiliar},
        dataType: 'JSON',
        error: function () {
//            console.log("error");
            window.location.href = "admin.jsp";
        }
    }).success(function (sub) {
        console.log("wejnjsdfsd");
        window.location.href = "admin.jsp";
//          window.location.href="admin.jsp";



    });
}


function cerrarCon() {


    $("#consulta").slideUp("fast");


}


function iniciarSesion() {
    usuario = $("#usu").val();
    pass = $("#pass").val();


    $.ajax({
        url: 'inisioSesion',
        type: 'POST',
        data: {iniSesion: "true", usuario: usuario, pass: pass}
    }).done(function (sub) {

        if ((sub.indexOf('exito') >= 0)) {
            window.location = "admin.jsp";


        } else {
            $("#msjInicio").html("<br> Error de inicio");
            $("#msjInicio").slideDown("slow").delay(1000).slideUp("fast");
        }


    });
}