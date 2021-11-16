package com.examble.projektispring;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Motion extends AbstractPersistable<Long>{

    @Column
    private String motionname;
    @Column
    private String description;
    @Column
    private LocalDate date;
    @ManyToOne
    private Maker maker;
    
}
