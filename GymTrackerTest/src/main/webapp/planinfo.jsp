 <%@page import="java.util.List"%>
<%@page import="viewmodel.PlanInfoViewModel"%>
<%@page import="entities.Exercise"%>
<jsp:include page="header.jsp">
    <jsp:param value="Workout plans" name="title"/>
</jsp:include>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="viewmodel.LoginViewModel" %>

     <% 
     LoginViewModel user = (LoginViewModel) session.getAttribute("user");
     List<PlanInfoViewModel> vm = user.selectPlanInfoById(request.getParameter("id"));
     //PlanInfoViewModel vmPlanName = vm.stream().filter(p -> p.getPlanName());
     %>
     <div class="row">
     	<div class="col-6 offset-3">
   		     	<div class="jumbotron">
			          <h1 class="display-3"> <% out.println(vm.get(0).getPlanName()); %></h1>
			          <p class="lead">View your plan information, edit or delete them as needed.</p>
			          <hr class="my-4">
			          <p>Create a new plan here.</p>
			          <p class="lead">
			          </p>
		   	  	</div>
  			</div>
   		</div>
	</div>
</body>
</html>