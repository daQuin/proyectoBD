function menuSesion() {

    var div = document.querySelector("#menuSesion");
    if (div.style.display == "block") {
        div.style.display = "none";
       // div.fadeToggle(500);
    } else {
        div.style.display = "block";
		//div..toggle(500);
    }
}


$("#abierto").toggle(
function(){
$("#menuSesion").fadeToggle(500);

}, function(){
$("#menuSesion").toggle(500);

}
)