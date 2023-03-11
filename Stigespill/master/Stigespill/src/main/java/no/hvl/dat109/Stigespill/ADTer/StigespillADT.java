package no.hvl.dat109.Stigespill.ADTer;

public interface StigespillADT {
	
	/**
	 * skal starte eit nytt spill med antallspillere gitt av parameteren antallSpiller
	 * vi skal initialisere eit nytt brett, en ny terning og skal gjøre klart for x antallspillere
	 * gir turen til den første spilleren
	 * @param antallSpiller
	 */
	
	public void startSpill(int antallSpiller);
	
	/**
	 * starter en tur for den spilleren som har turen.
	 * lar spilleren trille en terning, flytter deretter brikken
	 * sjekker dermed om ruten den lander på er en slange eller stige
	 * og flytter brikken deretter. Sjekker så om det ble trillet en sekser
	 * og oppfører seg deretter
	 */
	
	public void taTur();
	/**
	 * sjekker om spilleren har trillet slik at han kommer for langt
	 * @param flytt, det som ble trillet
	 * @return false dersom det ikke ble trillet for langt, true ellers
	 */
	public boolean forLang(int flytt);
	
	/**
	 * gir turen videre til den sin tur det er
	 */
	
	public void giTurenVidere();
	/**
	 * sjekker om ruten til spilleren er en slange stige eller om spilleren har vunnet
	 * dersom spilleren har vunnet avsluttes spillet
	 * dersom spilleren har landet på en slange flytter han tilbake
	 * dersom spilleren har landet på en stige flytter han fram
	 * @param posisjonen til spilleren
	 */
	public void sjekkOmSlangeEllerStigeEllerVunnet(int posisjon);
	/**
	 * Sjekker om det ble trillet en sekser
	 * dersom det ble trillet en sekser sjekker vi om det er 3. sekseren denne runden
	 * dersom det er det flyttes spilleren til posisjon 0 og gir turen videre
	 * viss ikkje triller spilleren igjen
	 * @param terningkast
	 */
	public boolean sjekkOmSekser(int terningkast);
	
	/**
	 * avslutter spillet
	 */
	
	public void avsluttSpill();
	/**
	 * Sjekker om spilleren som har turen sitter i "fengsel" altså har trillet 3 seksere
	 * lar deretter spilleren trille, dersom spilleren ikke får seks gis turen videre
	 * dersom spilleren triller 6 vil spilleren flytte seks ruter og slippes ut av fengsel, ikke få trille igjen
	 * og gi turen videre til neste spiller
	 * @return true dersom spilleren er i fengsel, false ellers
	 */
	public boolean sjekkFengsel();
	
	
	
	
	
	
}
