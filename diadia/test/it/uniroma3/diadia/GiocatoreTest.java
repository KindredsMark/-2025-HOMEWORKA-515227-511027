package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	
	private Giocatore giocatore;
	
	@BeforeEach
	void setUp(){
		giocatore = new Giocatore();
		giocatore.setCfu(20);
	}

	@Test
	void testCFUIniziali() {
		assertEquals(20, giocatore.getCfu(), "I cfu iniziali devono essere 20");
	}
	
	@Test
	void testCFUDuranteLaPartita() {
		giocatore.setCfu(5);
		assertEquals(5, giocatore.getCfu(), "Cfu aggiornati nel corso della partita");
	}
	
	@Test
	void testBorsaNotNull() {
		assertNotNull(giocatore.getBorsa(), "La borsa del giocatore non deve essere nulla");
	}

}
