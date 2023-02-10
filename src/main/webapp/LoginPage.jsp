<%--
  Created by IntelliJ IDEA.
  User: chris
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrazione Netflix</title>
    <link rel="stylesheet" href="css/RegNetStyle.css">
    <script type="text/javascript" src="javaScript/LoginPage.js"></script>
</head>
<body>

<div class="reg">
    <div class="intro">
        <img src="css/logo.png"><br>
        <h2>Accedi con il tuo account Netflix</h2><br><br>
    </div>
    <div class="reg-form">
        <form id="formLogin" action="">
            <label for="email">Username:</label><br><br>
            <input type="text" id="email" name="email" value="" placeholder="Email"><br><br>

            <label for="password">Password:</label><br><br>
            <input type="password" id="password" name="password" value="" placeholder="Password"><br><br>

            <input type="button" onclick="showForm()" value="Accedi"><br>
            <a href="RegistrazionePage.jsp" style="text-decoration: none; color: darkgrey; margin-top: 5px">Se non hai un account registrati</a>
        </form>
    </div>
    <div class="reg-user" >
        <%
            String str;
            if(request.getAttribute("errore") == null)
                str = "";
            else str = request.getAttribute("errore").toString();
        %>
        <p id="success"><%=str%></p>
    </div>
</div>
</body>
</html>
