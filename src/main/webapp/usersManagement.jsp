<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@	page import="it.contrader.dto.UsersDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users Management</title>
	<%
		List<UsersDTO> listUser = (List<UsersDTO>) request.getAttribute("users");
	 %>
</head>
<body>
	<form action="UsersManagementServlet" method="post">
	<table>
		<tr><th>UserId</th><th>Name</th><th>Surname</th><th>Username</th><th>Password</th><th>Type</th><th>State</th></tr>
		<%
			for(UsersDTO user: listUser){
		 %>
		 	<tr>
		 		<td><%=user.getUserId()%></td>
		 		<td><%=user.getUserName()%></td>
		 		<td><%=user.getUserSurname()%></td>
		 		<td><%=user.getUserUser()%></td>
		 		<td><%=user.getUserPassword()%></td>
		 		<td><%=user.getUserType()%></td>
		 		<td><%=user.isUserState()%></td>
		 		<td><a href="UsersManagementServlet?richiesta=Delete&user_id=<%=user.getUserId() %>">Delete</a></td>
		 		<td><a href="UsersManagementServlet?richiesta=UpdateRedirect&id=<%=user.getUserId()%>">Update</a></td>
		 	</tr>
		<% 
			}
		%>
	</table>
	<a href="insertUser.jsp">Insert Patient</a>
	<br>
	<br>
	</form>
	
	<a href="homeDoctor.jsp">Back</a>
</body>
</html>