package peog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import peog.entities.account.AccountStatus;
import peog.entities.Address;
import peog.entities.User;
import peog.services.AddressService;
import peog.services.UserService;

import java.sql.Date;

@Controller
public class AccessControlsController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("newAccount", new User());
        model.addAttribute("newAddress", new Address());
        return "register";
    }

    @PostMapping("/register")
    public String registerAccount(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam("birthdate") Date birthdate,
            @RequestParam("sex") String sex,

            @RequestParam("address1") String address1,
            @RequestParam("address2") String address2,
            @RequestParam("country") String country,
            @RequestParam("county") String county,
            @RequestParam("postcode") String postcode,
            Model model) {

        Address address = new Address(address1, address2, country, county, postcode, null);
        User user = new User(username, password, email, birthdate, sex, address);

        addressService.createAddress(address);
        userService.createUser(user);

        model.addAttribute("newAccount", new User());
        model.addAttribute("newAddress", new Address());
        return "register";
    }

}
