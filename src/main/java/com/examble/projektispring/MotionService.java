package com.examble.projektispring;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MotionService {


    @Autowired
    MakerRepository makr;

    @Autowired
    MotionRepository motr;

    public Iterable<Motion> listAll(){
        return motr.findAll();
    }

    @Transactional
    public void add(String motionname, String description, LocalDate date){
        Motion motion = new Motion();
        motion.setMotionname(motionname);
        motion.setDescription(description);
        motion.setDate(date);
        motr.save(motion);
    }

   /* @Transactional
    public void remove(Long motionId){
        Motion motion = motr.getById(motionId);
        for(Maker maker : motion.getMakers()){
            maker.getMotions().remove(motion);
        }
        motr.delete(motion);
    }*/

    @Transactional(readOnly = true)
    public List<Motion> listMakersMotions(Long makerId){
        Maker maker = makr.getById(makerId);
        return motr.findMakersMotions(maker);
    }

                    /*Sähköisessä aloitelaatikossa käsitellään käyttäjien tekemiä aloitteita. Käyttäjällä voi olla yksi tai useampi aloite ja aloite liittyy vain yhteen käyttäjään. Kyseessä on siis yhden suhde moneen yhteys (OneToMany)Sähköisen aloitelaatikonkäsitteet ja niiden väliset yhteydet on kuvattu allaolevassaluokkakaaviossa.HUOM! Aloite-käsitteen pvm on aloitteen teko päivämäärä.Vaatimukset sovellukselle:Tietokantaan on voitava lisätä uusia tekjöiden tekemiä aloitteita.Tietokannassa olevia aloitteita ja niiden tekijöitä on myös pystyttävä listaamaan.Tiedot näytetään taulukkomuodossa.Sovelluksella tulee olla kotisivu, jossa on päävalikko.Jokaisella sivulta tulee olla paluulinkki kotisivulle. */

    
}
