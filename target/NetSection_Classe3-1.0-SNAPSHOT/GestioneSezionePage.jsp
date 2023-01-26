<%--
  Created by IntelliJ IDEA.
  User: giuseppe
  Date: 23/01/23
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Gestione Sezione|NetSection</title>
    <link type="text/css" rel="stylesheet" href="css/GestioneSezioneStyle.css">
    <link rel="stylesheet" type="text/css" href="css/GestioneDiscussioniStyle.css">
</head>
<body>
<%@ include file="NavBar.jsp"%>
<form>
<div id="corpo">
    <div class="elemento">
        Modifica nome<br>
        <input type="text">
    </div>
    <div class="elemento">
        modifica immagine<br>
        <input type="file">
    </div>
    <div class="elemento">
        modifica descrizione<br>
        <textarea rows="10" cols="30"></textarea>
    </div>
    <div class="elemento">
        <div class="lista" style="overflow: scroll; height: 300px">
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
    </div>
    <div class="elemento">
        Modifica generi<br>
        <input type="checkbox" id="genere1" name="genere1" value="genere1">
        <label for="genere1">genere1</label><br>
        <input type="checkbox" id="genere2" name="genere2" value="genere2">
        <label for="genere2">genere2</label><br>
        <input type="checkbox" id="genere3" name="genere3" value="genere3">
        <label for="genere3">genere3</label><br>
    </div>
    <div class="elemento">
        <input type="submit">
    </div>
</div>
</form>
</body>
</html>
