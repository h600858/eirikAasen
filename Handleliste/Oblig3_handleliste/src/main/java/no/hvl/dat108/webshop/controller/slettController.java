package no.hvl.dat108.webshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.webshop.model.Handlevogn;
import no.hvl.dat108.webshop.util.LoginUtil;

@Controller
@RequestMapping("/slett")
public class slettController {

	private String REQUIRES_LOGIN_MESSAGE = "Forespørselen din krever at du er innlogget";
	
	
	
	@PostMapping
	public String slettVare(@RequestParam(name="skjult", required = false)String vare,
			HttpSession session, RedirectAttributes ra) {
		//tar inn en vare, og sletter denne fra listen
		if(!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + "login";
		}
		
		Handlevogn temp = (Handlevogn) session.getAttribute("handlevogn");
		temp.fjern(vare);
		session.setAttribute("handlevogn", temp);
		return "redirect:" + "webshop";
		
		
	}
	
}
