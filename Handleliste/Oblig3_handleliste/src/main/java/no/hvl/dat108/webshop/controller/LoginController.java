package no.hvl.dat108.webshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.webshop.util.LoginUtil;

@Controller
@RequestMapping("/${app.url.login}")
public class LoginController {
	
	@Value("${app.message.invalidPassord}")
	private String INVALID_PASSORD;
	
	/* 
	 * GET /login er forespørselen for å hente login-skjema.
	 */
	@GetMapping
    public String hentLoginSkjema() {
		return "loginView";
    }

	/* 
	 * POST /login er forespørselen for å logge inn.
	 */
	@PostMapping
    public String provAaLoggeInn(@RequestParam String passord,
    		HttpServletRequest request,	RedirectAttributes ra) {
		
		//sjekke om passordet er riktig, går dermed videre til webshoppen
		if(!LoginUtil.validPassord(passord)) {
			ra.addFlashAttribute("redirectMessage", INVALID_PASSORD);//overlever redirecten men ikkje noe serlig lengre
			return "redirect:" + "login";
		}
		
		LoginUtil.loggInnBruker(request, passord);
		
		
		return "redirect:" + "webshop";
    }
}
