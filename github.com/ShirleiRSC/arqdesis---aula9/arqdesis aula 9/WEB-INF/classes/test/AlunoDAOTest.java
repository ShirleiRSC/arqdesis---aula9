package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import dao.AlunoDAO;
import to.AlunoTO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlunoDAOTest {
	AlunoDAO dao;
	AlunoTO to;
	
	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco
	 * nenhuma linha com o id igual ao do escolhido para o objeto instanciado
	 * abaixo. Se houver, delete. 
	 * Certifique-se de que o fixture aluno 1 existe no banco.
	 * Certifique-se também que sobrecarregou o equals na classe AlunoTO
	 * Além disso, a ordem de execução dos testes é importante; por isso a anotação
	 * FixMethodOrder logo acima do nome desta classe
	 */

	@Before
	public void setUp() throws Exception {
		dao = new AlunoDAO();
		to = new AlunoTO();
		to.setNome("Alessandro");
		to.setEndereco("Rua Mariano de Sousa");
		to.setTelefone("1111-1111");
		to.setEmail("alessandrosponte@gmail.com");
		to.setRG("222222222");
		to.setCPF("22222222222");
		to.setId(3);
	}

	@Test
	public void test00Carregar() {
		//para funcionar o aluno 1 deve ter sido carregado no banco por fora
		//INSERT into aluno(id,nome,endereco,telefone,email,rg,cpf) values(1,'Alessandro','Rua Sousa','1111-1111','alessandro@gmail.com','111111111','11111111111');
		AlunoTO fixture = new AlunoTO();
		fixture.setId(1);
		fixture.setNome("Alessandro");
		fixture.setEndereco("Rua Sousa");
		fixture.setTelefone("1111-1111");
		fixture.setEmail("alessandro@gmail.com");
		fixture.setRG("111111111");
		fixture.setCPF("11111111111");		
		AlunoTO novo = dao.carregar(1);
		novo.setId(1);
		assertEquals("testa carregar", novo, fixture);
	}

	@Test
	public void test01Inserir() {
		dao.incluir(to);
		AlunoTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar() {
		to.setTelefone("999999");
		dao.atualizar(to);
		AlunoTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa atualizar", novo, to);
	}
	
	@Test
	public void test03Excluir() {
		to.setNome(null);
		to.setEndereco(null);
		to.setTelefone(null);
		to.setEmail(null);
		to.setRG(null);
		to.setCPF(null);
		dao.excluir(to);
		AlunoTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa exclus�o", novo, to);
	}

}
