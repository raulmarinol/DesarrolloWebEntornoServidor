<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/bootstrap.jsp" />
<title>Modificar Empleado</title>
</head>
<body>
	<div class="row justify-content-center">
		<jsp:include page="../include/barra.jsp" />
	
			<div class="col-8">
			
			<form method="post">
				<label for="employeeNumber" class="form-label mt-3">employeeNumber</label>
				<input type="text" class="form-control" id="employeeNumber" name="employeeNumber" value="${employeeNumber}" readonly >
				<label for="lastName" class="form-label mt-3">lastName</label>
				<input type="text" class="form-control" id="lastName" name="lastName"value="${employee.lastName}">
				<label for="firstName" class="form-label mt-3">firstName</label>
				<input type="text" class="form-control" id="firstName" name="firstName" value="${employee.firstName}">
				<label for="extension" class="form-label mt-3">extension</label>
				<input type="text" class="form-control" id="extension" name="extension" value="${employee.extension}">
				<label for="email" class="form-label mt-3">email</label>
				<input type="text" class="form-control" id="email" name="email" value="${employee.email}">
				
				<label for="officeCode" class="form-label mt-3">OfficeCode</label></br>
				<select name="officeCode" id="officeCode">
					<c:forEach items="${officeList}" var="loff">
						<option type="text" value="${loff.officeCode}">${loff.officeCode}</option>																				
					</c:forEach>
				</select></br>
				
				<label for="reportsTo" class="form-label mt-3">reportsTo</label>
				<select name="reportsTo" id="reportsTo">
					<c:forEach items="${employeeList}" var="lee">
						<option type="text" value="${lee.reportsTo}">${lee.reportsTo}</option>																				
					</c:forEach>
				</select></br>
				
				
				<label for="jobTitle" class="form-label mt-3">jobTitle</label>
				<input type="text" class="form-control" id="jobTitle" name="jobTitle" value="${employee.jobTitle}">
					<input type="submit" class="btn btn-primary w-100 mt-3"
							value="AÑADIR" />
					</form>
			
				
				

		
		</div>

	</div>
  
  

</body>
</html>