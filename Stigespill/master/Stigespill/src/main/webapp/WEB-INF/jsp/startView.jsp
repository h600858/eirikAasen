
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
${spill}
<form method="post">
		<fieldset>
			<label for="mobil">Antall spillere:</label> <input type="text" color="grey" pattern="^[2-8]{1}$" name="AntallSpillere">
			<br><br><button type="submit">Submit</button>
		</fieldset>
	</form>