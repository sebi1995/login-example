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
import peog.SecureConfig;
import peog.entities.User;
import peog.services.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/changepass")
    public String getChangePass(String stat, Model model) {

        String pass = "TOP";
        String epass = passwordEncoder.encode(pass);
        userService.createUser(new User("", epass));


        System.out.println(epass);
        System.out.println(userService.getUserByUsername("").getPassword());
        System.out.println(pass);
        System.out.println(passwordEncoder.matches(epass, pass));


        model.addAttribute("user", new User());
        model.addAttribute("changeStatus", stat);
        return "changepassword";
    }

    @PostMapping("/changepass")
    public String changePass(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {

        User dbUser = userService.getUserByUsername(username);

        if (passwordEncoder.matches(dbUser.getPassword(), password)) {
            System.out.println(dbUser.getPassword());
        } else System.out.println("encpass ");

        System.out.println();
        System.out.println();
        System.out.println(dbUser.getPassword());
        System.out.println(passwordEncoder.encode(password));

        return "redirect:/account/changepass";

    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}
