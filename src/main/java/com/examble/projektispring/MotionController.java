package com.examble.projektispring;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MotionController {

    @Autowired
    private MotionService mots;

    
    @GetMapping("/motions")
    public String getAll(Model model){
        model.addAttribute("motions", mots.listAll());
        return "motions";
    }

    @GetMapping("motions/{id}")
    public String getOne(Model model, @PathVariable Long id){
        
        return "motion";
    }

    @PostMapping("/motions")
    public String addMotion(@RequestParam String name, @RequestParam String description, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        mots.add(name, description, date);
        return "redirect:/motions";
    }

   /* @DeleteMapping("/motions/{motionId}")
    public String remove(@PathVariable(value = "motionId") Long motionId){
        mots.remove(motionId);
        return "redirect:/motions";
    }*/


        /*Sähköisessä aloitelaatikossa käsitellään käyttäjien tekemiä aloitteita. Käyttäjällä voi olla yksi tai useampi aloite ja aloite liittyy vain yhteen käyttäjään. Kyseessä on siis yhden suhde moneen yhteys (OneToMany)Sähköisen aloitelaatikonkäsitteet ja niiden väliset yhteydet on kuvattu allaolevassaluokkakaaviossa.HUOM! Aloite-käsitteen pvm on aloitteen teko päivämäärä.Vaatimukset sovellukselle:Tietokantaan on voitava lisätä uusia tekjöiden tekemiä aloitteita.Tietokannassa olevia aloitteita ja niiden tekijöitä on myös pystyttävä listaamaan.Tiedot näytetään taulukkomuodossa.Sovelluksella tulee olla kotisivu, jossa on päävalikko.Jokaisella sivulta tulee olla paluulinkki kotisivulle.
 */


    
}
