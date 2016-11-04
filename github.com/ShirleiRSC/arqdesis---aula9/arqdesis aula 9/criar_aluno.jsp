<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Let's Study - Criar Aluno</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegaÃ§Ã£o -->
    <c:import url="Menu.jsp"></c:import>
    <!-- Container Principal -->
    <div id="home-padding" class="container">
        <h3 class="page-header">Incluir Aluno</h3>
        <!-- Formulario para inclusao de Alunos -->
        <form action="controller.do" method="post">
            <!-- area de campos do form -->
            <div class="row">
            	
                <div class="form-group col-md-12">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="Nome Completo">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="endereco">Endereço</label>
                    <input type="text" class="form-control" name="endereco" id="endereco" required maxlength="100" placeholder="Endereço">
                </div>
             </div>
			<div class="row">
                <div class="form-group col-md-6">
                    <label for="telefone">Telefone</label>
                    <input type="tel" class="form-control" name="telefone" id="telefone" required maxlength="15" pattern="(?:\(\d{2}\)|\d{2})[- ]?\d{5}[- ]?\d{4}" placeholder="Telefone">
                </div>
                <div class="form-group col-md-6">
                    <label for="email">E-Mail</label> <input type="email" class="form-control"
						name="email" id="email" required maxlength="60"
						placeholder="E-mail">
				</div>
            </div>
            
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="rg">RG</label>
                    <input type="text" class="form-control" name="rg" id="rg" required maxlength="9" placeholder="RG">
                </div>
                <div class="form-group col-md-6">
                    <label for="cpf">CPF</label>
                    <input type="text" class="form-control" name="cpf" id="cpf" required maxlength="11" placeholder="CPF">
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CriarAluno">Salvar</button>
                    <a href="ListarAlunos.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>