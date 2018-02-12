<jsp:include page="header.jsp">
	<jsp:param value="Workout plans" name="title" />
</jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@page import="viewmodel.LoginViewModel"%>
<%@page import="entities.Exercise"%>

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
		<form method="post" > 
			<fieldset style="margin:5%;" id="form">
			     <legend>Step 1, Plan setup</legend>
				<div class="form-group" >
					<label for="planName">Plan name</label> 
					<input type="text" class="form-control" name="planName" id="planName" placeholder="Enter plan name">
					<label for="amountOfDays">Amount of days</label>
					<select class="form-control" name="amountOfDays" id="amountOfDays">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
				    </select>
				    <button type="button" onclick="nextStep()" class="btn btn-primary" style="margin-top:3%;" id="nextStepBtn" name="nextStepBtn">Next step</button>
				</div>
			</fieldset>
		</form>
	</div>
</div>
<script>
	function nextStep() {
		step2();
		var name = document.getElementById("planName").readOnly = true;
		var days = document.getElementById("amountOfDays").disabled = true;
		var nextStepBtn = document.getElementById("nextStepBtn").disabled = true;
		
	}

	function step2() {
		var form = document.getElementById("form");
		var formgroup = document.createElement('div');
		formgroup.classList.add("form-group");

		formgroup.innerHTML = 
		"<legend>Step 2, exercises</legend>" +
		"<label for=\"amountOfDays\">Choose exercise</label>" +
			"<select class=\"form-control\" name=\"exerciseSelectList\" id=\"exerciseSelectList\">"+
	    "</select>" + 
	    "<button type=\"button\"" +
		    	"onclick=\"nextStep()\"" +
			    "class=\"btn btn-primary\"" +
				"style=\"margin-top:3%;\"" +
				"id=\"nextStepBtn\"" + 
				"name=\"nextStepBtn\">" +
					"Next step" +
		"</button>"
			
		form.appendChild(formgroup);

		/*var legend = document.createElement('legend');
		legend.innerHTML = "Step 2, add exercises</br>";
				
		var select = document.createElement('select');
		select.setAttribute("type", "text");
		select.setAttribute("name", "exercises")
		select.setAttribute("placeholder", "Add exercise");
		select.classList.add("form-control");
		
		var submit = document.createElement('button');
		submit.setAttribute("type", "button");
		submit.setAttribute("name", "submit");
		submit.innerHTML = "Add exercise";
		submit.classList.add("btn");
		submit.classList.add("btn-primary");

		var cancel = document.createElement('button');
		cancel.setAttribute("type", "button");
		cancel.innerHTML = "Back";
		cancel.classList.add("btn");
		cancel.classList.add("btn-primary");

		formgroup.appendChild(legend);
		formgroup.appendChild(select);
		formgroup.appendChild(submit);
		formgroup.appendChild(cancel);
		form.appendChild(formgroup);*/
		
	}

	function cancel() {
		var name = document.getElementById("planName").readOnly = false;
		name.value="";
		var days = document.getElementById("amountOfDays").disabled = false;
		days.value="";
		var nextStepBtn = document.getElementById("nextStepBtn").disabled = false;
		var step2 = document.getElementById("step-2");
		element.parentNode.removeChild(step2);
	}

</script>
</body>
</html>