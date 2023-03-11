package no.hvl.lph.dat108.Controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.lph.dat108.Util.LoginUtil;

@RequestMapping("/paameldt")
@Controller
public class PaameldingsBekreftelseController {

	
	@GetMapping
	public String paameldingsBekreftelse(HttpSession session, RedirectAttributes ra) {
		if(!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", "Krever at du er innlogget");
			return "redirect:" + "innlogging";
		}
		
		
		return "paameldtView";
	}
	
	
}
