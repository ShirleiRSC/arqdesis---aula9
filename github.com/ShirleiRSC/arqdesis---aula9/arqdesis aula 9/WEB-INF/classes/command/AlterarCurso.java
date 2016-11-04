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

public class AlterarCurso implements Command {
	
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
		} catch (Exception e) {

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
		RequestDispatcher view = null;

		curso.atualizar();
		@SuppressWarnings("unchecked")
		ArrayList<CursoTO> lista = (ArrayList<CursoTO>) session.getAttribute("lista");
		int pos = busca(curso, lista);
		lista.remove(pos);
		lista.add(pos, curso.getTO());
		session.setAttribute("lista", lista);
		request.setAttribute("curso", curso.getTO());
		view = request.getRequestDispatcher("VisualizarCurso.jsp");
		view.forward(request, response);
	}

	public int busca(Curso curso, ArrayList<CursoTO> lista) {
		CursoTO to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == curso.getId()) {
				return i;
			}
		}
		return -1;
	}

}
