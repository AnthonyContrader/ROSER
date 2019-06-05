<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> <!-- Aggiungo stringa per il foreach -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MANAGEMENT USERS</title>
</head>
<body>
	<h2>------- USERS' LIST -------</h2>
		<table border= 1>
		<tr><td><b>Id</b></td><td><b>Name</b></td><td><b>Surname</b></td><td><b>Username</b></td><td><b>Password</b></td><td><b>State</b></td></b></tr>
				${posts}
  		</table>
  		<br>
  		<br>
	<button type="submit" value="Insert" name="pulsanteInsert">Insert</button>
	<button type="submit" value="Delete" name="pulsanteDelete">Delete</button>
	<button type="submit" value="Update" name="pulsanteUpdate">Update</button>
	<button type="submit" value="Back" name="pulsanteBack">Back</button>
</body>
</html>