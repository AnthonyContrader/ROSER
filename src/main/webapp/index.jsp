<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>LOGIN ROSER</title>

  <!-- Bootstrap CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="css/elegant-icons-style.css" rel="stylesheet" />
  <link href="css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet" />
</head>

<body  class="login-img3-body">
  <div class="container"> <!-- Container generale della pagina-->
	<div class="row">     <!-- Container oer creare la griglia a colonne -->
		<div class="col-sm-6 login-logo">  <!-- Container per la prima colonna la proprieta: col-sm-(x) {x=12/numero colonne previste} -->
				<img src="img/logo_bianco.svg">
		</div>
		
	<div class="col-sm-6">
	<form class="login-form" action="/User/login" method="post">
	
		<div class="login-wrap">
					<p class="login-img"><i class="icon_lock_alt"></i></p>
					<div class="input-group">
						<span class="input-group-addon"><i class="icon_profile"></i></span>
						<input type="text" name="username" class="form-control" placeholder="Username" autofocus>
					</div>
					<div class="input-group">
						<span class="input-group-addon"><i class="icon_key_alt"></i></span>
						<input type="password" name ="password" class="form-control" placeholder="Password">
					</div>

					<button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
				</div>
				
	</form>
	</div>
	</div>
	</div>
</body>
</html>