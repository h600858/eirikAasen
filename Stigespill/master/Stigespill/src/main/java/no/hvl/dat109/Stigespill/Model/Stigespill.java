package no.hvl.dat109.Stigespill.Model;

import java.util.LinkedList;
import java.util.List;
//import java.util.Scanner;

import no.hvl.dat109.Stigespill.ADTer.StigespillADT;

public class Stigespill implements StigespillADT {

	private Brett brett;
	private List<Spiller> spillere;
	private Terning terning;
	private Spiller harTur;
	private int antallseksere = 0;
	private boolean startet;
	private String hendelse;
	private LinearNode<Spiller> test;
	@SuppressWarnings("unchecked")
	private LinearNode<Spiller>[] test1 = new LinearNode[8];
	public Stigespill() {
		brett = new Brett();
		spillere = new LinkedList<Spiller>();
		terning = new Terning();
	}

	@Override
	public void startSpill(int antallSpiller) {
		brett.initialiser();
		test = new LinearNode<Spiller>(new Spiller("spiller1"));
		test1[0] = test;
		spillere.add(0, test.getElement());
		for (int i = 1; i < antallSpiller; i++) {
			Spiller temp = new Spiller("spiller" + (i + 1));
			spillere.add(temp);
			test1[i] = new LinearNode<Spiller>(temp);
		}

		for (int o = antallSpiller - 1; o >= 1; o--) {
			test1[o - 1].setNeste(test1[o]);
		}
		test1[antallSpiller - 1].setNeste(test1[0]);
		System.out.println(test1[2].getNeste().getElement());
		System.out.println(test.getNeste().getElement());
		harTur = test.getElement();
		startet = true;
	}
	@Override
	public void taTur() {
		hendelse = "";
		// input = scanner.next();
		// if (input.equals("trill")) {
		if (!startet) {
			return;
		}
		if (sjekkFengsel()) {
			giTurenVidere();
			return;
		}
		int flytt = terning.trillTerning();
		hendelse += (harTur.getNavn() + " trillet " + flytt + "\n");
		if (!forLang(flytt)) {
			harTur.flytt(flytt);
			hendelse += (harTur.getNavn() + " flyttet " + flytt + " og er nå på rute " + harTur.getPosisjon() + "\n");
			sjekkOmSlangeEllerStigeEllerVunnet(harTur.getPosisjon());
			if (!startet) {
				return;
			}
			if (sjekkOmSekser(flytt)) {
				return;
			}
			giTurenVidere();
		} else {
			giTurenVidere();
		}

	}
	//For testing
	public void taTur(int x) {
		hendelse = "";
		// input = scanner.next();
		// if (input.equals("trill")) {
		if (!startet) {
			return;
		}
		if (sjekkFengsel()) {
			giTurenVidere();
			return;
		}
		int flytt = x;
		hendelse += (harTur.getNavn() + " trillet " + flytt + "\n");
		if (!forLang(flytt)) {
			harTur.flytt(flytt);
			hendelse += (harTur.getNavn() + " flyttet " + flytt + " og er nå på rute " + harTur.getPosisjon() + "\n");
			sjekkOmSlangeEllerStigeEllerVunnet(harTur.getPosisjon());
			if (sjekkOmSekser(flytt)) {
				return;
			}
			giTurenVidere();
		} else {
			giTurenVidere();
		}

	}
	@Override
	public boolean sjekkFengsel() {
		if (this.harTur.getFengsel()) {
			int flyttIgjen = terning.trillTerning();
			if (flyttIgjen == 6) {
				this.harTur.flytt(flyttIgjen);
				this.harTur.setFengsel(false);
				return true;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	// for testing
	public boolean sjekkFengsel(int x) {
		if (this.harTur.getFengsel()) {
			int flyttIgjen = 6;
			if (flyttIgjen == 6) {
				this.harTur.flytt(flyttIgjen);
				this.harTur.setFengsel(false);
				return true;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	@Override
	public boolean forLang(int flytt) {
		if (harTur.getPosisjon() + flytt > 100) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public void giTurenVidere() {
		hendelse += " gir turen videre fra " + test.getElement().getNavn();
		test = test.getNeste();
		harTur = test.getElement();
		hendelse += " til " + test.getElement().getNavn();
	}
	@Override
	public void sjekkOmSlangeEllerStigeEllerVunnet(int posisjon) {
		if (posisjon == 100) {
			hendelse += ("Gratulerer " + harTur.getNavn() + " du har vunnet \n");
			avsluttSpill();
			return;
		}
		if (brett.getRuter()[harTur.getPosisjon()] != null) {
			Rute rute = brett.getRuter()[harTur.getPosisjon()];
			if (rute.getNavn().equals("Slange")) {
				hendelse += "Det var en slange og du må gå tilbake " + rute.getLengde() + "\n";
				harTur.flyttTilbake(rute.getLengde());
				hendelse += harTur.getNavn() + " landet på rute " + harTur.getPosisjon() + "\n";
				return;
			} else {
				hendelse += "Det var en stige og du går fram " + rute.getLengde() + "\n";
				harTur.flytt(rute.getLengde());
				if (harTur.getPosisjon() == 100) {
					hendelse += "Gratuelerer " + harTur.getNavn() + " du har vunnet";
					this.avsluttSpill();
					return;
				}
				hendelse += harTur.getNavn() + " landet på rute " + harTur.getPosisjon() + "\n";
				return;
			}
		} else {
			hendelse += "Det var en vanlig rute \n";
			return;
		}
	}
	@Override
	public boolean sjekkOmSekser(int terningkast) {
		if (terningkast == 6) {
			hendelse += "OII EN SEKSER !!!!! \n";
			this.antallseksere++;
			if (antallseksere == 3) {
				hendelse += "Oii du har trillet 3 seksere og flyttes tilbake til start \n";
				harTur.setPosisjon(0);
				hendelse += harTur.getNavn() + " er nå på rute " + harTur.getPosisjon() + "\n";
				this.harTur.setFengsel(true);
				this.giTurenVidere();
				antallseksere = 0;
				return true;
			} else {
				return true;
			}
		} else {
			antallseksere = 0;
			return false;
		}
	}
	@Override
	public void avsluttSpill() {
		startet = false;
	}

	public Brett getBrett() {
		return brett;
	}

	public void setBrett(Brett brett) {
		this.brett = brett;
	}

	public List<Spiller> getSpillere() {
		return spillere;
	}

	public void setSpillere(List<Spiller> spillere) {
		this.spillere = spillere;
	}

	public Terning getTerning() {
		return terning;
	}

	public void setTerning(Terning terning) {
		this.terning = terning;
	}

	public String getHendelse() {
		return this.hendelse;
	}

	public Spiller getHarTur() {
		return this.harTur;
	}

	public int getAntallSeksere() {
		return this.antallseksere;
	}

	public boolean getStartet() {
		return this.startet;
	}

}
