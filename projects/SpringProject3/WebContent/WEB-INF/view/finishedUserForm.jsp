<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/styles/finishedUserForm.css">
<title>Finished Form</title>
</head>


<body>
	<div class="container">
		<h2>UserForm completed successfully!</h2>

		<p>Thanks for your time, ${messageForUser}.</p>
		<br>
		<p>Have a nice day!</p>

		<img height="150px" width="150px" alt="GIF mountain"
			src="${pageContext.request.contextPath}/resources/imgs/mountainsGif.gif">
	</div>
</body>
</html>
