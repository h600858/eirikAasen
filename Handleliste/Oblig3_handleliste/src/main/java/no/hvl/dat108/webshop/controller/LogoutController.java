package no.hvl.dat108.webshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.webshop.util.LoginUtil;

@Controller
@RequestMapping("/logout")
public class LogoutController {
	
	private String LOGGED_OUT_MESSAGE = "Du er nå logget ut";
	
	/* 
	 * POST /logout er forespørselen for å logge ut.
	 */
	@PostMapping
    public String loggUt(HttpSession session, RedirectAttributes ra) {
		LoginUtil.loggUtBruker(session);
		ra.addFlashAttribute("redirectMessage", LOGGED_OUT_MESSAGE);
		return "redirect:" + "login";
    }
}
