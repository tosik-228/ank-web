package com.ank.controller.profile;

import com.ank.model.XUser;
import com.ank.repo.UserRepositoryJPA;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    private final UserRepositoryJPA userRepositoryJPA;

    public ProfileController(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    @GetMapping("/prof")
    public String mainPage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        XUser xUser = userRepositoryJPA.findByEmail(user.getUsername());

        model.addAttribute("xUser", xUser);
        return "prof";
    }
}
