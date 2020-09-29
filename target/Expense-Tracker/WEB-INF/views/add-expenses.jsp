<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Expenses</title>
<jsp:include page="/components/bootstrap-css-js.jsp" />
</head>
<body>

	<div class="container m-5">

		<div class="row">

			<div class="col-md-4"></div>

			<div class="col-md-4">

				<div class="card">

					<div class="text-center text-primary">
						<h3>Add Expenses</h3>
					</div>

					<div class="card-body">

						<form:form action="addedExpenses" method="post" modelAttribute="expenses">

							<div class="form-group">
								<form:input class="form-control" name="item"
									path="item" placeholder="Expense Item" required="required"/>
								<form:errors path="item" cssClass="error"/>	
							</div>

							<div class="form-group">
								<form:input type="text" class="form-control" name="cost"
									path="cost" placeholder="Cost" required="required"/>
									<form:errors path="cost" cssClass="error"/>
							</div>
							
							<div class="form-group">
								<form:input type="date" class="form-control" name="date"
									path="date" placeholder="Date" required="required"/>
									<form:errors path="date" cssClass="error"/>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-success">Add Expense</button>
							</div>

						</form:form>

					</div>

				</div>

				<a href="expenses" style="text-decoration: underline;">Back to expenses</a>

			</div>

			
			<div class="col-md-4"></div>

		</div>

	</div>

</body>
</html>