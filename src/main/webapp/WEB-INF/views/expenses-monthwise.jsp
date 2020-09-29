<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/components/bootstrap-css-js.jsp" />
<title>Report</title>
</head>
<body>

	<div class="container mt-5">
		
			<div class="row">
			
				<div class="col-md-5 mx-auto">
				
					<h3 class="text-center mb-4">Monthly Report</h3>
					
					<table class="table table-striped">
					
						<tr>
							<th>Month-Year</th>
							<th>Expense Amount</th>
						</tr>
						
						<c:forEach var="item" items="${totalMonthlyExpenses}">
							
							<tr>
								<td>${item[0]}-${item[1]}</td>
								<td>${item[2] } &#8377;</td>
							</tr>
						
						</c:forEach>
						
					</table>
					
					<div class="expenses">
						Total Expenses:  ${totalExpensesMon } &#8377;
					</div>
				
				</div>
			
			</div>
		
		</div>
	
</body>
</html>