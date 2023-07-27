package com.ank.controller.tables;

import com.ank.model.XUser;
import com.ank.model.tables.SvGoriEl;
import com.ank.repo.SvGoriRepositoryJPA;
import com.ank.repo.UserRepositoryJPA;
import com.ank.service.TablesService;
import com.ank.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
public class TablesViewController {

    private final UserRepositoryJPA userRepositoryJPA;
    private final SvGoriRepositoryJPA svGoriRepositoryJPA;

    private TablesService service;

    public TablesViewController(UserRepositoryJPA userRepositoryJPA, SvGoriRepositoryJPA svGoriRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.svGoriRepositoryJPA = svGoriRepositoryJPA;
    }

    @GetMapping("/viewtables")
    public String testPage(Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        XUser xUser = userRepositoryJPA.findByEmail(user.getUsername());

        List<SvGoriEl> svGoriEls = service.listAll();
        model.addAttribute("svGoriEls", svGoriEls);
        model.addAttribute("xUser", xUser);

        return "viewtables";
    }

    @GetMapping("/viewtables/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            SvGoriEl sv = service.get(id);
            model.addAttribute("sv", sv);
            model.addAttribute("pageTitle", "Edit svGoriEl (ID: " + id + ")");

        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "user_form";
        }
        return "redirect:/viewtables";
    }

    @GetMapping("/viewtables/new")
    public String showNewForm(Model model) {
        model.addAttribute("sv", new SvGoriEl());
        model.addAttribute("pageTitle", "Add New String");
        return "user_form";
    }

    @PostMapping("/viewtables/save")
    public String saveUser(SvGoriEl sv, RedirectAttributes ra) {
        service.save(sv);
        ra.addFlashAttribute("message", "The user has been saved successfully.");
        return "redirect:/viewtables";
    }

}






















