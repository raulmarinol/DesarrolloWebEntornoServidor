<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Main</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<div class="row justify-content-center">
				<div class="col-8">
					<form method="post">
					<c:choose>
						<c:when test="${oficinas!=null and oficinas.size()>0}">
							<table class="table table-striped">
								<h2>Oficinas</h2>
								
								
								<tbody>									
									<select name="oficinas" id="oficinas">
										<c:forEach items="${oficinas}" var="o">									
											 <option type="text" name="oficina" value="${o.city}">${o.city}</option>														
										</c:forEach>
									</select>
								</tbody>
							</table>
						</c:when>
						<c:when test="${oficinas!=null and oficinas.size()==0}">
							<p class="text-danger">NO HAY RESULTADOS</p>
						</c:when>
					</c:choose>
					<input type="submit" class="btn btn-primary w-100 mt-3"
							value="Obtener Datos" />
					</form>
					<c:if test="${city!=null}">
						<table>
							<tr><td>DATOS DE LA OFICINA DE ${city}</td></tr>
						  	<tr><td>Code:${officeCode}</td></tr>
							<tr><td>Ciudad:${city} </td></tr>
							<tr><td>Teléfono:${phone}</td></tr>
							<tr><td>Dirección 1:${addresLine1}</td></tr>
							<tr><td>Dirección 2:${addresLine2}</td></tr>
							<tr><td>Estado:${state}</td></tr>
							<tr><td>País:${country}</td></tr>
							<tr><td>Código Postal:${postalCode}</td></tr>
							<tr><td>Territorio: ${territory}</td></tr>
						  </table>
				</c:if>
					
				</div>
			</div>
		</div>
	 </div>	
  </div>
  
  

</body>
</html>