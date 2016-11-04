package test;

import static org.junit.Assert.*;
//assertEquals;
import org.junit.Before;
import org.junit.Test;

import to.AlunoTO;

public class AlunoTOTest {
	AlunoTO to;
	@Before
	public void setUp() throws Exception {
		to = new AlunoTO();
		to.setId(3);
		to.setNome("Alessandro");
		to.setEndereco("Rua Mariano de Sousa");
		to.setTelefone("11111111");
		to.setEmail("alessandrosponte@gmail.com");
		to.setRG("222222222");
		to.setCPF("22222222222");
	}

	@Test
	public void testGets() {
		assertEquals("getId", to.getId(), 3);
		assertEquals("getNome", to.getNome(), "Alessandro");
		assertEquals("getEndereco", to.getEndereco(), "Rua Mariano de Sousa");
		assertEquals("getTelefone", to.getTelefone(), "11111111");
		assertEquals("getEmail", to.getEmail(), "alessandrosponte@gmail.com");
		assertEquals("getRG", to.getRG(), "222222222");
		assertEquals("getCPF", to.getCPF(), "22222222222");

	}

	@Test
	public void testEquals(){
		AlunoTO copia = new AlunoTO();
		copia.setId(to.getId());
		copia.setNome(to.getNome());
		copia.setEndereco(to.getEndereco());
		copia.setTelefone(to.getTelefone());
		copia.setEmail(to.getEmail());
		copia.setRG(to.getRG());
		copia.setCPF(to.getCPF());		
		assertEquals(to, copia);
	}

}


