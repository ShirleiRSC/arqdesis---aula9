package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import model.Aluno;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlunoTest {
	Aluno aluno, copia;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o objeto instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se tambÃ©m que sobrecarregou o equals na classe
	 * Aluno. 
	 * Certifique-se que a fixture aluno 1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes são importantes; por
	 * isso a anotaçãoo FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		aluno = new Aluno(5,"alessandro","Rua Sousa","1111-1111","alessandro@gmail.com","444444444","44444444444");
		copia = new Aluno(5,"alessandro","Rua Sousa","1111-1111","alessandro@gmail.com","444444444","44444444444");
	}
	
	@Test
	public void test00Carregar() {
		//para funcionar o aluno 1 deve ter sido carregado no banco por fora
		//INSERT into aluno(id,nome,endereco,telefone,email,rg,cpf) values(1,'Alessandro','Rua Sousa','1111-1111','alessandro@gmail.com','111111111','11111111111');
		Aluno fixture = new Aluno(1,"Alessandro","Rua Sousa","1111-1111","alessandro@gmail.com","111111111","11111111111");
		Aluno novo = new Aluno(1, null, null,null,null,null,null);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		aluno.criar();
		aluno.carregar();
		assertEquals("testa criacao", aluno, copia);
	}

	@Test
	public void test02Atualizar() {
		aluno.setTelefone("99998888");
		copia.setTelefone("99998888");		
		aluno.atualizar();
		aluno.carregar();
		assertEquals("testa inclusao", aluno, copia);
	}

	@Test
	public void test03Excluir() {
		aluno.setNome(null);
		aluno.setTelefone(null);
		aluno.setEndereco(null);
		aluno.setEmail(null);
		aluno.setRG(null);
		aluno.setCPF(null);
		copia.setNome(null);
		copia.setTelefone(null);
		copia.setEndereco(null);
		copia.setEmail(null);
		copia.setRG(null);
		copia.setCPF(null);
		aluno.excluir();
		assertEquals("testa inclusao", aluno, copia);
	}
}