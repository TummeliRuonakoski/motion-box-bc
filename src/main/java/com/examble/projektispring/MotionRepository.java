package com.examble.projektispring;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MotionRepository extends JpaRepository<Motion,Long>{


    @Query("select m from Motion m where :maker nor member of m.makers")
    List<Motion> findMakersMotions(@Param("maker") Maker maker);
    
}
