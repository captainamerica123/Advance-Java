<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page  errorPage="error.jsp" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RegistrationController" method="post">
<H1>Welcome to ASKOH IT ADVANCE JAVA course by KARTHIK</H1>
<BR>



<br>
First Name <input type="text" id="firstName", name="firstName"><br><Br>
Mid Name <input type="text" id="midName", name="midName"><br><Br>
Last Name <input type="text" id="lastName", name="lastName"><br><Br>
Email <input type="text" id="email", name="email"><br><Br>
Mobile Number <input type="text" id="mobileNumber", name="mobileNumber"><br><Br>
User Name <input type="text" id="userName", name="userName"><br><Br>
Password <input type="password" id="password", name="password"><br><Br>
<input type="SUBMIT" name="Register"><br><Br>
<%
int a=10;
int b=6;  
int c=a/b;  
out.print("division of numbers is: "+c);  %>
</form>
</body>
</html>