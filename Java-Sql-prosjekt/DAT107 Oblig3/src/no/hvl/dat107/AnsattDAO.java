package no.hvl.dat107;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

public class AnsattDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit",
			Map.of("javax.persistence.jdbc.password", "ferskeniste321"));

	public Ansatt finnAnsattMedId(int id) {

		EntityManager em = emf.createEntityManager();
		Ansatt funnet = null;

		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT t FROM Ansatt t WHERE t.AnsattID = " + id, Ansatt.class);

			funnet = query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return funnet;
	}

	public Ansatt finnAnsattMedBrukernavn(String brukernavn) {

		EntityManager em = emf.createEntityManager();
		Ansatt funnet = null;

		try {
			funnet = em.find(Ansatt.class, brukernavn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return funnet;
	}

	public void getAlleAnsatt() {
		EntityManager em = emf.createEntityManager();
		List<Ansatt> AlleAnsatt = null;

		try {
			AlleAnsatt = em.createQuery("SELECT t FROM Ansatt t", Ansatt.class).getResultList();

			for (Ansatt a : AlleAnsatt) {
				a.SkrivUt();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	public void oppdaterStilling(String brukernavn, String stilling) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Ansatt managedAnsatt = em.find(Ansatt.class, brukernavn);
			managedAnsatt.setStilling(stilling);

			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}

	}

	public void oppdaterLonn(String brukernavn, Integer lonn) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Ansatt managedAnsatt = em.find(Ansatt.class, brukernavn);
			managedAnsatt.setMaanedsLonn(lonn);

			tx.commit();

		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

	public void leggTilAnsatt(String Brukernavn, String Fornavn, String Etternavn, LocalDate AnsettelseDato,
			String Stilling, Integer MaanedsLonn, Avdeling avdeling) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Ansatt nyAnsatt = new Ansatt(Brukernavn, Fornavn, Etternavn, AnsettelseDato, Stilling, MaanedsLonn,
					avdeling);

			em.persist(nyAnsatt);

			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}

	}

	public void fjernAnsatt(String brukernavn) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Ansatt managedAnsatt = em.find(Ansatt.class, brukernavn);
			em.remove(managedAnsatt);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void oppdaterAvdeling(String brukernavn, Avdeling avdeling) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Ansatt funnet = em.find(Ansatt.class, brukernavn);

			if (!funnet.getAvdeling().getSjefBrukernavn().equals(brukernavn)) {
				funnet.setAvdeling(avdeling);
				em.merge(funnet);
				em.flush();
			}

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
}
