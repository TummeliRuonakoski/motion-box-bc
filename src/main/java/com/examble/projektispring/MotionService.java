package com.examble.projektispring;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotionService {


   @Autowired
    MakerRepository makr;

    @Autowired
    MotionRepository motr;

    public List<Motion> listAll(){
        return motr.findAll();
    }

    public void add(String motionname, String description, LocalDate date, Long makerId){
        Motion motion = new Motion();
        motion.setMotionname(motionname);
        motion.setDescription(description);
        motion.setDate(date);
        Maker maker = makr.getById(makerId);
        motion.setMaker(maker);
        motr.save(motion);
    }

    public void addMakerToMotion(Long motionId, Long makerId){
        Motion motion = motr.getById(motionId);
        Maker maker = makr.getById(makerId);
        motion.setMaker(maker);
        motr.save(motion);
    }

    public Motion findById(Long motionId) {
        return motr.getById(motionId);
    }
/*
    @Transactional
    public void remove(Long motionId){
        Motion motion = motr.getById(motionId);
        for(Maker maker : motion.getMakers()){
            maker.getMotions().remove(motion);
        }
        motr.delete(motion);
    }*/

/*    @Transactional(readOnly = true)
    public List<Motion> listMakersMotions(Long makerId){
        Maker maker = makr.getById(makerId);
        return motr.findMakersMotions(maker);
    }*/

                    /*Sähköisessä aloitelaatikossa käsitellään käyttäjien tekemiä aloitteita. Käyttäjällä voi olla yksi tai useampi aloite ja aloite liittyy vain yhteen käyttäjään. Kyseessä on siis yhden suhde moneen yhteys (OneToMany)Sähköisen aloitelaatikonkäsitteet ja niiden väliset yhteydet on kuvattu allaolevassaluokkakaaviossa.HUOM! Aloite-käsitteen pvm on aloitteen teko päivämäärä.Vaatimukset sovellukselle:Tietokantaan on voitava lisätä uusia tekjöiden tekemiä aloitteita.Tietokannassa olevia aloitteita ja niiden tekijöitä on myös pystyttävä listaamaan.Tiedot näytetään taulukkomuodossa.Sovelluksella tulee olla kotisivu, jossa on päävalikko.Jokaisella sivulta tulee olla paluulinkki kotisivulle. */

    
}
