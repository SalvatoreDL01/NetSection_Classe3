<%--
  Created by IntelliJ IDEA.
  User: chris
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrazione Netflix</title>
    <link rel="stylesheet" href="css/RegNetStyle.css">

</head>
<body>
<script>
    function validateForm() {
        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;
        if(!email.includes("@")){
            document.getElementById("success").innerHTML="L'email non è valida"
            return false;
        }
        if (!email || !password ) {
            document.getElementById("success").innerHTML="I campi email e password sono obbligatori"
            return false;
        }

        if (password.length < 8) {
            document.getElementById("success").innerHTML="La password deve essere lunga almeno 8 caratteri"
            return  false;
        }
        return true;
    }
    function showForm(){
        if(validateForm()==1){
            setTimeout(function (){
                document.getElementById("success").innerHTML="Account Verificato"
            },1500)
            document.getElementById("formLogin").action = "RegistrazioneController"
            document.getElementById("formLogin").submit()
            //setTimeout(function (){
            //document.getElementById("user").style.display="block"
            //},3000)
        }

        function validateFormTwo(){
            let user=document.getElementById("username").value;
            if(user.length<5){
                alert("L'username scelto è troppo corto");
                return false;
            }
            return true;
        }
    }

</script>
<div class="reg">
    <div class="intro">
        <img src="css/logo.png"><br>
        <h2>Accedi con il tuo account Netflix</h2><br><br>
    </div>
    <div class="reg-form">
        <form id="formLogin">
            <label for="user">Username:</label><br><br>
            <input type="text" id="user" name="user" value="" placeholder="User name"><br><br>

            <label for="email">Email:</label><br><br>
            <input type="email" id="email" name="email" value="" placeholder="Email"><br><br>

            <label for="data">Data di nascita:</label><br><br>
            <input type="date" id="data" name="data" value="" placeholder="0"><br><br>

            <label for="password">Password:</label><br><br>
            <input type="password" id="password" name="password" value="" placeholder="Password"><br><br>

            <input type="button" onclick="showForm()" value="Registrati">
        </form>
    </div>
    <div class="reg-user" >
        <p id="success"></p>
    </div>
</div>
</body>
</html>
