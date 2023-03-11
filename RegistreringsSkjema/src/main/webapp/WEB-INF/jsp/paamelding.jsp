<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!-- saved from url=(0032)http://localhost:8080/paamelding -->
<html lang="no"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style><%@include file="/WEB-INF/css/simple.css"%></style>
 <script><%@include file="/WEB-INF/js/paamelding.js"%></script>  
	<title>Påmelding</title>
</head>

<body>
<p style="color:red">${redirectMessage}</p>
	<h2>Påmelding</h2>
	
	<form id="deltagerFormBean" action="http://localhost:8080/paamelding" method="post">
		<fieldset>
		
			<label for="fornavn">Fornavn</label>
			<!-- NB! Spring sin (form:input)-tag støtter ikke required alene, 
			     men greit med required="noe"! -->
			<input id="fornavn" name="fornavn" title="fornavn kan minst vere 2 bokstaver" pattern="^\s*\\p{Lu}[a-zA-ZæøåÆØÅ]{2,20}" placeholder="Fyll inn fornavn" required="required" type="text" value="${fornavn}" >${feilFornavn}<br>
            
            
            <label for="etternavn">Etternavn</label> 
            <input id="etternavn" name="etternavn" title="..." pattern="^\s*\\p{Lu}[a-zA-ZæøåÆØÅ]{2,20}" placeholder="Fyll inn etternavn" required="required" type="text" value="${etternavn}">${feilEtternavn}<br>
            
            
            <label for="mobil">Mobil (8 siffer)</label>  
            <input id="mobil" name="mobil" title="..." pattern="[0-9]{8}" placeholder="Fyll inn telefonnummer" required="required" type="text" value="${mobil}">${feilMobil}<br>
            

            <label for="passord">Passord</label> 
            <input id="passord" name="passord" title="..." pattern="[a-zA-ZæøåÆØÅ0-9]{5,}" placeholder="Velg et passord" type="password" required="required" value="${passord}">${feilPassord}<br>
            
            
            <label for="passordRepetert">Passord repetert</label> 
            <input id="passordRepetert" name="passordRepetert" title="..." pattern=".*" placeholder="Gjenta passord" type="password" required="required" value="${passordRepetert}">${feilRepetertPassord}<br>
            
            
			<label for="kjonn">Kjønn:</label> 
			<input id="kjonn1" name="kjonn" checked="checked" type="radio" value="mann">mann
			<input id="kjonn2" name="kjonn" type="radio" value="kvinne">kvinne
			     
			<br><br><button type="submit">Meld meg på</button>
		</fieldset>
	</form>


</body></html>