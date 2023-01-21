var divInEvidenza = 0;

function plusDivs(n){
    if(divInEvidenza + n == 1){
        document.getElementById("pagina1Popolari").style.display = "block";
        document.getElementById("pagina2Popolari").style.display = "none";
        document.getElementById("pagina3Popolari").style.display = "none";
        divInEvidenza += n;
    }
    if(divInEvidenza + n == 2){
        document.getElementById("pagina1Popolari").style.display = "none";
        document.getElementById("pagina2Popolari").style.display = "block";
        document.getElementById("pagina3Popolari").style.display = "none";
        divInEvidenza += n;
    }
    if(divInEvidenza + n == 3){
        document.getElementById("pagina1Popolari").style.display = "none";
        document.getElementById("pagina2Popolari").style.display = "none";
        document.getElementById("pagina3Popolari").style.display = "block";
        divInEvidenza += n;
    }
}