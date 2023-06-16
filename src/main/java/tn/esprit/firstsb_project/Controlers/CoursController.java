package tn.esprit.firstsb_project.Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstsb_project.Services.ICoursService;
import tn.esprit.firstsb_project.entities.Cours;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {

    @Autowired
    ICoursService coursService;

    @PostMapping
    public Cours addCours(@RequestBody Cours cours) {
        return coursService.add(cours);
    }

    @GetMapping
    public List<Cours> getAllCours() {
        return coursService.getAll();
    }

    @GetMapping("/{id}")
    public Cours getCoursById(@PathVariable("id") Long id) {
        return coursService.getCoursbyId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCours(@PathVariable("id") Long id) {
        coursService.deleteCours(id);
    }

    @PutMapping("/{id}")
    public Cours updateCours(@PathVariable("id") Long id) {
        return coursService.updateCours(id);
    }
}
