
<%@page import="java.util.List"%>
<%@page import="viewmodel.PlanInfoViewModel"%>
<%@page import="entities.Plan"%>
<jsp:include page="header.jsp">
	<jsp:param value="Workout plans" name="title" />
</jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="viewmodel.LoginViewModel"%>

<% 
	LoginViewModel user = (LoginViewModel) session.getAttribute("user");
	List<Plan> vm = user.selectPlanNames(user.getId());
	int id = Integer.parseInt(request.getParameter("id"));
	Plan plan = new Plan();
	for (int i = 0; i < vm.size(); i++) {
		if (id == vm.get(i).getId()) {
			plan.setName(vm.get(i).getName());
		}
	}
	//PlanInfoViewModel vmPlanName = vm.stream().filter(p -> p.getPlanName());
%>
<div class="row">
	<div class="col-12">
		<div class="jumbotron">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="viewplans">Manage plans</a></li>
				<li class="breadcrumb-item active"> <% out.println(plan.getName()); %> </li>
			</ol>
			<h1 class="display-3"><% out.println(plan.getName()); %> </h1>
			<p class="lead">View your plan information, edit or delete them as needed.</p>
			<hr class="my-4">
			<p class="lead">
			<button type="button" class="btn btn-danger">Delete plan</button>
		</div>
		</p>
	</div>
</div>
</div>
</div>
</body>
</html>