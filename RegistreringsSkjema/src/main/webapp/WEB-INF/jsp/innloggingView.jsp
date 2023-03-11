<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!-- saved from url=(0032)http://localhost:8080/innlogging -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style><%@include file="/WEB-INF/css/simple.css"%></style> 
<link rel="stylesheet" href="simple.css">
<title>Logg inn</title>
</head>
<body>
<p style="color:red">${redirectMessage}</p>
	<h2>Logg inn</h2>
	<p style="color:red;"></p>
	<form method="post">
		<fieldset>
			<label for="mobil">Mobil:</label> 
			<input id="mobil" name="mobil" title="..." pattern=".*" placeholder="Fyll inn telefonnummer" required="required" type="text" value="${mobil}">${feilMobil}<br>
			<label for="passord">Passord:</label> 
			<input id="passord" name="passord" title="..." pattern=".*" placeholder="Legg inn passord" type="password" required="required" value="${passord}">${feilPassord}<br>
			<br><br><button type="submit">Logg inn</button>
		</fieldset>
	</form>


</body></html>