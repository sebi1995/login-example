package peog.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peog.CurrentSession;
import peog.entities.User;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("index")
    public String getIndex() {
        return "index";
    }

    @GetMapping("home")
    public String getHome(Model model) {
        model.addAttribute("username", CurrentSession.getUser().getUsername());
        model.addAttribute("password", CurrentSession.getUser().getPassword());
        return "home";
    }
}
