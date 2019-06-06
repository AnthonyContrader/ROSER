<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.contrader.dto.UsersDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MANAGEMENT PATIENT</title>
<%
	List<UsersDTO> allUser = (List<UsersDTO>) request.getAttribute("patient");
%>
</head>
<body>
<div>
	<h2>------- USERS' LIST -------</h2>
	
	<table border=2>
		<tr><th>Id</th><th>Name</th><th>Surname</th><th>Username</th><th>Password</th><th>UserType</th><th>UserState</th></tr>
    	<%
			for (UsersDTO users : allUser) {
		%>
		<tr>
			<td><%=users.getUserId()%></td>
			<td><%=users.getName()%></td>
			<td><%=users.getSurname()%></td>
			<td><%=users.getUserName()%></td>
			<td><%=users.getPassword()%></td>
			<td><%=users.getUserType()%></td>
			<td><%=users.isUserState()%></td>
			<td><a href="UsersServlet?richiesta=delete&id=<%=users.getUserId()%>">Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
	
	</div>
</body>
</html>