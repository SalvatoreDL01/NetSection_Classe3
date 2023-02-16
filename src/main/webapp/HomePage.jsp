<%@ page import="ServiziEStorage.Entry.Sezione" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: giuseppe
  Date: 21/01/23
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>HomePage|NetSection</title>
    <link rel="icon" type="image/x-icon" href="css/icone/icona.png">
    <link rel="stylesheet" type="text/css" href="css/HomePageStyle.css">
</head>
<body>

<%@include file="NavBar.jsp" %>

<div id="corpo">

<!-- slider delle sezioni più popolari, ogni slider contiene tre div con degli elementi all'interni che vengono fatti scorrere da una funzione js-->
    <%
        List<Sezione> listaSezioni = new ArrayList<>();
        listaSezioni = (List<Sezione>) request.getAttribute("sezioni");
        List<Sezione> mostDiscusse = new ArrayList<>();
        mostDiscusse = (List<Sezione>) request.getAttribute("sezioneDiscusse");
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
        <div class="mySlidesPopolari">
            <%
                for(int i=4; i<8; i++){
                    if(listaSezioni.size()>i){
            %>
            <a class="element" href="SezioneControl?idSezione=<%=listaSezioni.get(i).getIdSezione()%>">
                <img src="<%=listaSezioni.get(i).getImmagine()%>">
                <p><%=listaSezioni.get(i).getTitolo()%></p>
            </a>
            <%}}%>
        </div>
        <div class="mySlidesPopolari">
            <%
                for(int i=8; i<12; i++){
                    if(listaSezioni.size()>i){
            %>
            <a class="element" href="SezioneControl?idSezione=<%=listaSezioni.get(i).getIdSezione()%>">
                <img src="<%=listaSezioni.get(i).getImmagine()%>">
                <p><%=listaSezioni.get(i).getTitolo()%></p>
            </a>
            <%}}%>
        </div>
        <button class="frecciaIndietro" onclick="plusDivsPopolari(-1)">&#10094;</button>
        <button class="frecciaAvanti" onclick="plusDivsPopolari(1)">&#10095;</button>
    </div>
<!---->
    <!-- funzione js per la gestione dello scorrimento dello slider, sliderIndexPopolari tiene traccia del div visibile in quel momento mentre gli altri sono nascosti-->
    <script>
        var slideIndexPopolari = 1;
        showDivsPopolari(slideIndexPopolari);

        function plusDivsPopolari(n) {
            showDivsPopolari(slideIndexPopolari += n);
        }

        function showDivsPopolari(n) {
            var i;
            var x = document.getElementsByClassName("mySlidesPopolari");
            if (n > x.length) {slideIndexPopolari = 1}
            if (n < 1) {slideIndexPopolari = x.length}
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
            x[slideIndexPopolari-1].style.display = "block";
        }
    </script>


    <!-- slider delle sezioni più viste-->
    <div class="slideShow">
        <h1>SEZIONI PIÙ DISCUSSE</h1>
        <div class="mySlidesVisti">
            <%
                for(int i=0; i<4; i++){
                    if(mostDiscusse.size()>i){
            %>
            <a class="element" href="SezioneControl?idSezione=<%=mostDiscusse.get(i).getIdSezione()%>">
                <img src="<%=mostDiscusse.get(i).getImmagine()%>">
                <p><%=mostDiscusse.get(i).getTitolo()%></p>
            </a>
            <%}}%>
        </div>
        <div class="mySlidesVisti">
            <%
                for(int i=4; i<8; i++){
                    if(mostDiscusse.size()>i){
            %>
            <a class="element" href="SezioneControl?idSezione=<%=mostDiscusse.get(i).getIdSezione()%>">
                <img src="<%=mostDiscusse.get(i).getImmagine()%>">
                <p><%=mostDiscusse.get(i).getTitolo()%></p>
            </a>
            <%}}%>
        </div>
        <div class="mySlidesVisti">
            <%
                for(int i=8; i<12; i++){
                    if(mostDiscusse.size()>i){
            %>
            <a class="element" href="SezioneControl?idSezione=<%=mostDiscusse.get(i).getIdSezione()%>">
                <img src="<%=mostDiscusse.get(i).getImmagine()%>">
                <p><%=mostDiscusse.get(i).getTitolo()%></p>
            </a>
            <%}}%>
        </div>
        <button class="frecciaIndietro" onclick="plusDivsVisti(-1)">&#10094;</button>
        <button class="frecciaAvanti" onclick="plusDivsVisti(1)">&#10095;</button>
    </div>
    <!--funzioni js per la gestione dello scorrimento dello slider-->
    <script>
        var slideIndexVisti = 1;
        showDivsVisti(slideIndexVisti);
        function plusDivsVisti(n) {
            showDivsVisti(slideIndexVisti += n);
        }
        function showDivsVisti(n) {
            var i;
            var x = document.getElementsByClassName("mySlidesVisti");
            if (n > x.length) {slideIndexVisti = 1}
            if (n < 1) {slideIndexVisti = x.length}
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
            x[slideIndexVisti-1].style.display = "block";
        }
    </script>




<!-- slider delle sezioni più viste-->
    <div class="slideShow">
        <h1>I TUOI GENERI PREFERITI</h1>
        <div class="mySlidesVisti">
        <%
            List<Sezione> lista = new ArrayList<>();
            if(request.getAttribute("listaGeneriPreferiti") != null) {
                lista = (List<Sezione>) request.getAttribute("listaGeneriPreferiti");
                for (Sezione s : lista) {
                    %>
        <a class="element" href="SezioneControl?idSezione=<%=s.getIdSezione()%>">
            <img src="css/witcher.jpeg">
            <p>the witcher</p>
        </a>
        <%}}%>
        </div>

    </div>

</div>
</body>
</html>
