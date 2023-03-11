<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!-- saved from url=(0030)http://localhost:8080/paameldt -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style><%@include file="/WEB-INF/css/simple.css"%></style>

<link rel="stylesheet" href="simple.css">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		&nbsp;&nbsp;&nbsp;${fornavn}<br>
		&nbsp;&nbsp;&nbsp;${etternavn}<br>
		&nbsp;&nbsp;&nbsp;${mobil}<br> 
		&nbsp;&nbsp;&nbsp;${kjonn}
	</p>
	<a href="http://localhost:8080/deltagerliste">Gå til deltagerlisten</a>

</body></html>