<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Let's Study - Alterar Curso</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>

        <body>
                <!-- Barra superior com os menus de navegação -->
                <c:import url="Menu.jsp"></c:import>
                <!-- Container Principal -->
                <div id="home-padding" class="container">
                    <h3 class="page-header">Alterar Curso #${curso.id}</h3>
                    <!-- Formulario para alteração de clientes -->
                    <form action="controller.do" method="post">
                        <!-- area de campos do form -->
                        <input type="hidden" name="id" value="${curso.id}" />
                        <div class="row">
                            <div class="form-group col-md-12">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="nome do curso" value="${curso.nome}">
                </div>
            </div>
            
            
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="dataInicio">Data Início</label>
                    <input type="text" class="form-control" name="dataInicio" id="dataInicio" required maxlength="100" placeholder="data de início" value="${curso.dataInicio}">
                </div>
                <div class="form-group col-md-6">
                    <label for="dataTermino">Data Termino</label>
                    <input type="tel" class="form-control" name="dataTermino" id="dataTermino" required maxlength="15" placeholder="data de término" value="${curso.dataTermino}">
                </div>
             </div>
			<div class="row">
                <div class="form-group col-md-6">
                    <label for="hora">Hora</label> <input type="text"class="form-control"
						name="hora" id="hora" required maxlength="60"
						placeholder="hora" value="${curso.hora}">
				</div>
				<div class="form-group col-md-6">
                    <label for="vagas">Vagas</label>
                    <input type="text" class="form-control" name="vagas" id="vagas" required maxlength="9" placeholder="vagas" value="${curso.vagas}">
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-3">
                </div>
                <div class="form-group col-md-6">
                    <label for="valor">Valor</label>
                    <input type="text" class="form-control" name="valor" id="valor" required maxlength="11" placeholder="valor" value="${curso.valor}">
                </div>
            </div>
                        <hr />
                        <div id="actions" class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary" name="command" value="AlterarCurso">Salvar</button>
                                <a href="ListarCursos.jsp" class="btn btn-default">Cancelar</a>
                            </div>
                        </div>
                    </form>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>