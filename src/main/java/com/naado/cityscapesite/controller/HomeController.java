package com.naado.cityscapesite.controller;

import com.naado.cityscapesite.model.ServerAccount;
import com.naado.cityscapesite.model.Town;
import com.naado.cityscapesite.repository.RepoTown;
import com.naado.cityscapesite.repository.ServerAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RequestMapping("/")
@Controller
public class HomeController {

    @Autowired
    RepoTown repoTown;

    @Autowired
    ServerAccountRepo serverAccountRepo;

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<Town> towns = new ArrayList<>();
        List<Town> topCitizens = new ArrayList<>();

        Integer userId = getAuthenticatedUserId();
        if (userId != null) {
            ServerAccount serverAccount = serverAccountRepo.findById(userId.intValue());
            towns = serverAccount.getTowns();
            topCitizens = (towns.stream()
                    .sorted(Comparator.comparing(Town::getCitizenCount).reversed())
                    .limit(3)
                    .toList());
            model.addAttribute("towns", towns);
            model.addAttribute("topCitizens", topCitizens);
        } else {
            model.addAttribute("towns", towns);
        }

        return "home";
    }


    public Integer getAuthenticatedUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();

            // Cerca l'utente nel repository in base al nome utente (nickname)
            ServerAccount user = serverAccountRepo.findByNickname(username);

            return user != null ? user.getId() : null;
        } else {
            return null;
        }
    }
}
