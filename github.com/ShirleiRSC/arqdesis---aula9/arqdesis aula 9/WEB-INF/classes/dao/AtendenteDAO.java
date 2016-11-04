package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.AlunoTO;
import to.CursoTO;

public class AtendenteDAO {

	public ArrayList<AlunoTO> listarAlunos() {
		AlunoTO to;
		ArrayList<AlunoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, endereco, telefone, email, rg, cpf FROM aluno";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new AlunoTO();
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setEndereco(rs.getString("endereco"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmail(rs.getString("email"));
					to.setRG(rs.getString("rG"));
		            to.setCPF(rs.getString("cPF"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public ArrayList<AlunoTO> listarAlunos(String chave) {
		AlunoTO to;
		ArrayList<AlunoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, endereco, telefone, email, rg, cpf FROM aluno where upper(nome) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new AlunoTO();
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setEndereco(rs.getString("endereco"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmail(rs.getString("email"));
					to.setRG(rs.getString("rG"));
		            to.setCPF(rs.getString("cPF"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public ArrayList<CursoTO> listarCursos() {
		CursoTO to;
		ArrayList<CursoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, dataInicio, dataTermino, hora, vagas, valor FROM curso";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoTO();
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setDataInicio(rs.getString("dataInicio"));
					to.setDataTermino(rs.getString("dataTermino"));
					to.setHora(rs.getString("hora"));
					to.setVagas(rs.getInt("vagas"));
		            to.setValor(rs.getDouble("valor"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public ArrayList<CursoTO> listarCursos(String chave) {
		CursoTO to;
		ArrayList<CursoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, dataInicio, dataTermino, hora, vagas, valor FROM curso where upper(nome) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoTO();
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setDataInicio(rs.getString("endereco"));
					to.setDataTermino(rs.getString("telefone"));
					to.setHora(rs.getString("hora"));
					to.setVagas(rs.getInt("vagas"));
		            to.setValor(rs.getDouble("valor"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

}
