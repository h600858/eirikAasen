package no.hvl.dat107;

import java.util.Map;

import javax.persistence.*;

public class AvdelingDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit", 
			Map.of("javax.persistence.jdbc.password", "ferskeniste321"));
	
	
	public Avdeling finnAvdelingMedID(int id) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Avdeling funnet = null;
		
		try {
			tx.begin();
			funnet = em.find(Avdeling.class, id);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return funnet;
	}
	
	
	public void skrivUtAlleAnsatt(int id) {
		
		EntityManager em = emf.createEntityManager();
		Avdeling funnet = em.find(Avdeling.class, id);
		
		try {
		System.out.println("Ansatte i " + funnet.getAvdelingNavn() + ": " + "\n");
		Ansatt sjef = null;
		
		for(Ansatt a : funnet.getAnsatt()) {
			
			if(!a.getStilling().equals("Sjef")) {
				a.SkrivUt();
			} else {
				sjef = a;
			}
		}
		System.out.println("Sjefen i "+ funnet.getAvdelingNavn() + ": "  + "\n");
		sjef.SkrivUt();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public void opprettAvdeling(String brukernavn,String AvdelingNavn) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		AnsattDAO dao = new AnsattDAO();
		
		try {
			
			Ansatt funnet = em.find(Ansatt.class, brukernavn);
			
			if(!funnet.getAvdeling().getSjefBrukernavn().equals(brukernavn)) {
				tx.begin();
				Avdeling nyAvdeling = new Avdeling(AvdelingNavn,funnet.getBrukernavn());
				funnet.setAvdeling(nyAvdeling);
				funnet.setStilling("Sjef");
				em.persist(nyAvdeling);
				em.merge(funnet);
				em.flush();
				tx.commit();
			} else {
				System.out.println("Funker ikke, velg et annet brukernavn");
			}	
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	
	}
	
}
