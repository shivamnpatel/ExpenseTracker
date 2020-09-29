<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/components/bootstrap-css-js.jsp" />
<title>Welcome</title>
</head>
<body>

	<div class="container mt-4">
	
		<!--1st Row -->
		<div class="row m-3 mt-5">
		
			<div class="col-md-4">
			
				<div class="card">
				
					<div class="card-body">
					
						<h4 class="text-center">Today's Expenses</h4>
						<p>${allExpensesTotal.get(0) } &#8377;</p>
					</div>
				
				</div>
			
			</div>
			
			<div class="col-md-4">
			
				<div class="card">
				
					<div class="card-body">
					
						<h4 class="text-center">Yesterday's Expenses</h4>
						<p>${allExpensesTotal.get(1) } &#8377;</p>
					</div>
				
				</div>
			
			</div>
			
			<div class="col-md-4">
			
				<div class="card">
				
					<div class="card-body">
					
						<h4 class="text-center">Last 7 days Expenses</h4>
						<p>${allExpensesTotal.get(2) } &#8377;</p>
					</div>
				
				</div>
			
			</div>
		
		</div>
		
		<!-- 2nd Row -->
		<div class="row m-3 mt-3">
		
			<div class="col-md-4">
			
				<div class="card">
				
					<div class="card-body">
					
						<h4 class="text-center">Last 30 days Expenses</h4>
						<p>${allExpensesTotal.get(3) } &#8377;</p>
					</div>
				
				</div>
			
			</div>
			
			<div class="col-md-4">
			
				<div class="card">
				
					<div class="card-body">
					
						<h4 class="text-center">This year Expenses</h4>
						<p>${allExpensesTotal.get(4) } &#8377;</p>
					</div>
				
				</div>
			
			</div>
			
			<div class="col-md-4">
			
				<div class="card">
				
					<div class="card-body">
					
						<h4 class="text-center">Total Expenses</h4>
						<p>${allExpensesTotal.get(5) } &#8377;</p>
					</div>
				
				</div>
			
			</div>
		
		</div>
		
	</div>
	
	<!-- Side Bar buttons -->
	
	<!-- <div class="mt-3 text-center">
	
		<b>Expenses</b><br>
		<a href="add">Add Expenses</a><br>
		<a href="expenses">Manage Expenses</a>
		
	</div>
	<div class="mt-3 text-center">
	
		<b>Expenses Report</b><br>
		<a href="expense-report">Datewise Report</a><br>
		<a href="expense-report">Monthwise Report</a><br>
		<a href="expense-report">Yearwise Report</a><br>
		
	</div> -->
	
</body>
</html>