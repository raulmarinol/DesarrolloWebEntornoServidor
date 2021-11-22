<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Búsqueda de Oficuina</title>
<jsp:include page="include/bootstrap.jsp" />
</head>
<body>

	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<form method="post" class="d-flex">
				<input name="busqueda" class="form-control me-2" type="search"
					placeholder="Search" aria-label="Search" required>
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</nav>
		<div class="row justify-content-center">
			<c:choose>
				<c:when test="${office!=null and offices.size()>0}">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Código</th>
								<th>Nombre</th>
								<th>Categoria</th>
								<th>Stock</th>
								<th>Precio</th>
								<th>Accion</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${offices}" var="p">
								<tr>
									<td>${p.productCode}</td>
									<td>${p.productName}</td>
									<td>${p.productLine}</td>
									<td>${p.quantityInStock}</td>
									<td>${p.buyPrice}</td>
									<td></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:when test="${office!=null and offices.size()==0}">
					<p class="text-danger">NO HAY RESULTADOS</p>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>