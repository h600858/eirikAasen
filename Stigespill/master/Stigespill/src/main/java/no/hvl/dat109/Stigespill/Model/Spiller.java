package no.hvl.dat109.Stigespill.Model;

import no.hvl.dat109.Stigespill.ADTer.SpillerADT;

public class Spiller  implements SpillerADT {

	private int posisjon;
	private String navn;
	private boolean fengsel;
	
	public Spiller(String navn) {
		this.navn = navn;
		posisjon = 0;
		fengsel = false;
	}
	
	@Override
	public void flytt(int antallPosisjoner) {
		setPosisjon(this.posisjon+antallPosisjoner);
	}
	
	public void flyttTilbake(int antallPosisjoner) {
		setPosisjon(this.posisjon-antallPosisjoner);
	}
	
	
	public int getPosisjon() {
		return posisjon;
	}

	public void setPosisjon(int posisjon) {
		this.posisjon = posisjon;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	@Override
	public String toString() {
		return this.getNavn();
	}


	public boolean getFengsel() {
		return fengsel;
	}


	public void setFengsel(boolean fengsel) {
		this.fengsel = fengsel;
	}
}
