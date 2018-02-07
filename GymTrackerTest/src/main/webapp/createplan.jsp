<jsp:include page="header.jsp">
    <jsp:param value="Workout plans" name="title"/>
</jsp:include> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="viewmodel.LoginViewModel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #2B3E50">
     <% LoginViewModel user = (LoginViewModel) session.getAttribute("user"); %>
      <div class="row">
  		<div class="col-6 offset-3">
	     	<div class="jumbotron">
	          <h1 class="display-3">Create plans for <% out.println(user.getUsername()); %></h1>
	          <p class="lead">Create unlimited plans for different purposes</p>
	          <hr class="my-4">
	          <p>Create a new plan here.</p>
	          <p class="lead">
	          <button type="button" class="btn btn-info">Create plan</button>
	          </p>
   	 		</div>
   		</div>
     </div>
     	

     
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  <% out.println(user.selectPlanNames().get(0)); %>
</button>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><% out.println(user.selectPlanNames().get(0)); %></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

     
</body>
</html>