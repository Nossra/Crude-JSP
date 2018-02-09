<%@page import="java.util.List"%>
<%@page import="viewmodel.PlanInfoViewModel"%>
<%@page import="entities.Exercise"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Testing ..</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
				<script
  src="http://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
		<script>
		<%@ include file="js/bootstrap.min.js" %>
		<%@ include file="js/bootstrap.bundle.js" %>
		</script>
		
		<style>
				<%@ include file="css/bootstrap.min.css" %>
				<%@ include file="css/bootstrap-reboot.min.css" %>
				<%@ include file="css/bootstrap-grid.min.css" %>
				<%@ include file="css/_variables.scss" %>
				<%@ include file="css/_bootswatch.scss" %>
	
			.nav-st {
				position: fixed !important;
			    width: 100% !important;
			    z-index: 99 !important;
	   		}
		</style>
	</head>
	<body style="background-color: #2B3E50">
		 <nav class="navbar navbar-expand-lg navbar-dark bg-dark nav-st" >
         <a class="navbar-brand" href="#">gym</a>
         <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
           <span class="navbar-toggler-icon"></span>
         </button>
       
         <div class="collapse navbar-collapse" id="navbarColor03">
           <ul class="navbar-nav mr-auto">
             <li class="nav-item">
               <a class="nav-link" href="profile">Profile <span class="sr-only"></span></a>
             </li>
                          <li class="nav-item">
               <a class="nav-link" href="logout">Logout<span class="sr-only"></span></a>
             </li>
             <li class="nav-item">
               <a class="nav-link" href="viewplans">Manage plans <span class="sr-only"></span></a>
            </li>
             <li class="nav-item">
               <a class="nav-link" href="newday">New day <span class="sr-only"></span></a>
             </li>
           </ul>
         </div>
      </nav>