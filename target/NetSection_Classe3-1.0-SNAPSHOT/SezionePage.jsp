<%@ page import="ServiziEStorage.Entry.Sezione" %>
<%@ page import="ServiziEStorage.Entry.Discussione" %>
<%@ page import="java.util.List" %>
<%@ page import="ServiziEStorage.Entry.UtenteRegistrato" %><%--
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
<%
    Sezione s = (Sezione) request.getAttribute("sezione");
    List<Discussione> lDiscussione = (List<Discussione>) s.getListaDiscussioni();
    UtenteRegistrato utente = (UtenteRegistrato) request.getSession().getAttribute("user");
%>
<div id="sfondo" tyle="background-image: url(<%=s.getImmagine()%>)"></div>
<div id="paginaSezione">
    <div id="ricercaFiltrata">
        <div id="bottoneRicerca">
            RicercaFiltrata
        </div>
        <form action="" method="POST">
            <input type="hidden" name="idSezione" value="<%=s.getIdSezione()%>">
        </form>
    </div>
    <!-- For per  visualizzare le selezioni (quando saranno implementate dovrà avere un tasto di "mostra altro") -->
    <form method="get" action="CreazioneDiscussioniControl">
        <input type="hidden" name="sezione" value="idsezione">
        <input type="submit" value="Crea discussione">
    </form>
    <%for(Discussione d: lDiscussione){%>
    <div class="discussione">
        <p class="titoloDiscussione"><%=d.getTitolo()%></p>
        <div class="immagine">
            <img src="<%=d.getImmagine()%>">
        </div>
        <br>
        <div class="componenti">
            <div class="componentiDiscissione">
                <div class="partecipanti">
                    <img src="css/icone/gruppo.png">
                    <p class="componenteTestuale", id="numeroPartecipanti"><%=d.getListaIscritti().size()%></p>
                </div>
            </div>
            <div class="bottonePartecipazione">
                <%if(utente!=null && !d.getListaIscritti().contains(utente) && !d.getListaKickati().contains(utente)){%>
                <form method="get" action="/SubscribeController">
                    <input type="hidden" value="sezione">
                    <input type="hidden" value="titolo">
                    <input type="button" value="Partecipa">
                </form>
                <%}else{ if(d.getListaKickati().contains(utente))%>
                <p class="kickato">Non puoi più accedere</p>
                <%}%>
            </div>
            <div class="testo">
                <div class="tags"><%for(int j=0;j<4;j++){%><%=d.getListaTag().get(j)%>,<%}%>...</div>
            </div>
        </div>
    </div>
    <br>
    <%}%>
</div>
</body>
</html>
