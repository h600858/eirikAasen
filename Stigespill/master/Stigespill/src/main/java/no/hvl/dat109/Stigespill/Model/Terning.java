package no.hvl.dat109.Stigespill.Model;

import no.hvl.dat109.Stigespill.ADTer.TerningADT;

public class Terning implements TerningADT {

	@Override
	public int trillTerning() {
		int max = 6;
		int min = 1;
		return (int)(Math.random()*(max-min+1)+min); 
		
		
	}

}
