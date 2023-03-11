package no.hvl.dat109.Stigespill.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import no.hvl.dat109.Stigespill.ADTer.BrettADT;
import no.hvl.dat109.Stigespill.ServiceOgRepoer.BrettService;


public class Brett implements BrettADT {
	
	@Autowired BrettService service;
	private Rute[] ruter;
	
	public Brett() {
		ruter = new Rute[100];
	}

	public Rute[] getRuter() {
		return ruter;
	}

	public void setRuter(Rute[] ruter) {
		this.ruter = ruter;
	}

	@Override
	public boolean initialiser() {
		List<Rute> SlangeEllerStige = service.getRuter();
		SlangeEllerStige.forEach(r -> ruter[r.getPosisjon()]=r);
		return true;
	}
	//For testing
	public void setService(BrettService service) {
		this.service = service;
	}

}
