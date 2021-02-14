<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/styles/checkDevelopers.css">
<title>Check Developers</title>
</head>

<body>

	<div class="container">
		<header>
			<form action="mainPage" method="GET">
				<input type="submit" value="HOME">
			</form>
			<form action="userForm" method="GET">
				<input type="submit" value="REGISTER">
			</form>
		</header>

		<div class="devitem">
			<table>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Main Language</th>
					<th>Birthday Date</th>
					<th>Registration Date</th>
				</tr>

				<c:forEach items="${devList}" var="dev">

					<tr>
						<td>${dev.getId()}</td>
						<td>${dev.getName()}</td>
						<td>${dev.getMainLanguage()}</td>
						<td>${dev.getBirthdayDate().toString()}</td>
						<td>${dev.getRegistrationDate().toString()}</td>
					</tr>
				</c:forEach>

			</table>
		</div>

	</div>

</body>
</html>