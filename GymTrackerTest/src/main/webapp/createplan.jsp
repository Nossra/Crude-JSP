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
<div class="row" id="step1">
	<div class="col-12">
		<form method="post" style="margin:5%;"> 
			     <legend>Step 1, Plan setup</legend>
				<div class="form-group" >
					<label for="planName">Plan name</label> 
					<input type="text" class="form-control" name="planName" id="planName" placeholder="Enter plan name">
					<label for="amountOfDays">Amount of days</label>
					<select class="form-control" name="amountOfDays" id="amountOfDays">
						<option value="" disabled selected>Select how many days you workout</option>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
				    </select>
				    <button type="button" onclick="step2()" class="btn btn-primary" style="margin-top:3%;" id="nextStepBtn" name="nextStepBtn">Next step</button>
				</div>
		</form>
	</div>
</div>

<div class="row" id="step2" style="display:none !important;">
	<div class="col-12">
	<form action="" method="post" id="exercisesForm" style="margin:5%;">
		<div class="form-group">
			<legend>Step 2, exercises</legend>
			<label for="exerciseSelectList">Choose exercise</label>
			<select class="form-control" name="exerciseSelectList" id="exerciseSelectList">
		    	<option value="" disabled selected>Choose your exercise</option>
		    </select>
		    <label for="sets">Amount of sets</label>
		    <select type="text" name="sets" onchange="createSetFields()" id="sets" placeholder="Amount of sets" class="form-control">
		        <option value="" disabled selected>Sets for this exercise</option>
		        <option value="1">1</option>
		        <option value="2">2</option>
		        <option value="3">3</option>
		        <option value="4">4</option>
		        <option value="5">5</option>
		    </select>
		    <button type="button" id="goToStep1Btn" class="btn btn-primary" style="margin-top:3% !important" onclick="goBack()">Go back</button>
		</div>
	</form>
	</div>
</div>
<div class="row">
    <div class="col-12">
        <form action="" method="post" id="exercises" style="margin:5%;">
        
        
        </form>
    </div>
</div>
    
<script>

	function goBack() {
		var step1 = document.getElementById("step1").style = "display: visible !important;"
			var step2 = document.getElementById("step2").style = "display: none !important;"
			var name = document.getElementById("planName").readOnly = false;
			var days = document.getElementById("amountOfDays").disabled = false;
			var nextStepBtn = document.getElementById("nextStepBtn").disabled = false;
	}

	function step2() {
		var step1 = document.getElementById("step1").style = "display: none !important;"
		var step2 = document.getElementById("step2").style = "display: visible !important;"
		var name = document.getElementById("planName").readOnly = true;
		var days = document.getElementById("amountOfDays").disabled = true;
		var nextStepBtn = document.getElementById("nextStepBtn").disabled = true;
		var e = document.getElementById("exerciseSelectList");
		if (e.length < 2) {
			$.ajax({
				"url": "http://localhost:8080/GymTrackerTest/api/exercise",
				"method": "get",
 				"success": function(result) {
					for(var i = 0; i < result.length;i++) {
						var option = document.createElement("option");
						option.innerText = result[i].name;
						option.value = result[i].id;
						e.appendChild(option);
					}					
 	 			}
			})
		}
	}

	function createSetFields(value) {
		var e = document.getElementById("sets");
		var val = e.options[e.selectedIndex].value;
		var div = document.createElement('div');
		div.innerHTML = "";
		for (var i = 0; i < val; i++) {
			div.innerHTML += 
			"<legend>Set "+(i+1)+"</legend>"
		+	"<label>Weights</label>" 
		+	"<input type=\"text\" name=\"weights"+(i+1)+"\" placeholder=\"Weights\" class=\"form-control\">"
		+	"<label>Repetitions</label>"
		+	"<input type=\"text\" name=\"repetitions"+(i+1)+"\" placeholder=\"Repetitions\" class=\"form-control\">"
		}
		
		var ex = document.getElementById("exercises");
		ex.appendChild(div);
	}
	
</script>
</body>
</html>