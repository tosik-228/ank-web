package com.ank.controller.test;

import com.ank.model.XUser;
import com.ank.model.tables.Arrears;
import com.ank.model.tables.SV_GORY_Model;
import com.ank.repo.ArrearsRepository;
import com.ank.repo.UserRepositoryJPA;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String mainPage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        XUser xUser = userRepositoryJPA.findByEmail(user.getUsername());

        List<Arrears> list = arrearsRepository.findAll();


        model.addAttribute("list", list);
        model.addAttribute("xUser", xUser);

        return "main";
    }

    @GetMapping("/main/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model, RedirectAttributes ra) {
        try {
            Arrears arrears = arrearsRepository.findById(id);
            model.addAttribute("arrears", arrears);
            model.addAttribute("pageTitle", "Edit svGoriEl (ID: " + id + ")");

            return "user_form_arrears";

        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/main";
        }
    }

    @GetMapping("/main/new")
    public String showNewForm(Model model) {
        model.addAttribute("arrears", new Arrears());
        model.addAttribute("pageTitle", "ADD USER");
        return "user_form_arrears";
    }

    @PostMapping("/main/save")
    public String saveUser(Arrears arrears, RedirectAttributes ra) {
        arrearsRepository.save(arrears);
        ra.addFlashAttribute("message", "The user has been saved successfully.");
        return "redirect:/main";
    }

    @GetMapping("/main/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {

        Arrears arrears = arrearsRepository.deleteById(id);
        model.addAttribute("arrears", arrears);
        return "redirect:/main";
    }
}