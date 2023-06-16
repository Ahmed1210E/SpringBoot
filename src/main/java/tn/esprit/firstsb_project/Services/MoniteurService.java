package tn.esprit.firstsb_project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstsb_project.DAO.ICoursRepo;
import tn.esprit.firstsb_project.DAO.IMoniteurRepo;
import tn.esprit.firstsb_project.entities.Cours;
import tn.esprit.firstsb_project.entities.Moniteur;

import java.util.List;
import java.util.Optional;

@Service
public class MoniteurService implements IMoniteurService{

    @Autowired
    IMoniteurRepo moniteurRepo;

    @Autowired
    ICoursRepo coursRepo;


    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {

        return moniteurRepo.save(moniteur);
    }

    @Override
    public List<Moniteur> getAll() {
        return moniteurRepo.findAll();
    }

    @Override
    public Moniteur getMoniteurbyId(Long id) {
        return moniteurRepo.findById(id).get(); //orElseNull
    }

    @Override
    public void deleteMoniteur(Long id) {
        moniteurRepo.deleteById(id);
    }

    @Override
    public Moniteur updateMoniteur(Long id) {
        Moniteur mn= moniteurRepo.findById(id).get();
        return moniteurRepo.save(mn);
    }


    @Override
    public Moniteur addMoniteurAndAssignToCours(Moniteur moniteur, Long numCours) {
        Optional<Cours> coursOptional = coursRepo.findById(numCours);


            Cours cours = coursOptional.get();
            moniteur.getCours().add(cours);
            moniteurRepo.save(moniteur);
            coursRepo.save(cours);
            return moniteur;

    }
}
