<jsp:include page="header.jsp">
	<jsp:param value="Profile" name="title"/>
</jsp:include>
 <%@page import="java.util.List"%>
<%@page import="viewmodel.PlanInfoViewModel"%>
<%@page import="viewmodel.LoginViewModel"%>
<%@page import="entities.Exercise"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 	 <% 
     LoginViewModel user = (LoginViewModel) session.getAttribute("user");	
     %>
	     <div class="row">
   	     <div class="col-12">
	     	<div class="jumbotron"">
		          <h1 class="display-3"> New day</h1>
		          <p class="lead">Choose plan</p>
	   	  	</div>
	   	  </div>
   		</div>
	</div>
</body>