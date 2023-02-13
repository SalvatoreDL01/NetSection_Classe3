<%@ page import="java.util.ArrayList" %>
<%@ page import="ServiziEStorage.Entry.Genere" %>
<%@ page import="ServiziEStorage.DAO.GenereDAO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: chris
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiorna Catalogo</title>
    <link rel="stylesheet" href="css/RegNetStyle.css">
</head>
<body>

<div class="aggiorna-catalogo">
    <h2>Da qui puoi inserire una nuova Sezione:</h2><br><br>
    <form action="/UpdateCatalog">
        <input type="text" id="titolo" name="titolo" value="" placeholder="Titolo..."><br>
        <input type="text" id="descrizione" name="descrizione" value="" placeholder="Descrizione..."><br>
        <input type="text" id="immagine" name="immagine" value="" placeholder="Immagine..."><br><br>
        <label for="scelta">Scegli i generi:</label><br>
        <form id="scelta">
            <input type="checkbox" name="SceltaGenere" value="Animazione">Animazione<br>
            <input type="checkbox" name="SceltaGenere" value="Avventura">Avventura<br>
            <input type="checkbox" name="SceltaGenere" value="Biografico">Biografico<br>
            <input type="checkbox" name="SceltaGenere" value="Cappa e Spada">Cappa e Spade<br>
            <input type="checkbox" name="SceltaGenere" value="Catastrofico">Catastrofico<br>
            <input type="checkbox" name="SceltaGenere" value="Comico">Comico<br>
            <input type="checkbox" name="SceltaGenere" value="Commedia">Commedia<br>
            <input type="checkbox" name="SceltaGenere" value="Drammatico">Drammatico<br>
            <input type="checkbox" name="SceltaGenere" value="Erotico">Erotico<br>
            <input type="checkbox" name="SceltaGenere" value="Fantascienza">Fantascienza<br>
            <input type="checkbox" name="SceltaGenere" value="Fantasy">Fantasy<br>
            <input type="checkbox" name="SceltaGenere" value="Gangaster">Gangster<br>
            <input type="checkbox" name="SceltaGenere" value="Giallo">Giallo<br>
            <input type="checkbox" name="SceltaGenere" value="Guerra">Guerra<br>
            <input type="checkbox" name="SceltaGenere" value="Horror">Horror<br>
            <input type="checkbox" name="SceltaGenere" value="Musicale">Musicale<br>
            <input type="checkbox" name="SceltaGenere" value="Politico-Sociale">Politico-Sociale<br>
            <input type="checkbox" name="SceltaGenere" value="Spionaggio">Spionaggio<br>
            <input type="checkbox" name="SceltaGenere" value="Sportivo">Sportivo<br>
            <input type="checkbox" name="SceltaGenere" value="Storico">Storico<br>
            <input type="checkbox" name="SceltaGenere" value="Teen">Teen<br>
            <input type="checkbox" name="SceltaGenere" value="Western">Western<br>
        </form>
        <br><br>
        <input type="submit" value="Aggiungi Sezione">
    </form>
</div>
</body>
</html>
