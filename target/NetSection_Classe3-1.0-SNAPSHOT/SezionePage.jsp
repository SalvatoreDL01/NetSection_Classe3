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

<div id="sfondo"></div>
<div id="paginaSezione">
    <!-- For per  visualizzare le selezioni (quando saranno implementate dovrà avere un tasto di "mostra altro") -->
    <form method="get" action="CreazioneDiscussioniServlet">
        <input type="hidden" name="sezione" value="idsezione">
        <input type="submit" value="Crea discussione">
    </form>
    <%for(int i=0;i<4;i++){%>
    <div class="discussione">
        <p class="titoloDiscussione">Titolo discussione</p>
        <div class="immagine">
            <img src="css/witcher.jpeg">
        </div>
        <br>
        <div class="componenti">
            <div class="componentiDiscissione">
                <div class="partecipanti">
                    <img src="css/witcher.jpeg">
                    <p class="componenteTestuale", id="numeroPartecipanti">1234</p>
                </div>
            </div>
            <div class="bottonePartecipazione">
                <%if(true){%>
                <form method="get" action="">
                    <input type="hidden" value="sezione">
                    <input type="hidden" value="titolo">
                    <input type="button" value="Partecipa">
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
    </div>
    <br>
    <%}%>
</div>
</body>
</html>
