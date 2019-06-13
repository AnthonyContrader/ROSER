<%@ page import="it.contrader.dto.SensordataDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient humor</title>

<% 
	String url = (String) request.getAttribute("url");
	SensordataDTO data = (SensordataDTO) request.getAttribute("data");
%>
</head>
<body>
	<h2>----- PATIENT HUMOR -----</h2>
	<table border=2>
			<tr><th>Patient Name</th><th>Patient Surname</th><th>Decibel</th><th>Face Express</th><th>Humidity</th><th>Humor</th><th>Image</th></tr>
			 	<tr>
			 		<td><%=data.getPatientName()%></td>
			 		<td><%=data.getPatientSurname()%></td>
			 		<td><%=data.getDecibel()%></td>
			 		<td><%=data.getFaceExpress() %></td>
			 		<td><%=data.getHumidity()%></td>
			 		<td>${emotion}</td>
			 		<td><img src=<%=url %>></td>
			 	</tr> 
		</table>
		<br>
	<a href="/homeRobot.jsp">Back</a>
</body>
</html>