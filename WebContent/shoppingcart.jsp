<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

String div = (String) request.getAttribute("div");
int carttotal = (Integer)request.getAttribute("carttotal");

%>    
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Green & Jin Shopping Cart</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/_css/style.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/_css/bootstrap.css" type="text/css">

</head>
<body>
<div class="container logo">
 
         <a href="signout" class="continue out">Sign Out</a>
		<img src="./_img/finallogo.png">

		<div class="shopping-cart">

			<div class="check-out">
		
				<a href="viewproduct" class="continue">Continue Shopping</a>

				<h2>Shopping Cart</h2>
				    
				   <%=div %>

				<div class="total-block">
					<div class="h2-section">
					<h2>Cart Total:</h2><h2 class="sum-total"><%=carttotal %></h2>
				</div>
					<p><a href="orderconfirmation.jsp" class="continue">Checkout</a></p>

				</div>


			</div>

		</div>


	</div>

</body>
</html>

