<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@	page import="it.contrader.dto.UserDTO"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Home Admin</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/navbar.css" rel="stylesheet">

</head>

<body>
<div>
<h2>WELCOME ${utenteCollegato}</h2>

</div>
<nav class='navbar navbar-inverse'>
     <div class='container-fluid'>
         <ul class='nav navbar-nav navbar-inverse navbar-custom'>
            <li><a href="/Home/doctorManagement/">Doctor Managment</a></li>
            <li><a href="/Home/devicesManagement/">Devices Managment</a></li>
            <li><a href="/Home/logout/">Logout</a></li>
         </ul>
    </div>
</nav>
</body>
</html>