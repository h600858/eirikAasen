package no.hvl.lph.dat108.Controllers;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.lph.dat108.Models.Deltager;
import no.hvl.lph.dat108.Services.deltagerService;
import no.hvl.lph.dat108.Util.LoginUtil;

@Controller
@RequestMapping("/deltagerliste")
public class DeltakerListeController {

	@Autowired deltagerService service;
	
	@GetMapping
	public String visDeltagerListe(HttpSession session, RedirectAttributes ra ) {
		if(!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", "Krever at du er innlogget");
			return "redirect:" + "innlogging";
		}
		
		String mobil = (String) session.getAttribute("mobil");
		Deltager innloggetBruker = service.finndeldtagerMedMobil(Integer.parseInt(mobil)).get();
		session.setAttribute("deltagerInnlogget", innloggetBruker);
		List<Deltager> deltagere = service.getDeltagere();
		System.out.println(deltagere.toString());
		session.setAttribute("deltagere", deltagere);
		return "deltagerliste";
	}
}
