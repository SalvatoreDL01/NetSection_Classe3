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
    Discussione discussione = (Discussione) request.getAttribute("discussione");
    List<Segnalazione> listaSegnalazione = (List<Segnalazione>) request.getAttribute("segnalazioni");
    List<Commento> commenti = (List<Commento>) request.getAttribute("commentiSegnalati");
    List<UtenteRegistrato> utenti = (List<UtenteRegistrato>) request.getAttribute("utenti");
    UtenteRegistrato user = (UtenteRegistrato) request.getSession().getAttribute("user");
%>
<div id="corpo">

    <div class="mod">
        <p>Lista discussioni moderate:</p>

    <!--div per la visualizzazione dei dati realtivi ad una discussione selezionata-->

    <div id="visualizzazioneDiscussione">
        <div>
            <p><%= discussione.getTitolo()%></p>
        </div>
        <div id="divImmagine">
            <p>Immagine</p>
            <img id="immagineDiscussione" src='<%= discussione.getImmagine()%>'>
        </div>
        <hr style="width: 800px">
        <div>
            <p>Elenco partecipanti</p>
            <%
            List<UtenteRegistrato> listu= (List<UtenteRegistrato>) discussione.getListaIscritti();
                for (UtenteRegistrato u: listu) { if(!user.equals(u)){
            %>
            <div class="partecipante">
                <form action="KickUser" method="get">
                    <p>ID: <%= u.getId() %></p>
                    <p>Nome: <%= u.getUsername() %></p>
                    <input type="hidden" name="kick" value="<%=u.getId()%>">
                    <input type="hidden" name="sezione" value="<%=discussione.getSezione()%>">
                    <input type="hidden" name="discussione" value="<%=discussione.getTitolo()%>">
                    <input type="submit" id="kick-button" value="KICK">
                </form>
            </div>
            <% }} %>
        </div>
        <div>
            <hr>
        <!-- display per la visualizzazione delle segnalazioni -->
        <h2>Segnalazioni</h2>
        <%if(!listaSegnalazione.isEmpty())%>
        <%for(int i=0; i<listaSegnalazione.size();i++){%>
            <hr>
        <p><%=utenti.get(i).getUsername()%></p>
        <p><%=commenti.get(i).getContenuto()%></p>
        <p><%=listaSegnalazione.get(i).getNatura()%></p>
        <p><%=listaSegnalazione.get(i).getContenuto()%></p>
        <form action="DeleteCommentController" method="post">
            <input type="hidden" name="sezione" value="<%=discussione.getSezione()%>">
            <input type="hidden" name="discussione" value="<%=discussione.getTitolo()%>">
            <input type="hidden" name="idCreatore" value="<%=commenti.get(i).getCreatore()%>">
            <input type="hidden" name="dataCommento" value="<%=commenti.get(i).getDataScrittura()%>">
            <input type="submit" value="Cancella commento">
        </form>
        <%}%>
        <hr style="width: 800px">
            </div>
    </div>
</div>
</div>
</body>
</html>
