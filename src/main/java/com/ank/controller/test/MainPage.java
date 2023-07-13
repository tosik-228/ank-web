package com.ank.controller.test;

import com.ank.model.XUser;
import com.ank.repo.UserRepositoryJPA;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MainPage {

    private final UserRepositoryJPA userRepositoryJPA;

    public MainPage(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    @GetMapping("/main")
    public String mainPage(Model model) throws IOException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        XUser xUser = userRepositoryJPA.findByEmail(user.getUsername());

        model.addAttribute("xUser", xUser);

        return "main";
    }
}