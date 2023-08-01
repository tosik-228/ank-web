package com.ank.controller.test;

import com.ank.model.XUser;
import com.ank.model.tables.Arrears;
import com.ank.repo.ArrearsRepository;
import com.ank.repo.UserRepositoryJPA;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class MainPage {

    private final UserRepositoryJPA userRepositoryJPA;
    private final ArrearsRepository arrearsRepository;

    public MainPage(UserRepositoryJPA userRepositoryJPA, ArrearsRepository arrearsRepository) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.arrearsRepository = arrearsRepository;
    }

    @GetMapping("/main")
    public String mainPage(Model model) throws IOException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        XUser xUser = userRepositoryJPA.findByEmail(user.getUsername());


        List<Arrears> list = arrearsRepository.findAll();

        model.addAttribute("list", list);
        model.addAttribute("xUser", xUser);

        return "main";
    }
}