package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;

class PartitaTest {
	
	private Partita partita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	
	@BeforeEach
	void setUp() {
		partita = new Partita();
		labirinto = new Labirinto();
		giocatore = partita.getGiocatore();
	}

	@Test
	void testGetStanzaVincente() {
		partita.setStanzaCorrente(partita.getStanzaCorrente().getStanzaAdiacente("nord"));
		assertTrue(partita.vinta(), "La partita è vinta quando ci si trova nella stanza vincente");
	}
	
	@Test
	void testGetStanzaAdicente() {
		assertEquals("Atrio", partita.getStanzaCorrente().getNome(), "La stanza iniziale è l'atrio");
	}
	
	/*@Test
	void testGetStanzaCorrenteAllInizio() {
		assertEquals(labirinto.getStanzaIniziale(), partita.getStanzaCorrente());
	}
	*/
	@Test
	void testStanzaCorrenteRestituisceStanzaVincente() {
		partita.setStanzaCorrente(labirinto.getStanzaFinale());
		assertEquals("Biblioteca", partita.getStanzaCorrente().getNome());
	}
	
	@Test
	void testCFUIniziali() {
		assertEquals(20, giocatore.getCfu(), "All'inizio della partita i CFU devono essere 20");
	}
	
	@Test
	void testPartitaFinita() {
		giocatore.setCfu(0);	//la partita è finita quando si hanno 0 CFU
		assertTrue(partita.isFinita(), "La partita è finita quando i CFU sono a 0");
	}
}

