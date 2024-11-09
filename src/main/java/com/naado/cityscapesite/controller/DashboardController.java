package com.naado.cityscapesite.controller;

import com.naado.cityscapesite.model.Request;
import com.naado.cityscapesite.repository.RepoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    RepoRequest repoRequest;

    @GetMapping()
    public String dashboardPage(Model model){
        List<Request> requestList = repoRequest.findAll();
        model.addAttribute("requests", requestList);
        return "dashboard";
    }

    @PostMapping("/deleteRequest/{id}")
    public String deleteRequest(@PathVariable int id, Model model){
        repoRequest.deleteById(id);
        List<Request> requestList = repoRequest.findAll();
        model.addAttribute("requests", requestList);
        return "dashboard";
    }
}