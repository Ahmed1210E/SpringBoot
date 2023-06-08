package tn.esprit.firstsb_project.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Abonnement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long numAbon ;


    private LocalDate dateDebut;

    private LocalDate dateFin;

    private Float prixAbon;

    @Enumerated
    private TypeAbonnement typeAbon;


}
