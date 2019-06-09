<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Robot</title>
</head>
<body>
<h1>Welcome: ${utente}</h1>  <!-- variabile che avrà la stessa dell'etichetta impostata sul servlet -->
	<h2>------- MENU PRINCIPALE -------</h2>
	<a href="UsersManagementServlet?richiesta=ReadParameter">Read parameter</a>
	<br>
	<br>
	<br>
	<a href="RobotManagementServlet?richiesta=Show log">Show log</a>
	<br>
	<br>
	<a href="LogoutServlet">Logout</a>
</body>
</html>