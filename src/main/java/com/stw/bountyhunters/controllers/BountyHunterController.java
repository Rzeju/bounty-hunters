package com.stw.bountyhunters.controllers;

import com.stw.bountyhunters.converters.BountyHunterResponse;
import com.stw.bountyhunters.model.BountyHunter;
import com.stw.bountyhunters.services.BountyHunterService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;
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

    @RequestMapping({"/bountyhunter/{id}", "/bountyhunter/{id}/index", "/bountyhunter/{id}/index.html"})
    public String getBountyHunterById(@PathVariable("id") Long id, Model model) {

        BountyHunter hunter = bountyHunterService.findById(id);

        model.addAttribute("hunter", hunter);

        return "bountyhunter/index";
    }

    @RequestMapping({"/bountyhunter/create/{name}/{login}/{password}"})
    public String createBountyHunter(@PathVariable("name") String name, @PathVariable("login") String login,
                                     @PathVariable("password") String password, Model model) {

        BountyHunter hunterToSave = BountyHunter.builder().name(name).login(login).password(password).build();

        BountyHunter hunter = bountyHunterService.save(hunterToSave);

        model.addAttribute("hunter", hunter);

        return "bountyhunter/index";
    }

    @RequestMapping(value = {"/getjson/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BountyHunterResponse getJsonResponse(@PathVariable("id") Long id) {
        BountyHunter hunter = bountyHunterService.findById(id);

        BountyHunterResponse response = new BountyHunterResponse();
        response.setName(hunter.getName());
        response.setLogin(hunter.getLogin());
        response.setPassword(hunter.getPassword());

        return response;

    }


}
