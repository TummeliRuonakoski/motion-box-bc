package com.examble.projektispring;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MakerService maks;




   @GetMapping("motions/{motionId}")
    public String showMotion(Model model, @PathVariable Long motionId){
        model.addAttribute("motion", mots.findById(motionId));
        model.addAttribute("maker", maks.listAll());
        return "motion";
    }

  /*  @PostMapping("/motions")
    public String addMotion(@RequestParam String motionname, @RequestParam String description){
        mots.add(motionname, description, LocalDate.now());
        System.out.println("!!!!!!!!!!!!!!!!!! " + LocalDate.now() + " !!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!! " + motionname + " " + description + " " + LocalDate.now() + " !!!!!!!!!!!!!!!!");
        return "redirect:/motions";
    }*/

    @PostMapping("/motions/{motionId}/makers")
    public String addMakerToMotion(@PathVariable Long motionId, @RequestParam Long makerId){
        mots.addMakerToMotion(motionId, makerId);
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
