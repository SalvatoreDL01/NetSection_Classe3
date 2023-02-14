<%@ page import="ServiziEStorage.Entry.Sezione" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: giuseppe
  Date: 13/02/23
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>HomePage|NetSection</title>
    <link rel="stylesheet" type="text/css" href="css/HomePageStyle.css">
</head>
<body>


<%@include file="NavBar.jsp" %>

<div id="corpo">

    <!-- slider delle sezioni più popolari, ogni slider contiene tre div con degli elementi all'interni che vengono fatti scorrere da una funzione js-->
        <%
        List<Sezione> listaSezioni = new ArrayList<>();
        listaSezioni = (List<Sezione>) request.getAttribute("listaRis");
        System.out.println(listaSezioni.size());
    %>
    <div class="slideShow">
        <h1>SEZIONI PRINCIPALI</h1>
        <div class="mySlidesPopolari">
            <%
                for(int i=0; i<4; i++){
                    if(listaSezioni.size()>i){
            %>
            <a class="element" href="SezioneControl?idSezione=<%=listaSezioni.get(i).getIdSezione()%>">
                <img src="<%=listaSezioni.get(i).getImmagine()%>">
                <p><%=listaSezioni.get(i).getTitolo()%></p>
            </a>
            <%}}%>
        </div>
    </div>


</body>
</html>
