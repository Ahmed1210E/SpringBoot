package tn.esprit.firstsb_project.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstsb_project.DAO.ISkieurRepo;
import tn.esprit.firstsb_project.entities.Skieur;

import java.util.List;

@AllArgsConstructor
@Service
public class SkieurServiceImpl implements ISkieurService{


    private ISkieurRepo iskieurRepo;



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

}
