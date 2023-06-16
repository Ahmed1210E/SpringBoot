package tn.esprit.firstsb_project.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.firstsb_project.DAO.*;
import tn.esprit.firstsb_project.entities.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class SkieurServiceImpl implements ISkieurService{


    private ISkieurRepo iskieurRepo;
    private IInscriptinRepo inscriptinRepo;
    private ICoursRepo coursRepo;
    private IAbonnementRepo abonnementRepo;

    private IMoniteurRepo moniteurRepo;


    @Override
    public Skieur addSkieur(Skieur skieur) {

        return iskieurRepo.save(skieur);
    }

    @Override
    public List<Skieur> getAll() {
        return iskieurRepo.findAll();
    }

    @Override
    public Skieur getSkieurbyId(Long id) {
        return iskieurRepo.findById(id).get(); //orElseNull
    }

    @Override
    public void deleteSkieur(Long id) {
        iskieurRepo.deleteById(id);
    }

    @Override
    public Skieur updateSkieur(Long id) {
      Skieur sk= iskieurRepo.findById(id).get();
      return iskieurRepo.save(sk);
    }

    @Override
    public Skieur getSkieurByNameAndLastName(String nom, String prenom) {
        return iskieurRepo.findByNomSAndPrenomS(nom,prenom);
    }


    @Override
    public Skieur addSkieurAndAssignToCours(Skieur skieur, Long numCours) {
        Cours cours = coursRepo.findById(numCours).orElse(null);


            Abonnement abonnement = skieur.getAbonnement();
            abonnement.setDateDebut(LocalDate.now());
            abonnement.setDateFin(LocalDate.now().plusMonths(6));

            Inscription inscription = new Inscription();
            inscription.setCours(cours);
            inscription.setSkieur(skieur);

            skieur.setAbonnement(abonnement);
            skieur.getInscription().add(inscription);

            iskieurRepo.save(skieur);
            abonnementRepo.save(abonnement);
            inscriptinRepo.save(inscription);

            return skieur;


    }


    @Override
    public List<Skieur> retrieveSkieursByTypeAbonnement(TypeAbonnement typeAbonnement) {
        return iskieurRepo.findByAbonnement_TypeAbonnement(typeAbonnement);
    }


    @Override
    public Set<Abonnement> getAbonnementByType(TypeAbonnement type) {
        List<Abonnement> abonnements = abonnementRepo.findByTypeAbonnement(type);
        return abonnements.stream()
                .sorted(Comparator.comparing(Abonnement::getDateDebut))
                .collect(Collectors.toSet());
    }

    @Override
    public List<Abonnement> retrieveAbonnementsByDates(LocalDate startDate, LocalDate endDate) {
        return abonnementRepo.findByDateDebutBetween(startDate, endDate);
    }

    @Override
    public Inscription addInscriptionAndAssignToSkieurAndCours(Inscription inscription, Long numSkieur, Long numCours) {
        Skieur skieur = iskieurRepo.findById(numSkieur).orElse(null);
        Cours cours = coursRepo.findById(numCours).orElse(null);

        if (skieur != null && cours != null) {
            inscription.setSkieur(skieur);
            inscription.setCours(cours);
            skieur.getInscription().add(inscription);
            cours.getInscription().add(inscription);

            iskieurRepo.save(skieur);
            coursRepo.save(cours);
            inscriptinRepo.save(inscription);

            return inscription;
        }

        return null;
    }

    @Override
    public List<Integer> numWeeksCourseOfMoniteurBySupport(Long numMoniteur, Support support) {
        Moniteur moniteur = moniteurRepo.findById(numMoniteur).orElse(null);

        if (moniteur != null) {
            Set<Integer> numWeeks = new HashSet<>();

            List<Cours> coursList = moniteur.getCours().stream()
                    .filter(c -> c.getSupport() == support)
                    .collect(Collectors.toList());

            for (Cours cours : coursList) {
                for (Inscription inscription : cours.getInscription()) {
                    numWeeks.add(inscription.getNumSemaine());
                }
            }

            return numWeeks.stream().sorted().collect(Collectors.toList());
        }

        return null;
    }
}
