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
    String username = ((Amministratore)session.getAttribute("user")).getUsername();
    String mail = ((Amministratore)session.getAttribute("user")).getEmail();
    int id= ((Amministratore)session.getAttribute("user")).getIdAdmin();
  %>
  <h2>Benvenuto, <%=username%></h2>
</div>
<div class="info">
  <p>Ecco alcune informazioni su di te: </p><br>
  <div id="info-list">
    <ul>
      <li>E-mail: <%=mail%></li><br>
      <li>ID: <%=id%></li>
    </ul>
  </div>
  <p>Puoi modificare la mail cliccando sul pulsante "Modifica"</p><br>
  <form>
    <input type="text" name="mail" id="mail" placeholder="Modifica la mail..."><br>
    <input type="button" id="edit" value="Modifica">
  </form>
</div>
<div class="sections">
  <div class="sections-values">
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
<script>
  function validateBan(){
    let id= document.getElementById("ban").value;

    if(id==" "){
      document.getElementById("hidden").innerHTML= "id non valido";
      return false;
    }
    return (true);
  }
</script>
<div class="ban-user-by-id">
  <p>Banna un Utente. Attenzione: il Ban è un'azione irreversibile!</p><br>
  <form action="BanUser" method="get" onsubmit="return (validateBan());">
    <input type="text" id="ban" name="ban" value=""><br>
    <input type="hidden" id="hidden" style="color: red" value=""><br><br>
    <input type="submit" value="Banna Utente">
  </form>
</div>
</body>
</html>