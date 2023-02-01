<%@ page import="ServiziEStorage.UtenteRegistrato" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ServiziEStorage.Genere" %>
<%@ page import="ServiziEStorage.GenereDAO" %><%--
  Created by IntelliJ IDEA.
  User: chris
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>UserPage</title>
  <link rel="stylesheet" href="css/AdmPageStyle.css">
</head>
<body>
<div class="welcome">
  <img src="css/logo.png"><br>
  <%
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
  <p>Puoi modificare queste informazioni cliccando sul pulsante "Modifica"</p><br>
  <input type="button" id="edit" value="Modifica">
</div>
<div class="netflix-profile">
  <p>Stato attuale profilo Netflix: </p><br>
  <input type="button" value="Collega profilo Netflix"><br>
  <div class="create-disc">
    <p>Le tue discussioni</p><br>
    <input type="button" value="Crea una discussione"><br><br>
    <input type="button" id="ltd" value="Le tue discussioni"><br>
  </div>
</div>
<div class="discuss">
  <p>Gestisci generi preferiti</p>
  <form >
    <%
      ArrayList<Genere> list = GenereDAO.retriveAll();
      for(Genere g: list){%>
    <input type="checkbox" id="<%=g.getNome()%>" name="<%=g.getNome()%>" value="<%=g.getNome()%>">
    <label for="<%=g.getNome()%>"> <%=g.getNome()%></label>
    <%
      }
    %>
    <input type="submit" value="Aggiorna">
  </form>
</div>
<div class="discuss">
  <p>Accedi alle tue discussioni preferite</p><br>
  <input type="button" value="Discussioni preferite">
</div>
</body>
</html>