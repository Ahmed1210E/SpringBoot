package tn.esprit.firstsb_project.Services;

import tn.esprit.firstsb_project.entities.Cours;

import java.util.List;

public interface ICoursService {
    Cours add(Cours cours);

    List<Cours> getAll();

    Cours getCoursbyId(Long id);

    void deleteCours(Long id);

    Cours updateCours(Long id);
}
