package com.examble.projektispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {

    @Autowired
    private MakerService maks;

    @Autowired
    private MotionService mots;

    @GetMapping("*")
    public String handleDefault() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String listMotions(Model model){
        model.addAttribute("motions", mots.listAll());
        model.addAttribute("makers", maks.listAll());
        return "index";
    }

    @PostMapping("/index")
    public String addMaker(@RequestParam String firstname, String lastname, String email){
        maks.add(firstname, lastname, email);
        return "redirect:/index";
    }

    
}
