<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt">
	<head>
		<meta charset="utf-8">
		<title>Projeto - Debora Uhhman</title>
		<link href="./resources/css/bootstrap.min.css" rel="stylesheet"/>
		<script src="./resources/js/jquery-3.2.1.min.js"></script>
		<script src="./resources/js/bootstrap.min.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	</head>
	<body>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">
						Projeto - Debora Uhhman
					</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Início</a></li>
					<li><a href="/mercadoria/servlet/CompraServlet">Compra</a></li>
					<li><a href="/mercadoria/servlet/VendaServlet">Venda</a></li>
					<li><a href="/mercadoria/servlet/ConsultaServlet">Consulta de Operações</a></li>
				</ul>
			</div>
		</nav>
		<div class="col-md-12" style="text-align: center;"> 
			<h1>Bem-Vindo!</h1>
		</div>
	</body>
</html>