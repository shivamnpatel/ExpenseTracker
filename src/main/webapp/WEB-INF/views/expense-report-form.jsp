	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/components/bootstrap-css-js.jsp" />
<title>Expense Report</title>
</head>
<body>

		<div class="container mt-5">
		
			<div class="row">
			
				<div class="col-md-4 mx-auto">
				
					<form action="expense-report" method="post">
					
					<h4 align="center">Expense Report</h4>
					
						<div class="form-group mt-4">
							<label for="fromDateId">From Date</label>
							<input type="date" class="form-control" name="fromDate" id="fromDateId"
								placeholder="dd-mm-yyyy" required="required"/>
							</div>

							<div class="form-group">
							<label for="toDateId">To Date</label>
							<input type="date" class="form-control" name="toDate" id="toDateId"
								placeholder="dd-mm-yyyy" required="required"/>
							</div>

							<div class="text-center">
								<input type="submit" name="datewise"
									value="Datewise" class="btn btn-primary">
								<input type="submit" name="monthwise"
									value="Monthwise" class="btn btn-primary">
								<input type="submit" name="yearwise"
									value="Yearwise" class="btn btn-primary">
							</div>
					
					</form>
				
				</div>
			
			</div>
		
		</div>

</body>
</html>