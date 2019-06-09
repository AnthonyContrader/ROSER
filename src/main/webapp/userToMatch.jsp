<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="it.contrader.dto.RobotDTO" %>
<%@ page import="it.contrader.dto.UsersDTO" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select user to match</title>
<%
	List<UsersDTO> users = (List<UsersDTO>) request.getAttribute("users");
	RobotDTO robot = (RobotDTO) request.getAttribute("robot");
 %>
</head>
<body>
	<h2>Select user to match</h2>
	<form>
	<table>
		<tr><th>User name</th><td>User surname</td></tr>
		<%for(UsersDTO user: users){%>
			<tr>
				<td><%=user.getUserName() %></td>
				<td><%=user.getUserSurname() %></td>
				<td><a href="RobotManagementServlet?richiesta=Match&robot=<%=robot.getRobotModel() %>&user=<%=user.getUserId() %>">Select</a></td>
			</tr>
		<%
		}
		%>
	</table>
	
	</form>
</body>
</html>