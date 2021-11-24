package com.examble.projektispring;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
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
        System.out.println("!!!!!!!!!!!!!!!!!! " + LocalDate.now() + " !!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!! " + motionname + " " + description + " " + LocalDate.now() + " "+  makerId + " !!!!!!!!!!!!!!!!");
        return "redirect:/maker";
    }
   /* @DeleteMapping("/makers/{makerId}")
    public String removeMaker(@PathVariable(value = "makerId") Long makerId){
        return "redirect:/makers";
    }*/

    


                /*Sähköisessä aloitelaatikossa käsitellään käyttäjien tekemiä aloitteita. Käyttäjällä voi olla yksi tai useampi aloite ja aloite liittyy vain yhteen käyttäjään. Kyseessä on siis yhden suhde moneen yhteys (OneToMany)Sähköisen aloitelaatikonkäsitteet ja niiden väliset yhteydet on kuvattu allaolevassaluokkakaaviossa.HUOM! Aloite-käsitteen pvm on aloitteen teko päivämäärä.Vaatimukset sovellukselle:Tietokantaan on voitava lisätä uusia tekjöiden tekemiä aloitteita.Tietokannassa olevia aloitteita ja niiden tekijöitä on myös pystyttävä listaamaan.Tiedot näytetään taulukkomuodossa.Sovelluksella tulee olla kotisivu, jossa on päävalikko.Jokaisella sivulta tulee olla paluulinkki kotisivulle. */


    
}
