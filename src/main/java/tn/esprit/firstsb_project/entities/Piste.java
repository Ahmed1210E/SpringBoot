package tn.esprit.firstsb_project.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class Piste implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long numPiste ;


    private String nomPiste;

    @Enumerated
    private Couleur couleur;

    private int longueur;

    private int pente;


    @ManyToMany(mappedBy = "piste")
    private List<Skieur> skieur;

}
