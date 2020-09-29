<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
<jsp:include page="/components/bootstrap-css-js.jsp" />
</head>

<body>

	<div class="container my-5">

		<div class="row">

			<div class="col-md-4"></div>

			<div class="col-md-4">

				<div class="card">

					<div class="card-header text-center text-primary">
						<h3>Register</h3>
					</div>

					<div class="card-body">
	
						<jsp:include page="/components/message.jsp" />
					
						<form:form action="register" method="post" modelAttribute="registerUser">

							<div class="form-group">
								<form:input class="form-control" name="userName"
									path="userName" placeholder="User Name" required="required"/>
								<form:errors path="userName" cssClass="error"/>	
							</div>

							<div class="form-group">
								<form:input type="email" class="form-control" name="userEmail"
									path="email" placeholder="Email" required="required"/>
									<form:errors path="email" cssClass="error"/>
							</div>
							
							<div class="form-group">
								<form:input type="text" class="form-control" name="userMobileNo"
									path="mobileNo" placeholder="Mobile Number" required="required"/>
									<form:errors path="mobileNo" cssClass="error"/>
							</div>

							<div class="form-group">
								<form:input type="password" class="form-control" name="userPassword"
									path="password" placeholder="Password" required="required"/>
									<form:errors path="password" cssClass="error"/>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-success">Sign Up</button>
							</div>

						</form:form>

					</div>

					<div class="card-footer">
						<div class="text-center">
							Already have an account? <a href="login">Sign in</a>
						</div>
					</div>

				</div>



			</div>

			<div class="col-md-4"></div>

		</div>

	</div>

</body>
</html>