<jsp:include page="header.jsp">
	<jsp:param value="Workout plans" name="title" />
</jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@page import="viewmodel.LoginViewModel"%>
<%@page import="entities.Exercise"%>
<%@page import="java.util.List"%>

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
		<hr class="my-4">

	</div>
</div>
<div class="row">
	<div class="col-12">
		<form method="post" style="margin:5%;"> 
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
				    <button type="button" onclick="step2()" class="btn btn-primary" style="margin-top:3%;" id="nextStepBtn" name="nextStepBtn">Next step</button>
					<input type="hidden" name="step" value="1"/> 
				</div>
		</form>
	</div>
</div>

<div class="row">
	<div class="col-12">
	<form action="" method="post" id="exercisesForm" style="margin:5%;">
		<div class="form-group">
			<legend>Step 2, exercises</legend>
			<label for="exerciseSelectList">Choose exercise</label>
			<select class="form-control" name="exerciseSelectList" id="exerciseSelectList">
		    </select>
		    <label for="sets">Amount of sets</label>
		    <select type="text" name="sets" onchange="createSetFields()" id="sets" placeholder="Amount of sets" class="form-control">
		        <option>1</option>
		        <option>2</option>
		        <option>3</option>
		        <option>4</option>
		        <option>5</option>
		        <option>6</option>
		        <option>7</option>
		        <option>8</option>
		        <option>9</option>
		    </select>
		</div>
	</form>
	</div>
</div>
<script>


	function step2() {
		var name = document.getElementById("planName").readOnly = true;
		var days = document.getElementById("amountOfDays").disabled = true;
		var nextStepBtn = document.getElementById("nextStepBtn").disabled = true;
		var e = document.getElementById("exerciseSelectList");
		$.ajax({
				"url": "http://localhost:8080/GymTrackerTest/api/exercise",
				"method": "get",
 				"success": function(result) {
					for(var i = 0;i < result.length;i++) {
						var option = document.createElement("option");
						option.innerText = result[i].name;
						option.value = result[i].id;
						e.appendChild(option);
					}					
 	 			}
			})
	}

	function createSetFields() {
		var sets = document.getElementById("sets").value;
	    var div = document.createElement('div');
		for (var i = 0; i < sets; i++) {
		    div.innerHTLM = 
			    "<label>Weight</label" +
			    "<input type=\"text\" name=\"weightInput\" placeholder\"Weight\">" +
			    "<label>Repetitions</label>" + 
			    "<input type=\"text\" name=\"repetitionInput\" placeholder\"Weight\">";
		}
		var exerciseForm = document.getElementById("exercisesForm");
		exerciseForm.appendChild(div);
	}
	
</script>
</body>
</html>