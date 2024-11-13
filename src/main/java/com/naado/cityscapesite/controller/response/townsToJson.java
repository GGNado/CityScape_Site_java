package com.naado.cityscapesite.controller.response;

import com.naado.cityscapesite.model.Town;
import com.naado.cityscapesite.repository.RepoTown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/getTowns")
public class townsToJson {

    @Autowired
    RepoTown repoTown;

    @GetMapping("/json")
    @ResponseBody
    public ResponseEntity<List<Town>> getTownsJson() {
        List<Town> towns = repoTown.findAll();
        return ResponseEntity.ok(towns);
    }

}
