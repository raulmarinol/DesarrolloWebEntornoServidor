<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/bootstrap.jsp" />
<title>Modificar Customer</title>
</head>
<body>
	<div class="row justify-content-center">
		<jsp:include page="../include/barra.jsp" />
	
			<div class="col-8">
			
			<form method="post">
					<label for="customerNumber" class="form-label mt-3">customerNumber</label>
				<input type="text" class="form-control" id="customerNumber" name="customerNumber" value="${codCustomer}" readonly >
				<label for="customerName" class="form-label mt-3">customerName</label>
				<input type="text" class="form-control" id="customerName" name="customerName"value="${customer2.contactLastName}">
				<label for="contactLastName" class="form-label mt-3">contactLastName</label>
				<input type="text" class="form-control" id="contactLastName" name="contactLastName" value="${customer2.contactLastName}">
				<label for="contactFirstName" class="form-label mt-3">contactFirstName</label>
				<input type="text" class="form-control" id=contactFirstName  name=contactFirstName value="${customer2.contactFirstName}">
				<label for="phone" class="form-label mt-3">phone</label>
				<input type="text" class="form-control" id=phone  name=phone value="${customer2.phone}">
				<label for="addressLine1" class="form-label mt-3">officeCode</label>
				<input type="text" class="form-control" id="addressLine1"  name="addressLine1"  value="${customer2.addressLine1}">
				<label for="addressLine2" class="form-label mt-3">addressLine2</label>
				<input type="text" class="form-control" id="addressLine2" name="addressLine2" value="${customer2.addressLine2}">
				<label for="city" class="form-label mt-3">city</label>
				<input type="text" class="form-control" id="city" name="city" value="${customer2.city}">
				<label for="state" class="form-label mt-3">state</label>
				<input type="text" class="form-control" id="state" name="state" value="${customer2.state}">
				<label for="postalCode" class="form-label mt-3">postalCode</label>
				<input type="text" class="form-control" id="postalCode" name="postalCode" value="${customer2.postalCode}">
				<label for="country" class="form-label mt-3">country</label>
				<input type="text" class="form-control" id="country" name="country" value="${customer2.country}">
				
				<label for="salesRepEmployeeNumber" class="form-label mt-3">salesRepEmployeeNumber</label>
				<select name="salesRepEmployeeNumber" id="salesRepEmployeeNumber">
					<c:forEach items="${customerList}" var="ct">									
						 <option type="text" name="oficina" value="${ct.employeeNumber}">${ct.firstName} ${ct.lastName}</option>														
					</c:forEach>
				</select>
				
				<label for="creditLimit" class="form-label mt-3">creditLimit</label>
				<input type="text" class="form-control" id="creditLimit" name="creditLimit" value="${customer2.creditLimit}">
					<input type="submit" class="btn btn-primary w-100 mt-3"
							value="Añadir" />
					</form>
			
				
				

		
		</div>

	</div>
  
  

</body>
</html>