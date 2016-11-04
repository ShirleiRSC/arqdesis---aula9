package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import factory.ConnectionFactory;
//import java.util.ArrayList;
import to.AlunoTO;

public class AlunoDAO {
	
	public void incluir(AlunoTO to) {
		String sqlInsert = "INSERT INTO aluno(nome,endereco,telefone,email,rg,cpf) VALUES (?,?,?,?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement st = conn.prepareStatement(sqlInsert);){
			 //st.setInt(1,to.getId());
	         st.setString(1,to.getNome());
	         st.setString(2,to.getEndereco());
	         st.setString(3,to.getTelefone());
	         st.setString(4,to.getEmail());
	         st.setString(5,to.getRG());
	         st.setString(6,to.getCPF());
	         st.execute();
	         String sqlSelect = "SELECT LAST_INSERT_ID()";
				try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
						ResultSet rs = stm1.executeQuery();){
						if(rs.next()){
							to.setId(rs.getInt(1));
						}
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(AlunoTO to) {
		String sqlUpdate = "UPDATE aluno SET nome = ?, endereco = ?, telefone = ?, email = ?, rg = ?, cpf = ? WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement st = conn.prepareStatement(sqlUpdate);){
	         st.setString(1,to.getNome());
	         st.setString(2,to.getEndereco());
	         st.setString(3,to.getTelefone());
	         st.setString(4,to.getEmail());
	         st.setString(5,to.getRG());
	         st.setString(6,to.getCPF());
	         st.setInt(7,to.getId());	         
	         st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(AlunoTO to) {
		String sqlDelete = "DELETE FROM aluno WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement st = conn.prepareStatement(sqlDelete);) {
			st.setInt(1, to.getId());
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public AlunoTO carregar(int id) {
		AlunoTO to = new AlunoTO();
		String sqlSelect = "SELECT id, nome, endereco, telefone, email, rg, cpf FROM aluno WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlSelect);) {
			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setEndereco(rs.getString("endereco"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmail(rs.getString("email"));
					to.setRG(rs.getString("rG"));
		            to.setCPF(rs.getString("cPF"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
	
	
}
