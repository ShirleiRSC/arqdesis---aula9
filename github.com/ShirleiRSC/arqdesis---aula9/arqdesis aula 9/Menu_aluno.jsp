<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="controller.do" method="post">
     <div id="top" class="row">
    <div class="col-md-3">
        <h2>Alunos</h2>
    </div>

    <div class="col-md-6">
        <div class="input-group h2">
            <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Alunos (deixe vazio para trazer todos)">
            <span class="input-group-btn">
                <button class="btn btn-primary" type="submit" name="command"
value="ListarAlunosBuscar">
                    <span class="glyphicon glyphicon-search"></span>
                </button>
            </span>
        </div>
    </div>
    <div class="col-md-3">
        <a href="criar_aluno.jsp" class="btn btn-primary pull-right h2">Novo Aluno</a>
    </div>
</div> <!-- /#top -->
 </form>