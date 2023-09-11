package com.bloom.pium.controller;

import com.bloom.pium.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/matching")
public class MatchingController {

    @Autowired
    private MatchingService matchingService;

    @GetMapping("/list")
    public String getParticipateList(Model model){
        model.addAttribute("matchinglist", matchingService.getParticipateList());
        return "MatchingList";
    }
}
