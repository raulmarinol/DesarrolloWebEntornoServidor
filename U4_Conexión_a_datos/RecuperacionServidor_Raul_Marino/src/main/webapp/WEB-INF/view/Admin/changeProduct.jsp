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
<title>Change Product</title>
</head>
<body>
	<div class="row justify-content-center">
		<jsp:include page="../include/barra.jsp" />
	
			<div class="col-8">
			
			<form method="post">
				
				<h2 class="text-center"><fmt:message key="asigPro" /></h2>
				
					
				<label for="productName" class="form-label mt-3"><fmt:message key="prod" /></label><br>
				<select name="productName" id="productName">
					<c:forEach items="${productList}" var="p">
						<option type="text" value="${p.productName}" selected>${p.productName}</option>
					</c:forEach>
				</select><br>
				
				<label for="productLine" class="form-label mt-3"><fmt:message key="cate" /></label><br>
				<select name="productLine" id="productLine">
					<c:forEach items="${productLineList}" var="pl">
						<option type="text" value="${pl.productLine}" selected>${pl.productLine}</option>
					</c:forEach>
				</select><br>
				
				<input type="submit" class="btn btn-primary w-100 mt-3" value=<fmt:message key="asg" />/><br>
				<c:if test="${confir!=null}">
							<h3 class="text-success text-small mt-3">${confir}</h3>
				</c:if>
			</form>
			
				
				

		
		</div>

	</div>
  
  

</body>
</html>