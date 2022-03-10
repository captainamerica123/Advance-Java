<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/Header.jsp" %>
<h1>Welcome to JSP</h1>
<%
List<Integer> l=new ArrayList();
l.add(10);
l.add(20);
%>

<h1>elements:<%=l %></h1>
<%@ include file="/Footer.jsp" %>

</body>
</html>