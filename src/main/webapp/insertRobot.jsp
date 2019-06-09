<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>----- INSERT ROBOT -----</h2>
	
	<form action="RobotManagementServlet?richiesta=Insert" method="post">
		<table>
			<tr>
				<td>Name</td><td><input type="text" name="user_name" placeholder="name"></td>
			</tr>
			
			<tr>
				<td>Surname</td><td><input type="text" name="user_surname" placeholder="surname"></td>
			</tr>
			
			<tr>
				<td>UserName</td><td><input type="text" name="user_user" placeholder="username"></td>
			</tr>
			
			<tr>
				<td>Password</td><td><input type="password" name="user_pass" placeholder="password"></td>
			</tr>
		</table>
		<button type="submit" value="Insert" name="pulsante">Insert</button>
	</form>
	
	<a href="RobotManagementServlet?richiesta=RobotManager">Back</a>
</body>
</html>