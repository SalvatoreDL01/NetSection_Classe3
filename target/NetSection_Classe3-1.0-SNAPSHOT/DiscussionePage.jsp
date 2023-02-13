<%@ page import="ServiziEStorage.Entry.Discussione" %>
<%@ page import="java.util.List" %>
<%@ page import="ServiziEStorage.Entry.Commento" %>
<%@ page import="ServiziEStorage.DAO.UtenteRegistratoDAO" %>
<%@ page import="ServiziEStorage.Entry.UtenteRegistrato" %><%--
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
    <%//aggiungere meccanismo per risposte%>
    <%}%>
</div>
</body>
</html>
