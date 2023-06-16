package tn.esprit.firstsb_project.Services;

import tn.esprit.firstsb_project.entities.Moniteur;

import java.util.List;

public interface IMoniteurService {


    Moniteur addMoniteur(Moniteur moniteur);

    List<Moniteur> getAll();

    Moniteur getMoniteurbyId(Long id);

    void deleteMoniteur(Long id);

    Moniteur updateMoniteur(Long id);

    Moniteur addMoniteurAndAssignToCours(Moniteur moniteur, Long numCours);
}
