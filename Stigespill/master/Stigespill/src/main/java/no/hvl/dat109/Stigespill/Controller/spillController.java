package no.hvl.dat109.Stigespill.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat109.Stigespill.Model.Stigespill;
import no.hvl.dat109.Stigespill.ServiceOgRepoer.BrettService;


@Controller
@RequestMapping("/spill")
public class spillController {
	
	Stigespill spill = new Stigespill();
	@Autowired BrettService service;
	boolean startet = false;
	@GetMapping
	public String getSpill(HttpSession session, RedirectAttributes ra, @RequestBody@ModelAttribute("spill") int antall) {
		if (!startet) {

		spill.getBrett().setService(service);
		spill.startSpill(antall);
		session.setAttribute("spillere", spill.getSpillere());
		startet = true;}
		return "velgSpillere";
	}
	
	@PostMapping
	public String postSpill(RedirectAttributes ra) {
		spill.taTur();
		ra.addFlashAttribute("spillere", spill.getSpillere());
		ra.addFlashAttribute("spill", spill.getSpillere().size());
		ra.addFlashAttribute("hendelse", spill.getHendelse());
		return "redirect:spill";
	}

}
