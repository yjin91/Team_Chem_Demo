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
<title>Green & Jin Product Browse</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/_css/style.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/_css/bootstrap.css" type="text/css">

</head>
<body>

<div class="container logo">
         <h3 class="hi"'>Hi, <%=username %></h3>
         <a href="signout" class="continue out">Sign Out</a>
		<img src="./_img/finallogo.png">

		<div class="product-browse">
	
			<div class="sidebar">
				<h3>View by Type</h3>

				<a href="#outerwear">Outerwear</a>
				<a href="#backpack">Backpacks</a>
				<a href="#hats">Hats</a>
			</div>

			<div class="main-browse">
				<a href="viewsc" class="view-cart">View Cart</a>
				<h2>Products</h2>

				<div class="product-squares" id="outerwear">
				
				<%= div %>

				</div>

			</div>

		</div>


	</div>

</body>
</html>

