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
    function validate() {
      let email = document.getElementById("email").value;
      let password = document.getElementById("password").value;
      if (email == " " || password == " ") {
        alternative("I campi email e password sono obbligatori");
        return false;
      }

      if (password.length < 8) {
        alert("La password deve essere lunga almeno 8 caratteri");
        return false;
      }
      return (true);
  }
</script>
<div class="reg">
  <div class="intro">
    <img src="css/logo.png"><br>
    <h2>Accedi con il tuo account Netflix</h2><br><br>
  </div>
  <div class="reg-form">
    <form action="RegistrazioneNetflixController" method="get" onsubmit="return(validate());">
      <label for="email">Email del tuo profilo Netflix:</label><br><br>
      <input type="email" id="email" name="email" value=""><br><br>

      <label for="password">Password del tuo profilo Netflix:</label><br><br>
      <input type="password" id="password" name="password" value=""><br><br>

      <input type="submit" value="Verifica account Netflix">
    </form>
  </div>
</div>
</body>
</html>
