 <%@page import="entities.Exercise"%>
<jsp:include page="header.jsp">
    <jsp:param value="Workout plans" name="title"/>
</jsp:include>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="viewmodel.LoginViewModel" %>


     <% LoginViewModel user = (LoginViewModel) session.getAttribute("user"); %>
     <div class="row">
     	<div class="col-12">
	     <div class="jumbotron">
		      <h1 class="display-3">Plans by <% out.println(user.getUsername()); %></h1>
		      <p class="lead">View your plan information, edit or delete them as needed.</p>
		      <hr class="my-4">
		      <p>Create a new plan here.</p>
		      <p class="lead">
		      <a href="createplan"><button type="button" class="btn btn-primary">Create plan</button></a>
		      </p>
	     </div>
	    </div>
     </div>
     </div>
</body>
</html>