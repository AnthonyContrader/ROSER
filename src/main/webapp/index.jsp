<html>
<head>
<title>Login Trader</title>
</head>
<body>
	<div>
		<form name="login" action="LoginServlet" method="post">
			<h3>
				username: <input type="text" id="user" name="user_user"
					placeholder="inserisci username">
			</h3>
			<h3>
				password: <input type="password" id="pass" name="user_pass"
					placeholder="inserisci password">
			</h3>
			<button type="submit" value="Login" name="pulsante">Login</button>
			<br> <a href="register.jsp"> Registrati </a>
		</form>
	</div>
</body>
</html>