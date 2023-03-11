package no.hvl.dat107;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(schema = "Oblig3")
public class Ansatt {
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer AnsattID;
	@Id
	private String Brukernavn;
	private String Fornavn;
	private String Etternavn;
	private LocalDate AnsettelseDato;
	private String Stilling;
	private Integer MaanedsLonn;
	
	@ManyToOne
	@JoinColumn(name = "AvdelingsID", referencedColumnName = "AvdelingID")
	private Avdeling avdeling;

	
	public Ansatt() {
		
	}
	
	public Ansatt(String Brukernavn,String Fornavn,String Etternavn,LocalDate AnsettelseDato,String Stilling, Integer MaanedsLonn, Avdeling avdeling) {
		this.Brukernavn = Brukernavn;
		this.Fornavn = Fornavn;
		this.Etternavn = Etternavn;
		this.AnsettelseDato = AnsettelseDato;
		this.Stilling = Stilling;
		this.MaanedsLonn = MaanedsLonn;
		this.avdeling = avdeling;
		
	}
	
	public Integer getAnsattID() {
		return AnsattID;
	}
	public void setAnsattID(Integer ansattID) {
		AnsattID = ansattID;
	}
	public String getBrukernavn() {
		return Brukernavn;
	}
	public void setBrukernavn(String brukernavn) {
		Brukernavn = brukernavn;
	}
	public String getFornavn() {
		return Fornavn;
	}
	public void setFornavn(String fornavn) {
		Fornavn = fornavn;
	}
	public String getEtternavn() {
		return Etternavn;
	}
	public void setEtternavn(String etternavn) {
		Etternavn = etternavn;
	}
	public LocalDate getAnsettelseDato() {
		return AnsettelseDato;
	}
	public void setAnsettelseDato(LocalDate ansettelseDato) {
		AnsettelseDato = ansettelseDato;
	}
	public String getStilling() {
		return Stilling;
	}
	public void setStilling(String stilling) {
		Stilling = stilling;
	}
	public Integer getMaanedsLonn() {
		return MaanedsLonn;
	}
	public void setMaanedsLonn(Integer maanedsLonn) {
		MaanedsLonn = maanedsLonn;
	}
	
	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}
	
	public void SkrivUt() {
		
		System.out.println("AnsattID: " + AnsattID + "\n" + "Brukernavn: " + Brukernavn + "\n" + "Fornavn: " + Fornavn + "\n" + "Etternavn: " + Etternavn + "\n"
				+"Ansettelse Dato: " + AnsettelseDato + "\n" + "Stilling: " + Stilling + "\n" + "MaanedsLonn: " + MaanedsLonn + "\n");
	}
}
