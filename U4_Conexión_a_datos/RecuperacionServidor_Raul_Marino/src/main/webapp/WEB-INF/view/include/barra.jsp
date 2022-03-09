<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" /> 
<c:if test="${sessionScope.usuario!=null}">
	<div class="row bg-primary justify-content-between" >
		<div class="col-6 text-start">			
			<p class="text-white p-2">
			<a class="text-white" href="${pageContext.request.contextPath}/Home"><fmt:message key="Home" /></a>			
			<c:if test="${sessionScope.role=='admin'}"><a class="text-white" href="${pageContext.request.contextPath}/Admin/AddProductLine"><fmt:message key="AddProductLine" /></a></c:if>
			<c:if test="${sessionScope.role=='admin'}"><a class="text-white" href="${pageContext.request.contextPath}/Admin/ChangeProductProductLine"><fmt:message key="asigPro" /></a></c:if>
			</p>  
		</div>
		
		<div class="col-3 text-center">			
			<p class="text-white p-2">			
			<c:if test="${sessionScope.role!='admin'}"><fmt:message key="ZONAUSUARIO" /></c:if>
			<c:if test="${sessionScope.role=='admin'}"><fmt:message key="ZONAAdmin" /></c:if>
			</p>  
		</div>
		
		<div class="col-3 text-end">			
			<p class=" text-white p-2">
				<a class="text-white" href="${pageContext.request.contextPath}/LogOut"><i class="bi bi-box-arrow-left"></i></a>
			</p>  
		</div>	
	</div>
</c:if>