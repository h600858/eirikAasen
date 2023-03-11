package no.hvl.lph.dat108.Controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.lph.dat108.Models.Deltager;
import no.hvl.lph.dat108.Models.deltagerRepo;
import no.hvl.lph.dat108.Util.LoginUtil;

@Controller
@RequestMapping("/innlogging")
public class LoginController {

	
	@Autowired deltagerRepo DeltagerRepo;
	
	@GetMapping
	public String getInnlogging() {
		return "innloggingView";
	}
	@PostMapping
	public String provAaLoggInn(@RequestParam String mobil,@RequestParam String passord, HttpServletRequest request, RedirectAttributes ra) {
		
		if(!DeltagerRepo.findById(Integer.parseInt(mobil)).isPresent()) {
			ra.addFlashAttribute("redirectMessage", "mobilnummer oppgitt stemmer ikkje");
			return "redirect:" + "innlogging";
		}
		if(!DeltagerRepo.findById(Integer.parseInt(mobil)).get().getPassord().equals(passord)) {
				ra.addFlashAttribute("redirectMessage", "feil passord skrevet inn");
				return "redirect:"
						+ "innlogging";
			}
			
		
		Deltager deltager = DeltagerRepo.findById(Integer.parseInt(mobil)).get();
		LoginUtil.loggInnBruker(request, passord, deltager.getFornavn(), deltager.getEtternavn(), mobil);
		
		return "redirect:" + "deltagerliste";
	}
}
