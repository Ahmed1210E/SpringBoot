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
public class Cours implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCours;

    private int niveau;

    @Enumerated
    private TypeCours typeCours;

    @Enumerated
    private Support support;

    private Float prix;

    private int creneau;

    @OneToMany(mappedBy = "cours")
    private List<Inscription> inscription;



}
