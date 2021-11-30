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
}
