 <%@page import="entities.Exercise"%>
<jsp:include page="header.jsp">
    <jsp:param value="Workout plans" name="title"/>
</jsp:include>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="viewmodel.LoginViewModel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body style="background-color: #2B3E50">
     <% LoginViewModel user = (LoginViewModel) session.getAttribute("user"); %>
     <div class="jumbotron">
	      <h1 class="display-3">Plans by <% out.println(user.getUsername()); %></h1>
	      <p class="lead">View your plan information, edit or delete them as needed.</p>
	      <hr class="my-4">
	      <p>Create a new plan here.</p>
	      <p class="lead">
	      <a href="createplan"><button type="button" class="btn btn-info">Create plan</button></a>
	      </p>
     </div>

</body>
</html>