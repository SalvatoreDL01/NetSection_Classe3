<%--
  Created by IntelliJ IDEA.
  User: utente
  Date: 20/01/2023
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Sezione Page</title>
</head>
<body>
<link rel="stylesheet" type="text/css" href="css/SezioneStyle.css">
<%@include file="NavBar.jsp" %>
<%for(int i=0;i<4;i++){%>
<div class="discussione">
    <p class="titoloDiscussione">Titolo discussione</p>
    <div class="immagine">
        <img>
    </div>
    <div class="componentiDiscissione">
        <div class="partecipanti">
            <img>
            <p class="componenteTestuale">1234</p>
        </div>
    </div>
    <div class="bottonePartecipazione">
        <%if(true){%>
        <form method="get" action="">
            <input type="hidden" value="sezione">
            <input type="hidden" value="titolo">
            <input type="button" value="visita">
        </form>
        <%}else{%>
        <p class="kickato">Non puoi più accedere</p>
        <%}%>
    </div>
    <div class="testo">
        <div class="tags"><%for(int j=0;j<4;j++){%>tag <%if(j<4){%>,<%}%><%}%></div>
        <p class="creatore">Creato da: creatore</p>
    </div>
</div>
<br>
<%}%>
</body>
</html>
