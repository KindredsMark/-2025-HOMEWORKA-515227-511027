package diadia;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.Partita;

import org.junit.Before;

public class PartitaTest {
	private Partita partita;
	
	@Before
	public void setUp() {
		partita = new Partita();
	}
	
	/**
	 * Test per verificare il funzionamento di vinta
	 */
	@Test
	public void testVinta_vero() {
		partita.setStanzaCorrente(partita.getLabirinto().getUscita());
		assertTrue(partita.vinta());
	}
	@Test
	public void testVinta_falso() {
		assertFalse(partita.vinta());
	}

	/**
	 * Test per verificare il funzionamento di isFinita
	 */
	@Test
	public void testIsFinita_vinta() {
		partita.setStanzaCorrente(partita.getLabirinto().getUscita());
		assertTrue(partita.isFinita());
	}
	@Test
	public void testIsFinita_zeroCFU() {
		partita.getGiocatore().setCfu(0);
		assertTrue(partita.isFinita());
	}
}
