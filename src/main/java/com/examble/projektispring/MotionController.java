package com.examble.projektispring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MotionController {

   @Autowired
    private MotionService mots;

    @Autowired
    private MakerService maks;

   @GetMapping("motions/{motionId}")
    public String showMotion(Model model, @PathVariable Long motionId){
        model.addAttribute("motion", mots.findById(motionId));
        model.addAttribute("maker", maks.listAll());
        return "motion";
    }

}
