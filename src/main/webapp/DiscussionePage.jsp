<%--
  Created by IntelliJ IDEA.
  User: utente
  Date: 23/01/2023
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Discussione</title>
    <link rel="stylesheet" type="text/css" href="css/DiscussionePageStyle.css">
    <link rel="stylesheet" type="text/css" href="css/SezioneStyle.css">
</head>
<body>
<%@include file="NavBar.jsp" %>
<div id="paginaDiscussione">
    <div class="immagineDiscussione">
        <img src="css/witcher.jpeg">
    </div>
    <p class="title">Nome Discussione</p>
    <%for(int i=0;i<4;i++){%>
    <hr>
    <div class="immagineUtente">
    </div>
    <p class="commento">Nome Discussione</p> <!-- aggiungere immagini punteggio -->
    <h6>rispondi</h6>
    <%//aggiungere meccanismo per risposte%>
    <%}%>
</div>
</body>
</html>
