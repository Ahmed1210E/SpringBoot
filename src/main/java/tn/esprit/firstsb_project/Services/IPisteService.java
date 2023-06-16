package tn.esprit.firstsb_project.Services;

import tn.esprit.firstsb_project.entities.Piste;
import tn.esprit.firstsb_project.entities.Skieur;

import java.util.List;

public interface IPisteService {
    Piste add(Piste piste);

    List<Piste> getAll();

    Piste getPistebyId(Long id);

    void deletePiste(Long id);

    Piste updatePiste(Long id);

    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);
}
