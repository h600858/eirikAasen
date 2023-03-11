package no.hvl.dat107;


import java.util.List;

import javax.persistence.*;

@Entity
@Table(schema = "oblig3")
public class Avdeling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer AvdelingID;
	private String AvdelingNavn;	
	private String SjefBrukernavn;
	
	@OneToMany(mappedBy = "avdeling",fetch = FetchType.EAGER)
	List <Ansatt> ansatt;

	
	public Avdeling() {
		
	}
	
	public Avdeling(String AvdelingNavn,String SjefBrukernavn) {
		this.AvdelingNavn = AvdelingNavn;
		this.SjefBrukernavn = SjefBrukernavn;
		
	}
	
	public Integer getAvdelingID() {
		return AvdelingID;
	}

	public List<Ansatt> getAnsatt() {
		return ansatt;
	}

	public void setAnsatt(List<Ansatt> ansatt) {
		this.ansatt = ansatt;
	}

	public void setAvdelingID(Integer avdelingID) {
		AvdelingID = avdelingID;
	}

	public String getAvdelingNavn() {
		return AvdelingNavn;
	}

	public void setAvdelingNavn(String avdelingNavn) {
		AvdelingNavn = avdelingNavn;
	}

	public String getSjefBrukernavn() {
		return SjefBrukernavn;
	}

	public void setSjefBrukernavn(String sjefBrukernavn) {
		SjefBrukernavn = sjefBrukernavn;
	}
	
	public void skrivUt() {
		System.out.println("AvdelingID: " + AvdelingID + "\n"+ "Avdeling navn: " + AvdelingNavn + "\n" + "Sjef brukernavn: " + SjefBrukernavn + "\n");
		
	}
}
