<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RegistrationController" method="post">
<h1>For login,please<a href="login.jsp">click here</a>to continue</h1>
<br>
<h1>For Admin Access,please<a href="admin.jsp">click here</a></h1>

<h1>Welcome to register jsp</h1>
<br>
<h1>First Name:<input type="text" id="firstname" name="firstname"></h1>
<h1>last name:<input type="text" id="lastname" name="lastname"> </h1>
<h1>Email:<input type="text" id="email" name="email"> </h1>
<h1>age:<input type="text" id="age" name="age"> </h1>
<h1>user id:<input type="text" id="userid" name="userid"></h1>
<h1>user password:<input type="password" id="password" name="password"></h1>
<br>
<input type="SUBMIT" name="Register">
<%-- <%
int a=10;
int b=0;
int c=a/b;
out.print("division of no is:"+c);
%> --%>
</form>
</body>
</html>