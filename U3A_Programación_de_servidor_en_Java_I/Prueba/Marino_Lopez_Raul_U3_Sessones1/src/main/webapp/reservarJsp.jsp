<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post">
	<label for="nombre">Fecha Inicio</label>
	<input type="text" name="feinicio" id="finico" value="finicio"><br/>
	<label for="apellidos">Fecha fin</label>
	<input type="text" name="fefin" id="ffin" value="ffin"><br/>
	<label for="correo">Correo</label>
	<input type="text" name="numero" id="numero" value="numero"><br/>
	<label for="text">Numero de personas</label>
	<
	</label><br/><br/>
	<label for="extras">Extras:<br/>
	WIFI <input type="checkbox" name="modulos" value="WIFI"><br/>
	TOALLAS <input type="checkbox" name="modulos" value="Toallas"><br/>
	DESAYUNO<input type="checkbox" name="modulos" value="Desayuno"><br/>
	LIMPIEZA<input type="checkbox" name="modulos" value="Limpieza"><br/>
	VISITA GUIADA<input type="checkbox" name="modulos" value="VISITAGUIADA">
	</label><br/>
	<input type="submit" value="Reservar">
</form>
</body>
</html>