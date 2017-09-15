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
					<li class="active"><a href="#">Venda</a></li>
					<li><a href="/mercadoria/servlet/ConsultaServlet">Consulta de Operações</a></li>
				</ul>
			</div>
		</nav>
		<div class="row">
			<div class="col-md-12" style="text-align: center;"> 
				<h1>Venda de Mercadorias</h1>
			</div>
		</div>
		<div class="row">
			<br>
			<br>
			<br>
			<br>
			<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
				<form id="form" method="post">
					<div class="form-group">
						<label class="">Escolha um tipo de Mercadoria</label>
						<select class="input-large form-control" onChange="alteraSel()" id="selMercadoria">
							<option value="0" selected="selected">Selecione</option>
							<c:if test="${not empty listaTiposMercadoria}">
								<c:forEach var="tipoMercadoria" items="${listaTiposMercadoria}">
									<option value="${tipoMercadoria.idTipoMercadoria}">${tipoMercadoria.dsTipoMercadoria}</option>
								</c:forEach>
							</c:if>
						</select>
						<input type="hidden" name="tipoMercadoria" id="tipoMercadoria" value="0"/>
						<input type="hidden" name="acao" id="acao" value="fimVenda"/>
					</div>
					<div class="form-group">
						<label class="">O que você está vendendo?</label>
						<input class="form-control" maxlength="6" type="text" id="inMercadoria" name="inMercadoria" placeholder="Nome" required>
					</div>
					<div class="form-group">
						<label class="">Digite a Quantidade</label>
						<input class="form-control" maxlength="6" type="number" id="inQuantidade" name="inQuantidade" placeholder="Quantidade" min="1" step="1">
					</div>
					<div class="form-group">
						<label class="">Qual o preço?</label>
						<input class="form-control" maxlength="6" type="number" id="inPreco" name="inPreco" placeholder="Preço" min="0.01">
					</div>
					<div class="form-group">
						<a class="btn btn-primary" onClick="prosseguir()">Vender!</a>
					</div>
				</form>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		$(document).ready(function(){
			$("body").show();
			var erro = '${erro}';
			var sucesso = '${sucesso}';
			if(erro.length > 0){
				alert('Ocorreu um erro de processamento! Favor tentar novamente.')
			}
			if(sucesso.length > 0){
				alert('Compra efetuada com sucesso!')
			}
		});
		function alteraSel(){
			var valSel = $("#selMercadoria").val();
			$("#tipoMercadoria").val(valSel);
		}
		function prosseguir(){
			var tipoMercadoria = $("#tipoMercadoria").val();
			var inMercadoria = $("#inMercadoria").val();
			var inQuantidade = $("#inQuantidade").val();
			var inPreco = $("#inPreco").val();
			if(tipoMercadoria == 0){
				alert('Favor selecionar um tipo de mercadoria!');
				return;
			}
			if(inMercadoria.length <= 0){
				alert('Existem dados a serem preenchidos!');
				return;
			}
			if(inQuantidade.length <= 0){
				alert('Existem dados a serem preenchidos!');
				return;
			}
			if(inPreco.length <= 0){
				alert('Existem dados a serem preenchidos!');
				return;
			}
			$("#form").submit();
		}
	</script>
</html>