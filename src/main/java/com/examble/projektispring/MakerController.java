package com.examble.projektispring;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MakerController {


    @Autowired
    MakerService maks;

    @Autowired
    MotionService mots;

    @GetMapping("/makers/{makerId}")
    public String showMaker(Model model, @PathVariable(value = "makerId") Long makerId){
        model.addAttribute("maker", maks.findById(makerId));
        model.addAttribute("motions", mots.listAll());
        return "maker";
    }

    @PostMapping("/makers/{makerId}")
    public String addMotion(@RequestParam String motionname, @RequestParam String description, @PathVariable Long makerId){
        mots.add(motionname, description, LocalDate.now(), makerId);
        return "redirect:/index";
    }
}
