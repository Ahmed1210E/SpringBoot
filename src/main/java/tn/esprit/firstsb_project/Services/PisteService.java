package tn.esprit.firstsb_project.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstsb_project.DAO.IPisteRepo;
import tn.esprit.firstsb_project.DAO.ISkieurRepo;
import tn.esprit.firstsb_project.entities.Piste;
import tn.esprit.firstsb_project.entities.Skieur;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class PisteService implements IPisteService{

    @Autowired
    ISkieurRepo skieurRepo;

    @Autowired
    IPisteRepo pisteRepo;



    @Override
    public Piste add(Piste piste) {

        return pisteRepo.save(piste);
    }

    @Override
    public List<Piste> getAll() {
        return pisteRepo.findAll();
    }

    @Override
    public Piste getPistebyId(Long id) {
        return pisteRepo.findById(id).get(); //orElseNull
    }

    @Override
    public void deletePiste(Long id) {
        pisteRepo.deleteById(id);
    }

    @Override
    public Piste updatePiste(Long id) {
        Piste sk= pisteRepo.findById(id).get();
        return pisteRepo.save(sk);
    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        Optional<Skieur> skieurOptional = skieurRepo.findById(numSkieur);
        Optional<Piste> pisteOptional = pisteRepo.findById(numPiste);


            Skieur skieur = skieurOptional.get();
            Piste piste = pisteOptional.get();
            skieur.getPiste().add(piste);
            piste.getSkieur().add(skieur);
            skieurRepo.save(skieur);
            pisteRepo.save(piste);
            return skieur;

    }


}
