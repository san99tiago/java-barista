<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Finished Form</title>
</head>

<style type="text/css">
.container {
	align-items: center;
	background: rgba(55, 255, 255, 1);
	border: solid 1px black;
	border-radius: 20px;
	display: flex;
	flex-direction: column;
	font-size: 25px;
	justify-content: space-between;
	margin: 50px;
	padding: 100px 100px;
}

</style>

<body>
	<div class="container">
		<h2>UserForm completed successfully!</h2>

		<p>Thanks for your time, ${param.UserName}.</p>
		<br>
		<p>Have a nice day!</p>
	</div>
</body>
</html>