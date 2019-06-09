<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="it.contrader.dto.UsersDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
	List<UsersDTO> listUsers = (List<UsersDTO>) request.getAttribute("doctor");
%>
<title>Doctor Management</title>
</head>
<body>
	<form action="DoctorManagementServlet" action="post">
		<table>
			<tr><th>UserId</th><th>Name</th><th>Surname</th><th>Username</th><th>Password</th><th>Type</th><th>State</th></tr>
			<%
				for(UsersDTO user: listUsers){
			 %>
			 	<tr>
			 		<td><%=user.getUserId()%></td>
			 		<td><%=user.getUserName()%></td>
			 		<td><%=user.getUserSurname()%></td>
			 		<td><%=user.getUserName() %></td>
			 		<td><%=user.getUserPassword()%></td>
			 		<td><%=user.getUserType()%></td>
			 		<td><%=user.isUserState()%></td>
			 		<td><a href="DoctorManagementServlet?richiesta=Delete&user_id=<%=user.getUserId() %>">Delete</a></td>
			 		<td><a href="DoctorManagementServlet?richiesta=UdpateRedirect&id=<%=user.getUserId() %>">Update</a></td>
			 	</tr>
			 <% 
			 	}
			 %>	 
		</table>
		
		<a href="insertDoctor.jsp">Insert Doctor</a>
	</form>
	
	<a href="homeAdmin.jsp">Back</a>
</body>
</html>