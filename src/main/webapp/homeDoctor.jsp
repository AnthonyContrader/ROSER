<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
<html>
<head>
<title>Doctor Menù</title>
</head>
<body>
	<h1>Benvenuto: ${utente}</h1>
	<h2>------- MEDICAL MENU'-------</h2>
			<a href="DoctorServlet?richiesta=PatientManager">User management</a>
			<br>
			<a href="DevicesServlet?richiesta=DevicesManager"> Device management</a>
</body>
</html>