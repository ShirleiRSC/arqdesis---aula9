package test;

import static org.junit.Assert.*;
//import java.util.Calendar;
//import javax.crypto.CipherSpi;
import org.junit.Before;
import org.junit.Test;

import to.CursoTO;

public class CursoTOTest {
	CursoTO to;
	@Before
	public void setUp() throws Exception {
		to = new CursoTO();
		to.setId(3);
		to.setNome("Sistemas");
		to.setDataInicio("02/02/2016");
		to.setDataTermino("30/12/2017");
		to.setHora("22:00");
		to.setVagas(220);
		to.setValor(300.00);
	}

	@Test
	public void testGets() {
		assertEquals("getId", to.getId(), 3);
		assertEquals("getNome", to.getNome(), "Sistemas");
		assertEquals("getDataInicio", to.getDataInicio(), "02/02/2016");
		assertEquals("getDataTermino", to.getDataTermino(), "30/12/2017");
		assertEquals("getHora", to.getHora(), "22:00");
		assertEquals("getVagas", to.getVagas(), 220);
		assertEquals("getValor", to.getValor(), 300.00, 0.03);

	}

	@Test
	public void testEquals(){
		CursoTO copia = new CursoTO();
		copia.setId(to.getId());
		copia.setNome(to.getNome());
		copia.setDataInicio(to.getDataInicio());
		copia.setDataTermino(to.getDataTermino());
		copia.setHora(to.getHora());
		copia.setVagas(to.getVagas());
		copia.setValor(to.getValor());		
	}
}