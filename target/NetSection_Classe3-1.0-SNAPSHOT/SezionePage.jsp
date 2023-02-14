<%@ page import="ServiziEStorage.Entry.Sezione" %>
<%@ page import="ServiziEStorage.Entry.Discussione" %>
<%@ page import="java.util.List" %>
<%@ page import="ServiziEStorage.Entry.UtenteRegistrato" %>
<%@ page import="ServiziEStorage.Entry.UtenteNetflix" %><%--
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
<div id="sfondo" tyle="background-image: url(<%=s.getImmagine()%>),background-repeat: no-repeat,background-size: 100%, width: 100%,height: 650px,left:0px,top:0px,position:absolute,z-index: 3"></div>
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

    <form method="get" action="CreaDiscussioneController">
        <input type="hidden" name="sezione" value="<%=s.getIdSezione()%>">
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
                <form method="get" action="SubscribeController">
                    <input type="hidden" name="sezione" value="<%=s.getIdSezione()%>">
                    <input type="hidden" name="titolo" value="<%=d.getTitolo()%>">
                    <input type="submit" value="Iscriviti">
                </form>
                <%}else{ if(d.getListaKickati().contains(utente)){%>
                <p class="kickato">Non puoi più accedere</p>
                <%}else{if(d.getListaIscritti().contains(utente)){%>
                <form method="get" action="DiscussiController">
                    <input type="hidden" name="tipo" value="iscritto">
                    <input type="hidden" name="sezione" value="<%=s.getIdSezione()%>">
                    <input type="hidden" name="titolo" value="<%=d.getTitolo()%>">
                    <input type="submit" value="Partecipa">
                </form>
                <%}}}%>
            </div>
            <div class="testo">
                <div class="tags"><%for(int j=0;j<d.getListaTag().size();j++){%><%=d.getListaTag().get(j)%><%if(j<4){%>,<%}else{%>...<%break;}}%></div>
            </div>
        </div>
    </div>
    <br>
    <%}%>
</div>
</body>
</html>
