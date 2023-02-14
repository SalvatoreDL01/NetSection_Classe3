<%@ page import="ServiziEStorage.Entry.UtenteRegistrato" %>
<%@ page import="ServiziEStorage.DAO.GenereDAO" %>
<%@ page import="ServiziEStorage.Entry.Genere" %>
<%@ page import="java.util.List" %>
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
    <a class="elementiNavBar" href="index.jsp"><img id="imageLogo" class="elementiNavBar" src="css/logo.png"></a>
    <!--form per la ricerca delle sezioni-->
    <form class="elementiNavBar" action="RicercaSezioneControl">
        <input type="text" id="ricerca" name="nomeSezione" placeholder="cerca sezione...">
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
        String nome = "";
        if(session.getAttribute("user") != null)
            nome = ((UtenteRegistrato) session.getAttribute("user")).getUsername();
        else nome = "LOGIN";
    %>
    <a class="elementiNavBar" id="login" href="<%=str%>"><%=nome%></a>
</div>
<div id="ricercaGeneri">
    <form action="RicercaGenere">
        <input type="submit" name="nome" class="genere" value="animazione" style="background-color: #0a1316; color: aliceblue">
    </form>
    <form action="RicercaGenere">
        <input type="submit" name="nome" class="genere" value="avventura" style="background-color: #0a1316; color: aliceblue">
    </form>
    <form action="RicercaGenere">
        <input type="submit" name="nome" class="genere" value="biografico" style="background-color: #0a1316; color: aliceblue">
    </form>
    <form action="RicercaGenere">
        <input type="submit" name="nome" class="genere" value="comico" style="background-color: #0a1316; color: aliceblue">
    </form>
    <form action="RicercaGenere">
        <input type="submit" name="nome" class="genere" value="commedia" style="background-color: #0a1316; color: aliceblue">
    </form>
    <form action="RicercaGenere">
        <input type="submit" name="nome" class="genere" value="drammatico" style="background-color: #0a1316; color: aliceblue">
    </form>
    <form action="RicercaGenere">
        <input type="submit" name="nome" class="genere" value="fantascienza" style="background-color: #0a1316; color: aliceblue">
    </form>
    <form action="RicercaGenere">
        <input type="submit" name="nome" class="genere" value="animazione" style="background-color: #0a1316; color: aliceblue">
    </form>
</div>
</body>
</html>
