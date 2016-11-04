package model;

import dao.AlunoDAO;
import to.AlunoTO;

public class Aluno {

	private int id;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private String rG;
	private String cPF;
	
	public Aluno(int id, String n, String end, String tel, String email,
					String rG, String cPF){
		setId(id);
		setNome(n);
	    setEndereco(end);
	    setTelefone(tel);
	    setEmail(email);
	    setRG(rG);
	    setCPF(cPF);		
	}
	
	//SET's
	 	public void setId(int id){
		   this.id = id;
		   }
	   public void setNome(String n){
		   this.nome = n;
		   }
	   public void setEndereco(String end){
		   this.endereco = end;
		   }
	   public void setTelefone(String tel){
		   this.telefone = tel;
		   }
	   public void setEmail(String email){
		   this.email = email;
		   }
	   public void setRG(String rG){
		   this.rG = rG;
		   }
	   public void setCPF(String cPF){
		   this.cPF = cPF;
		   }
	   
	//GET's
	   public int getId(){
		  return id;}
	   public String  getNome(){
	      return nome;}
	   public String  getEndereco(){
	      return endereco;}
	   public String  getTelefone(){
	      return telefone;}
	   public String  getEmail(){
	      return email;}
	   public String     getRG(){
	      return rG;}
	   public String     getCPF(){
	      return cPF;}
	   
	   public void criar() {
			AlunoDAO dao = new AlunoDAO();
			AlunoTO to = getTO();
			dao.incluir(to);
			this.id = to.getId();
		}

	public AlunoTO getTO() {
		AlunoTO to = new AlunoTO();
		to.setId(id);
		to.setNome(nome);
		to.setEndereco(endereco);
		to.setTelefone(telefone);
		to.setEmail(email);
		to.setRG(rG);
		to.setCPF(cPF);
		return to;
	}
	   
	   public void atualizar() {
			AlunoDAO dao = new AlunoDAO();
			AlunoTO to = getTO();
			dao.atualizar(to);
	   }
	   
	   public void excluir() {
			AlunoDAO dao = new AlunoDAO();
			AlunoTO to = new AlunoTO();
			to.setId(id);
			dao.excluir(to);
	   }
	   
	   public void carregar() {
			AlunoDAO dao = new AlunoDAO();
			AlunoTO to = dao.carregar(id);
			id = to.getId();
			nome = to.getNome();
			endereco = to.getEndereco();
			telefone = to.getTelefone();
			email = to.getEmail();
			rG = to.getRG();
			cPF = to.getCPF();
			
		}
	   
	   @Override
		public String toString() {
			return "Aluno [id=" + id + ", nome=" + nome + ", endereço=" + endereco + 
					", telefone=" + telefone + ", email=" + email + ", RG=" + rG + ", CPF=" + cPF +  "]";
		}
	   
	   @Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Aluno other = (Aluno) obj;
			if (id != other.id)
				return false;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			if (endereco == null) {
				if (other.endereco != null)
					return false;
			} else if (!endereco.equals(other.endereco))
				return false;
			if (telefone == null) {
				if (other.telefone != null)
					return false;
			} else if (!telefone.equals(other.telefone))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (rG == null) {
				if (other.rG != null)
					return false;
			} else if (!rG.equals(other.rG))
				return false;
			if (cPF == null) {
				if (other.cPF != null)
					return false;
			} else if (!cPF.equals(other.cPF))
				return false;
			return true;
			
		}
}
