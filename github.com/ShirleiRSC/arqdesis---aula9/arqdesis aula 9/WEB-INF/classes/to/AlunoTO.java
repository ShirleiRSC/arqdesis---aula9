package to;

public class AlunoTO {
	private int id;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private String rG;
	private String cPF;
	
	
	public int getId(){
		return id;
	}
	
	public void setId(int i){
		this.id = i;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRG() {
		return rG;
	}

	public void setRG(String rG) {
		this.rG = rG;
	}

	public String getCPF() {
		return cPF;
	}

	public void setCPF(String cPF) {
		this.cPF = cPF;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoTO other = (AlunoTO) obj;
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
