package no.hvl.dat108.webshop.util;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;

import no.hvl.dat108.webshop.model.Cart;
public class LoginUtil {
	
	
	private static String rettpassord = "1234";
	
	private final static int MAX_INTERACTIVE_INTERVAL = 60;

	public static void loggUtBruker(HttpSession session) {
		session.invalidate();
	}

	public static void loggInnBruker(HttpServletRequest request, String passord) {
		
		loggUtBruker(request.getSession());
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
		session.setAttribute("passord", passord);
		
		
		
		
	}
	
	public static boolean erBrukerInnlogget(HttpSession session) {
		
		return  session != null && session.getAttribute("passord") != null ; //&& en ekstra session attributt =! null;
	}
	public static boolean validPassord(String passord) {
		
		return passord.equals(rettpassord);
	
	}

}
