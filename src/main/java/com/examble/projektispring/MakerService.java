package com.examble.projektispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakerService {

    @Autowired
    MakerRepository makr;

    @Autowired
    MotionRepository motr;

    public List<Maker> listAll() {
        return makr.findAll();
    }

    public void add(String firstname, String lastname, String email) {
        Maker maker = new Maker();
        maker.setFirstname(firstname);
        maker.setLastname(lastname);
        maker.setEmail(email);
        makr.save(maker);
    }

    public Maker findById(Long makerId) {
        return makr.getById(makerId);
    }


    public List<Motion> listAllMakersMotions(){
        return motr.findAll();
    }

    /*
     * @Transactional public void remove(Long makerId) { Maker maker =
     * makr.getById(makerId); for(Motion motion : maker.getMotions()){
     * motion.getMakers().remove(maker); } makr.deleteById(makerId);
     * 
     * }
     */

    /*
     * @Transactional public void addMakertoMotion(Long makerId, Long motionId){
     * motr.getById(motionId).getMaker().add(); makr.getById(makerId)); }
     */

    
}
