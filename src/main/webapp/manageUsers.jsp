<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.contrader.dto.DoctorDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MANAGEMENT USERS</title>
<%
	List<DoctorDTO> allDoctor = (List<DoctorDTO>) request.getAttribute("doctor");
%>
</head>
<body>
<div>
	<h2>------- USERS' LIST -------</h2>
	
	<table border=2>
		<tr><th>Id</th><th>Name</th><th>Surname</th><th>Username</th><th>Password</th><th>UserType</th><th>UserState</th><th>Options</th></tr>
    	<%
			for (DoctorDTO doctor : allDoctor) {
		%>
		<tr>
			<td><%=doctor.getDoctorId()%></td>
			<td><%=doctor.getName()%></td>
			<td><%=doctor.getSurname()%></td>
			<td><%=doctor.getUserName()%></td>
			<td><%=doctor.getPassword()%></td>
			<td><%=doctor.getUserType()%></td>
			<td><%=doctor.isUserState()%></td>
			<td><a href="UsersServlet?richiesta=delete&id=<%=doctor.getDoctorId()%>">Delete</a>
				<a href="UsersServlet?richiesta=updateRedirect&id=<%=doctor.getDoctorId()%>">Update</a></td>
			
		</tr>
		<%
			}
		%>
	</table>
	<br>
			<br>
			<a href="insertUser.jsp">Insert</a>
			<a href="UsersServlet?richiesta=Back">Back</a>
	
	</div>
</body>
</html>