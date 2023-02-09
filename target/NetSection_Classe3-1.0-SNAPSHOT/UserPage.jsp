<%@ page import="ServiziEStorage.Entry.UtenteRegistrato" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ServiziEStorage.Entry.Genere" %>
<%@ page import="ServiziEStorage.DAO.GenereDAO" %>
<%@ page import="ServiziEStorage.DAO.UtenteRegistratoDAO" %><%--
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
    <%
      u = UtenteRegistratoDAO.doRetriveByIdForListaGeneri(u.getId());
      ArrayList<Genere> list = (ArrayList<Genere>) u.getListaPreferiti();
      System.out.println(list.size());
      for(Genere g: list){%>
          <p><%=g.getNome()%></p>
          <a href="GeneriPreferitiController?azione=rimuovi&genere=<%=g.getNome()%>">Rimuovi dai preferiti</a>
    <%
      }
    %>
  <%
    ArrayList<Genere> listaGeneri = GenereDAO.retriveAll();
    for(Genere g: list){
      listaGeneri.remove(g);
    }
    for(Genere g1: listaGeneri){
     %>
  <p><%=g1.getNome()%></p>
  <a href="GeneriPreferitiController?azione=aggiungi&genere=<%=g1.getNome()%>" style="color: aliceblue; text-decoration: none; height: 40px; width: 50px; background-color: #0a1316">Aggiungi ai preferiti</a>
  <%}%>
</div>
<div class="discuss">
  <p>Accedi alle tue discussioni preferite</p><br>
  <input type="button" value="Discussioni preferite">
</div>
</body>
</html>