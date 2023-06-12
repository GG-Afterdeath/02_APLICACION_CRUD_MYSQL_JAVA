cambioForm ('logeo', 'registro');

function cambioForm(logeo, registro) {
    var formularios = document.getElementsByTagName("form");

    for (var i = 0; i < formularios.length; i++) {
        formularios[i].style.display = "none";
    }

    document.getElementById(logeo).style.display = "block";
    document.getElementById(registro).style.display = "none";
}

