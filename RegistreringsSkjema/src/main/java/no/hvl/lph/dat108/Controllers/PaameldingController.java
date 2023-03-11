package no.hvl.lph.dat108.Controllers;

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
import no.hvl.lph.dat108.Util.InputValidator;
import no.hvl.lph.dat108.Util.LoginUtil;
import no.hvl.lph.dat108.Util.PassordUtil;

@Controller
@RequestMapping("/paamelding")
public class PaameldingController {
	
	private String INVALID_FORNAVN = "fornavn må vere mellom 2-20 tegn og må starte med stor bokstav ";
	private String INVALID_ETTERNAVN = "etternavn må være mellom 2-20 tegn og må starte med stor bokstav";
	private String INVALID_MOBIL = "mobil må være akkurat 8 siffer";
	private String INVALID_REPETERTPASSORD = "repetertpassord er feil";
	private String INVALID_PASSORD = "passord må være minst 5 tegn";
	
	@Autowired deltagerRepo DeltagerRepo;
	
	@GetMapping
    public String getPaamelding() {
    	return "paamelding";
    }
	@PostMapping
	public String meldPaa(@RequestParam String passord, @RequestParam String fornavn, @RequestParam String etternavn, @RequestParam String mobil, @RequestParam String passordRepetert,
			@RequestParam String kjonn,
    		HttpServletRequest request,	RedirectAttributes ra,HttpSession session) {
		char kjonn1 = kjonn.toUpperCase().toCharArray()[0];
		if(!InputValidator.inputValidator(fornavn, etternavn, mobil, passord, passordRepetert)) {
			if(!InputValidator.fornavnValidator(fornavn)) {
			ra.addFlashAttribute("feilFornavn", INVALID_FORNAVN); 
		}
		if(!InputValidator.etternavnValidator(etternavn)) {
			ra.addFlashAttribute("feilEtternavn", INVALID_ETTERNAVN); 
		}
		if(!InputValidator.mobilValidator(mobil)) {
			ra.addFlashAttribute("feilMobil", INVALID_MOBIL);
			 
		}
		if(!InputValidator.passordValidator(passord)) {
			ra.addFlashAttribute("feilPassord", INVALID_PASSORD);
		 
		}
		if(!InputValidator.passordRepetertValidator(passord, passordRepetert)) {
			ra.addFlashAttribute("feilRepetertPassord", INVALID_REPETERTPASSORD); 
		}
		return "redirect:" + "paamelding";
		}
		if(DeltagerRepo.findById(Integer.parseInt(mobil)).isPresent()) {
			ra.addFlashAttribute("redirectMessage", "denne brukeren finnes allerede");
			return "redirect:" + "innlogging";
		}
		String salt = PassordUtil.genererTilfeldigSalt();
		String hash = PassordUtil.hashMedSalt(passord, salt);
		Deltager deltager = new Deltager(fornavn, etternavn, mobil, hash, salt, passord, kjonn1);
		DeltagerRepo.save(deltager);
		LoginUtil.loggInnBruker(request, passord, fornavn, etternavn, mobil);
		session.setAttribute("fornavn", fornavn);
		session.setAttribute("etternavn", etternavn);
		session.setAttribute("mobil", mobil);
		session.setAttribute("deltager", deltager);
		
		return "redirect:" + "paameldt";
	}
}
