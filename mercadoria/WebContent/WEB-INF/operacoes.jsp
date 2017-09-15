<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<li><a href="./inicio.jsp">Início</a></li>
					<li><a href="/mercadoria/servlet/CompraServlet">Compra</a></li>
					<li><a href="/mercadoria/servlet/VendaServlet">Venda</a></li>
					<li class="active"><a href="#">Consulta de Operações</a></li>
				</ul>
			</div>
		</nav>
		<div class="row">
			<div class="col-md-12" style="text-align: center;"> 
				<h1>Lista de Operações</h1>
			</div>
		</div>
		<div class="row">
			<br>
			<br>
			<br>
			<br>
			<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
				<table class="table table-striped table-responsive" style="margin-top: 20px;">
					<thead>
						<tr>
							<th>Data</th>
						</tr>
						<tr>
							<th>Mercadoria</th>
						</tr>
						<tr>
							<th>Quantidade</th>
						</tr>
						<tr>
							<th>Negociação</th>
						</tr>
						<tr>
							<th>Valor Total</th>
						</tr>
					</thead>
					<c:if test="${not empty listaOperacoes}">
						<c:forEach var="operacao" items="${listaOperacoes}">
							<tbody>
								<tr>
									<td>${operacao.data}</td>
								</tr>
								<tr>
									<td>${operacao.nomeMercadoria}</td>
								</tr>
								<tr>
									<td>${operacao.qntMercadoria}</td>
								</tr>
								<tr>
									<td>${operacao.vl_total}</td>
								</tr>
								<tr>
									<td>${operacao.dsTipoNegocio}</td>
								</tr>
							</tbody>
						</c:forEach>
					</c:if>
				</table>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		$(document).ready(function(){
			$("body").show();
			var erro = '${erro}';
			if(erro.length > 0){
				alert('Ocorreu um erro de processamento! Favor tentar novamente.')
			}
		});
	</script>
</html>