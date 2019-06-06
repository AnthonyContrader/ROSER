<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="it.contrader.dto.RobotDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ROBOTS UPDATE</title>
<%
	RobotDTO robotUpdate = (RobotDTO) request.getAttribute("RobotUpdate");
%>
</head>
<body>
<div class="pre_contenitore">

			<h2>------- ROBOTS UPDATE -------</h2>

		</div>
		
		<div>
		<form method="POST" action="DevicesServlet?richiesta=update">
			
			<input type="hidden" name="id" value="<%=robotUpdate.getRobotId()%>" />
			<input type="hidden" name="type" value="<%=robotUpdate.getType()%>" />
			<table border = 2>

			<tr>
				<td><b>Username:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="username" value="<%=robotUpdate.getRobotUsername()%>" /></td>
			</tr>
			<tr>
				<td><b>Password:</b></td>
				<td> <input type="text" size="40" maxlength="40" name="password" value="<%=robotUpdate.getPassword()%>" /></td>
			</tr>
			
			</table>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="DevicesServlet?richiesta=DevicesManager">Back</a>

		</form>

	</div>
</body>
</html>