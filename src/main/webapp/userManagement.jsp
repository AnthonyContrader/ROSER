<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@	page import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
	<%
		List<UserDTO> listUser = (List<UserDTO>) request.getAttribute("user");
	 %>
</head>
<body>
	<table>
		<tr><th>UserId</th><th>Name</th><th>Surname</th><th>Username</th><th>Password</th><th>Type</th><th>State</th></tr>
		<%
			for(UserDTO user: listUser){
		 %>
		 	<tr>
		 		<td><%=user.getUserId()%></td>
		 		<td><%=user.getUserName()%></td>
		 		<td><%=user.getUserSurname()%></td>
		 		<td><%=user.getUserUser()%></td>
		 		<td><%=user.getUserPass()%></td>
		 		<td><%=user.getUserType()%></td>
		 		<td><%=user.isUserState()%></td>
		 		<td><a href="/Doctor/deleteUser?id=<%=user.getUserId() %>">Delete</a></td>
		 		<td><a href="/Doctor/redirectUpdate?id=<%=user.getUserId()%>">Update</a></td>
		 	</tr>
		<% 
			}
		%>
	</table>
	<a href="/insertUser.jsp/">Insert Patient</a>
	<br>
	<a href="/homeDoctor.jsp">Back</a>
	<br>
</body>
</html>