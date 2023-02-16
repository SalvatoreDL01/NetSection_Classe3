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
    <link rel="icon" type="image/x-icon" href="css/icone/icona.png">
    <link rel="stylesheet" type="text/css" href="css/DiscussionePageStyle.css">
    <link rel="stylesheet" type="text/css" href="css/SezioneStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#bottoneRicerca").click(function(){
                $("#segnala").slideToggle('fast');
            });
        });
    </script>
</head>
<body>
<%
    UtenteRegistrato utente = (UtenteRegistrato) request.getSession().getAttribute("user");
    Discussione d = (Discussione) request.getAttribute("discussione");
    List<Commento> commenti = (List<Commento>) d.getListaCommenti();
    UtenteRegistratoDAO utenteRegistratoDAO = new UtenteRegistratoDAO();
%>
<script>
    function validateElect(){
        let id= document.getElementById("userToElect").value;

        if(id==" "){
            let hid= document.getElementById("hidden").innerHTML= "utente non valido!";
            return false;
        }
        return true;
    }
</script>
<%@include file="NavBar.jsp" %>
<div id="paginaDiscussione">
    <div class="immagineDiscussione">
        <img src="<%=d.getImmagine()%>">
    </div>
    <p class="title"><%=d.getTitolo()%></p>

    <hr>
    <%for(Commento c: commenti){
        UtenteRegistrato u = utenteRegistratoDAO.doRetriveById(c.getCreatore());
    %>
    <hr>

    <div class="immagineUtente" style="color: aliceblue">
        <img style="float:left;" src="<%if(u.getImmagine()!=null){%>
                                <%=u.getImmagine()%>
                                    <%}else{%>css/icone/user.png<%}%>">
        <p style="float:left;" class="nomeUtente"><%=u.getUsername()%></p>
        <p style="float:left;width: 80%" class="commento"><%=c.getContenuto()%></p> <!-- aggiungere immagini punteggio -->
           <a href="VotoCommentoController?data=<%=c.getDataScrittura()%>&creatore=<%=c.getCreatore()%>&idSezione=<%=d.getSezione()%>&discussione=<%=d.getTitolo()%>"><img src="css/icone/mipiace.png"></a><%=c.getPunteggio()%>
        <a href="VotoCommentoController?data=<%=c.getDataScrittura()%>&creatore=<%=c.getCreatore()%>&idSezione=<%=d.getSezione()%>&discussione=<%=d.getTitolo()%>&dec=si"><img src="css/icone/mipiace.png" style="rotate: 180deg"></a>
    </div>
    <br>
    <p class="segnalazione" id="bottoneRicerca">
        segnala
    </p>
    <form id="segnala">
        <br>
        <input type="hidden" value="<%=d.getSezione()%>" name="sezione">
        <input type="hidden" value="<%=d.getTitolo()%>" name="discussione">
        <input type="hidden" value="<%=c.getDataScrittura()%>" name="dataSegnalato">
        <input type="hidden" value="<%=c.getCreatore()%>" name="creatoreSegnalato">
        <input id="natura" type="text" name="natura" placeholder="natura segnalazione"><br><br>
        <textarea id="segnalaText" name="contenuto" placeholder="scrivi la motivazuione"></textarea><br><br>
        <input type="submit" value="Segnala Utente">
    </form>
<%}%>
    <br>
    <br>
    <form id="formCommento" class="commento" action="AggiungiCommento">

        <input type="hidden" name="idSezione" value="<%=d.getSezione()%>">
        <input type="hidden" name="discussione" value="<%=d.getTitolo() %>">
        <textarea id="testoCommetno" name="commento" placeholder="Scrivi il tuo commento..."></textarea>
        <br><br>
        <input id="submitCommento" type="submit" value="Pubblica"><br>
    </form>
    <p></p>
</div>
<script>
    function validateKickForm(){
        let m= document.getElementById("mot").value;
        if(m<10 || m>255){
            alert("Dai una breve motivazione!");
            return false;
        }
        return true;
    }
</script>
<div>
</div>
<div class="elect-mod-button">
    <form action="ElectModController" method="get" onsubmit="return (validateElect());">
        <label for="userToElect">Inserisci l'ID dell'utente che vuoi eleggere:</label>
        <input type="text" id="userToElect" name="userToElect" placeholder="Utente da eleggere..."><br>
        <input type="hidden" id="hidden" style="color: red" value=""><br><br>
        <input type="submit" id="Eleggi" name="electButton"><br>
    </form>
</div>
</body>
</html>
