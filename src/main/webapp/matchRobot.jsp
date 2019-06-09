<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="it.contrader.dto.RobotDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<%
		List<RobotDTO> robots = (List<RobotDTO>) request.getAttribute("robots");
	 %>
</head>
<body>
	<h2>---- Robot Matching ----</h2>
	
	<table>
		<tr><th>Robot Model</th><th>Robot Owner Name</th><th>Robot Onwer Surname</th></tr>
		<% for(RobotDTO robot: robots){%>
			<tr>
				<td><%=robot.getRobotModel() %></td>
				<td><%=robot.getRobotOwnerName() %></td>
				<td><%=robot.getRobotOwnerSurname() %></td>
				<td><%if(robot.getRobotOwnerName().equals("") || robot.getRobotOwnerName().equals(" ") ||
							robot.getRobotOwnerName().equals(null)){%>
							<a href="RobotManagementServlet?richiesta=UserToMatchRedirect&robot=<%=robot.getRobotModel()%>">Match</a>
					<%}else{ %>
							<a href="RobotManagementServelt?richiesta=Dismatch&robot=<%=robot.getRobotModel() %>">Dismatch</a>
				</td>
			</tr>
		<% 
			}
		} %>
	</table>	
	
	<br>
	<a href="homeDoctor.jsp">Back</a>
</body>
</html>