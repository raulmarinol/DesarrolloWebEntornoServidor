<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="barra.jsp"></jsp:include>	
	<div class="container">
		<div class="row justify-content-center mt-5">
			<% if (!session.isNew() && session.getAttribute("LOGEADO")!=null && ((boolean)session.getAttribute("LOGEADO")) ) { %>

			<!-- ELEMENTOS DE LA PÁGINA QUE SE SACAN SI ESTAMOS LOGEADOS -->
			<div>
				<a href="<%= request.getContextPath()+"/Logout" %>"></a>
				<div wight=""></div>
					
			</div>

			<% } else { %>

			<% HttpSession sesion = request.getSession();
	if(sesion.isNew() || sesion.getAttribute("usuario")==null){%>
		<form method="post">
		<label for="usuario">Usuario: </label>
		<input type="text" name="usuario"><br>
		<label for="password">Passowrd</label>
		<input type="password" name="password">
		<label for="password2">Confirmar Passowrd</label>
		<input type="password" name="password">
		<input type="submit" name="enviar" value="Entrar">
		</form>
	<%}else{%>
		<p>Está logeado con el usuario <%= sesion.getAttribute("usuario") %></p>
		<a href="LogOut">Registrarse</a>
	<%}%>
			</div>
			<% } %>
		</div>	
			
			

</body>
</html>