<%@page import="com.bhushan.RegisterApplication.Model.RegisterModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AdminController" method="get"> 
<h1>Welcome to Admin Page</h1>
<br>
<% List<RegisterModel>userList= (List)request.getAttribute("COMPLETE_USER_DETAILS");%>
<input type="SUBMIT" value="employeeinformation" name="Click here for getting emp info">
<br>
<br>
<table border="5px">
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Age</th>
<th>UserId</th>
<th>UserPassword</th>
</tr>
<% 
if(null!=userList && userList.size()>0){
	for(int i=0;i<userList.size();i++)
	{
		RegisterModel model=userList.get(i);%>
	
		<tr><td><%=model.getFirstname() %></td>
		<td><%=model.getLastname() %></td>
		<td><%=model.getEmail() %></td>
		<td><%=model.getAge() %></td>
		<td><%=model.getUserid() %></td>
		<td><%=model.getPassword() %></td>
		</tr>
	<%}
	}
%>
</table>
</form>
</body>

</html>