<jsp:include page="header.jsp">
	<jsp:param value="login" name="Login"/>
</jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm">
				<form method="post" action="login">
					User: <input type="text" name="user" placeholder="Username" /><br>
					Password: <input type="password" name="password" placeholder="Password" />
					<input type="submit" value="Submit" class="btn btn-secondary">
				</form>
			</div>
			<div class="col-sm">
			</div>
		</div>
	</div>
		
</body>
</html>