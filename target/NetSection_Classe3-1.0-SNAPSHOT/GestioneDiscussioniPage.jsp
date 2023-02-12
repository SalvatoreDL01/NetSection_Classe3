<%--
  Created by IntelliJ IDEA.
  User: giuseppe
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Gestione Discussioni|NetSection</title>
    <link rel="stylesheet" type="text/css" href="css/GestioneDiscussioniStyle.css">
</head>
<body>
<%@include file="NavBar.jsp"%>
<div id="corpo">

    <!--lista discussioni create dall'utente-->

    <div class="lista">
        <p>Lista discussioni create</p>
        <div class="discussione">
            <div><img class="imgDiscussione" src="css/witcher.jpeg"> </div>
            <div><p>Cosa è successo a Ranucolo?</p><p>data creazione:</p><p> xx/xx/xxxx</p></div>
        </div>
        <div class="discussione">
            <div><img class="imgDiscussione" src="css/witcher.jpeg"> </div>
            <div><p>Cosa è successo a Ranucolo?</p><p>data creazione:</p><p> xx/xx/xxxx</p></div>
        </div>
        <div class="discussione">
            <div><img class="imgDiscussione" src="css/witcher.jpeg"> </div>
            <div><p>Cosa è successo a Ranucolo?</p><p>data creazione:</p><p> xx/xx/xxxx</p></div>
        </div>
        <div class="discussione">
            <div><img class="imgDiscussione" src="css/witcher.jpeg"> </div>
            <div><p>Cosa è successo a Ranucolo?</p><p>data creazione:</p><p> xx/xx/xxxx</p></div>
        </div>
        <div class="discussione">
            <div><img class="imgDiscussione" src="css/witcher.jpeg"> </div>
            <div><p>Cosa è successo a Ranucolo?</p><p>data creazione:</p><p> xx/xx/xxxx</p></div>
        </div>
        <div class="discussione">
            <div><img class="imgDiscussione" src="css/witcher.jpeg"> </div>
            <div><p>Cosa è successo a Ranucolo?</p><p>data creazione:</p><p> xx/xx/xxxx</p></div>
        </div>
    </div>

    <!--listqa discussioni moderate dall'utente-->

    <div class="lista">
        <p>Lista discussioni moderate</p>
        <div class="discussione">
            <div><img class="imgDiscussione" src="css/witcher.jpeg"> </div>
            <div><p>Cosa è successo a Ranucolo?</p><p>data creazione:</p><p> xx/xx/xxxx</p></div>
        </div>
        <div class="discussione">
            <div><img class="imgDiscussione" src="css/witcher.jpeg"> </div>
            <div><p>Cosa è successo a Ranucolo?</p><p>data creazione:</p><p> xx/xx/xxxx</p></div>
        </div>
        <div class="discussione">
            <div><img class="imgDiscussione" src="css/witcher.jpeg"> </div>
            <div><p>Cosa è successo a Ranucolo?</p><p>data creazione:</p><p> xx/xx/xxxx</p></div>
        </div>
    </div>

    <!--div per la visualizzazione dei dati realtivi ad una discussione selezionata-->

    <div id="visualizzazioneDiscussione">
        <div>
            <p>Nome discussione</p>
            <input type="text" value="" style="width: 350px">
        </div>
        <div>
            <p>Immagine</p>
            <img src="css/witcher.jpeg">
            <input type="file" value="scegli file">
        </div>
        <hr style="width: 800px">
        <div>
            <p>Elenco tag</p>
            <textarea cols="50" rows="15">tags</textarea>
        </div>
        <div>
            <div>
                <p>Tag da aggiungere</p>
                <input type="text">
            </div>
            <div>
                <p>Tag da togliere</p>
                <input type="text">
            </div>
        </div>
        <hr style="width: 800px">
        <div>
            <p>Elenco partecipanti</p>
            <div class="partecipante">
                <p>nome</p>
                <button>kick</button>
            </div>
            <div class="partecipante">
                <p>nome</p>
                <button>kick</button>
            </div>
            <div class="partecipante">
                <p>nome</p>
                <button>kick</button>
            </div>
            <div class="partecipante">
                <p>nome</p>
                <button>kick</button>
            </div>
            <div class="partecipante">
                <p>nome</p>
                <button>kick</button>
            </div>
            <div class="partecipante">
                <p>nome</p>
                <button>kick</button>
            </div>
            <div class="partecipante">
                <p>nome</p>
                <button>kick</button>
            </div>
            <div class="partecipante">
                <p>nome</p>
                <button>kick</button>
            </div>
            <div class="partecipante">
                <p>nome</p>
                <button>kick</button>
            </div>
            <div class="partecipante">
                <p>nome</p>
                <button>kick</button>
            </div>
            <div class="partecipante">
                <p>nome</p>
                <button>kick</button>
            </div>
            <div class="partecipante">
                <p>nome</p>
                <button>kick</button>
            </div>
        </div>
        <hr style="width: 800px">
        <div>
            <button>Aggiorna dati</button>
            <button>Elimina discussione</button>
        </div>
    </div>
</div>
</body>
</html>
