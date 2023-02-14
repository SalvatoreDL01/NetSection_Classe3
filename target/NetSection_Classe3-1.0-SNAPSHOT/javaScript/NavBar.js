function mostraMenu(){
    var display = document.getElementById("ricercaGeneri").style.display;
    if(display == "block"){
        document.getElementById("ricercaGeneri").style.display = "none";
    }
    else{
        document.getElementById("ricercaGeneri").style.display = "block";
    }
}