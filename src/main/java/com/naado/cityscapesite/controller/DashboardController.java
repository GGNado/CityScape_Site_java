package com.naado.cityscapesite.controller;

import com.naado.cityscapesite.model.Request;
import com.naado.cityscapesite.repository.RepoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    RepoRequest repoRequest;

    @GetMapping()
    public String dashboardPage(Model model){
        List<Request> requestList = repoRequest.findAll();
        System.out.println(requestList);
        model.addAttribute("requests", requestList);
        return "dashboard";
    }
}
