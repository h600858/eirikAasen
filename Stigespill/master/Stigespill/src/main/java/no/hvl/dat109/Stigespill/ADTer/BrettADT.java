package no.hvl.dat109.Stigespill.ADTer;

public interface BrettADT {

/**
 * Initialiserer brettet ved å legge inn rutene som inneholder enten
 * slanger eller stiger inn i posisjonen bestemt av dataen fra databasen
 * dersom en rute ikke er verken stige eller slange vil det bare være en null
 * verdi	
 * @return true dersom alt går etter planen, false ellers
 */
public boolean initialiser();	
	
}
