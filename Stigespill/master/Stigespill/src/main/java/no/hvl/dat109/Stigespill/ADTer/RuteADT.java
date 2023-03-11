package no.hvl.dat109.Stigespill.ADTer;

public interface RuteADT {

	/**
	 * Setter navnet på en rute, skal være enten slange
	 * eller stige
	 * @param det nye navnet
	 */
	
	public void setNavn(String navn);
	/**	
	 * Returnerer navnet til en Rute, skal være enten Slange eller Stige 
	 * @return navnet på ruten
	 */
	public String getNavn();

	/**
	 * Setter verdien til en rute. Verdien til en rute er så mange posisjoner en spiller
	 * skal flytte fram eller tilbake avgenig av om ruten er en slange eller stige
	 * @param den nye verdien
	 */
	
	public void setLengde(int verdi);
	
	/**
	 * Returnerer verdien til en rute. Verdien til en rute er så mange posisjoner en spiller
	 * skal flytte fram eller tilbake avgenig av om ruten er en slange eller stige
	 * @return verdien til en rute
	 */
	
	public int getLengde();
	
	/**
	 * Setter posisjonen til en rute, posisjonen til en rute er der den aktiveres, det vil si hodet på en slange
	 * og starten til en stige
	 * @param Den nye posisjonen
	 */
	
	public void setPosisjon(int posisjon);
	/**
	 * Returnerer posisjonen til en rute, posisjonen til en rute er der den aktiveres, det vil si hodet på en slange
	 * og starten til en stige
	 * @return posisjonen til en rute
	 */
	public int getPosisjon();
	
}
