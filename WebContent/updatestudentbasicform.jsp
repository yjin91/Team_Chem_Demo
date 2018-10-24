<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Student"%>
    
<%   
    Student student = (Student) request.getAttribute("student");
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

				<h2>Update Student: <%= student.getStudentID() %></h2>
				 
				<div class='table-block'>
				
				<form name=updateForm action=updatebsinfo method=post >
					<label>
					      Student ID:
					</label>
					   <input type=text name=studentID value="<%=student.getStudentID()%>" readonly='readonly' />
					   <br />
					<label>
					      First Name
					</label>
					   <input type=text name=fName value="<%=student.getfName()%>" />
					     <br /> 
					<label>
					      Middle Name:
					</label>
					   <input type=text name=mName value="<%=student.getmName()%>" />
					     <br />
					<label>
					      Last Name:
					</label>
					   <input type=text name=lName value="<%=student.getlName()%>" />
					   <br />
					<label>
					      Ethnic:
					</label>
					   <input type=text name=ethnic value="<%=student.getEthnic()%>" />
					   <br />
					<label>
					      Gender:
					</label>
					   <input type=text name=gender value="<%=student.getGender()%>" />
					   <br />
					<label>
					      Email:
					</label>
					   <input type=text name=email value="<%=student.getEmail()%>" />
					   <br />
					<label>
					      Nationality:
					</label>
					   <input type=text name=nationality value="<%=student.getNationality()%>" />
					   <br />
					   
					<label>
					      GRE Verbal:
					</label>
					   <input type=text name=greVerb value="<%=student.getGreVerb()%>" />
					   <br />
					   
				    <label>
					      GRE Quantitative:
					</label>
					   <input type=text name=greQuan value="<%=student.getGreQuan()%>" />
					   <br />
					   
					<label>
					      GRE Analytical Writing:
					</label>
					   <input type=text name=greAW value="<%=student.getGreAW()%>" />
					   <br />
					   
					<label>
					      Research Status:
					</label>
					   <input type=text name=inResearch value="<%=student.getInResearch() %>" />
					   <br />
					   
					<label>
					      Work Status:
					</label>
					   <input type=text name=inWork value="<%=student.getInWork() %>" />
					   <br />
					   
					<input class="submit-button" type=submit name=submit value="Update" />
					</form>								
				</div> 	   
				 <br>
				 <br>

				</div>
					<p><a href="viewstudentbasic" class="continue">Return to Database</a></p>

		</div>

</div>



</body>
</html>