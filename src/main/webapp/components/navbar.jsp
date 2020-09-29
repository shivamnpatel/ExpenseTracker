<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!--  get the base url of the jsp page -->
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="${baseURL }">Expense Tracker</a> 
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

<ul class="navbar-nav">

	<li class="nav-item dropdown">
	<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">Expenses </a>
		<div class="dropdown-menu">
		  <a class="dropdown-item" href="add">Add Expenses</a>
		  <a class="dropdown-item" href="expenses">Manage Expenses</a> 
		</div>
	</li>
	
	<li class="nav-item dropdown">
	<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">Expense Report</a>
		<div class="dropdown-menu">
		  <a class="dropdown-item" href="expense-report">Datewise Reports</a>
		  <a class="dropdown-item" href="expense-report">Monthwise Reports</a>
		  <a class="dropdown-item" href="expense-report">Yearwise Reports</a>
		</div>
	</li>
	
	
</ul>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
  
    <ul class="navbar-nav ml-auto">
	
			<c:if test="${sessionScope.userEmail == null}">
			
		    	<li class="nav-item active text-primary">
		        	<a class="nav-link" href="register">Register</a>
		    	</li> 
		    	     
		    	<li class="nav-item active text-primary">
		        	<a class="nav-link" href="login">Login</a>
		    	</li>      
	
			</c:if>  
			   
			<c:if test="${sessionScope.userEmail != null}">
			
				<li class="nav-item active text-primary">
		        	<a class="nav-link" href="#">${sessionScope.userName}<span class="sr-only">(current)</span></a>
		   		</li>      
		    
		    	<li class="nav-item active text-primary">
		        	<a class="nav-link" href="Logout">Logout</a>
		    	</li>
			
			</c:if>     
    </ul>
    
  </div>
  
</nav>