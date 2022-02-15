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
	
			<div class="col-8">
			
			<form method="post">
					<label for="productCode" class="form-label mt-3">ProductCode</label>
				<input type="text" class="form-control" id="productCode" name="productCode" value="${product.productCode}" readonly >
				<label for="productName" class="form-label mt-3">ProductName</label>
				<input type="text" class="form-control" id="productName" name="productName"value="${product.productName}">
				<label for="productLine" class="form-label mt-3">productLine</label></br>
				<select name="productLine" id="productLine">
					<c:forEach items="${listaProductLine}" var="lp">
						<c:if test="${lp.productLine == product.productLine}">
						<option type="text" value="${lp.productLine}" selected>${lp.productLine}</option>
						</c:if>									
						<c:if test="${lp.productLine != product.productLine}">
						<option type="text" value="${lp.productLine}">${lp.productLine}</option>
						</c:if>															
					</c:forEach>
				</select></br>
				<label for="productScale" class="form-label mt-3">ProductScale</label>
				<input type="text" class="form-control" id="productScale" name="productScale" value="${product.productScale}">
				<label for="productVendor" class="form-label mt-3">productVendedor</label>
				<input type="text" class="form-control" id=productVendor  name=productVendor value="${product.productVendor}">
				<label for="productDescription" class="form-label mt-3">productDescripction</label>
				<textarea  class="form-control" id="productDescription" name="productDescription"> ${product.productDescription}</textarea>
				<label for="quantityInStock" class="form-label mt-3">quantityInStock</label>
				<input type="text" class="form-control" id="quantityInStock"  name="quantityInStock"  value="${product.quantityInStock}">
				<label for="buyPrice" class="form-label mt-3">buyPrice</label>
				<input type="text" class="form-control" id="buyPrice" name="buyPrice" value="${product.buyPrice}">
				<label for="msrp" class="form-label mt-3">MSRP</label>
				<input type="text" class="form-control" id="msrp" name="msrp" value="${product.msrp}">
					<input type="submit" class="btn btn-primary w-100 mt-3"
							value="MODIFICAR" />
					</form>
			
				
				

		
		</div>

	</div>
  
  

</body>
</html>