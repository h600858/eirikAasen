package no.hvl.lph.dat108.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUtil {

	
	public static void loggUtBruker(HttpSession session) {
		session.invalidate();
	}

	public static void loggInnBruker(HttpServletRequest request, String passord, String fornavn, String etternavn, String mobil) {
		
	
		
		HttpSession session = request.getSession();
		session.setAttribute("fornavn", fornavn);
		session.setAttribute("etternavn", etternavn);
		session.setAttribute("mobil", mobil);
		session.setAttribute("passord", passord);
		
		
		
		
	}
	
	public static boolean erBrukerInnlogget(HttpSession session) {
		
		return  session != null && session.getAttribute("mobil") != null ; //&& en ekstra session attributt =! null;
	}
	
}
