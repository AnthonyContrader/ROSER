<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.contrader.dto.UsersDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Doctor</title>
	<%
		UsersDTO doctorUpdate = (UsersDTO) request.getAttribute("doctor");
	 %>
</head>
<body>
	<form method="POST" action="DoctorManagementServlet?richiesta=Update&user_id=<%=doctorUpdate.getUserId()%>">
			<tr>
				<td><b>Name:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="name" value="<%= doctorUpdate.getUserName()%>"/></td>
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
				<td> <input type="text" size="40" maxlength="40" name="password" value="<%=doctorUpdate.getUserPassword()%>" /></td>
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
		</form>
		
		<a href="DoctorManagementServlet?richiesta=DoctorManager">Back</a>
</body>
</html>