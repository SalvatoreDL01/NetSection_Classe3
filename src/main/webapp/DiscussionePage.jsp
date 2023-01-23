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
</head>
<body>
<div id="paginaDiscussione">
    <div class="immagine">
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
