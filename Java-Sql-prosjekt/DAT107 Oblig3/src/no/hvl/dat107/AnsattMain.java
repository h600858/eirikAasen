package no.hvl.dat107;

import java.time.LocalDate;

public class AnsattMain {

	public static void main(String[] args) {
	
		
		AnsattDAO dao = new AnsattDAO();
		dao.finnAnsattMedId(1).SkrivUt();
		
		
		
//		System.out.println("Før: ");
		
		
		
//		dao.oppdaterAvdeling("Euge",adao.finnAvdelingMedID(2));
//		dao.leggTilAnsatt("Saff", "Saffa", "Martinez",LocalDate.of(2021, 3, 3) , "Programmerer", 500000);
//		dao.leggTilAnsatt("Just", "Justin", "Dupnot",LocalDate.of(2017, 9, 10) , "Programmerer", 500000);
//		dao.leggTilAnsatt("Donn", "Donnell", "Pittman",LocalDate.of(2016, 11, 11) , "Programmerer", 500000);
//		
		
//		System.out.println("Etter: ");
//		dao.getAlleAnsatt();
	}
}
