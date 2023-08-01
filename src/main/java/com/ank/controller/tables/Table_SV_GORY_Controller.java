package com.ank.controller.tables;

import com.ank.model.XUser;
import com.ank.model.tables.SV_GORY_Model;
import com.ank.repo.SvGoriRepositoryJPA;
import com.ank.repo.UserRepositoryJPA;
import com.ank.service.TablesService;
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
public class Table_SV_GORY_Controller {

    private final UserRepositoryJPA userRepositoryJPA;
    private final SvGoriRepositoryJPA svGoriRepositoryJPA;

    private final TablesService service;

    public Table_SV_GORY_Controller(UserRepositoryJPA userRepositoryJPA, SvGoriRepositoryJPA svGoriRepositoryJPA, TablesService service) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.svGoriRepositoryJPA = svGoriRepositoryJPA;
        this.service = service;
    }

    @GetMapping("/viewtables")
    public String testPage(Model model) throws Exception {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        XUser xUser = userRepositoryJPA.findByEmail(user.getUsername());

        List<SV_GORY_Model> list = service.listAll();
        model.addAttribute("list", list);
        model.addAttribute("xUser", xUser);

        return "viewtables";
    }

    @GetMapping("/viewtables/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Optional<SV_GORY_Model> sv = svGoriRepositoryJPA.findById(id);
            model.addAttribute("sv", sv);
            model.addAttribute("pageTitle", "Edit svGoriEl (ID: " + id + ")");

            return "user_form";

        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/viewtables";
        }
    }

    @GetMapping("/viewtables/new")
    public String showNewForm(Model model) {
        model.addAttribute("sv", new SV_GORY_Model());
        model.addAttribute("pageTitle", "ADD USER");
        return "user_form";
    }

    @PostMapping("/viewtables/save")
    public String saveUser(SV_GORY_Model sv, RedirectAttributes ra) {
        service.save(sv);
        ra.addFlashAttribute("message", "The user has been saved successfully.");
        return "redirect:/viewtables";
    }

    @GetMapping("/viewtables/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {

        SV_GORY_Model sv = svGoriRepositoryJPA.deleteById(id);
        model.addAttribute("sv", sv);
        return "redirect:/viewtables";
    }

}






















