package it.uniroma3.diadia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	private Stanza stanza;
	private Stanza stanzaAdiacente;
	private Attrezzo attrezzo;
	
	@BeforeEach
	public void setUp(){
		// Verifica che la lista degli attrezzi venga inizializzata nel costruttore di Stanza
		stanza = new Stanza("sala");
		stanzaAdiacente = new Stanza("salaEST");
		attrezzo = new Attrezzo("spada", 5);
		
	}
	
	/*Test per addAttrezzo*/
	//test per aggiungere attrezzo quando la stanza non è piena
	@Test
	public void testAddAttrezzo() {
		boolean risultato = stanza.addAttrezzo(attrezzo);
		assertTrue("Attrezzo aggiunto con successo", risultato);
	}
	
	//test stanza piena
	@Test
	public void testAddAttrezzoStanzaPiena() {
		for(int i = 0; i < 10; i++) {
			stanza.addAttrezzo(new Attrezzo("spada" +i, 1));
		}
		assertFalse("Stanza piena, non è possibile aggiungere attrezzi", stanza.addAttrezzo(attrezzo));
	}
	
	//test attrezzo nome vuoto
	@Test
	public void testAddAttrezzoNomeVuoto() {
		Attrezzo attrezzoVuto = new Attrezzo("", 5);
		boolean risultato = stanza.addAttrezzo(attrezzo);
		assertTrue("L'attrezzo con nome vuoto dovrebbe essere aggiunto", risultato);
    }
	
	/*Test per hasAttrezzo*/
	@Test
	public void testHasAttrezzoEsistente() {
	    stanza.addAttrezzo(attrezzo);
	    assertTrue("La stanza dovrebbe contenere l'attrezzo 'spada'", stanza.hasAttrezzo("spada"));
	}

	
	@Test
	public void testHasAttrezzoNonEsistente() {
	    assertFalse("La stanza non dovrebbe contenere l'attrezzo 'scudo'", stanza.hasAttrezzo("scudo"));
	}

	@Test
	public void testHasAttrezzoStanzaVuota() {
	    assertFalse("La stanza vuota non dovrebbe contenere attrezzi", stanza.hasAttrezzo("spada"));
	}
	/*Test per getAttrezzo*/
	@Test
	public void testGetAttrezzoStanzaVuota() {
		assertNull(new Stanza("stanza").getAttrezzo("attrezzo"));
	}
	
	@Test
	public void testGetAttrezzoStanzaAttrezzoPresente() {
		Stanza stanza = new Stanza("stanza");
		stanza.addAttrezzo(new Attrezzo("attrezzo", 1));
		assertNotNull(stanza.getAttrezzo("attrezzo"));
	}
	
	@Test
	public void testGetAttrezzoStanzaAttrezzoNonPresente() {
		Stanza stanza = new Stanza("stanza");
		stanza.addAttrezzo(new Attrezzo("attrezzo", 1));
		assertNull(stanza.getAttrezzo("attrezzoNonPresente"));
	}
	/*Test per getStanzaAdiacente*/
	@Test
	public void testGetStanzaAdiacentStanzaEsistente() {
	    Stanza stanza1 = new Stanza("stanza1");
	    Stanza stanza2 = new Stanza("stanza2");
	    stanza1.impostaStanzaAdiacente("nord", stanza2);
	    assertEquals(stanza2, stanza1.getStanzaAdiacente("nord"));
	}
	@Test
	public void testGetStanzaAdiacenteNonEsistente() {
	    Stanza adiacente = stanza.getStanzaAdiacente("Ovest");
	    assertNull("La stanza adiacente a 'Ovest' dovrebbe essere null", adiacente);
	}

	@Test
	public void testGetStanzaAdiacenteVuota() {
	    Stanza adiacente = stanza.getStanzaAdiacente("Nord");
	    assertNull("La stanza non dovrebbe avere stanze adiacenti a 'Nord'", adiacente);
	}
	
	

}
