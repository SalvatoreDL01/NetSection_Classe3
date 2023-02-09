<%--
  Created by IntelliJ IDEA.
  User: utente
  String: 05/02/2023
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/CreazioneDiscussionePageStyle.css">
</head>
<body>
<h1>AGGIUNGI SEZIONE</h1>
<!--visualizzazione del messaggio per dare conferma dell'aggiunta-->
<div id="dati">

    <!--form per l'aggiunta di una Sezione-->
    <form id="formSezione" action="UpdateCatalogController" method="POST">

        <div id="gioco" class="forms">
            <label for="titolo">Titolo Sezione</label><br>
            <input type="text" id="titolo" name="titolo" placeholder="Titolo Sezione"><br>
            <label for="descrizione" id="textLable">Descrizione</label><br>
            <textarea id="descrizione" name="descrizione" placeholder="Descrizione..."></textarea><br>
            <p>Carica immagine</p>
            <label id="labl1" class="custom-file-upload">
                <input type="file" name="immagine" multiple oninput="" >
                Aggiungi
            </label>
            <p>Seleziona generi</p>
            <div id="generi">
                <input type="checkbox" value="animazione" id="animazione" name="c1">
                <label for="animazione">Animazione</label>
                <input type="checkbox" value="avventura" id="avventura" name="c2">
                <label for="avventura">Avventura</label>
                <input type="checkbox" value="biografico" id="biografico" name="c3">
                <label for="biografico">Biografico</label>
                <input type="checkbox" value="cappa e spada" id="cappaESpada" name="c4">
                <label for="cappaESpada">Cappa e spada</label><br>
                <input type="checkbox" value="catastrofico" id="catastrofico" name="c5">
                <label for="catastrofico">Catastrofico</label>
                <input type="checkbox" value="comico" id="comico" name="c6">
                <label for="comico">Comico</label>
                <input type="checkbox" value="commedia" id="commedia" name="c7">
                <label for="commedia">Commedia</label>
                <input type="checkbox" value="drammatico" id="drammatico" name="c8">
                <label for="drammatico">Drammatico</label><br>
                <input type="checkbox" value="erotico" id="erotico" name="c9">
                <label for="erotico">Erotico</label>
                <input type="checkbox" value="fantascienza" id="fantascienza" name="c10">
                <label for="fantascienza">Fantascienza</label>
                <input type="checkbox" value="fantasy" id="fantasy" name="c11">
                <label for="fantasy">Fantasy</label>
                <input type="checkbox" value="gangster" id="gangster" name="c12">
                <label for="gangster">Gangster</label><br>
                <input type="checkbox" value="giallo" id="giallo" name="c13">
                <label for="giallo">Giallo</label>
                <input type="checkbox" value="guerra" id="guerra" name="c14">
                <label for="guerra">Guerra</label>
                <input type="checkbox" value="horror" id="horror" name="c15">
                <label for="horror">Horror</label>
                <input type="checkbox" value="musicale" id="musicale" name="c16">
                <label for="musicale">Musicale</label><br>
                <input type="checkbox" value="politco-sociale" id="politco-sociale" name="c17">
                <label for="politco-sociale">Politco-sociale</label>
                <input type="checkbox" value="spionaggio" id="spionaggio" name="c18">
                <label for="spionaggio">Spionaggio</label>
                <input type="checkbox" value="sportivo" id="sportivo" name="c19">
                <label for="sportivo">Sportivo</label>
                <input type="checkbox" value="storico" id="storico" name="c20">
                <label for="storico">Storico</label><br>
                <input type="checkbox" value="western" id="western" name="c21">
                <label for="western">Western</label>
                <input type="checkbox" value="teen" id="teen" name="c22">
                <label for="teen">Teen</label>
            </div>
            <br><br>
            <div id="bottoneGioco">
                <input type="submit" value="Aggiungi gioco">
            </div>

        </div>

    </form>


</div>
</body>
</html>
