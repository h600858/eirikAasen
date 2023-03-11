<!DOCTYPE html>
<html lang="no">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="icon" href="data:," />

<link href="main.css" rel="stylesheet" type="text/css" />
<script src="js/passordvalidator.js" defer></script>
<script src="js/formcontroller.js" defer></script>
<title>Påmelding</title>
</head>

<body>
    <h2>Påmelding</h2>    

    <form method="post" action="action.html">
        <fieldset>
            <label for="fornavn">Fornavn:</label>
            <input type="text" name="fornavn" id="fornavn"
                placeholder="Fyll inn fornavn"
                title="Fornavn må starte med stor forbokstav og innholde kun bokstaver, og antall tegn må være mellom 2 og 20"
                required pattern="\s*\p{Lu}\p{Ll}+(\s+\p{Lu}\p{Ll}+)*\s*" />
            <span class="melding"></span>

            <label for="etternavn">Etternavn:</label>
            <input type="text" name="etternavn" id="etternavn"
                placeholder="Fyll inn etternavn"
                title="Etternavn må starte med stor forbokstav og innholde kun bokstaver, og antall tegn må være mellom 2 og 20"
                required pattern="\s*\p{Lu}\p{Ll}+\s*"
            />
            <span class="melding"></span>

            <label for="mobil">Mobil (8 siffer):</label>
            <input type="text" name="mobil" id="mobil"
                placeholder="Fyll inn telefonnummer"
                title="Mobilnummer må bestå av nøyaktig 8 siffre"
                required pattern="\s*\+?\s*(\d\s*){8}\s*"
            />
            <span class="melding"></span>

            <label for="passord">Passord:</label>
            <input type="password" name="passord" id="passord"
                placeholder="Velg et passord"
                title="Passordet må bestå av minst 8 tegn, men bør ha minst 14 tegn"
                required pattern=".{8,}"
             />
             <span class="melding"></span>

            <label for="passordRepetert">Passord repetert:</label>
            <input type="password" name="passordRepetert" id="passordRepetert"
                placeholder="Gjenta passord"
                required />
            <span class="melding"></span>

            <span class="columnfirst">Kjønn:</span>
            <span>
                <label>
                    <input type="radio" name="kjonn" value="mann" checked="checked" /> mann</label>
                <label>
                <input type="radio" name="kjonn" value="kvinne" />kvinne</label>
            </span>
            <span class="melding"></span>

            <button type="submit">Meld meg på</button>
        </fieldset>
    </form>
</body>
</html>
