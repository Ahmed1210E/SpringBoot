package tn.esprit.firstsb_project.Services;

import org.springframework.stereotype.Service;
import tn.esprit.firstsb_project.entities.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public interface ISkieurService {

    public Skieur addSkieur(Skieur skieur);

    public List<Skieur> getAll();

    public  Skieur getSkieurbyId(Long id);

    public void deleteSkieur(Long id);

    public  Skieur updateSkieur(Long id);

    public Skieur  getSkieurByNameAndLastName(String nom, String prenom);

    Skieur addSkieurAndAssignToCours(Skieur skieur, Long numCours);

    List<Skieur> retrieveSkieursByTypeAbonnement(TypeAbonnement typeAbonnement);

    Set<Abonnement> getAbonnementByType(TypeAbonnement type);

    List<Abonnement> retrieveAbonnementsByDates(LocalDate startDate, LocalDate endDate);

    Inscription addInscriptionAndAssignToSkieurAndCours(Inscription inscription, Long numSkieur, Long numCours);

    List<Integer> numWeeksCourseOfMoniteurBySupport(Long numMoniteur, Support support);
}
