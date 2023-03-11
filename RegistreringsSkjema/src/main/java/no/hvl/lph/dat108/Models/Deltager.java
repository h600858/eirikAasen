package no.hvl.lph.dat108.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "deltagere")
public class Deltager {


	
	

	@Override
	public String toString() {
		return "Deltager [fornavn=" + fornavn + ", etternavn=" + etternavn + ", mobil=" + mobil + ", passord=" + passord
				+ ", kjonn=" + kjonn + "]";
	}

	public String fornavn;
	public String etternavn;
	@Id
	public int mobil;
	public String passord;
	public char kjonn;
	public String hash;
	public String salt;
	
	public Deltager() {
		
	}
	
	public Deltager(String fornavn, String etternavn, String mobil,String hash, String salt, String passord, char kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = Integer.parseInt(mobil);
		this.passord = passord;
		this.kjonn = kjonn;
		this.hash = hash;
		this.salt = salt;
	}
	public String getFornavn() {
		return fornavn;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	public String getEtternavn() {
		return etternavn;
	}
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	public int getMobil() {
		return mobil;
	}
	public void setMobil(String mobil) {
		this.mobil = Integer.parseInt(mobil);
	}
	public String getPassord() {
		return passord;
	}
	public void setPassord(String passord) {
		this.passord = passord;
	}

	public char getKjonn() {
		return kjonn;
	}

	public void setKjonn(char kjonn) {
		this.kjonn = kjonn;
	}

	public void setMobil(int mobil) {
		this.mobil = mobil;
	}
	
	
	
}
