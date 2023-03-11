package no.hvl.dat108.webshop.model;

import java.util.ArrayList;
import java.util.List;

public class Handlevogn {

	private List<Vare> liste;
	Vare vare = new Vare();
	public Handlevogn() {
		 liste = new ArrayList<Vare>();
	}
	
	public void leggTil(String vareNavn) {
		int index = inneholder(vareNavn);
		System.out.println(index);
		if (index >=0){
			liste.get(index).endreAntall(1);
			
    	} else {
    		Vare vare1 = new Vare(vareNavn, 1);
    		liste.add(vare1);
    		
    	}
		
    }
	public void fjern(String vareNavn) {
		for(int i =0; i< liste.size(); i++) {
			if(liste.get(i).erLik(vareNavn)) {
				liste.get(i).endreAntall(-1);
				liste.remove(i);
			}
		}
		
	}
	public List<Vare> getItems(){
		return liste;
	}
	public int inneholder(String vareNavn) {
		
		boolean funnet = false;
		int i = 0;
		while(i <liste.size() && !funnet) {
			if(liste.get(i).erLik(vareNavn)) {
				funnet = true;
				return i;
			}else {
				i++;
			}
		}
		return -1;
	}
	
}
