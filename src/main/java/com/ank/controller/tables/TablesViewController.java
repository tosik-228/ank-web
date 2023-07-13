package com.ank.controller.tables;

import com.ank.model.XUser;
import com.ank.repo.SvGoriRepositoryJPA;
import com.ank.repo.UserRepositoryJPA;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class TablesViewController {

    private final UserRepositoryJPA userRepositoryJPA;
    private final SvGoriRepositoryJPA svGoriRepositoryJPA;

    public TablesViewController(UserRepositoryJPA userRepositoryJPA, SvGoriRepositoryJPA svGoriRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.svGoriRepositoryJPA = svGoriRepositoryJPA;
    }

    @GetMapping("/viewtables")
    public String mainPage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        XUser xUser = userRepositoryJPA.findByEmail(user.getUsername());


        List<String> list = Arrays.asList("№", "Потребитель", "№ счетчика", "Новые", "Предыдущие",
                "Потребление кВт", "Сумма без НДС", "Сумма с НДС");
        List<Map<String, Object>> columns = new ArrayList<>();

        var i = svGoriRepositoryJPA.findAll();

        for (var z : i) {
            columns.add(Map.of("№", z.getId(), "Потребитель", z.getName(), "№ счетчика", z.getSchetchik(),
                    "Предыдущие", z.getOld(), "Новые", z.getNew1(),
                    "Потребление кВт", z.getResult(), "Сумма без НДС", z.getWithoutVAT(), "Сумма с НДС",
                    z.getWithVAT()));
        }

        model.addAttribute("xUser", xUser);
        model.addAttribute("list", list);
        model.addAttribute("columns", columns);

        return "viewtables";
    }
}