package no.hvl.dat109.Stigespill.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import no.hvl.dat109.Stigespill.ADTer.RuteADT;


@Entity
@Table(schema= "ruter")
public class Rute implements RuteADT{

	@Id
	private int posisjon;
	private int lengde;
	private String navn;
	
	
	public Rute(){}
	
	public Rute(int posisjon , int lengde, String navn) {
		this.navn = navn;
		this.posisjon = posisjon;
		this.lengde = lengde;
	}


	public String getNavn() {
		return navn;
	}


	public void setNavn(String navn) {
		this.navn = navn;
	}


	public int getPosisjon() {
		return posisjon;
	}


	public void setPosisjon(int posisjon) {
		this.posisjon = posisjon;
	}


	public int getLengde() {
		return lengde;
	}


	public void setLengde(int verdi) {
		this.lengde = verdi;
	}	
	
	@Override
	public String toString() {
		return " " + posisjon + " " + lengde + " " + navn;
	}
}
