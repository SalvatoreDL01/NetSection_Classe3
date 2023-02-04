<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/NavBarStyle.css">
    <script type="text/javascript" src="javaScript/NavBar.js"></script>
</head>
<body>
<!--barra di navigazione fissa superiore-->
<div id="navBar">
    <!--logo nella barra di navigazione com un link alla homepage-->
    <a class="elementiNavBar" href="/index.jsp"><img id="imageLogo" class="elementiNavBar" src="css/logo.png"></a>
    <!--form per la ricerca delle sezioni-->
    <form class="elementiNavBar">
        <input type="text" id="ricerca" placeholder="cerca sezione...">
        <!--bottone per la ricerca dei generi-->
        <button type="button" id="bottoreRicerca" onclick="mostraMenu()">RICERCA PER GENERE</button>
    </form>
    <!--link per accesso alla pagina di login-->
    <%
        String str;
        if(session.getAttribute("user") != null)
            str = "UserPage.jsp";
        else
            str = "LoginPage.jsp";
    %>
    <a class="elementiNavBar" id="login" href="<%=str%>"><%=request.getAttribute("login")%></a>
</div>
<div id="ricercaGeneri">
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <div class="genere">
        genere
    </div>
    <button style="margin-left: 50px; margin-top: 10px">Cerca</button>
</div>
</body>
</html>
