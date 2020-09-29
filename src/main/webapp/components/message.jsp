<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:if test="${sessionScope.message != null }">

	<div class="alert alert-primary alert-dismissible fade show" role="alert">
	
		<strong>${sessionScope.message}</strong>
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		
	</div>

	<c:remove var="message"/>
</c:if>

<c:if test="${sessionScope.message == null }"></c:if>

