<%@page import="com.ashokit.registerapplication.model.RegisterModel"%>
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
<BR>

<% List<RegisterModel> userList= (List)request.getAttribute("COMPLETE_USER_DETAILS");%>


<BR>


<input type="Submit" value="EmployInformation" name="EmployInformation">
<BR>

<br>
<br>
<br>

<table border="5">
<tr>
<th> First Name</th>
<th>Mid Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Mobile Number</th>
<th>User Name</th>

</tr>

<%
if(null!=userList && userList.size()>0){
	for(int i=0;i<userList.size();i++){
	RegisterModel model=userList.get(i);%>
	
	<tr><td><%=model.getFirstName() %></td>
	<td><%=model.getMidName() %></td>
	<td><%=model.getLastName() %></td>
	<td><%=model.getEmail() %></td>
	<td><%=model.getMobileNumber() %></td>
	<td><%=model.getUserName() %></td>
	</tr>
	
		
	<%}
}

%>
</table>
</form>
</body>
</html>