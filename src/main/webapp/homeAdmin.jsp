<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> <!-- Aggiungo stringa per il foreach -->
<html>
<head>
<title>Menu Principale</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="header">
	<h1>Benvenuto: ${utente}</h1>
	<h2>------- MENU PRINCIPALE -------</h2>
	
</div>
			<a href="UsersServlet?richiesta=UsersManager">User Management</a>
			<br>
			<a href="DevicesServlet?richiesta=DevicesManager"> Device management</a>
</body>
</html>