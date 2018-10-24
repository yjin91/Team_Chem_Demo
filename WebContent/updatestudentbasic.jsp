<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%

String div = (String) request.getAttribute("div");
String username = (String) request.getAttribute("username");

%>     
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UGA CHEM deparment database</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/_css/style.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/_css/bootstrap.css" type="text/css">

</head>
<body>

<div class="container logo">
         <h3 class="hi"'>Hi, <%=username %></h3>
         <a href="signout" class="continue out">Sign Out</a>
		<img src="./_img/finallogo.png">

		<div class="shopping-cart">

			<div class="check-out">
		
				<a href="viewstudentbasic" class="continue">Return to Database</a>

				<h2>Student Basic Information</h2>
				    
				   <%=div %>
				   
				 <br>
				 <br>

				</div>
					<p><a href="viewstudentbasic" class="continue">Return to Database</a></p>

		</div>

</div>
</body>
</html>