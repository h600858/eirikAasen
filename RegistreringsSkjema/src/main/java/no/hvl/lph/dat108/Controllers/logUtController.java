package no.hvl.lph.dat108.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.lph.dat108.Util.LoginUtil;



@Controller
@RequestMapping("/utlogging")
public class logUtController {

	@PostMapping
    public String loggUt(HttpSession session, RedirectAttributes ra) {
		LoginUtil.loggUtBruker(session);
		ra.addFlashAttribute("redirectMessage", "Du er logget Ut");
		return "redirect:" + "innlogging";
    }
	
}
