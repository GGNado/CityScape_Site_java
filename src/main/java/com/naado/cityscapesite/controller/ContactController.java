package com.naado.cityscapesite.controller;

import com.naado.cityscapesite.enums.Problem;
import com.naado.cityscapesite.model.Request;
import com.naado.cityscapesite.repository.RepoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    RepoRequest repoRequest;

    @GetMapping()
    public String contact(Model model) {
        List<String> problems = Problem.getValues();
        model.addAttribute("problems", problems);
        return "contact";
    }

    @PostMapping("/sendInfo")
    public String sendInfo(Request request, Model model, RedirectAttributes redirectAttributes) {
        repoRequest.save(request);
        redirectAttributes.addFlashAttribute("banner", true);

        List<Request> requests = repoRequest.findAll();
        System.out.println(requests);
        return "redirect:/";
    }
}
