<%@ page import="ServiziEStorage.Entry.UtenteRegistrato" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ServiziEStorage.Entry.Genere" %>
<%@ page import="ServiziEStorage.DAO.GenereDAO" %>
<%@ page import="ServiziEStorage.DAO.UtenteRegistratoDAO" %>
<%@ page import="ServiziEStorage.Entry.Discussione" %>
<%@ page import="java.util.List" %>
<%@ page import="ServiziEStorage.DAO.DiscussioneDAO" %><%--
  Created by IntelliJ IDEA.
  User: chris
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>UserPage</title>
  <link rel="stylesheet" href="css/UserPageStyle.css">
</head>
<body>
<div class="welcome">
  <img src="css/logo.png"><br>
  <%
    UtenteRegistratoDAO utenteRegistratoDAO = new UtenteRegistratoDAO();
    GenereDAO genereDAO = new GenereDAO();
    UtenteRegistrato u = null;
    if(session.getAttribute("user") != null){
      u = (UtenteRegistrato) session.getAttribute("user");
    }
  %>
  <h2>Benvenuto, <%=u.getUsername()%></h2>
</div>
<div class="info">
  <p>Ecco alcune informazioni su di te: </p>
  <div id="info-list">
    <ul>
      <li>Username: <%=u.getUsername()%></li><br>
      <li>E-mail: <%=u.getEmail()%></li><br>
      <li>Anno di nascita: <%=u.getDataNascita()%></li><br>
    </ul>
  </div>
  <!--<p>Puoi modificare queste informazioni cliccando sul pulsante "Modifica"</p><br>
  <input type="button" id="edit" value="Modifica">-->
</div>
<div class="netflix-profile">
  <p>Stato attuale profilo Netflix: </p><br>
  <form action="RegistrazioneNetflix.jsp">
    <input type="submit" value="Collega profilo Netflix"><br>
  </form>
  <script>
    function mostraMenu(){
      var display = document.getElementById("tue-discussioni").style.display;
      if(display == "block"){
        document.getElementById("tue-discussioni").style.display = "none";
      }
      else{
        document.getElementById("tue-discussioni").style.display = "block";
      }
    }
  </script>
  <div class="create-disc">
    <p>Le tue discussioni</p><br>
    <input type="button" value="Crea una discussione" ><br><br>
    <input type="button" id="ltd" value="Le tue discussioni" onclick="mostraMenu()"><br>
  </div>
  <div id="tue-discussioni">
    <%
      UtenteRegistrato us = (UtenteRegistrato) session.getAttribute("user");
      us = new UtenteRegistratoDAO().doRetriveById(us.getId());
      if(us.getListaIscizioni() != null){
        List<Discussione> l = (List<Discussione>) us.getListaIscizioni();
        for(Discussione d: l){%>
    <a href="DiscussiController?tipo=iscritto&sezione=<%=d.getSezione()%>&titolo=<%=d.getTitolo()%>" style="color: aliceblue; text-decoration: none"><%=d.getTitolo()%></a><br>
    <%}}%>
  </div>
</div>
<div class="discuss" style="height: 1100px">
  <div style="height: 500px">
    <p>Generi preferiti</p>
    <div>
      <%
        //correzione
        u = utenteRegistratoDAO.doRetriveById(u.getId());
        ArrayList<Genere> list = (ArrayList<Genere>) u.getListaPreferiti();
        System.out.println(list.size());
        for(Genere g: list){%>
      <div style="float: left; border: solid 1px cadetblue; margin: 3px; border-radius: 6px">
        <p><%=g.getNome()%></p>
        <a href="GeneriPreferitiController?azione=rimuovi&genere=<%=g.getNome()%>" style="color: aliceblue; text-decoration: none; height: 40px; width: 50px; background-color: #0a1316">Rimuovi dai preferiti</a>
      </div>
      <%
        }
      %>
    </div>
  </div>
  <div style="height: 500px">
    <p>Generi da poter aggiungere</p>
    <div>
      <%
        ArrayList<Genere> listaGeneri = genereDAO.retriveAll();
        for(Genere g: list){
          listaGeneri.remove(g);
        }
        for(Genere g1: listaGeneri){
      %>
      <div style="float: left; border: solid 1px cadetblue; margin: 3px; border-radius: 6px">
        <p><%=g1.getNome()%></p>
        <a href="GeneriPreferitiController?azione=aggiungi&genere=<%=g1.getNome()%>" style="color: aliceblue; text-decoration: none; height: 40px; width: 50px; background-color: #0a1316">Aggiungi ai preferiti</a>
      </div>
      <%}%>
    </div>
  </div>
</div>
<!--
<div class="discuss">
  <p>Accedi alle tue discussioni preferite</p><br>
  <input type="button" value="Discussioni preferite">
</div>-->
<div class="discuss">
  <input type="button" onclick="visualizzaForm()" value="Segnala un problema">
</div>
<div style="display: none" id="segnalazione" class="discuss">
  <form action="SegnalazioneProblemaControl">
    <label for="naturaProblema">Inserisci la natura del problema</label>
    <input type="text" name="naturaProblema" id="naturaProblema"><br><br>
    <label for="paginaProblema">Inserisci la pagina dove è stato riscontrato il problema</label>
    <select name="paginaProblema" id="paginaProblema">
      <option value="Pagina creazione sezione">Pagina creazione sezione</option>
      <option value="Pagina creazione discussione">Pagina creazione discussione</option>
      <option value="Pagina home">Pagina home</option>
      <option value="Pagina login">Pagina login</option>
      <option value="Pagina di registrazione">Pagina di registrazione</option>
      <option value="Pagina visualizzazione sezione">Pagina visualizzazione sezione</option>
      <option value="Pagina utente">Pagina utente</option>
    </select><br><br>
    <label for="descrizione">Inserisci la natura del problema</label><br>
    <textarea name="descrizione" id="descrizione" rows="10" cols="40"></textarea><br>
    <input type="submit" value="Invia">
    <%
      if(request.getParameter("errore") == null){
    %>
    <p>Esito: </p>
    <%}
      else{
    %>
    <p><%=request.getAttribute("errore")%></p>
    <%}%>
  </form>
</div>
<script>
  function visualizzaForm(){
    document.getElementById("segnalazione").style.display = "block";
  }
</script>
<div class="discuss">
  <form action="LogoutController">
    <input type="submit" value="Logout">
  </form>
</div>
</body>
</html>