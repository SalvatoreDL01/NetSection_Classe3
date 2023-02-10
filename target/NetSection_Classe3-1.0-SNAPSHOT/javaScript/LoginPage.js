function validateForm() {
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    if(!email.includes("@")){
        document.getElementById("success").innerHTML="L'email non è valida"
        return false;
    }
    if (!email || !password ) {
        document.getElementById("success").innerHTML="Tutti i campi sono obbligatori"
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
        document.getElementById("formLogin").action = "LoginController"
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