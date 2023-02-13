<%--
  Created by IntelliJ IDEA.
  User: chris
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrati</title>
    <link rel="stylesheet" href="css/RegNetStyle.css">

</head>
<body>
<script>
    function validate() {
        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;
        let data= document.getElementById("data").value;
        let user=document.getElementById("username").value;

        if (!user || !email || !password || !data) {
            document.getElementById("success").innerHTML="Tutti i campi  sono obbligatori"
            return false;
        }

        if (password.length < 8) {
            document.getElementById("success").innerHTML="La password deve essere lunga almeno 8 caratteri"
            return  false;
        }
        if(user.length<5){
            document.getElementById("success").innerHTML="L'username deve contenere almeno 5 caratteri"
            return false;
        }
        return true;
    }

</script>
<div class="reg">
    <div class="intro">
        <img src="css/logo.png"><br>
        <h2>Accedi con il tuo account Netflix</h2><br><br>
    </div>
    <div class="reg-form">
        <form id="formLogin" onsubmit="return validate()" action="RegistrazioneController">
            <label for="user">Username:</label><br><br>
            <input type="text" id="user" name="user" value="" placeholder="User name..."><br><br>

            <label for="email">Email:</label><br><br>
            <input type="email" id="email" name="email" value="" placeholder="Email..."><br><br>

            <label for="data">Data di nascita:</label><br><br>
            <input type="date" id="data" name="data" value="" placeholder="0"><br><br>

            <label for="password">Password:</label><br><br>
            <input type="password" id="password" name="password" value="" placeholder="Password..."><br><br>

            <input type="submit" value="Registrati"><br>
        </form>
    </div>
    <div class="reg-user" >
        <p id="success"></p>
    </div>
</div>
</body>
</html>
