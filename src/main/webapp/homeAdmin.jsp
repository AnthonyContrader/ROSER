<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Admin Menu</title>
</head>
<body>
	<h1>Welcome: ${utente}</h1>  <!-- variabile che avrà la stessa dell'etichetta impostata sul servlet -->
	<h2>------- MENU PRINCIPALE -------</h2>
	<a href="DoctorManagementServlet?richiesta=DoctorManager">Doctor management</a>
	<br>
	<br>
	<br>
	<a href="RobotManagementServlet?richiesta=RobotManager">Device management</a>
	<br>
	<br>
	<a href="LogoutServlet">Logout</a>
</body>
</html>