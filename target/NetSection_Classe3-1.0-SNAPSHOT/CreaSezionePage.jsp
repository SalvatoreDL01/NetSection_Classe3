<%--
  Created by IntelliJ IDEA.
  User: utente
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/CreazioneDiscussionePageStyle.css">
</head>
<body>
<script>
    function validate(){
        let titolo=document.getElementById("titolo");
        let descrizione=document.getElementById("descrizione");
        let checkbox= document.querySelectorAll('input[type="checkbox"]');

        if(titolo==null || descrizione==null){
            alert("Tutti i campi sono obbligatori!");
            return false;
        }
        if(titolo.lenght()<5){
            alert("Il titolo deve contenere almeno 5 caratteri!");
        }
        if(descrizione.lenght()<10){
            alert("Il titolo deve contenere almeno 10 caratteri!");
        }
        checkboxes.forEach((checkbox) => {
            checkbox.addEventListener('change', (event) => {
                // Verifica se almeno un checkbox è selezionato
                const atLeastOneChecked = Array.from(checkboxes).some((cb) => cb.checked);
                if (atLeastOneChecked) {
                    console.log('Almeno un checkbox selezionato');
                } else {
                    alert("Nessun checkbox selezionato!");
                }
            });
        });
    }

</script>

<h1>AGGIUNGI SEZIONE</h1>
<!--visualizzazione del messaggio per dare conferma dell'aggiunta-->
<div id="dati">

    <!--form per l'aggiunta di una Sezione-->
    <form id="formSezione" action="UpdateCatalogController" method="POST" enctype="multipart/form-data" onsubmit="validate()">

        <div id="gioco" class="forms">
            <label for="titolo">Titolo Sezione</label><br>
            <input type="text" id="titolo" name="titolo" placeholder="Titolo Sezione"><br>
            <label for="descrizione" id="textLable">Descrizione</label><br>
            <textarea id="descrizione" name="descrizione" placeholder="Descrizione..."></textarea><br>
            <p>Carica immagine</p>
            <label id="labl1" class="custom-file-upload">
                <input type="file" name="immagine" accept=".jpg, .jpeg, .png" multiple >
                Aggiungi
            </label>
            <p>Seleziona generi</p>
            <div id="generi">
                <input type="checkbox" value="animazione" id="animazione" name="c1">
                <label for="animazione">Animazione</label>
                <input type="checkbox" value="avventura" id="avventura" name="c2">
                <label for="avventura">Avventura</label>
                <input type="checkbox" value="biografico" id="biografico" name="c3">
                <label for="biografico">Biografico</label>
                <input type="checkbox" value="cappa e spada" id="cappaESpada" name="c4">
                <label for="cappaESpada">Cappa e spada</label><br>
                <input type="checkbox" value="catastrofico" id="catastrofico" name="c5">
                <label for="catastrofico">Catastrofico</label>
                <input type="checkbox" value="comico" id="comico" name="c6">
                <label for="comico">Comico</label>
                <input type="checkbox" value="commedia" id="commedia" name="c7">
                <label for="commedia">Commedia</label>
                <input type="checkbox" value="drammatico" id="drammatico" name="c8">
                <label for="drammatico">Drammatico</label><br>
                <input type="checkbox" value="erotico" id="erotico" name="c9">
                <label for="erotico">Erotico</label>
                <input type="checkbox" value="fantascienza" id="fantascienza" name="c10">
                <label for="fantascienza">Fantascienza</label>
                <input type="checkbox" value="fantasy" id="fantasy" name="c11">
                <label for="fantasy">Fantasy</label>
                <input type="checkbox" value="gangster" id="gangster" name="c12">
                <label for="gangster">Gangster</label><br>
                <input type="checkbox" value="giallo" id="giallo" name="c13">
                <label for="giallo">Giallo</label>
                <input type="checkbox" value="guerra" id="guerra" name="c14">
                <label for="guerra">Guerra</label>
                <input type="checkbox" value="horror" id="horror" name="c15">
                <label for="horror">Horror</label>
                <input type="checkbox" value="musicale" id="musicale" name="c16">
                <label for="musicale">Musicale</label><br>
                <input type="checkbox" value="politco-sociale" id="politco-sociale" name="c17">
                <label for="politco-sociale">Politco-sociale</label>
                <input type="checkbox" value="spionaggio" id="spionaggio" name="c18">
                <label for="spionaggio">Spionaggio</label>
                <input type="checkbox" value="sportivo" id="sportivo" name="c19">
                <label for="sportivo">Sportivo</label>
                <input type="checkbox" value="storico" id="storico" name="c20">
                <label for="storico">Storico</label><br>
                <input type="checkbox" value="western" id="western" name="c21">
                <label for="western">Western</label>
                <input type="checkbox" value="teen" id="teen" name="c22">
                <label for="teen">Teen</label>
            </div>
            <br><br>
            <div id="bottoneGioco">
                <input type="submit" value="Aggiungi Sezione" onclick="validate()">
            </div>

        </div>

    </form>


</div>
</body>
</html>
