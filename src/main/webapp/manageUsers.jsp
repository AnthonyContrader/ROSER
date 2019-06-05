<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MANAGEMENT USERS</title>
</head>
<body>
<div>
<form action="ManageServletUsers" method="post">
	<h2>------- USERS' LIST -------</h2>
		<table border= 1>
		<tr><td><b>Id</b></td><td><b>Name</b></td><td><b>Surname</b></td><td><b>Username</b></td><td><b>Password</b></td><td><b>State</b></td><td><b>Operation</b></td></tr>
		<tr><td>${posts}</td></tr>
  		</table>
  		<br>
  		<br>
  	
	<button type="submit" value="Insert" name="pulsante">Insert</button>
	<!-- <button type="submit" value="Delete" name="pulsante">Delete</button>-->
	<!-- <button type="submit" value="Update" name="pulsante">Update</button> -->
	<button type="submit" value="Back" name="pulsante">Back</button>
	</form>
	
	</div>
</body>
</html>