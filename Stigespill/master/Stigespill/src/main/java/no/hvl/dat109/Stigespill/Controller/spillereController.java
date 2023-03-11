package no.hvl.dat109.Stigespill.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat109.Stigespill.ServiceOgRepoer.BrettService;

@Controller
@RequestMapping("/spillere")
public class spillereController {

	@Autowired BrettService service;
	@GetMapping
	public String getTest(HttpSession session, RedirectAttributes ra) {
		return "startView";
	}
	
	@PostMapping
	public String postTest(RedirectAttributes ra, @RequestParam String AntallSpillere){
		System.out.println(AntallSpillere);
		ra.addFlashAttribute("spill", AntallSpillere);
		return "redirect:spill";
	}
}
