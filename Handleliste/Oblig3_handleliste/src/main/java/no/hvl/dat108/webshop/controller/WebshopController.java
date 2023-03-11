package no.hvl.dat108.webshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.webshop.model.Cart;
import no.hvl.dat108.webshop.model.Handlevogn;
import no.hvl.dat108.webshop.model.Vare;
import no.hvl.dat108.webshop.util.InputValidator;
import no.hvl.dat108.webshop.util.LoginUtil;

@Controller
@RequestMapping("/webshop")
public class WebshopController {
	
	Handlevogn handlevogn = new Handlevogn();
	private String REQUIRES_LOGIN_MESSAGE = "Forespørselen din krever at du er innlogget";
	private String UGYLDIG_VARENAVN = "ugyldig input av vare";
	/* 
	 * GET /webshop er forespørselen for å vise webshop-siden.
	 */
	@GetMapping
    public String visWebshoppen(HttpSession session, RedirectAttributes ra) {
		if(!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + "login";
		}
		session.setAttribute("handlevogn", handlevogn);
		return "webshopView";
    }

	/* 
	 * POST /webshop er forespørselen for å handle en/flere varer.
	 */
	@PostMapping
    public String leggVarerIHandlekurv(
    		@RequestParam(name="vare", required=false) String vare,
    		HttpSession session, RedirectAttributes ra) {
		if(!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + "login";
		}
//		if(!InputValidator.isValid(vare)) {
//			ra.addFlashAttribute("redirectMessage", UGYLDIG_VARENAVN);
//			return "redirect:" + "webshop";
//		}
		System.out.println(vare);
		//oppdaterer handlevogn med data fra request-param vare
		handlevogn.leggTil(vare);
		session.setAttribute("handlevogn", handlevogn);
		
		return "redirect:" + "webshop";
    }
	
}
