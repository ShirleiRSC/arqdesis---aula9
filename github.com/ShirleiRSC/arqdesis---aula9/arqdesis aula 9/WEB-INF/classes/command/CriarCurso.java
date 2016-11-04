package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Curso;
import to.CursoTO;

public class CriarCurso implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pDataInicio = request.getParameter("dataInicio");
		String pDataTermino = request.getParameter("dataTermino");
		String pHora = request.getParameter("hora");
		String pVagas = request.getParameter("vagas");		
		String pValor = request.getParameter("valor");
		String pId = request.getParameter("id");

		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}
		int vagas = -1;
		try {
			vagas = Integer.parseInt(pVagas);
		} catch (NumberFormatException e) {

		}
		Double valor = -1.0;
		  String str = "";

		  if (pVagas == null)
		     {str = valor.toString();}else{str = pValor;}
		try {
			valor = Double.parseDouble(str);
		} catch (NumberFormatException e) { 
			e.printStackTrace();
		}

		Curso curso = new Curso (id, pNome, pDataInicio,pDataTermino,pHora,vagas,valor);
		HttpSession session = request.getSession();

		curso.criar();
		ArrayList<CursoTO> lista = new ArrayList<>();
		lista.add(curso.getTO());
		session.setAttribute("lista", lista);
		RequestDispatcher view =  request.getRequestDispatcher("ListarCursos.jsp");
		view.forward(request, response);
	}
}
