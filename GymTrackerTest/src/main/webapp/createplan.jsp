<jsp:include page="header.jsp">
    <jsp:param value="Workout plans" name="title"/>
</jsp:include> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="viewmodel.LoginViewModel" %>

     <% LoginViewModel user = (LoginViewModel) session.getAttribute("user"); %>
      <div class="row">
     	<div class="jumbotron" style="width:100% !important;">
          <h1 class="display-3">Create plans for <% out.println(user.getUsername()); %></h1>
          <p class="lead">Create unlimited plans for different purposes</p>
          <hr class="my-4">
          <p>Create a new plan here.</p>
          <p class="lead">
          <button type="button" class="btn btn-info">Create plan</button>
          </p>
		</div>
     </div>
     
</body>
</html>