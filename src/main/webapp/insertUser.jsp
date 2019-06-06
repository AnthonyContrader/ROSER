<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="it.contrader.dto.DoctorDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<title>MANAGEMENT USERS</title>
<%
	DoctorDTO doctor = new DoctorDTO();
%>
</head>
<body>

<h2><center>------- INSERT USER -------</center></h2>
	
    <h3>Inserisci i dati dell'utente</h3>
    	<form action="UsersServlet?richiesta=insert" method="post">
     		<h4>Username: <input type = "text" id = "user" name ="username" placeholder = "inserisci username"></h4>
     	
     		<h4>Password: <input type = "password" id = "pass" name ="password" placeholder = "inserisci la password"></h4>
     	
     		<h4>Nome: <input type = "text" id = "name" name ="nameuser" placeholder = "inserisci nome"></h4>
     	
     		<h4>Cognome: <input type = "text" id = "surname" name ="surnameuser" placeholder = "inserisci cognome"></h4>
     		
     		<input type="SUBMIT" value="Add">
    	 </form>
</body>
</html>