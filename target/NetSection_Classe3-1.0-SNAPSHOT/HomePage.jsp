<%--
  Created by IntelliJ IDEA.
  User: giuseppe
  Date: 21/01/23
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage|NetSection</title>
    <link rel="stylesheet" type="text/css" href="css/NavBarStyle1.css">
</head>
<body>
<div id="navBar">
    <img id="imageLogo" class="elementiNavBar" src="css/logo.png">
    <form class="elementiNavBar">
        <input type="text" id="ricerca">
        <button type="button" id="bottoreRicerca">Ricerca per genere</button>
    </form>
    <a class="elementiNavBar" id="login" href="#">LOGIN</a>
</div>
<div id="corpo">
    <div class="slideShow">
        <h1>I più popolari</h1>
        <div class="mySlides">
            <div class="element">
                <img src="css/witcher.jpeg">
                <p>the witcher</p>
            </div>
            <div class="element">
                <img src="css/witcher.jpeg">
                <p>the witcher</p>
            </div>
            <div class="element">
                <img src="css/witcher.jpeg">
                <p>the witcher</p>
            </div>
            <div class="element">
                <img src="css/witcher.jpeg">
                <p>the witcher</p>
            </div>
            <div class="element">
                <img src="css/witcher.jpeg">
                <p>the witcher</p>
            </div>
        </div>
        <div class="mySlides">
            <div class="element">
                <img src="css/peacky.jpeg">
                <p>peacky blinders</p>
            </div>
            <div class="element">
                <img src="css/peacky.jpeg">
                <p>peacky blinders</p>
            </div>
            <div class="element">
                <img src="css/peacky.jpeg">
                <p>peacky blinders</p>
            </div>
            <div class="element">
                <img src="css/peacky.jpeg">
                <p>peacky blinders</p>
            </div>
            <div class="element">
                <img src="css/peacky.jpeg">
                <p>peacky blinders</p>
            </div>
        </div>
        <div class="mySlides">
            <div class="element">
                <img src="css/big.jpeg">
                <p>the big bang teory</p>
            </div>
            <div class="element">
                <img src="css/big.jpeg">
                <p>the big bang teory</p>
            </div>
            <div class="element">
                <img src="css/big.jpeg">
                <p>the big bang teory</p>
            </div>
            <div class="element">
                <img src="css/big.jpeg">
                <p>the big bang teory</p>
            </div>
            <div class="element">
                <img src="css/big.jpeg">
                <p>the big bang teory</p>
            </div>
        </div>
        <button class="frecciaIndietro" onclick="plusDivs(-1)">&#10094;</button>
        <button class="frecciaAvanti" onclick="plusDivs(1)">&#10095;</button>
    </div>

    <div class="slideShow">
        <h1>I più popolari</h1>
        <div class="mySlides">
            <div class="element">
                <img src="css/witcher.jpeg">
                <p>the witcher</p>
            </div>
            <div class="element">
                <img src="css/witcher.jpeg">
                <p>the witcher</p>
            </div>
            <div class="element">
                <img src="css/witcher.jpeg">
                <p>the witcher</p>
            </div>
            <div class="element">
                <img src="css/witcher.jpeg">
                <p>the witcher</p>
            </div>
            <div class="element">
                <img src="css/witcher.jpeg">
                <p>the witcher</p>
            </div>
        </div>
        <div class="mySlides">
            <div class="element">
                <img src="css/peacky.jpeg">
                <p>peacky blinders</p>
            </div>
            <div class="element">
                <img src="css/peacky.jpeg">
                <p>peacky blinders</p>
            </div>
            <div class="element">
                <img src="css/peacky.jpeg">
                <p>peacky blinders</p>
            </div>
            <div class="element">
                <img src="css/peacky.jpeg">
                <p>peacky blinders</p>
            </div>
            <div class="element">
                <img src="css/peacky.jpeg">
                <p>peacky blinders</p>
            </div>
        </div>
        <div class="mySlides">
            <div class="element">
                <img src="css/big.jpeg">
                <p>the big bang teory</p>
            </div>
            <div class="element">
                <img src="css/big.jpeg">
                <p>the big bang teory</p>
            </div>
            <div class="element">
                <img src="css/big.jpeg">
                <p>the big bang teory</p>
            </div>
            <div class="element">
                <img src="css/big.jpeg">
                <p>the big bang teory</p>
            </div>
            <div class="element">
                <img src="css/big.jpeg">
                <p>the big bang teory</p>
            </div>
        </div>
        <button class="frecciaIndietro" onclick="plusDivs(-1)">&#10094;</button>
        <button class="frecciaAvanti" onclick="plusDivs(1)">&#10095;</button>
    </div>

    <script>
        var slideIndex = 1;
        showDivs(slideIndex);

        function plusDivs(n) {
            showDivs(slideIndex += n);
        }

        function showDivs(n) {
            var i;
            var x = document.getElementsByClassName("mySlides");
            if (n > x.length) {slideIndex = 1}
            if (n < 1) {slideIndex = x.length}
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
            x[slideIndex-1].style.display = "block";
        }
    </script>
</div>
</body>
</html>
