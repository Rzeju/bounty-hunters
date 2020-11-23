package com.stw.bountyhunters.controllers;

import com.stw.bountyhunters.model.BountyHunter;
import com.stw.bountyhunters.services.BountyHunterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class BountyHunterController {

    private final BountyHunterService bountyHunterService;

    public BountyHunterController(BountyHunterService bountyHunterService) {
        this.bountyHunterService = bountyHunterService;
    }

    @RequestMapping({"/bountyhunters", "/bountyhunters/index", "/bountyhunters/index.html"})
    public String getBountyHunters(Model model) {

        Set<BountyHunter> hunters = bountyHunterService.findAll();

        model.addAttribute("hunters", hunters);

        return "bountyhunters/index";
    }
}
