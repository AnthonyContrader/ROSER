<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.contrader.dto.RobotDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%
	List<RobotDTO> listRobot = (List<RobotDTO>) request.getAttribute("robot");
 %>

</head>
<body>
	<form action="RobotManagementServlet" action="post">
		<table>
			<tr><th>Robot id</th><th>Robot Model<th>Robot Owner Name</th><th>Robot Owner Surname</th><th>UserName</th><th>Password</th></tr>
			<%
				for(RobotDTO robot: listRobot){
			%>
			<tr>
				<td><%=robot.getRobotId() %></td>
				<td><%=robot.getRobotModel() %></td>
				<td><%=robot.getRobotOwnerName() %></td>
				<td><%=robot.getRobotOwnerSurname() %></td>
				<td><%=robot.getRobotModel() %></td>
				<td><%=robot.getPassword() %>
				<td><a href="RobotManagementServlet?richiesta=Delete&robot_model=<%=robot.getRobotModel()%>">Delete</a></td>
			</tr>
			
			<%
				}	
			%>
		</table>
		
		<a href="insertRobot.jsp">Insert</a>
	</form>
	
	<a href="homeAdmin.jsp">Back</a>
</body>
</html>