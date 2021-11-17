package com.examble.projektispring;

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

    @GetMapping("/index")
    public String listMakers(Model model){
        model.addAttribute("makers", maks.listAll());
        return "index";
    }

    @PostMapping("/index")
    public String addMaker(@RequestParam String firstname, String lastname, String email){
        maks.add(firstname, lastname, email);
        return "redirect:/index";
    }

     @GetMapping("/makers/{makerId}")
    public String showMaker(Model model, @PathVariable(value = "makerId") Long makerId){
        model.addAttribute("maker", maks.findById(makerId));
        model.addAttribute("motions", maks.listAllMakersMotions());
        return "maker";
    }

   /* @DeleteMapping("/makers/{makerId}")
    public String removeMaker(@PathVariable(value = "makerId") Long makerId){
        return "redirect:/makers";
    }*/

    


                /*Sähköisessä aloitelaatikossa käsitellään käyttäjien tekemiä aloitteita. Käyttäjällä voi olla yksi tai useampi aloite ja aloite liittyy vain yhteen käyttäjään. Kyseessä on siis yhden suhde moneen yhteys (OneToMany)Sähköisen aloitelaatikonkäsitteet ja niiden väliset yhteydet on kuvattu allaolevassaluokkakaaviossa.HUOM! Aloite-käsitteen pvm on aloitteen teko päivämäärä.Vaatimukset sovellukselle:Tietokantaan on voitava lisätä uusia tekjöiden tekemiä aloitteita.Tietokannassa olevia aloitteita ja niiden tekijöitä on myös pystyttävä listaamaan.Tiedot näytetään taulukkomuodossa.Sovelluksella tulee olla kotisivu, jossa on päävalikko.Jokaisella sivulta tulee olla paluulinkki kotisivulle. */


    
}
