<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/bootstrap.jsp" />
<title>Modificar Customer</title>
</head>
<body>
	<div class="row justify-content-center">
		<jsp:include page="../include/barra.jsp" />
	
			<div class="col-8">
							<form method="post">    				
    				<h3>CLIENTE: ${sessionScope.firstName}</h3>
    				<h3>CONTACT EN CLIENTE: ${customer2.firstName}</h3>
    				
					<label for="salesRepEmployeeNumber" class="form-label mt-3">salesRepEmployeeNumber</label>
					<select name="salesRepEmployeeNumber" id="salesRepEmployeeNumber">
										<c:forEach items="${customerList}" var="ct">									
											 <option type="text" name="oficina" value="${ct.employeeNumber}">${ct.firstName} ${ct.lastName}</option>														
										</c:forEach>
									</select>
					
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="Asignar el empleado" />					
				</form>
		
		</div>

	</div>
  
  

</body>
</html>