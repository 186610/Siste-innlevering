package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggstabell;
	private int nesteLedige;

	public Blogg() {
		this(20);
	}

	public Blogg(int lengde) {
		innleggstabell = new Innlegg[lengde];
		nesteLedige = 0;
	}

	public int getAntall() {
		return nesteLedige;
	}
	
	public Innlegg[] getSamling() {
		return innleggstabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		boolean lik = false;
		int pos = 0;
		while (pos < nesteLedige && !lik) {
			if (innleggstabell[pos].erLik(innlegg)) {
				lik = true;
			} pos++;
		}
		if (lik) {
			return pos;
		} return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for (Innlegg i : innleggstabell) {
			if (i != null && i.erLik(innlegg)) {
				return true;
			}
		}
		
		return false;
	}

	public boolean ledigPlass() {
		if (nesteLedige < innleggstabell.length) {
			return true;
		} 
		return false;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (finnes(innlegg) || nesteLedige == innleggstabell.length) {
			return false;
		} 
		
		innleggstabell[nesteLedige] = innlegg;
		nesteLedige++;
		return true;
	}
	
	public String toString() {
		String s = getAntall() + "\n";
		
		for (int i = 0; i < nesteLedige; i++) {
			s += innleggstabell[i].toString();
		}
		
		return s;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] utvidetInnleggstabell = new Innlegg[innleggstabell.length * 2];
		
		for (int i = 0; i < innleggstabell.length; i++) {
			utvidetInnleggstabell[i] = innleggstabell[i];
		}
		innleggstabell = utvidetInnleggstabell;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if (!finnes(innlegg)) {
			return false;
		}  
			
		if (nesteLedige >= innleggstabell.length) {
			utvid();
		}
		
		return leggTil(innlegg);
	}
	
	public boolean slett(Innlegg innlegg) {
		
		for (int i = 0; i < nesteLedige; i++) {
			if (innleggstabell[i].erLik(innlegg)) {
				nesteLedige--;
				innleggstabell[i] = innleggstabell[nesteLedige];
				innleggstabell[nesteLedige] = null;
				return true;
			}
		}
		
		return false;
		
	}
}