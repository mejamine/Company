package exp.company.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/")
    public String Home(){
        return "redirect:/team/all";
    }
}
