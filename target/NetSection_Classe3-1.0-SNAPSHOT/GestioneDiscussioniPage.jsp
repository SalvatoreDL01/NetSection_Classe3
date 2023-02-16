<%@ page import="ServiziEStorage.DAO.UtenteRegistratoDAO" %>
<%@ page import="ServiziEStorage.Entry.*" %><%--
  Created by IntelliJ IDEA.
  User: giuseppe
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Gestione Discussioni|NetSection</title>
    <link rel="icon" type="image/x-icon" href="css/icone/icona.png">
    <link rel="stylesheet" type="text/css" href="css/GestioneDiscussioniStyle.css">
</head>
<body>
<%@include file="NavBar.jsp"%>

<%
    UtenteRegistrato utente = (UtenteRegistrato) request.getSession().getAttribute("user");
    UtenteRegistratoDAO utenteRegistratoDAO = new UtenteRegistratoDAO();
    Discussione discussione = (Discussione) request.getAttribute("discussione");
    List<Segnalazione> listaSegnalazione = (List<Segnalazione>) request.getAttribute("segnalazioni");
    List<Commento> commenti = (List<Commento>) request.getAttribute("commenti");
    List<UtenteRegistrato> utenti = (List<UtenteRegistrato>) request.getAttribute("utenti");
%>
<div id="corpo">

    <div class="mod">
        <p>Lista discussioni moderate:</p>
    <!--lista discussioni create dall'utente-->
    <%
        List<Discussione> lista= (List<Discussione>) utente.getListaModerazioni();
        for (Discussione d: lista) {
    %>
        <div class="discussione-moderata">
            <div><img class="imgDiscussione" src="css/witcher.jpeg"> </div>
            <div><p><% d.getTitolo(); %></p><p>creata da:</p><p><% d.getCreatore(); %></p></div>
        </div>
    </div>
    <% } %>

    <!--div per la visualizzazione dei dati realtivi ad una discussione selezionata-->

    <div id="visualizzazioneDiscussione">
        <div>
            <p><% discussione.getTitolo(); %></p>
        </div>
        <div>
            <p>Immagine</p>
            <img src='<% discussione.getImmagine(); %>'>
        </div>
        <hr style="width: 800px">
        <div>
            <p>Elenco tag</p>
            <textarea cols="50" rows="15"><% discussione.getListaTag(); %></textarea>
        </div>
        <hr style="width: 800px">
        <div>
            <p>Elenco partecipanti</p>
            <%
            List<UtenteRegistrato> listu= (List<UtenteRegistrato>) discussione.getListaIscritti();
                for (UtenteRegistrato u: listu) {
            %>
            <div class="partecipante">
                <form action="KickUser" method="get">
                    <p>ID: <% u.getId(); %></p>
                    <p>Nome: <% u.getUsername(); %></p
                    <input type="submit" id="kick-button" value="KICK">
                </form>
            </div>
            <% } %>
        </div>
        <h2>Segnalazioni</h2>
        <%for(int i=0; i<listaSegnalazione.size();i++){%>
        <p><%=utenti.get(i).getUsername()%></p>
        <p><%=commenti.get(i).getContenuto()%></p>
        <p><%=listaSegnalazione.get(i).getNatura()%></p>
        <p><%=listaSegnalazione.get(i).getContenuto()%></p>
        <form action="DeleteCommentController" method="post">
            <input type="hidden" name="idCreatore" value="<%=commenti.get(i).getCreatore()%>">
            <input type="hidden" name="dataCommento" value="<%=commenti.get(i).getDataScrittura()%>">
            <input type="submit" value="Cancella commento">
        </form>
        <%}%>
        <hr style="width: 800px">
    </div>
</div>
</body>
</html>
