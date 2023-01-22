<%--
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
<div class="welcome">
  <img src="css/logo.png"><br>
  <h2>Benvenuto, *username*</h2>
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
  <input type="button" value="Modifica">
</div>
<div class="sections">
  <div class="delete">
    <p>Elimina una Sezione</p>
    <form>
      <input type="text" id="sid" name="sid" placeholder="ID Sezione..." value=""><br><br>
      <input type="button" value="Elimina">
    </form>
  </div>
  <div class="add">
    <p>Aggiungi una Sezione</p>
    <form>
      <input type="text" id="nome" name="nome" placeholder="Nome Sezione..." value=""><br><br>
      <input type="button" value="Aggiungi">
    </form>
  </div>
</div>
<div class="netflix-profile">
  <p>Stato attuale profilo Netflix: </p><br>
  <input type="button" value="Collega profilo Netflix"><br>
  <div class="create-disc">
    <p>Le tue discussioni</p>
    <input type="button" value="Crea una discussione"><br><br>
    <input type="button" value="Le tue discussioni"><br>
  </div>
</div>
<div class="discuss">
  <p>Accedi alle tue discussioni preferite</p><br>
  <input type="button" value="Discussioni preferite">
</div>
</body>
</html>