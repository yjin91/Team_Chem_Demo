<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Green & Jin Retail Final</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/_css/style.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/_css/bootstrap.css" type="text/css">
</head>
<body>

<div class="container logo">
		<img src="./_img/finallogo.png">

<h2 class="reg">Registration Form</h2>
<p class="reg"><span style="font-size: 14px; color: red;"">*</span> Indicates Required Field</p>

		<form name=AddUser action=adduser method=post >
			  
              <p class="required">Username:</p>
			  <input type=text name=username value=" ">
			  <br>
			  
			  <p>First name:</p>
			  <input type=text name=firstname value=" ">
			  <br>

			  <p>Last name:</p>
			  <input type=text name=lastname value=" ">
			  <br>

			  <p class="required">Email:</p>
			  <input type=email name=email value ="">
			  <br>

			  <p class="required">Password:</p>
			  <input type=password name=password>
			  <br>

			  <input class="submit" type=submit  name=submit value="Submit" />
		</form> 
	</div>

</body>
</html>