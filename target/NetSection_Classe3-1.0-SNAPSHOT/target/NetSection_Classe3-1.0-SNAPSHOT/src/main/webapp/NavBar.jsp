<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/NavBarStyle.css">
    <script type="text/javascript" src="javaScript/HomeScript.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!--Script per i bottoni nascosti-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#ricercaAvanzata").click(function(){
                $("#menuAvanzato").slideToggle('slow');
            });
        });

        $(document).ready(function(){
            $("#searchBar").click(function(){
                $("#menuAvanzato").slideUp('slow');
                $("#freccia").css("transform", "rotate(0deg)");
            });
        });

    </script>

</head>
<body onscroll="barEffect(), hiddenRisultatiAjax(),menuEffect()" onresize="researchEffect()">

<!-- creazione barra di navigazione-->
<div id="navBar">
    <!-- Logo sito-->
    <div id="logo" class="button">
        <a href="index.jsp"><img src="css/pictures/logo.png"></a>
    </div>
    <div id="search">
        <!-- Script ricerca prodotto-->
        <form action="" id="searchBarForm">
            <input type="text" id="searchBar" placeholder="cerca..." onblur="toggleSerch()" onclick="toggleSerch()" onkeyup="ricerca()">
            <!--<input type="submit" id="searchButton" value="       ">-->
        </form>
    </div>
    <!-- Bottone per lo script del menù filtri-->
    <div id="ricercaAvanzata" onclick="ruota('freccia'),hideAjax()">
        <div>Filtra prodotti</div>
        <div id="freccia"><img src="css/pictures/freccia.png"></div>
    </div>
    <!-- Bottone carrello-->
    <a id="carrello" class="button" style="float: right; text-decoration: none" href="CaricaCarrello">
        <img src="css/pictures/carrello.png">

        <img id="numeroCarrello" style="margin-bottom: 20px" src="">
    </a>

    <!-- Bottone login-->
    <div id="login" style="float: right">
        <a href="loginPage.jsp">LOGIN</a>
    </div>
</div>

<!-- creazione menù ricerca avanzata-->



<div id="menu">
    <div id="risultatiAjax">
        <a class="risultato" id="risultato1" href="">gioco</a>
        <a class="risultato" id="risultato2" href="">gioco</a>
        <a class="risultato" id="risultato3" href="">gioco</a>
        <a class="risultato" id="risultato4" href="">gioco</a>
        <a class="risultato" id="risultato5" href="">gioco</a>
        <a class="risultato" id="risultato6" href="">gioco</a>
        <a class="risultato" id="risultato7" href="">gioco</a>
        <a class="risultato" id="risultato8" href="">gioco</a>
        <a class="risultato" id="risultato9" href="">gioco</a>
        <a class="risultato" id="risultato10" href="">gioco</a>
    </div>
</div>
<!-- Selezione filtri-->
<div id="menuAvanzato" >
    <form method="GET" action="RisultatoFiltro">

        <div class="sezione">
            <p class="paragrafiReserch">ricerca piattaforme</p>

        </div>

        <div class="sezione" id="generi">
            <p class="paragrafiReserch" style="text-align: center">ricerca generi</p>


        </div>

        <br>

        <div id="annoPrezzo" class="sezione">
            <input type="submit" id="ricercaavButton" value="cerca">
        </div>

    </form>
</div>

</body>
</html>
