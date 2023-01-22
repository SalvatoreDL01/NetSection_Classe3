<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/NavBarStyle.css">
</head>
<body>
<!--barra di navigazione fissa superiore-->
<div id="navBar">
    <!--logo nella barra di navigazione com un link alla homepage-->
    <a class="elementiNavBar" href="###"><img id="imageLogo" class="elementiNavBar" src="css/logo.png"></a>
    <!--form per la ricerca delle sezioni-->
    <form class="elementiNavBar">
        <input type="text" id="ricerca" placeholder="cerca sezione...">
        <!--bottone per la ricerca dei generi-->
        <button type="button" id="bottoreRicerca">RICERCA PER GENERE</button>
    </form>
    <!--link per accesso alla pagina di login-->
    <a class="elementiNavBar" id="login" href="#">LOGIN</a>
</div>
</body>
</html>
