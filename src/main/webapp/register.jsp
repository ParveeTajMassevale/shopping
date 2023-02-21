<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="shopping.model.User" %>
    <%
    User auth = (User)request.getSession().getAttribute("auth");
    if(auth!=null){
    	request.setAttribute("auth",auth);
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTER</title>
<%@ include file = "includes/head.jsp" %>
</head>
<body>
<%@ include file = "includes/navbar.jsp" %>
	<div class ="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">REGISTER</div>
			<div class="card-body">
				<form action="register" method="post">
					<div class="form-group">
						<label>Name</label> <input
							class="form-control" name="register-name"
							placeholder="Enter Your Name" required>
					</div>
					<div class="form-group">
						<label>Email Address</label> <input type="email"
							class="form-control" name = "register-email"
							placeholder="Enter Your Email" required>
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name ="register-password"
							placeholder="Enter your password" required>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Register</button>
					</div>
				</form>
			</div>
		</div>
	</div>
<%@ include file = "includes/footer.jsp" %>

</body>
</html>