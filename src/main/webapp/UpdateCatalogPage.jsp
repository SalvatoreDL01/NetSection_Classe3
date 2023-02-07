<%@ page import="java.util.ArrayList" %>
<%@ page import="ServiziEStorage.Genere" %>
<%@ page import="ServiziEStorage.GenereDAO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: chris
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiorna Catalogo</title>
    <link rel="stylesheet" href="css/AdmPageStyle.css">
</head>
<body>

<%
    List<Genere> generi= GenereDAO.retriveAll();
%>

<div class="aggiorna-catalogo">
    <h2>Da qui puoi inserire una nuova Sezione:</h2><br><br>
    <form action="/UpdateCatalog">
        <input type="text" id="titolo" name="titolo" value="" placeholder="Titolo..."><br>
        <input type="text" id="descrizione" name="descrizione" value="" placeholder="Descrizione..."><br>
        <input type="text" id="immagine" name="immagine" value="" placeholder="Immagine..."><br><br>
        <label for="scelta">Scegli i generi:</label><br>
        <form id="scelta">
        <%
        if(!generi.isEmpty()){
            for(Genere g: generi){
        %>
            <input type="checkbox" id="<% g.getNome();%>" value="<% g.getNome();%>">
            <label for="<% g.getNome();%>"><% g.getNome();%></label>
            <%
            }
            }
            %>
        </form>
        <br><br>
        <input type="submit" value="Aggiungi Sezione">
    </form>
</div>
</body>
</html>
