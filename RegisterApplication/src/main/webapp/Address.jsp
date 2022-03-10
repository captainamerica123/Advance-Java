<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="HomeController" method="post">
<%String user_id=(String)session.getAttribute("User_Id"); %>
<h1>Login Successful:<%=user_id %></h1>
<br>
Temp address:<input type="text" name="tempaddress" id="tempaddress"> 
<BR>
per address:<input type="text" name="peraddress" id="peraddress"> 

<input type="submit" value="save address" name="save address">

</form>

</body>
</html>