<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- saved from url=(0035)http://localhost:8080/deltagerliste -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style><%@include file="/WEB-INF/css/simple.css"%></style>
	
	 <script><%@include file="/WEB-INF/js/deltagerliste.js"%></script>
	
	<title>Deltagerliste</title>
</head>
<body>
    <p id = "innloggetBruker" value ="${deltagerInnlogget.mobil}">Innlogget som: <c:out value="${deltagerInnlogget.mobil}"/> / <c:out value="${deltagerInnlogget.fornavn}"/>  <c:out value="${deltagerInnlogget.etternavn}"/></p>
	<h2>Deltagerliste</h2>
	<table id="MyTable">
		<tbody><tr>
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		
		<c:forEach var="deltager" items="${deltagere}">
		
            <tr id="deltagerMobil" value="${deltager.mobil}" style="${deltagerInnlogget.mobil == deltager.mobil ? 'background-color:green;' : ''}">
				
				<td align="center"><c:out value="${deltager.kjonn}"></c:out> </td>
				<td><c:out value="${deltager.fornavn}"></c:out> </td>
				<td><c:out value="${deltager.mobil}"> </c:out> </td>
			</tr>
		
			</c:forEach>
	</tbody></table>
	<br>
	<form action="http://localhost:8080/utlogging" method="post">
	   <button type="submit">Logg ut</button> 
	</form>

</body></html>