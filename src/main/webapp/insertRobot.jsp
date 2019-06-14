<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert robot</title>
</head>
<body>
	<h2>----- INSERT ROBOT -----</h2>
	
	<form class="insert-form" action="/Admin/insertRobot" method="post">
		<table border=2>
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
		<button class="btn btn-primary btn-lg btn-block" type="submit">Insert</button>
	</form>
	
	<a href="/Admin/devicesManagement">Back</a>
</body>
</html>