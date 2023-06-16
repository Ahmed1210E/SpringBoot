package tn.esprit.firstsb_project.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.firstsb_project.DAO.ICoursRepo;
import tn.esprit.firstsb_project.entities.Cours;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class CoursService implements ICoursService{



    private ICoursRepo coursRepo;


    @Override
    public Cours add(Cours cours) {

        return coursRepo.save(cours);
    }

    @Override
    public List<Cours> getAll() {
        return coursRepo.findAll();
    }

    @Override
    public Cours getCoursbyId(Long id) {
        return coursRepo.findById(id).get(); //orElseNull
    }

    @Override
    public void deleteCours(Long id) {
        coursRepo.deleteById(id);
    }

    @Override
    public Cours updateCours(Long id) {
        Cours ck= coursRepo.findById(id).get();
        return coursRepo.save(ck);
    }
}
