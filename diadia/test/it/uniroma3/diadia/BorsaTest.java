package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	
	private Borsa borsa;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	
	@BeforeEach
	void setUp(){
		this.borsa = new Borsa();
		this.attrezzo1 = new Attrezzo("macete", 4);
		this.attrezzo2 = new Attrezzo("mattoni", 10);
		this.attrezzo3 = new Attrezzo("ascia", 2);
	}

	@Test
	void testBorsaVuota() {
		assertEquals(0, borsa.getPeso());
	}
	
	@Test
	void testBorsaPiena() {
		borsa.addAttrezzo(attrezzo2);
		assertFalse(borsa.addAttrezzo(attrezzo1), "La borsa è piena, non puoi aggiungere altro");
	}
	
	@Test
	void testAggiungiAttrezzo() {
		borsa.addAttrezzo(attrezzo1);
		assertTrue(borsa.addAttrezzo(attrezzo3), "Attrezzo aggiunto con successo");
	}

}
