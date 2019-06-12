<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="it.contrader.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USERS UPDATE</title>

<%
	UserDTO doctorUpdate = (UserDTO) request.getAttribute("doctor");
%>
</head>
<body>
<div class="center">

		<div class="pre_contenitore">

			<h2>------- USERS UPDATE -------</h2>

		</div>
		<form method="POST" action="/Admin/updateDoctor">
			<input type="hidden" name="id" value="<%=doctorUpdate.getUserId()%>" />
			<input type="hidden" name="type" value="<%=doctorUpdate.getUserType()%>" />
			<table border = 2>

			<tr>
				<td><b>Name:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="name" value="<%=doctorUpdate.getUserName()%>" /></td>
			</tr>
			<tr>
				<td><b>Surname:</b></td> 
				<td> <input type="text" size="40" maxlength="40" name="surname" value="<%=doctorUpdate.getUserSurname()%>" /></td>
			</tr>
			<tr>
				<td><b>Username:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="username" value="<%=doctorUpdate.getUserUser()%>" /></td>
			</tr>
			<tr>
				<td><b>Password:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="password" value="<%=doctorUpdate.getUserPass()%>" /></td>
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
			<a href="/Admin/doctorManagement">Back</a>

		</form>

	</div>
</body>
</html>