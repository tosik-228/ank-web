package com.ank.controller.tables;

import com.ank.model.tables.SvGoriDTO;
import com.ank.model.tables.SvGoriEl;
import com.ank.repo.SvGoriRepositoryJPA;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CreateDataTablesController {

    private final SvGoriRepositoryJPA svGoriRepositoryJPA;

    public CreateDataTablesController(SvGoriRepositoryJPA svGoriRepositoryJPA) {
        this.svGoriRepositoryJPA = svGoriRepositoryJPA;
    }


    @GetMapping("/edits")
    public String mainPage(Model model) {


        List<SvGoriEl> lists = new ArrayList<>();
        svGoriRepositoryJPA.findAll().iterator().forEachRemaining(lists :: add);

        model.addAttribute("form", new SvGoriDTO(lists));

        return "edit";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        SvGoriDTO form = new SvGoriDTO();

        for (int i = 1; i <= 3; i++) {
            form.addList(new SvGoriEl());
        }

        model.addAttribute("form", form);
        model.addAttribute("lists", svGoriRepositoryJPA.findAll());
        return "edit";
    }
}