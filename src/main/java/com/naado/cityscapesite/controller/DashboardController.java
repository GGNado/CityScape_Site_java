package com.naado.cityscapesite.controller;

import com.naado.cityscapesite.model.News;
import com.naado.cityscapesite.model.Request;
import com.naado.cityscapesite.repository.RepoNews;
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

    @Autowired
    RepoNews repoNews;

    @GetMapping()
    public String dashboardPage(Model model){
        List<Request> requestList = repoRequest.findAll();
        model.addAttribute("requests", requestList);
        model.addAttribute("news", repoNews.findAll());
        return "dashboard";
    }

    @PostMapping("/deleteRequest/{id}")
    public String deleteRequest(@PathVariable int id, Model model){
        repoRequest.deleteById(id);
        List<Request> requestList = repoRequest.findAll();
        model.addAttribute("requests", requestList);
        return "redirect:/dashboard";
    }

    @PostMapping("/addNews")
    public String addNews(News news, Model model){
        System.out.println(news);
        repoNews.save(news);
        return "redirect:/dashboard";
    }

    @PostMapping("/updateNews/{id}")
    public String updateNews(@PathVariable int id, News news, Model model){
        repoNews.save(news);
        return "redirect:/dashboard";
    }

    @PostMapping("/deleteNews/{id}")
    public String deleteNews(@PathVariable int id, Model model){
        repoNews.deleteById(id);
        return "redirect:/dashboard";
    }
} 