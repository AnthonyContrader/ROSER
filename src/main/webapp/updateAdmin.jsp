<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="it.contrader.dto.DoctorDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USERS UPDATE</title>

<%
	DoctorDTO doctorUpdate = (DoctorDTO) request.getAttribute("doctorUpdate");
%>
</head>
<body>
<div class="center">

		<div class="pre_contenitore">

			<h2>------- USERS UPDATE -------</h2>

		</div>
		<form method="POST" action="UsersServlet?richiesta=update">
			<input type="hidden" name="id" value="<%=doctorUpdate.getDoctorId()%>" />
			<input type="hidden" name="type" value="<%=doctorUpdate.getUserType()%>" />
			<table border = 2>

			<tr>
				<td><b>Name:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="name" value="<%=doctorUpdate.getName()%>" /></td>
			</tr>
			<tr>
				<td><b>Surname:</b></td> 
				<td> <input type="text" size="40" maxlength="40" name="surname" value="<%=doctorUpdate.getSurname()%>" /></td>
			</tr>
			<tr>
				<td><b>Username:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="username" value="<%=doctorUpdate.getUserName()%>" /></td>
			</tr>
			<tr>
				<td><b>Password:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="password" value="<%=doctorUpdate.getPassword()%>" /></td>
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
			<a href="UsersServlet?richiesta=UsersManager">Back</a>

		</form>

	</div>
</body>
</html>