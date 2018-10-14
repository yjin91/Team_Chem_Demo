<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UGA Chem Database</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/_css/style.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/_css/bootstrap.css" type="text/css">

</head>
<body>

<div class="container logo">
		<img src="./_img/finallogo.png">

		<form action="login">

			  <p class="required">Username:</p>
			  <input type="text" name="username">
			  <br>

			  <p class="required">Password:</p>
			  <input type="password" name="password">
			  <br>

			  <input type="submit" class="submit" value="Login">
		</form> 


	</div>

</body>
</html>