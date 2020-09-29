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
			
				<div class="col-md-6 mx-auto">
				
					<h3 class="text-center mb-4">Datewise Report</h3>
					
					<table class="table table-striped">
					
						<tr>
							<th>Expense Item</th>
							<th>Date(dd-mm-yyyy)</th>
							<th>Amount</th>
						</tr>
						
						<c:forEach var="item" items="${expenseFromRange}">
						
							<tr>
								<td>${item.item }</td>
								<td><fmt:formatDate value="${item.date }" pattern="dd-MM-yyyy"/></td>
								<td>${item.cost } &#8377;</td>
							</tr>
						
						</c:forEach>
						
					</table>
					
					<div class="expenses">
						Total Expenses:  ${totalExpensesDay } &#8377;
					</div>
					
				</div>
			
			</div>
		
		</div>
	
</body>
</html>