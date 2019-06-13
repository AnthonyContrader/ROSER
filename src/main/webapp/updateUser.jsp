<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="it.contrader.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USERS UPDATE</title>

<%
	UserDTO userUpdate = (UserDTO) request.getAttribute("user");
%>
</head>
<body>
<div class="center">

		<div class="pre_contenitore">

			<h2>------- USERS UPDATE -------</h2>

		</div>
		<form method="POST" action="/Doctor/updateUser">
			<input type="hidden" name="id" value="<%=userUpdate.getUserId()%>" />
			<input type="hidden" name="type" value="<%=userUpdate.getUserType()%>" />
			<table border = 2>

			<tr>
				<td><b>Name:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="name" value="<%=userUpdate.getUserName()%>" /></td>
			</tr>
			<tr>
				<td><b>Surname:</b></td> 
				<td> <input type="text" size="40" maxlength="40" name="surname" value="<%=userUpdate.getUserSurname()%>" /></td>
			</tr>
			<tr>
				<td><b>Username:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="username" value="<%=userUpdate.getUserUser()%>" /></td>
			</tr>
			<tr>
				<td><b>Password:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="password" value="<%=userUpdate.getUserPass()%>" /></td>
			</tr>
			<tr>
					<td><b>Status:</b></td>
					<td> <input type="checkbox" name="state" value="true" >Enable
						
					</td>
			</tr>
			</table>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="/Doctor/userManagement">Back</a>

		</form>

	</div>
</body>
</html>