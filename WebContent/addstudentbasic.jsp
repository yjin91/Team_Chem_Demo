<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Student"%>
    
<%   
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

				<h2>Add Student Record</h2>
				 
				<div class='table-block'>
				
				<form name=addStudentBasic action=addstudent method=post >
					      
					   <p>Student ID:</p>
					   <input type=text name=studentID value="" />
					   <br />
					<p>First Name</p>
					   <input type=text name=fName value="" />
					     <br /> 
					<p>Middle Name:</p>
					   <input type=text name=mName value="" />
					     <br />
					<p>Last Name:</p>
					   <input type=text name=lName value="" />
					   <br />
					<p>Ethnic:</p>
					   <input type=text name=ethnic value="" />
					   <br />
					<p>Gender:</p>
					   <input type=text name=gender value="" />
					   <br />
					<p>Email:</p>
					   <input type=text name=email value="" />
					   <br />
					<p>Nationality:</p>
					   <input type=text name=nationality value="" />
					   <br />
					<p>GRE Verbal:</p>
					   <input type=text name=greVerb value="" />
					   <br />
					   
				    <p>GRE Quantitative:</p>
					   <input type=text name=greQuan value="" />
					   <br />
					   
					<p>GRE Analytical Writing:</p>
					   <input type=text name=greAW value="" />
					   <br />
					   
					<p>Research Status:</p>
					   <input type=text name=inResearch value="" />
					   <br />
					   
					<p>Work Status:</p>
					   <input type=text name=inWork value="" />
					   <br />
					   
					<input class="submit-button" type=submit name=Add value="Add" />
					</form>								
				</div> 	   
				</div>
					<p><a href="viewstudentbasic" class="continue">Return to Database</a></p>

		</div>

</div>


</body>
</html>