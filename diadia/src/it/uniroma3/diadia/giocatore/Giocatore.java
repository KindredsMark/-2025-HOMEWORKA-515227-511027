package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	
	private int cfu;
	private Borsa borsa;
	
	public Giocatore(){
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}

	public int getCfu() {
		return this.cfu;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	public Borsa getBorsa() {
		return borsa;
	}
	/**
	 * Imposta il contenuto della borsa
	 */
	public void prendi(Attrezzo attrezzo) {
		this.getBorsa().addAttrezzo(attrezzo);
	}
	
	/**
	 * Rimuove un attrezzo dalla borsa
	 */
	public void posa(String nomeAttrezzo) {
		this.getBorsa().removeAttrezzo(nomeAttrezzo);
	}
	
	/**
	* Restituisce una rappresentazione stringa di questo giocatore,
	* stampadone i cfu e gli eventuali attrezzi posseduti
	* @return la rappresentazione stringa
	*/
	public String toString(){
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.getCfu());
		risultato.append("CFU\n");
		
		risultato.append(this.borsa.toString());
		
		return risultato.toString();
	}
}
