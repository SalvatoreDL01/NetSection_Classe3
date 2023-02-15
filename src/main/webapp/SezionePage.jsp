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
    List<String> tagSezione = (List<String>) request.getAttribute("tags");
    Sezione s = (Sezione) request.getAttribute("sezione");
    List<Discussione> lDiscussione = (List<Discussione>) s.getListaDiscussioni();
    UtenteRegistrato utente = (UtenteRegistrato) request.getSession().getAttribute("user");
    List<Discussione> discussioniTag = (List<Discussione>) request.getAttribute("discussioniTag");
%>
<div id="sfondo" style="background-image: url(<%=s.getImmagine()%>);"></div>
<div id="paginaSezione">
    <div id="ricercaFiltrata">
        <p class="tags" id="bottoneRicerca">
            RicercaFiltrata
        </p>
        <form class="tags" action="" method="POST">
            <input type="hidden" name="idSezione" value="<%=s.getIdSezione()%>">
            <%for(int i=0;i<tagSezione.size();i++){%>
            <input type="checkbox" value="<%=tagSezione.get(i)%>" id="tag<%=i%>" name="c<%=i%>">
            <label for="tag<%=i%>"><%=tagSezione.get(i)%></label>
            <%if(i==5){%><br><%}%>
            <%}%><br><br>
            <input type="submit" value="Filtra">
        </form>
    </div>
    <!-- For per  visualizzare le selezioni (quando saranno implementate dovrà avere un tasto di "mostra altro") -->

    <form method="get" action="CreaDiscussioneController">
        <input type="hidden" name="sezione" value="<%=s.getIdSezione()%>">
        <input type="submit" value="Crea discussione">
    </form>

    <%  if(discussioniTag==null){
        for(int i=0; i<lDiscussione.size();i++){%>
    <div class="discussione">
        <p class="titoloDiscussione"><%=lDiscussione.get(i).getTitolo()%></p>
        <div class="immagine">
            <img src="<%=lDiscussione.get(i).getImmagine()%>">
        </div>
        <br>
        <div class="componenti">
            <div class="componentiDiscissione">
                <div class="partecipanti">
                    <img src="css/icone/gruppo.png">
                    <p class="componenteTestuale", id="numeroPartecipanti"><%=lDiscussione.get(i).getListaIscritti().size()%></p>
                </div>
            </div>
            <div class="bottonePartecipazione">
                <%if(utente!=null && !lDiscussione.get(i).getListaIscritti().contains(utente) && !lDiscussione.get(i).getListaKickati().contains(utente)){%>
                <form method="get" action="SubscribeController">
                    <input type="hidden" name="sezione" value="<%=s.getIdSezione()%>">
                    <input type="hidden" name="titolo" value="<%=lDiscussione.get(i).getTitolo()%>">
                    <input type="submit" value="Iscriviti">
                </form>
                <%}else{ if(lDiscussione.get(i).getListaKickati().contains(utente)){%>
                <p class="kickato">Non puoi più accedere</p>
                <%}else{if(lDiscussione.get(i).getListaIscritti().contains(utente)){%>
                <form method="get" action="DiscussiController">
                    <input type="hidden" name="tipo" value="iscritto">
                    <input type="hidden" name="sezione" value="<%=s.getIdSezione()%>">
                    <input type="hidden" name="titolo" value="<%=lDiscussione.get(i).getTitolo()%>">
                    <input type="submit" value="Partecipa">
                </form>
                <%}}}%>
            </div>
        </div>
    </div>
    <br>
    <%}}else{for(Discussione d: discussioniTag){%>
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
                    <p class="componenteTestuale", id="numeroPartecipanti2"><%=d.getListaIscritti().size()%></p>
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
        </div>
    </div>
    <br>

    <%}}%>
</div>
</body>
</html>
