package test;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import dao.CursoDAO;
import to.CursoTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CursoDAOTest {
	
	CursoDAO dao;
	CursoTO to;
	
	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco
	 * nenhuma linha com o id igual ao do escolhido para o objeto instanciado
	 * abaixo. Se houver, delete. 
	 * Certifique-se de que o fixture cliente 1 existe no banco.
	 * Certifique-se também que sobrecarregou o equals na classe CursoTO
	 * Além disso, a ordem de execução dos testes é importante; por isso a anotação
	 * FixMethodOrder logo acima do nome desta classe
	 */

	@Before
	public void setUp() throws Exception {
		dao = new CursoDAO();
		to = new CursoTO();
		to.setNome("Sistemas");
		to.setDataInicio("2016-02-02");
		to.setDataTermino("2017-12-30");
		to.setHora("22:00");
		to.setVagas(220);
		to.setValor(330.00);
		to.setId(3);
	}

	@Test
	public void test00Carregar() {
		//para funcionar o curso 1 deve ter sido carregado no banco por fora
		//INSERT into curso(id,nome,dataInicio,dataTermino,hora,vagas,valor) values(1,'Sistemas de Informa��o','2016-02-02','2017-02-28','22:00', 220, 300.00);
		CursoTO fixture = new CursoTO();
		fixture.setId(1);
		fixture.setNome("Sistemas de Informa��o");
		fixture.setDataInicio("2016-02-02");
		fixture.setDataTermino("2017-02-28");
		fixture.setHora("22:00");
		fixture.setVagas(220);
		fixture.setValor(300.00);		
		CursoTO novo = dao.carregar(1);
		novo.setId(1);
		assertEquals("testa carregar", novo, fixture);
	}

	@Test
	public void test01Inserir() {
		dao.incluir(to);
		CursoTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar() {
		to.setNome("Sistemas");
		dao.atualizar(to);
		CursoTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa atualizar", novo, to);
	}
	
	@Test
	public void test03Excluir() {
		to.setNome(null);
		to.setDataInicio(null);
		to.setDataTermino(null);
		to.setHora(null);
		to.setVagas(0);
		to.setValor(0.00);
		dao.excluir(to);
		CursoTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa exclusão", novo, to);
	}

}


