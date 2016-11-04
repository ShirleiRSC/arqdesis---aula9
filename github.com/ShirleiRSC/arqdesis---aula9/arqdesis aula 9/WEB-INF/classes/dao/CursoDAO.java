package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import factory.ConnectionFactory;
//import java.util.ArrayList;
import to.CursoTO;

public class CursoDAO {
	
	public void incluir(CursoTO to) {
		
		
		String sqlInsert = "INSERT INTO curso(nome,dataInicio,dataTermino,hora,vagas,valor) VALUES (?,?,?,?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement st = conn.prepareStatement(sqlInsert);){
			 //st.setInt(1,to.getId());
	         st.setString(1,to.getNome());
	         st.setString(2,to.getDataInicio());
	         st.setString(3,to.getDataTermino());
	         st.setString(4,to.getHora());
	         st.setInt(5,to.getVagas());
	         st.setDouble(6,to.getValor());
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
	
	public void atualizar(CursoTO to) {
		String sqlUpdate = "UPDATE curso SET nome = ?, dataInicio = ?, dataTermino = ?, hora = ?, vagas = ?, valor = ? WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement st = conn.prepareStatement(sqlUpdate);){
			
	         st.setString(1,to.getNome());
	         st.setString(2,to.getDataInicio());
	         st.setString(3,to.getDataTermino());
	         st.setString(4,to.getHora());
	         st.setInt(5,to.getVagas());
	         st.setDouble(6,to.getValor());	
	         st.setInt(7,to.getId());
	         st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(CursoTO to) {
		String sqlDelete = "DELETE FROM curso WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement st = conn.prepareStatement(sqlDelete);) {
			st.setInt(1, to.getId());
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CursoTO carregar(int id) {
		CursoTO to = new CursoTO();
		String sqlSelect = "SELECT id,nome,dataInicio,dataTermino,hora,vagas,valor FROM curso WHERE curso.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlSelect);) {
			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setDataInicio(rs.getString("DataInicio"));
					to.setDataTermino(rs.getString("dataTermino"));
					to.setHora(rs.getString("hora"));
					to.setVagas(rs.getInt("vagas"));
					to.setValor(rs.getDouble("Valor"));
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
