<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>listaEmpleados</title>
</head>
<body>
	
			<div class="row justify-content-center">
		<jsp:include page="include/barra.jsp" />
		<c:if test="${sessionScope.role=='admin'}">
		<div class="row justify-content-end">
			<div class="col-4"></br>
			<table>
			<tr>
			<td><a class="btn btn-primary w-100" href="AddCustomer">AÑADIR Customer</a></td>
			</tr>
			</table>
			</div>
		</div></c:if>
	
			<div class="col-10">	

		<table class="table table-striped">
			<thead>
				<tr>
					<th>customerNumber</th>
					<th>customerName</th>
					<th>contactLastName</th>
					<th>contactFirstName</th>
					<th>phone</th>
					<th>Acción</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customerList}" var="lc">
					<tr>
						<td>${lc.customerNumber}</td>
						<td>${lc.customerName}</td>
						<td>${lc.contactLastName}</td>
						<td>${lc.contactFirstName}</td>
						<td>${lc.phone}</td>
						<td><c:if test="${sessionScope.role=='admin'}"><a href="ChangeAssigment?change=${lc.customerNumber}"><i class="bi bi-pencil-fill"></i></a></c:if>						
						<c:if test="${sessionScope.role!='admin'}"><a href="CustomerReport?see=${lc.customerNumber}"><i class="bi bi-pencil-fill"></i></a></c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		
		<c:if test="${sessionScope.role=='admin'}">
		<div class="row justify-content-end">
			<div class="col-4"></br>
			<table>
			<tr>
			<td><a class="btn btn-primary w-100" href="AddCustomer">AÑADIR Customer</a></td>
			</tr>
			</table>
			</div>
		</div></c:if>

	</div>

	
	
	  

</body>
</html>