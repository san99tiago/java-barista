<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/styles/userForm.css">
<title>User Form</title>
</head>

<body>

	<div class="container">
		<h1>
			This is my amazing form for developers...<br>
		</h1>
		<h3>(to test MVC model with Spring Framework!)</h3>

		<form action="finishedUserForm" class="
				container__form"
			method="get">
			<p class="container__text">Please enter your name:</p>

			<input type="text" id="UserName" name="UserName"
				placeholder="Enter your name" class="container__input">

			<p class="container__text">Please enter your birthday
				(YYYY/mm/dd)):</p>

			<input type="text" id="UserBirthday" name="UserBirthday"
				placeholder="YYYY/mm/dd" class="container__input">

			<p class="container__text">Please enter your main programming
				language:</p>

			<input type="text" id="UserProgrammingLangugae"
				name="UserProgrammingLangugae"
				placeholder="Enter main programming language"
				class="container__input"> <input type="submit">
		</form>
	</div>

</body>
</html>