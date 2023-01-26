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
            alert("L'email non è valida");
            return false;
        }
        if (!email || !password ) {
            alert("Tutti i campi sono obbligatori");
            return false;
        }

        if (password.length < 8) {
            alert("La password deve essere lunga almeno 8 caratteri");
            return false;
        }
        return true;
    }
    function showForm(){
        if(validateForm()==true){
            setTimeout(function (){
                document.getElementById("success").innerHTML="Account Verificato"
            },1500)
            setTimeout(function (){
                document.getElementById("user").style.display="block"
            },3000)
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
        <form>
            <label for="user">Username:</label><br><br>
            <input type="text" id="user" name="user" value="" placeholder="User name o email"><br><br>

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
