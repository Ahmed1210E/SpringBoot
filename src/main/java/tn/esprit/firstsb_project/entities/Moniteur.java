package tn.esprit.firstsb_project.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Moniteur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long numMoniteur ;

    private String nomM;

    private String prenomM;


    private LocalDate dateRecu;

    @OneToMany
    private List<Cours> cours;
}
