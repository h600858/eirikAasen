package no.hvl.dat107;

public class AvdelingMain {

	public static void main(String[] args) {
		AvdelingDAO dao = new AvdelingDAO();
		AnsattDAO dao1 = new AnsattDAO();
		// dao.skrivUtAlleAnsatt(1);
		
		dao.opprettAvdeling(dao1.finnAnsattMedId(1).getBrukernavn(), "Test2");
	}

}
