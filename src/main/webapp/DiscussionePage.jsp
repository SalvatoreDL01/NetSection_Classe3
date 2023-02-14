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
    <link rel="stylesheet" type="text/css" href="css/DiscussionePageStyle.css">
    <link rel="stylesheet" type="text/css" href="css/SezioneStyle.css">
</head>
<body>
<%
    UtenteRegistrato utente = (UtenteRegistrato) request.getSession().getAttribute("user");
    Discussione d = (Discussione) request.getAttribute("discussione");
    List<Commento> commenti = (List<Commento>) d.getListaCommenti();
    UtenteRegistratoDAO utenteRegistratoDAO = new UtenteRegistratoDAO();
%><!--
<div class="elect-mod-button">
    <form>
        <label for="userToElect">Inserisci l'ID dell'utente che vuoi eleggere:</label>
        <input type="text" id="userToElect" name="userToElect" placeholder="Utente da eleggere..."><br><br>
        <input type="submit" id="Eleggi" name="electButton"><br>
    </form>
</div> -->
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

    <div class="immagineUtente" style="color: aliceblue">
        <img style="float:left;" src="<%if(u.getImmagine()!=null){%>
                                <%=u.getImmagine()%>
                                    <%}else{%>css/icone/user.png<%}%>">
        <p style="float:left;" class="nomeUtente"><%=u.getUsername()%></p>
        <p style="float:left;width: 80%" class="commento"><%=c.getContenuto()%></p> <!-- aggiungere immagini punteggio -->
           <a href="VotoCommentoController?data=<%=c.getDataScrittura()%>&creatore=<%=c.getCreatore()%>&idSezione=<%=d.getSezione()%>&discussione=<%=d.getTitolo()%>"><img src="css/icone/mipiace.png"></a><%=c.getPunteggio()%><a><img src="css/icone/mipiace.png" style="rotate: 180deg"></a>
    </div>
<%}%>
    <form id="formCommento" class="commento" action="AggiungiCommento">

        <input type="hidden" name="idSezione" value="<%=d.getSezione()%>">
        <input type="hidden" name="discussione" value="<%=d.getTitolo() %>">
        <textarea id="testoCommetno" name="commento" placeholder="Scrivi il tuo commento..."></textarea>

        <input id="submitCommento" type="submit" value="Pubblica">
    </form>
    <!--
    <h6>rispondi</h6>
    <form class="formRisposta" method="POST" class="commento" action="">
        <input type="hidden" name="idSezione" value=">
        <input type="hidden" name="idSezione" value="">
        <input type="hidden" name="idSezione" value="<%=d.getSezione()%>">
        <input type="hidden" name="discussione" value="<%=d.getTitolo() %>">
        <textarea class="testoRisposta" name="commento" placeholder="Scrivi il tuo commento..."></textarea>


       <input class="submitRisposta" type="submit" value="Pubblica">-->
    <p></p>
</div>
</body>
</html>
