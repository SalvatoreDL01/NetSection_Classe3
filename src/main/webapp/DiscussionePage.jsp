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
    <form id="formCommento" method="POST" class="commento" action="">

        <input type="hidden" name="idSezione" value="<%=d.getSezione()%>">
        <input type="hidden" name="discussione" value="<%=d.getTitolo() %>">
        <textarea id="testoCommetno" name="commento" placeholder="Scrivi il tuo commento..."></textarea>

        <input id="submitCommento" type="submit" value="Pubblica">
    </form>
    <%for(Commento c: commenti){
        UtenteRegistrato u = utenteRegistratoDAO.doRetriveById(c.getCreatore());
    %>
    <hr>

    <div class="immagineUtente">
        <img src="<%if(u.getImmagine()!=null){%>
                                <%=u.getImmagine()%>
                                    <%}else{%>css/icone/user.png<%}%>">
        <p class="nomeUtente"><%=u.getUsername()%></p
            <img src="css/icone/icons8-su-50.png"><%=c.getPunteggio()%><img src="css/icone/icons8-su-50.png" style="rotate: 180deg">
    </div>
    <p class="commento"><%=c.getContenuto()%></p> <!-- aggiungere immagini punteggio -->
    <div ></div>
    <h6>rispondi</h6>
    <form class="formRisposta" method="POST" class="commento" action="">
        <input type="hidden" name="idSezione" value="<%=c.getDataScrittura()%>">
        <input type="hidden" name="idSezione" value="<%=c.getCreatore()%>">
        <input type="hidden" name="idSezione" value="<%=d.getSezione()%>">
        <input type="hidden" name="discussione" value="<%=d.getTitolo() %>">
        <textarea class="testoRisposta" name="commento" placeholder="Scrivi il tuo commento..."></textarea>

        <input class="submitRisposta" type="submit" value="Pubblica">
    </form>
    <%if(c.getCreatore()==utente.getId())%>
    <h6>modifica</h6>
    <form class="formModifica" method="POST" class="commento" action="">
        <input type="hidden" name="idSezione" value="<%=d.getSezione()%>">
        <input type="hidden" name="discussione" value="<%=d.getTitolo() %>">
        <textarea class="testoModifica" name="commento" placeholder="Scrivi il tuo commento..."></textarea>

        <input class="submitModifica" type="submit" value="Modifica">
    </form>

    <%}%>
</div>
</body>
</html>
