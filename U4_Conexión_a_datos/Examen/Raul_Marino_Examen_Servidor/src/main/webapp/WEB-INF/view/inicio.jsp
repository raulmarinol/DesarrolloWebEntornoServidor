<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pantalla Multiple</title>
<jsp:include page="include/bootstrap.jsp" />
</head>
<body>
	<div class="container">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center mt-5">
			<div class="col-6">
			
			
				<c:if test="${sessionScope.role !='admin'}">
						<h1>Categorías disponible</h1>
				
				
						<c:forEach items="${productLineList}" var="lpl">
							<li><a class="text-primary" href="${pageContext.request.contextPath}/MostrarProductos?pr">${lpl.productLine}</a></li>																		
						</c:forEach>	
				</c:if>
				
				<h1>Categorías disponible</h1> test="${sessionScope.role=='admin'}
				
				<c:if test="${sessionScope.role =='admin'}">
						<h1>Operaciones disponible</h1>
				
						<ul>
							<li><a class="text-primary" href="${pageContext.request.contextPath}/Admin/Empleados">Mostrar Empleados</a></li>
							<li><a class="text-primary" href="${pageContext.request.contextPath}/Admin/AddEmpleado">Añadir Empleado</a></li>
						</ul>	
				</c:if>	
				
				
				
				
			</div>
		</div>	
	</div>
</body>
</html>