package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai' seguito dalla direzione per spostarti", "aiuto' per conoscere le istruzioni", "fine' per smettere di giocare", "prendi' seguito dall'oggetto nella stanza per prenderlo", "posa' seguito dall'oggetto nella borsa per posarlo"};

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
		scannerDiLinee.close();
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		if(comandoDaEseguire.getNome() == null)
			return false;
		else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true; }
		else if (comandoDaEseguire.getNome().equals("vai")) {
			this.vai(comandoDaEseguire.getParametro());
			System.out.println("Ti restano " + partita.getGiocatore().getCfu() + " CFU");
		}
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi")) {
			if(this.prendi(comandoDaEseguire.getParametro()) == true)
				System.out.println("Attrezzo preso correttamente");
		}
		else if (comandoDaEseguire.getNome().equals("posa")) {
			if(this.posa(comandoDaEseguire.getParametro()) == true)
				System.out.println("Attrezzo posato correttamente");
		}
		else
			System.out.println("Comando sconosciuto");
		
		if(this.partita.getGiocatore().getCfu() == 0) {
			System.out.println("Mi spiace hai finito i CFU\nHai perso");
			return true;
		}
		
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print("Usa '"+elencoComandi[i]+"\n");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(--cfu);
		}
		if(direzione==null)
			System.out.println("Dove vuoi andare?\nDigita 'vai' seguito dalla direzione");
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}
	
	/**
	 * Comando "Prendi".
	 */
	private boolean prendi(String nomeAttrezzo) {
		if(nomeAttrezzo == null) {
			System.out.println("Che attrezzo vuoi prendere?\nDigita 'prendi' seguito dall'attrezzo");
			return false;
		}
		Attrezzo attrezzo = null;
		attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(attrezzo == null) {
			System.out.println("Attrezzo non presente nella stanza");
			return false;
		}
		else {
			this.partita.getGiocatore().prendi(attrezzo);
			return this.partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			
		}
	}
	/**
	 * Comando "Posa".
	 */
	private boolean posa(String nomeAttrezzo) {
		if(nomeAttrezzo == null) {
			System.out.println("Quale attrezzo vuoi posare?\nDigita 'posa' seguito dall'attrezzo");
			return false;
		}
		Attrezzo attrezzo = null;
		attrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(attrezzo == null) {
			System.out.println("Attrezzo non presente nella borsa");
			return false;
		}
		else {
			this.partita.getGiocatore().posa(nomeAttrezzo);
			return this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
		}
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}}