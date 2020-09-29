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
			
				<div class="col-md-4 mx-auto">
				
					<h3 class="text-center mb-4">Yearly Report</h3>
					
					<table class="table table-striped">
					
						<tr>
							<th>Year</th>
							<th>Expense Amount</th>
						</tr>
						
						<c:forEach var="item" items="${totalYearlyExpenses}">
						
							<tr>
								<td>${item[0] }</td>
								<td>${item[1] }  &#8377;</td>
							</tr>
						
						</c:forEach>
						
					</table>
				
					<div class="expenses">
						Total Expenses:  ${totalExpensesYear } &#8377;
					</div>
				
				</div>
			
			</div>
		
		</div>
	
</body>
</html>