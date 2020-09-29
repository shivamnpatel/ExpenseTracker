<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expenses</title>
<jsp:include page="/components/bootstrap-css-js.jsp" />
</head>
<body>

	<div class="container">
	
		<div class="row">
		
			<div class="col-md-8 m-5 mx-auto text-center">
		
				<c:choose>
				
					<c:when test="${myExpenses}!=null ">
					
						<form:form modelAttribute="expenses">
					
						<jsp:include page="/components/message.jsp" />
					
							<table class="table table-striped">
						
							<tr>	
								<th>Expenses</th>
								<th>Date</th>
								<th>Cost</th>
								<th colspan="2">Action</th>
							</tr>
		
							<c:forEach var="exp" items="${myExpenses}">
		
								<tr>
									<td>${exp.item }</td>
									<td><fmt:formatDate value="${exp.date}"
											pattern="dd/MM/yyyy" /></td>
									<td>${exp.cost }</td>
									<td><a type="button" class="btn btn-primary"
										href="update-expenses?id=${exp.expenseId}">Update</a></td>
									<td><a type="button" class="btn btn-warning"
										onclick="return deleteExpense()" href="delete-expenses?id=${exp.expenseId}">Delete</a>
									</td>
								</tr>
		
							</c:forEach>
											
							</table>
					
						</form:form>
						
					</c:when>	
			
					<c:otherwise>
						<p>There are no expenses</p>
					</c:otherwise>
					
				</c:choose>
				
			</div>
		
		</div>
	
	</div>

</body>
</html>