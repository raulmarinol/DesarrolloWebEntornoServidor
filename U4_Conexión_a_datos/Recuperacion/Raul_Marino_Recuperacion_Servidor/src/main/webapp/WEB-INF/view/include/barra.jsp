<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.usuario!=null}">
	<div class="row bg-primary justify-content-between" >
		<div class="col-8 text-start">
			
			<p class="text-white p-2">
			<a class="text-white" href="${pageContext.request.contextPath}/Main">Inicio</a>
			<c:if test="${sessionScope.role=='admin'}"><a class="text-white" href="${pageContext.request.contextPath}/Admin/AddCustomer">Añadir Cliente</a></c:if>
			<c:if test="${sessionScope.role=='admin'}">Zona Admministracion</c:if>
			<c:if test="${sessionScope.role!='admin'}">Zona Usuario</c:if>
			
			</p>  
		</div>
		<div class="col-4 text-end">			
			<p class=" text-white p-2">

				<a class="text-white" href="${pageContext.request.contextPath}/LogOut">Salir</a>
			</p>  
		</div>	
	</div>
</c:if>