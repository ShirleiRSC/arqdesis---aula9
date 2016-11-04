package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import model.Curso;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CursoTest {
	
	Curso curso, copia;
	
	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Curso. 
	 * Certifique-se que a fixture curso foi criado no banco.
	 * Além disso, a ordem de execução dos testes são importantes; por
	 * isso a anotaçãoo FixMethodOrder logo acima do nome desta classe
	 */
	
	@Before
	public void setUp() throws Exception {
		curso = new Curso(5,"Sistemas","2016-02-02","2017-02-28","22:00", 220, 300.00);
		copia = new Curso(5,"Sistemas","2016-02-02","2017-02-28","22:00", 220, 300.00);
	}
	
	@Test
	public void test00Carregar() {
		//para funcionar o curso 1 deve ter sido carregado no banco por fora
		//INSERT into curso(id,nome,dataInicio,dataTermino,hora,vagas,valor) values(1,'Sistemas de Informação','2016-02-02','2017-02-28','22:00', 220, 300.00);
		Curso fixture = new Curso(1,"Sistemas de Informação","2016-02-02","2017-02-28","22:00", 220, 300.00);
		Curso novo = new Curso(1, null,null,null,null, 0,0.00);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		curso.criar();
		curso.carregar();
		assertEquals("testa criacao", curso, copia);
	}

	@Test
	public void test02Atualizar() {
		curso.setNome("Ciência da Computação");
		copia.setNome("Ciência da Computação");		
		curso.atualizar();
		curso.carregar();
		assertEquals("testa inclusao", curso, copia);
	}

	@Test
	public void test03Excluir() {
		curso.setNome(null);
		curso.setDataInicio(null);
		curso.setDataTermino(null);
		curso.setHora(null);
		curso.setVagas(0);
		curso.setValor(0.00);
		copia.setNome(null);
		copia.setDataInicio(null);
		copia.setDataTermino(null);
		copia.setHora(null);
		copia.setVagas(0);
		copia.setValor(0.00);
		copia.excluir();
		assertEquals("testa inclusao", curso, copia);
	}
}
	
