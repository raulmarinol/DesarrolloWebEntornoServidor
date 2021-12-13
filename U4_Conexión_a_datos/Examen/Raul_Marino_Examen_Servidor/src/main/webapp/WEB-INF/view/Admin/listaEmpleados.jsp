<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/bootstrap.jsp" />
<title>listaEmpleados</title>
</head>
<body>
	<div class="row justify-content-center">
		<jsp:include page="../include/barra.jsp" />
		<div class="row justify-content-end">
			<div class="col-4"></br>
			<table>
			<tr>
			<td><a class="btn btn-primary w-100" href="AddEmpleado">AÑADIR EMPLEADO</a></td>
			</tr>
			</table>
			</div>
		</div>
	
			<div class="col-10">	

		<table class="table table-striped">
			<thead>
				<tr>
					<th>employeeNumber</th>
					<th>lastName</th>
					<th>firstName</th>
					<th>extension</th>
					<th>email</th>
					<th>Acción</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employeeeList}" var="p">
					<tr>
						<td>${p.employeeNumber}</td>
						<td>${p.lastName}</td>
						<td>${p.firstName}</td>
						<td>${p.extension}</td>
						<td>${p.email}</td>						
						<td><a href="EditarEmpleado?emp=${p.employeeNumber}"><i class="bi bi-pencil-fill"></i></a>
						<a href="DeleteEmpleado?empdel=${p.employeeNumber}"><i class="bi bi-trash"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>

	</div>
  
  

</body>
</html>