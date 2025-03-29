package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;


public class LabirintoTest {
	Labirinto l;
	Stanza biblioteca;
	Stanza DS1;

	@BeforeEach
	public void setUp() {
		l = new Labirinto();
		l.creaStanze();
		biblioteca = new Stanza("Biblioteca");
		DS1 = new Stanza("DS1");
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getStanzaFinale().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaCorrente(DS1);
		assertEquals(DS1, l.getStanzaFinale());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", l.getStanzaFinale().getNome());
	}

}

