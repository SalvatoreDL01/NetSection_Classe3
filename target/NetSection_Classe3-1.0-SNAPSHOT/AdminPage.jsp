<%@ page import="ServiziEStorage.Entry.Amministratore" %><%--
  Created by IntelliJ IDEA.
  User: chris
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Admin Page</title>
  <link rel="stylesheet" href="css/AdmPageStyle.css">
</head>
<body>
<script>
  let id=document.getElementById("sid").value;
  let nome=document.getElementById("nome").value;

  function validateDelete(){
    if(id== " "){
      alert("Il campo non può essere vuoto");
      return false;
    }
    return true;
  }
  function validateAdd(){
    if(nome== " "){
      alert("Il campo non può essere vuoto");
      return false;
    }
    return true;
  }
</script>
<div class="welcome">
  <img src="css/logo.png"><br>
  <%
    String nome = ((Amministratore)session.getAttribute("user")).getUsername();
  %>
  <h2>Benvenuto, <%=nome%></h2>
</div>
<div class="info">
  <p>Ecco alcune informazioni su di te: </p><br>
  <div id="info-list">
    <ul>
      <li>Nome: *nome*</li><br>
      <li>Cognome: *cognome*</li><br>
      <li>E-mail: *mail*</li><br>
      <li>Età: *data*</li><br>
    </ul>
  </div>
  <p>Puoi modificare queste informazioni cliccando sul pulsante "Modifica"</p><br>
  <input type="button" id="edit" value="Modifica">
</div>
<div class="sections">
  <div class="sections-values">
    <div class="delete">
      <p>Elimina una Sezione</p>
      <form>
        <input type="text" id="sid" name="sid" placeholder="ID Sezione..." value=""><br><br>
        <input type="submit" value="Elimina" onclick="validateDelete()">
      </form>
    </div>
    <div class="add">
      <p>Aggiungi una Sezione</p>
      <form action="CreaSezionePage.jsp">
        <input type="submit" id="aggiungi" value="Aggiungi">
      </form>
    </div>
  </div>
</div>
<div class="netflix-profile">
  <p>Stato attuale profilo Netflix: </p><br>
  <input type="button" value="Collega profilo Netflix"><br>
  <div class="create-disc">
    <p>Le tue discussioni</p>
    <input type="button" value="Crea una discussione"><br><br>
    <input type="button" id="ltd" value="Le tue discussioni"><br>
  </div>
</div>
<div class="discuss">
  <p>Accedi alle tue discussioni preferite</p><br>
  <input type="button" value="Discussioni preferite">
</div>
<div class="ban-user-by-id">
  <p>Banna un Utente. Attenzione: il Ban è un'azione irreversibile!</p><br>
  <form name="ban-user" action="/BanUser">
    <input type="text" id="ban" name="ban" value=""><br><br>
    <input type="submit" value="Banna Utente">
  </form>
</div>
</body>
</html>