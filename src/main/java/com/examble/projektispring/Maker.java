package com.examble.projektispring;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Maker extends AbstractPersistable<Long>{

    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String email;
    @OneToMany(mappedBy = "maker")
    private List<Motion>motions = new ArrayList<>();
    
}
