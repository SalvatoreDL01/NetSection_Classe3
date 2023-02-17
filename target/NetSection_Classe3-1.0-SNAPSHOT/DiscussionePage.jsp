<%@ page import="ServiziEStorage.Entry.Discussione" %>
<%@ page import="java.util.List" %>
<%@ page import="ServiziEStorage.Entry.Commento" %>
<%@ page import="ServiziEStorage.DAO.UtenteRegistratoDAO" %>
<%@ page import="ServiziEStorage.Entry.UtenteRegistrato" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: utente
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Discussione</title>
    <link rel="icon" type="image/x-icon" href="css/icone/icona.png">
    <link rel="stylesheet" type="text/css" href="css/DiscussionePageStyle.css">
    <link rel="stylesheet" type="text/css" href="css/SezioneStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<%
    UtenteRegistrato utente = (UtenteRegistrato) request.getSession().getAttribute("user");
    Discussione d = (Discussione) request.getAttribute("discussione");
    List<Commento> commenti = (List<Commento>) d.getListaCommenti();
    UtenteRegistratoDAO utenteRegistratoDAO = new UtenteRegistratoDAO();
%>
<%@include file="NavBar.jsp" %>
<div id="paginaDiscussione">
    <div class="immagineDiscussione">
        <img src="<%=d.getImmagine()%>">
    </div>
    <p class="title"><%=d.getTitolo()%></p>

    <hr>
    <%for(Commento c: commenti){
        UtenteRegistrato u = utenteRegistratoDAO.doRetriveById(c.getCreatore());
    %>
    <hr>
    <!-- form per immagine utente -->
    <div class="immagineUtente" style="color: aliceblue">
        <img style="float:left;" src="<%if(u.getImmagine()!=null){%>
                                <%=u.getImmagine()%>
                                    <%}else{%>css/icone/user.png<%}%>">
        <p style="float:left;" class="nomeUtente"><%=u.getUsername()%></p>
        <p style="float:left;width: 80%" class="commento"><%=c.getContenuto()%></p> <!-- aggiungere immagini punteggio -->
           <a href="VotoCommentoController?data=<%=c.getDataScrittura()%>&creatore=<%=c.getCreatore()%>&idSezione=<%=d.getSezione()%>&discussione=<%=d.getTitolo()%>"><img src="css/icone/mipiace.png"></a><%=c.getPunteggio()%>
        <a href="VotoCommentoController?data=<%=c.getDataScrittura()%>&creatore=<%=c.getCreatore()%>&idSezione=<%=d.getSezione()%>&discussione=<%=d.getTitolo()%>&dec=si"><img src="css/icone/mipiace.png" style="rotate: 180deg"></a>
    </div>
    <br>
    <!-- form per segnalazione -->
    <%if(utente.getId()!=u.getId()){%>
    <form id="segnala" method="post" action="SegnalazioneCommentoController">
        <br>
        <input type="hidden" value="<%=d.getSezione()%>" name="idSezione">
        <input type="hidden" value="<%=d.getTitolo()%>" name="titolo">
        <input type="hidden" value="<%=c.getDataScrittura()%>" name="dataSegnalato">
        <input type="hidden" value="<%=c.getCreatore()%>" name="creatoreSegnalato">
        <input class="natura" type="text" name="natura" placeholder="natura segnalazione"><br><br>
        <textarea class=segnalaText id="segnalaText" name="contenuto" placeholder="scrivi la motivazuione"></textarea><br><br>
        <input type="submit" value="Segnala Utente">
    </form>
<%}%>
    <br>
    <br>
    <!-- form per commento -->
    <div class="commento">
        <form id="formCommento" class="commento" action="AggiungiCommento">

            <input type="hidden" name="idSezione" value="<%=d.getSezione()%>">
            <input type="hidden" name="discussione" value="<%=d.getTitolo() %>">
            <textarea id="testoCommetno" name="commento" placeholder="Scrivi il tuo commento..."></textarea>
            <br><br>
            <input id="submitCommento" type="submit" value="Pubblica"><br><br>
        </form>
        <p></p>
    </div>

</div>
<script>
    function validateKickForm(){
        let m= document.getElementById("mot").value;
        if(m<10 || m>255){
            alert("Dai una breve motivazione!");
            return false;
        }
        return true;
    }
</script>
<div>
</div>
<footer>
    <%if(d.getListaModeratori().contains(utente)){%>
    <div class="elect-mod-button">
        <form action="ElectModController" method="get" onsubmit="return (validateElect());">
            <label for="userToElect" style="color: white">Inserisci l'ID dell'utente che vuoi eleggere:</label><br>
            <input type="number" id="userToElect" name="userToElect" placeholder="Utente da eleggere..."><br>
            <input type="hidden" id="hidden" style="color: red" value=""><br><br>
            <input type="submit" id="Eleggi" value="electButton"><br>
        </form>
    </div>

    <div class="ges-disc-button">
        <form action="GestioneDiscussioneController" method="post">
            <input type="hidden" name="sezione" value="<%=d.getSezione()%>">
            <input type="hidden" name="titolo" value="<%=d.getTitolo()%>">
            <input type="submit" value="Gestisci discussioni"><br>
        </form>
    </div>
    <%}%>
</footer>
</body>
</html>
