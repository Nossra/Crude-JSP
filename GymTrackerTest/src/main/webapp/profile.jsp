<jsp:include page="header.jsp">
	<jsp:param value="Home page" name="title"/>
</jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="viewmodel.LoginViewModel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<%
		LoginViewModel user = (LoginViewModel) session.getAttribute("user");
	%>
	
	<p>Hello <% user.getUsername(); %>!</p>
</body>
</html>