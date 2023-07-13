package com.ank.controller.registration;

import com.ank.model.XUser;
import com.ank.repo.UserRepositoryJPA;
import com.ank.service.CustomUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {

    private final UserRepositoryJPA userRepositoryJPA;
    private final CustomUserDetailsService customUserDetailsService;

    public RegistrationController(UserRepositoryJPA userRepositoryJPA, CustomUserDetailsService customUserDetailsService) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.customUserDetailsService = customUserDetailsService;
    }

    @GetMapping("/registration")
    public String registerMethod() {

        return "registration";
    }

    @PostMapping("/registration")
    public String registerMethod(XUser user, BindingResult bindingResult, Map<String, Object> map) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        if (!customUserDetailsService.addUser(user)) {
            map.put("message", "User exists!");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate (Model model, @PathVariable String code) {


        boolean isActivated = customUserDetailsService.activateUser(code);

        if (isActivated) {
            model.addAttribute("message" , "User successfully activated");

        }
        else  {
            model.addAttribute("message", "Activation code is not found");
        }
        return "/login";
    }
}
