<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="index.jsp">Expense Tracker</a> 
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

<ul class="navbar-nav">

	<li class="nav-item dropdown">
	
	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" 
		data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Expenses
	</a>
		<div class="dropdown-menu" aria-labelledby="navbarDropdown">
		  <a class="dropdown-item" href="add">Add Expenses</a>
		  <a class="dropdown-item" href="expenses">Manage Expenses</a>
		  <div class="dropdown-divider"></div>
		  <a class="dropdown-item" href="#">Something else here</a>
		</div>
	</li>
	
</ul>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
	
			<li class="nav-item active text-primary">
		        <a class="nav-link" href="#">Username<span class="sr-only">(current)</span></a>
		    </li>
		    <li class="nav-item active text-primary">
		        <a class="nav-link" href="login">Login</a>
		    </li>      
		    
		    <li class="nav-item active text-primary">
		        <a class="nav-link" href="Logout">Logout</a>
		    </li>      
    </ul>
    
  </div>
</nav>