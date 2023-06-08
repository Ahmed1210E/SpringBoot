package tn.esprit.firstsb_project.Services;

import org.springframework.stereotype.Service;
import tn.esprit.firstsb_project.entities.Skieur;

import java.util.List;


public interface ISkieurService {

    public Skieur addSkieur(Skieur skieur);

    public List<Skieur> getAll();

    public  Skieur getSkieurbyId(Long id);

    public void deleteSkieur(Long id);

    public  Skieur updateSkieur(Long id);

    public Skieur  getSkieurByNameAndLastName(String nom, String prenom);
}
