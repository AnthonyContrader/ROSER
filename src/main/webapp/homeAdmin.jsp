<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> <!-- Aggiungo stringa per il foreach -->
<html>
<head>
<title>Menu Principale</title>
</head>
<body>
	<h1>Benvenuto: ${utente}</h1>
	<h2>------- MENU PRINCIPALE -------</h2>
		
	<form action="ManageServletUsers" method="post">
		<button type="submit" value="ListaUtenti" name="pulsanteUtenti">
			Lista Utenti</button>
	</form>
	
	<form action="MenuServletDevices" method="post">
			<button type="submit" value="ListaDIspositivi" name="pulsanteDispositivi">
			Lista Dispositivi</button>
	</form>
	<!--  
     <h3>2. Badges</h3>
     <form action="BadgeServlet" method="post">
     <button type="submit" value="badgesManagement" name="richiesta"> Management badge</button>
     </form>
     
     <h3>3. Assegnazione Badges</h3>
     <form action="AssegnazioneServlet" method="post">
     <button type="submit" value="assegnazioneManagement" name="richiesta"> Management Assegnazione</button>
     </form>
     
     <h3>4. Indietro</h3>
     <form action="CustomersServlet" method="post">
     <input type="submit" value="indietro" name="richiesta">
     </form>
     
       <h3>5.logout<h3>
     <form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>
-->


</body>
</html>