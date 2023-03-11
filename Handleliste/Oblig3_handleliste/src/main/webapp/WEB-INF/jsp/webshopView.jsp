<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<form action="webshop" method="post" >
		<p>Legg til: <input type="text" name="vare" value="${vareLagtTil}"/>
		<input type="submit" value="Legg til"/>
		${redirectMessage}</p>
	</form>
	
	<table>
	<c:forEach var="Vare" items="${handlevogn.items}">
	<tr>
	<form action="slett" method="post">
	<td><input type="submit" name ="delete"value="slett"/>
	<input type="hidden", name="skjult", value="${vare}"/></td>
	<td>${Vare}</td>
	</form>
	</tr>
	</c:forEach>
	</table>
</head>
<body>
</html>