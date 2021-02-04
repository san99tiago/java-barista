<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Form</title>
</head>

<style type="text/css">
.container {
	align-items: center;
	background: rgba(55, 255, 255, 1);
	border: solid 1px black;
	border-radius: 20px;
	display: flex;
	flex-direction: column;
	font-size: 20px;
	justify-content: space-between;
	margin: 100px;
	padding: 150px 100px;
}

.container__form {
	align-items: center;
	display: flex;
	flex-direction: column;
	justify-content: center;
	padding: 30px 0px;
	width: 100%;
}

.container__text {
	font-size: 25px;
}
.container__input {
	border: solid 1px black;
	border-radius: 20px;
	height: 25px;
	padding: 10px;
	margin: 20px;
	width: 40%;
}
</style>

<body>

	<div class="container">
		<h1>This is my amazing form (to test MVC model with Spring
			Framework!)</h1>

		<form action="finishedUserForm" class="
				container__form"
			method="get">
			<p class="container__text">Please enter your name:</p>
			<input type="text" id="UserName" name="UserName"
				placeholder="Enter your name" class="container__input"> <input type="submit">
		</form>
	</div>

</body>
</html>