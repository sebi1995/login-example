package peog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import peog.entities.User;
import peog.services.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping("/changepass")
    public String getChangePass(String stat, Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("changeStatus", stat);
        return "changepassword";
    }

    @PostMapping("/changepass")
    public String changePass(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {

        boolean isValidPassword = userService.authUser(username, password);
        System.out.println(isValidPassword);
        if (isValidPassword){
            model.addAttribute("user", userService.getUserByUsername(username));
        }
        return "redirect:/account/changepass";

    }
}
