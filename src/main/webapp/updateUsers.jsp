<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="it.contrader.dto.UsersDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users Update</title>
	<%
		UsersDTO userUpdate = (UsersDTO) request.getAttribute("users");
	 %>
</head>
<body>
<form method="POST" action="UsersManagementServlet?richiesta=Update&user_id=<%=userUpdate.getUserId()%>">
			<tr>
				<td><b>Name:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="name" value="<%= userUpdate.getUserName()%>"/></td>
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
				<td> <input type="text" size="40" maxlength="40" name="password" value="<%=userUpdate.getUserPassword()%>" /></td>
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
		<a href="UsersManagementServlet?richiesta=UserManager">Back</a>
</body>
</html>