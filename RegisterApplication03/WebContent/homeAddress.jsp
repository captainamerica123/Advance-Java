<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ashokit.registerapplication.model.RegisterModel"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="HomeController" method="post">
<%String userName=(String)session.getAttribute("USER_NAME"); %>
<h1>Login Successful: <%=userName %></h1>
<br>

Temp Address : <input type="text" name="tempAddress", id="tempAddress">
<BR>
Perm Address : <input type="text" name="permAddress", id="permAddress">


<input type="Submit" value="Save Address" name="Save Address">
<BR>

<br>
<br>
<br>

</form>

</body>
</html>