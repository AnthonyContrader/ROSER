<html>
<head>
<title>Login Roser</title>
</head>
<body>
	<div>
		<form action="LoginServlet" method="post"> <!-- si dichiara il servlet sul quale si collega la pagina con il metodo post(invia) -->
			<h3>
				<!-- l'attributo name sarà l'etichetta con la quale verrano passati i parametri interessati -->
				username: <input type="text" name="user_user"
					placeholder="inserisci username">
			</h3>
			<h3>
				password: <input type="password"name="user_pass"
					placeholder="inserisci password">
			</h3>
			<button type="submit" value="Login" name="pulsante">Login</button>
			
			<h2><font color="red">${errore}</font></h2>
		</form>
	</div>
</body>
</html>