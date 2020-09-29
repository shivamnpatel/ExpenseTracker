<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<jsp:include page="/components/bootstrap-css-js.jsp" />
</head>
<body>
	<div class="container my-5">

		<div class="row">

			<div class="col-md-4"></div>

			<div class="col-md-4">

				<div class="card">

					<div class="card-header text-center text-primary">
						<h3>Login</h3>
					</div>

					<div class="card-body">

						<form:form action="LoginUser" method="post" modelAttribute="loginUser">
							
							<div class="form-group">
								<form:input type="email" class="form-control" name="userEmail"
									path="email" placeholder="Email" required="required"/>
							</div>

							<div class="form-group">
								<form:input type="password" class="form-control" name="userPassword"
									path="password" placeholder="Password" required="required"/>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-success">Sign In</button>
							</div>
						</form:form>


					</div>

					<div class="card-footer">
						<div class="text-center">
							Don't have an account? <a href="register">Sign Up</a>
						</div>
					</div>

				</div>


			</div>

			<div class="col-md-4"></div>

		</div>

	</div>

</body>
</html>