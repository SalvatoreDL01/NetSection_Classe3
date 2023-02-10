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
<h1>AGGIUNGI DISCUSSIONE</h1>
<!--visualizzazione del messaggio per dare conferma dell'aggiunta-->
<div id="dati">

    <!--form per l'aggiunta di una discussione-->
    <form id="formDiscussione" action="" method="POST" enctype="multipart/form-data" >

        <div id="gioco" class="forms">
            <label for="titolo">Titolo discussione</label><br>
            <input type="text" id="titolo" name="titolo" placeholder="Titolo discussione"><br>
            <p>Carica immagine</p>
            <label id="labl1" class="custom-file-upload">
                <input type="file" name="immagine" accept=".jpg, .jpeg, .png" multiple>
                Aggiungi
            </label>
            <br><br>
            <label for="tags" id="textLable">Seleziona tag</label><br>
            <textarea id="tags" name="tags" placeholder="@NomeTAG, @NomeTAG2..."></textarea><br>
            <div id="bottoneGioco">
                <input type="submit" value="Aggiungi gioco">
            </div>

        </div>

    </form>


</div>
</body>
</html>
