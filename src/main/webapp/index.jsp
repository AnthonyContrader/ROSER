<html>
<head>
<title>Login Trader</title>
</head>
<body>
	<div>
		<form action="LoginServlet" method="post">
			<h3>
				username: <input type="text" id="user" name="username"
					placeholder="inserisci username">
			</h3>
			
			<h3>
				password: <input type="password" id="pass" name="password"
					placeholder="inserisci password">
			</h3>
			
			<h3><font color="red" name="error">${error}</font></h3>
			<button type="submit" value="Login" name="pulsante">Login</button>
		</form>
	</div>
</body>
</html>