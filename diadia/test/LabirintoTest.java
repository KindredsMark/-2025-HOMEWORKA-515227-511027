package diadia;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.*;

public class LabirintoTest {
	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		this.labirinto = new Labirinto();
		
	}

	@Test
	public void getIngressoTest() {
		assertSame(labirinto.getIngresso().getNome(), "Atrio");
	}
	
	@Test
	public void getUscitaTest() {
		assertSame(labirinto.getUscita().getNome(), "Biblioteca");
	}

}
