import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

import org.junit.Before;

public class BorsaTest {
	private Borsa borsa;
	private Attrezzo osso;
	private Attrezzo lampada;
	
	@Before
	public void setUp() {
		this.borsa = new Borsa();
		this.osso = new Attrezzo("Osso", 3);
		this.lampada = new Attrezzo("Lanterna", 2);
	}

	/**
	 * Test per verificare il funzionamento di addAttrezzo
	 */
	@Test
	public void testAddAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(osso));
	}
	
	/**