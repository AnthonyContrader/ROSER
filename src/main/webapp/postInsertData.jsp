<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%
	String url = (String) request.getAttribute("url");
%>
<title>Umore paziente</title>
</head>
<body>

	<h1>Patient Humor</h1>
		<img src="<%=url%>">
	<a href=homeRobot.jsp>Back</a>
</body>
</html>