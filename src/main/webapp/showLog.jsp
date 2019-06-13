<%@ page import="it.contrader.dto.SensordataDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show log</title>

<% 
	List<SensordataDTO> data = (List<SensordataDTO>) request.getAttribute("log");
%>
</head>
<body>
	<h2>----- SHOW LOG -----</h2>
	<table border=2>
			<tr><th>Patient Name</th><th>Patient Surname</th><th>Decibel</th><th>Face Express</th><th>Humidity</th><th>Date</th></tr>
			 	<%
					for(SensordataDTO sensordata: data){
				 %>
		 	<tr>
		 		<td><%=sensordata.getPatientName()%></td>
		 		<td><%=sensordata.getPatientSurname()%></td>
		 		<td><%=sensordata.getDecibel()%></td>
		 		<td><%=sensordata.getFaceExpress()%></td>
		 		<td><%=sensordata.getHumidity()%></td>
		 		<td><%=sensordata.getDataDate()%></td>
		 	</tr>
		<% 
			}
		%>
		</table>
		<br>
	<a href="/homeRobot.jsp">Back</a>
</body>
</html>