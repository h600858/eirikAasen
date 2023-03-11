package no.hvl.dat108.webshop.model;

public class Vare {

	private String navn;
	private int antall;
	public String getNavn() {
		return navn;
	}
	public Vare() {
		
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public int getAntall() {
		return antall;
	}
	public void setAntall(int nr) {
		this.antall = nr;
	}
	public Vare(String navn, int antall) {
		super();
		this.navn = navn;
		this.antall = antall;
	}
	@Override
	public String toString() {
		return navn + " " + antall;
	}
	
	public void endreAntall(int n) {
		antall += n;
	}
	
	public boolean erLik(String vareNavn) {
		boolean tf = false;
		if(navn.equals(vareNavn)) {
			tf = true;
		}
		return tf;
	}
}
