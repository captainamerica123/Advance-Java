<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.ashokit.registerapplication.model.RegisterModel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<form action="LoginServlet" method="post">
<body>
<br>User Name : <input type="text" id="userName" name="userName">
<br>Password : <input type="password" id="password" name="password">
<br>
<input type="Submit" name="Login">

<%
List<RegisterModel> l=(List)session.getAttribute("USER_DATA");


%>
<table border="3">
  <tr b>
    <th>EMP Name</th>
    <th>EMP Email</th>
    <th>EMP Mobile</th>
  </tr>
  <%if(null!=l){
  for(int i=0;i<l.size();i++){
	  RegisterModel model=l.get(i);
	  if(null!=model){
  %>
	  <tr><td>
	  <%=model.getFirstName() %></td>
	  <td><%=model.getEmail() %></td>
	  <td><%=model.getMobileNumber() %></td></tr>
	  <%}
	  }
	  }%>
  
</table>
</body>
</form>
</html>