<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Menu</title>
</head>
<body>

<h2><center>------- INSERT USER -------</center></h2>
</form>

     <h3>Inserisci i dati dell'utente</h3>
     <form action="UsersManagementServlet?richiesta=Insert" method="post">
     	
     	<h4>Name: <input type = "text" name ="name" placeholder = "insert name"></h4>
     	
     	<h4>Surname: <input type = "text" name ="surname" placeholder = "insert surname"></h4>
     	
     	<h4>UserName: <input type = "text" name ="user" placeholder = "insert username"></h4>
     	
     	<h4>Password: <input type = "password" name ="pass" placeholder = "insert password"></h4>
     	
     	<input type="submit" value="insert" name="pulsante">
     	
     </form>
     
     <a href="UsersManagementServlet?richiesta=UserManager">Back</a>
</body>
</html>