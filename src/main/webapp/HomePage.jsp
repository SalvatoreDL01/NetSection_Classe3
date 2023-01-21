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
    <a class="elementiNavBar" href="###"><img id="imageLogo" class="elementiNavBar" src="css/logo.png"></a>
    <form class="elementiNavBar">
        <input type="text" id="ricerca" placeholder="cerca sezione...">
        <button type="button" id="bottoreRicerca">RICERCA PER GENERE</button>
    </form>
    <a class="elementiNavBar" id="login" href="#">LOGIN</a>
</div>


<div id="corpo">


    <div class="slideShow">
        <h1>I PIÙ POPOLARI</h1>
        <div class="mySlidesPopolari">
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
        <div class="mySlidesPopolari">
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
        <div class="mySlidesPopolari">
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
        <button class="frecciaIndietro" onclick="plusDivsPopolari(-1)">&#10094;</button>
        <button class="frecciaAvanti" onclick="plusDivsPopolari(1)">&#10095;</button>
    </div>

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



    <div class="slideShow">
        <h1>I PIÙ VISTI</h1>
        <div class="mySlidesVisti">
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
        <div class="mySlidesVisti">
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
        <div class="mySlidesVisti">
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
        <button class="frecciaIndietro" onclick="plusDivsVisti(-1)">&#10094;</button>
        <button class="frecciaAvanti" onclick="plusDivsVisti(1)">&#10095;</button>
    </div>

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

</div>
</body>
</html>
