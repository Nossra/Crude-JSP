<jsp:include page="header.jsp">
	<jsp:param value="Workout plans" name="title" />
</jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="viewmodel.LoginViewModel"%>

<% LoginViewModel user = (LoginViewModel) session.getAttribute("user"); %>
<div class="row">
	<div class="jumbotron" style="width: 100% !important; padding-left:5% !important;padding-right:5% !important;">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="viewplans">Manage plans</a></li>
                <li class="breadcrumb-item active">Create plan</li>
            </ol>
		<h1 class="display-3">
			Create plans for
			<% out.println(user.getUsername()); %>
		</h1>
		<p class="lead">Unlimited plans for different purposes</p>
		<hr class="my-4">

	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<form> 
			<fieldset style="margin:5%;">
			     <legend>Step 1</legend>
				<div class="form-group">
					<label for="planName">Plan name</label> 
					<input type="text" class="form-control" id="planName" placeholder="Enter plan name">
					<label for="amountOfDays">Amount of days</label>
					<select class="form-control" name="amountOfDays">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
				    </select>
				    <button type="button" class="btn btn-primary" style="margin-top:3%;" name="nextStepBtn">Next step</button>
				</div>
			</fieldset>
		</form>
	</div>
</div>
</body>
</html>