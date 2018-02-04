<jsp:include page="header.jsp">
	<jsp:param value="Profile" name="title"/>
</jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="viewmodel.LoginViewModel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body style="background-color: #2B3E50">
     <% LoginViewModel user = (LoginViewModel) session.getAttribute("user"); %>
     <div class="jumbotron">
          <h1 class="display-3">Welcome <% out.println(user.getName());%>!</h1>
          <p class="lead">asdasdasd</p>
          <hr class="my-4">
          <p>asdasdasd</p>
          <p class="lead">
          <a href="createplan"><button type="button" class="btn btn-info">Create plan</button></a>
          <a href="viewplans"><button type="button" class="btn btn-info">View plans</button></a>
          </p>
     </div>
</body>
</html>