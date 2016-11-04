package model;

import java.util.ArrayList;

import dao.AtendenteDAO;
import to.AlunoTO;
import to.CursoTO;

public class Atendente {
	public ArrayList<AlunoTO> listarAlunos(){
		ArrayList<AlunoTO> lista;
		AtendenteDAO dao = new AtendenteDAO();
		lista = dao.listarAlunos();
		return lista;
	}
	public ArrayList<AlunoTO> listarAlunos(String chave){
		ArrayList<AlunoTO> lista;
		AtendenteDAO dao = new AtendenteDAO();
		lista = dao.listarAlunos(chave);
		return lista;
	}
	
	public ArrayList<CursoTO> listarCursos(){
		ArrayList<CursoTO> lista;
		AtendenteDAO dao = new AtendenteDAO();
		lista = dao.listarCursos();
		return lista;
	}

	public ArrayList<CursoTO> listarCursos(String chave){
		ArrayList<CursoTO> lista;
		AtendenteDAO dao = new AtendenteDAO();
		lista = dao.listarCursos(chave);
		return lista;
	}

}
