<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="no"> 
<head> 
	<!-- <link href="./simple.css" rel="stylesheet" type="text/css" /> -->
	<script defer></script>
	<style type="text/css"></style>
	<title>Stigespill</title> 
</head> 
<body>
<p hidden>${spill}</p>
<c:forEach var ="spiller" items="${spillere}">

<tr style="" id = "navn"><tr>
	<td align="center" id = "test">${spiller.navn}</td>
	<td>${deltager.fornavn} ${spiller.posisjon}</td>
	</tr>

</c:forEach><br>
${hendelse}

<form method="post">

<br> <button type="submit">Trill terning</button>

</form>

</body> 
</html> 


