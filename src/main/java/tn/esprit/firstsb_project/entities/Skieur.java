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
public class Skieur implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long numSkieur ;

    private String nomS;

    private String prenomS;


    private LocalDate dateNaissance;

    private String ville;

    @ManyToMany
    private List<Piste> piste;

    @OneToOne
    private Abonnement abonnement;

    @OneToMany(mappedBy = "skieur")
    private List<Inscription> inscription;
}
