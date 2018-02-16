<%@page import="viewmodel.LoginViewModel"%>
<jsp:include page="header.jsp">
	<jsp:param value="Profile" name="title"/>
</jsp:include>
	     <% LoginViewModel user = (LoginViewModel) session.getAttribute("user"); %>
	     <div class="row">
	     	<div class="col-12">
     	     <div class="jumbotron">
		          <h1 class="display-3">Welcome <% out.println(user.getName());%>!</h1>
		          <p class="lead">asdasdasd</p>
		          <hr class="my-4">
		          <p>asdasdasd</p>
		          <p class="lead">
		          <a href="createplan"><button type="button" class="btn btn-primary">Create plan</button></a>
		          <a href="viewplans"><button type="button" class="btn btn-primary">View plans</button></a>
		          </p>
		        </div>
	     	</div>
  		</div>
  	</div>
</body>
</html>