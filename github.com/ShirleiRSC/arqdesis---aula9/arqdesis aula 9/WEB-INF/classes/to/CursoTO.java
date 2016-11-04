package to;

public class CursoTO {
	private int id;
	   private String nome;
	   private String dataInicio;
	   private String dataTermino;
	   private String hora;
	   private int vagas;
	   private double valor;
	
	//método set
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
	   
	   //mÃ©todo get
	   public int getId(){
	      return id;
	   }
	   public String getNome(){
	      return nome;
	   }
	   public String getDataInicio(){
	      return dataInicio;
	   }
	   public String getDataTermino(){
	      return dataTermino;
	   }
	   public String getHora(){
	      return hora;
	   }
	   public int getVagas(){
	      return vagas;
	   }
	   public double getValor(){
	      return valor;
	   }
	   
	   
	   
	   @Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CursoTO other = (CursoTO) obj;
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
