package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	private Stanza stanza;
	private Attrezzo osso;
	private Attrezzo lanterna;
	
	@Before
	public void setUp() throws Exception {
		this.stanza = new Stanza("Stanza");
		this.osso = new Attrezzo("Osso", 3);
		this.lanterna = new Attrezzo("Lanterna", 2);
	}

	/**
	 * Test per verificare il funzionamento di hasAttrezzo
	 */
	@Test
	public void testHasAttrezzo_inesistente_stanzaVuota() {
		assertFalse(this.stanza.hasAttrezzo("introvabile"));		
	}
	@Test
	public void testHasAttrezzo_inesistente() {
		this.stanza.addAttrezzo(lanterna);
		assertFalse(this.stanza.hasAttrezzo("introvabile"));		
	}
	@Test
	public void testHasAttrezzo_esistente() {
		this.stanza.addAttrezzo(osso);
		assertSame(osso, this.stanza.getAttrezzo("Osso"));
	}
	
	/**
	 * Test per verificare il funzionamento di addAttrezzo
	 */
	@Test
	public void testAddAttrezzo() {
		assertTrue(this.stanza.addAttrezzo(osso));
	}
	@Test
	public void testAddAttrezzo_stanzaPiena() {
		this.stanza.setNumeroAttrezzi(10);
		assertFalse(this.stanza.addAttrezzo(osso));
	}
	
	
	/**
	 * Test per verificare il funzionamento di removeAttrezzo
	 */
	@Test
	public void testRemoveAttrezzo_inesistente() {
		assertFalse(this.stanza.removeAttrezzo(osso));
	}
	@Test
	public void testRemoveAttrezzo_esistente() {
		this.stanza.addAttrezzo(this.osso);
		assertTrue(this.stanza.removeAttrezzo(osso));
	}
	@Test
	public void testRemoveAttrezzo_primoDiDue() {
		this.stanza.addAttrezzo(osso);
		this.stanza.addAttrezzo(lanterna);
		assertTrue(this.stanza.removeAttrezzo(osso));
		assertTrue(this.stanza.hasAttrezzo(lanterna.getNome()));
	}
	
	/**
	 * Test per verificare il funzionamento di toString()
	 */
	@Test
	public void testToString_StanzaVuota() {
		assertEquals(this.stanza.toString(), "Stanza\nUscite: \nAttrezzi nella stanza: ");
	}
	@Test
	public void testToString_StanzaAttrezzo() {
		this.stanza.addAttrezzo(lanterna);
		assertEquals(this.stanza.toString(), "Stanza\nUscite: \nAttrezzi nella stanza: Lanterna (2kg) ");
	}
}
