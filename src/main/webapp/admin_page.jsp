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
<h1>Benvenuto, *username*</h1>
<div class="info">
  <p id="welcome">Ecco alcune informazioni su di te: </p><br>
  <ul>
    <li>Nome: *nome*</li><br>
    <li>Cognome: *cognome*</li><br>
    <li>E-mail: *mail*</li><br>
    <li>Età: *data*</li><br>
  </ul>
  <p>Puoi modificare queste informazioni cliccando sul pulsante "Modifica"</p>
  <button>Modifica</button>
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
      <input type="text" id="nome" name="nome" placeholder="Nome Sezione..." value="">
      <input type="button" value="Aggiungi">
    </form>
  </div>
</div>
<div class="netflix-profile">
  <p>Stato attuale profilo Netflix: </p>
  <button>Collega profilo Netflix</button>
  <div class="create-disc">
    <p>Le tue discussioni</p>
    <button>Crea una discussione</button>
    <button>Le tue discussioni</button>
  </div>
</div>
<div class="discuss">
  <p>Accedi alle tue discussioni preferite</p>
  <button>Discussioni Preferite</button>
</div>
</body>
</html>