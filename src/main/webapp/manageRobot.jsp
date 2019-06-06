<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="it.contrader.dto.RobotDTO" %>
	<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MANAGE ROBOTS</title>
<%
	List<RobotDTO> allRobot = (List<RobotDTO>) request.getAttribute("robot");
%>
</head>
<body>
<h2>------- DEVICES LIST -------</h2>
	
	<table border=2>
		<tr><th>Id</th><th>Username</th><th>Password</th><th>Options</th></tr>
    	<%
			for (RobotDTO robot : allRobot) {
		%>
		<tr>
			<td><%=robot.getRobotId()%></td>
			<td><%=robot.getRobotUsername()%></td>
			<td><%=robot.getRobotPassword()%></td>
			<td><a href="DevicesServlet?richiesta=delete&id=<%=robot.getUsername()%>">Delete</a>
				<!-- <a href="DevicesServlet?richiesta=updateRedirect&id=<%=robot.getRobotId()%>">Update</a></td>-->
			
		</tr>
		<%
			}
		%>
	</table>
	<br>
			<br>
			<a href="insertDevices.jsp">Insert</a>
			<a href="DevicesServlet?richiesta=Back">Back</a>
	
	</div>

</body>
</html>