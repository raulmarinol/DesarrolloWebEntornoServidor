<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" /> 
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
			<div class="col-10">
				<h2 class="text-center"><fmt:message key="listCategoy" /></h2>
				<table class="table table-striped">
					<thead>
						<tr>
							<th><fmt:message key="productLine" /></th>
							<th><fmt:message key="textDescription" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productLineList}" var="pl">
							<tr>
								<td>${pl.productLine}</td>
								<td>${pl.textDescription}</td>
								<td><c:if test="${sessionScope.role!='admin'}"><a href="ProductLineReport?id=${pl.productLine}"><i class="bi bi-eye"></i></a></c:if></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>					
			</div>
		</div>	
	</div>
</body>
</html>