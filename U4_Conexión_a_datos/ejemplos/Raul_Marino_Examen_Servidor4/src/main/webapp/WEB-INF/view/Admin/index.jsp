<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/bootstrap.jsp" />
<title>Main</title>
</head>
<body>
	<div class="row justify-content-center">
		<jsp:include page="../include/barra.jsp" />
	
			<div class="col-10">	

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nombre</th>
					<th>Categoría</th>
					<th>Stock</th>
					<th>Precio</th>
					<th>Acción</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ProductsList}" var="p">
					<tr>
						<td>${p.productCode}</td>
						<td>${p.productName}</td>
						<td>${p.productLine}</td>
						<td>${p.quantityInStock}</td>
						<td>${p.buyPrice}</td>						
						<td><a href="EditarProduct?pc=${p.productCode}"><i class="bi bi-pencil-fill"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>

	</div>
  
  

</body>
</html>