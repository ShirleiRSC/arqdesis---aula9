package model;

import dao.CursoDAO;
import to.CursoTO;


public class Curso {
	private int id;
	private String nome;
	private String dataInicio;
	private String dataTermino;
	private String hora;
	private int vagas;
	private double valor;

	public Curso(int idC, String nome, String dInicio, String dTermino, String hora, int nVagas, double valor) {
		setId(idC);
		setNome(nome);
		setDataInicio(dInicio);
		setDataTermino(dTermino);
		setHora(hora);
		setVagas(nVagas);
		setValor(valor);
	}

	//set's
	public void setId(int idC){
		this.id = idC;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public void setDataInicio(String dInicio){
		this.dataInicio = dInicio;
	}

	public void setDataTermino(String dTermino){
		this.dataTermino = dTermino;
	}

	public void setHora(String h){
		this.hora = h;
	}

	public void setVagas(int vagas){
		this.vagas = vagas;
	}

	public void setValor(double valor){
		this.valor = valor;
	}

	//get's
	public int getId(){
		return id;
	}

	public String  getNome(){
		return nome;
	}

	public String  getDataInicio(){
		return dataInicio;
	}

	public String  getDataTermino(){
		return dataTermino;
	}

	public String  getHora(){
		return hora;
	}

	public int getVagas(){
		return vagas;
	}

	public double getValor(){
		return valor;
	}

	public void criar() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = getTO();
		dao.incluir(to);
		this.id = to.getId();
	}

	public CursoTO getTO() {
		CursoTO to = new CursoTO();
		to.setId(id);
		to.setNome(nome);
		to.setDataInicio(dataInicio);
		to.setDataTermino(dataTermino);
		to.setHora(hora);
		to.setVagas(vagas);
		to.setValor(valor);
		return to;
	}

	public void atualizar() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = getTO();
		dao.atualizar(to);
	}

	public void excluir() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = new CursoTO();
		to.setId(id);
		dao.excluir(to);
	}

	public void carregar() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = dao.carregar(id);
		id = to.getId();
		nome = to.getNome();
		dataInicio = to.getDataInicio();
		dataTermino = to.getDataTermino();
		hora = to.getHora();
		vagas = to.getVagas();
		valor = to.getValor();

	}

	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", Data In�cio=" + dataInicio + 
				", Data T�rmino=" + dataTermino + ", Hora=" + hora + ", Vagas=" + vagas + ", Valor=" + valor +  "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataTermino.equals(other.dataTermino))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (vagas != other.vagas)
			return false;
		if (valor != other.valor) {
			return false;
		}
		return true;
	}
}