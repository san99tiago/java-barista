<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My first MVC example in Spring</title>
</head>

<style type="text/css">
.container {
	align-items: center;
	display: flex;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
}

.container>h1 {
	background: yellow;
	border: solid 1px black;
	border-radius: 20px;
	padding: 150px 100px;
}

.container>a {
	background: pink;
	border: solid 1px black;
	border-radius: 30px;
	color: black;
	font-size: 30px;
	font-weight: bolder;
	padding: 50px 100px;
	text-decoration: none;
}

.container>a:hover {
	background: rgb(255, 0, 0, 0.2);
	color: red;
}
</style>

<body>

	<div class="container">
		<h1>Hello my friends, I'm Santiago Garcia and this is my first
			"view" file for MVC with Spring, using JSP technologies!!!</h1>

		<a href="userForm" target="_blank">REGISTER</a>
	</div>

</body>
</html>