<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Let's Study - Buscar Cursos</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>

<body>
	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Excluir Curso</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este curso?</div>
				<div class="modal-footer">
					<form action="controller.do" method="post">
						<input type="hidden" name="id" id="id_excluir" />
						<button type="submit" class="btn btn-primary" name="command"
							value="ExcluirCurso">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"></c:import>
	<!-- Container Principal -->
	<div id="home-padding" class="container-fluid">
	<c:import url="Menu_curso.jsp"></c:import>		
		<hr />
		<c:if test="${not empty lista}">
		<div id="list" class="row">

			<div class="table-responsive col-md-12">
				<table class="table table-striped" cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>Data Início</th>
							<th>Data Término</th>
							<th>Hora</th>
							<th>Vagas</th>
							<th>Valor</th>
							<th class="actions">Ações</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="curso" items="${lista}">
						
							<tr>
								<td>${curso.id}</td>
								<td>${curso.nome}</td>
								<td>${curso.dataInicio}</td>
								<td>${curso.dataTermino}</td>
								<td>${curso.hora}</td>
								<td>${curso.vagas}</td>
								<td><fmt:setLocale value="pt_BR"/>
      <fmt:formatNumber value="${curso.valor}" type="currency"/></td>
								<td class="actions"><a class="btn btn-success btn-xs"
									href="controller.do?command=VisualizarCurso&id=${curso.id}">Visualizar</a>
									<a class="btn btn-warning btn-xs"
									href="controller.do?command=EditarCurso&id=${curso.id}">Editar</a>
									<button id="btn${curso.id}" type="button"
										class="btn btn-danger btn-xs" data-toggle="modal"
										data-target="#delete-modal" data-cliente="${curso.id}">Excluir</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
		<!-- /#list -->

		<div id="bottom" class="row">
			<div class="col-md-12">
				<!-- paginação ainda não foi implementada -->
				<ul class="pagination">
					<li class="disabled"><a>&lt; Anterior</a></li>
					<li class="disabled"><a>1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li class="next"><a href="#" rel="next">Próximo &gt;</a></li>
				</ul>
				<!-- /.pagination -->

			</div>
		</div>
		</c:if>
		<!-- /#bottom -->
	</div>
	<!-- /#main -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
                $("#delete-modal").on('show.bs.modal', function(event) {
                    var button = $(event.relatedTarget); //botao que disparou a modal
                    var recipient = button.data('cliente');
                    $("#id_excluir").val(recipient);
                });
            </script>
</body>

</html>