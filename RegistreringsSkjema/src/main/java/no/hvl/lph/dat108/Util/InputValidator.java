package no.hvl.lph.dat108.Util;

public class InputValidator {

	 public static final String ANY_LETTER = "[a-zA-ZæøåÆØÅ]";
	    public static final String ANY_LETTER_OR_DIGIT = "[a-zA-ZæøåÆØÅ0-9]";
	    public static final String THREE_OR_MORE_TIMES = "{3,}";
	    public static final String fornavn = "^\s*\\p{Lu}[a-zA-ZæøåÆØÅ.-]{2,20}";
	    public static final String etternavn = "^\s*\\p{Lu}[a-zA-ZæøåÆØÅ.-]{2,20}";
	    public static final String mobil = "[0-9]{8}";
	    public static final String passord = "[a-zA-ZæøåÆØÅ0-9]{5,}";
	    
	    
	public static boolean inputValidator(String fornavn, String etternavn, String mobil, String passord, String repetertPassord) {
		boolean fornavnV = true;
		boolean etternavnV = true;
		boolean mobilV = true;
		boolean passordV = true;
		boolean repetertPassordV = true;
		
		if(!fornavnValidator(fornavn)) {
			System.out.println("fornavn er feil");
			fornavnV = false;
		}
		if(!etternavnValidator(etternavn)) {
			System.out.println("etternavn er feil");
			etternavnV = false;
		}
		if(!mobilValidator(mobil)) {
			System.out.println("mobil er feil");
			mobilV = false;
		}
		if(!passordValidator(passord)) {
			System.out.println("passord er feil");
			passordV = false;
		}
		if(!passordRepetertValidator(passord, repetertPassord)) {
			System.out.println("passord er feil");
			repetertPassordV = false;
		}
		return fornavnV&etternavnV&mobilV&passordV&repetertPassordV;
	}
	    
	public static boolean fornavnValidator(String navn) {
		return navn != null && navn.matches(fornavn);
	}
	public static boolean etternavnValidator(String navn){
		return navn != null && navn.matches(etternavn);
	}
	public static boolean mobilValidator(String mob) {
		return mob != null && mob.matches(mobil);
	}
	public static boolean passordValidator(String pass) {
		return pass != null && pass.matches(passord);
	}
	public static boolean passordRepetertValidator(String pass, String repetertPassord) {
		return pass.equals(repetertPassord);
	}
}
