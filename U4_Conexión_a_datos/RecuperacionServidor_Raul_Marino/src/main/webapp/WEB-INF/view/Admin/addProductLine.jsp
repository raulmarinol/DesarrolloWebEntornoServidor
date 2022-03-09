<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/bootstrap.jsp" />
<title>addProductLine</title>
</head>
<body>
	<div class="row justify-content-center">
		<jsp:include page="../include/barra.jsp" />
	
			<div class="col-8">
			
			<form method="post">
				
				<h2 class="text-center"><fmt:message key="AddProductLine" /></h2>
				<label for="productLine" class="form-label mt-3"><fmt:message key="productLine" /></label>
				<input type="text" class="form-control" id="productLine" name="productLine">
				<c:if test="${error!=null}">
					<p class="text-danger text-small mt-3">${error}</p>
				</c:if>
				<label for="textDescription" class="form-label mt-3"><fmt:message key="textDescription" /></label>
				<input type="text" class="form-control" id="textDescription" name="textDescription">
				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR" />
				<c:if test="${confir!=null}">
							<h3 class="text-success text-small mt-3">${confir}</h3>
				</c:if>
			</form>
			
				
				

		
		</div>

	</div>
  
  

</body>
</html>