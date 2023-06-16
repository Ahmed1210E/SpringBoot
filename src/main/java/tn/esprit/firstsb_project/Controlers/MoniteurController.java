package tn.esprit.firstsb_project.Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstsb_project.Services.IMoniteurService;
import tn.esprit.firstsb_project.entities.Moniteur;

import java.util.List;

@RestController
@RequestMapping("/moniteur")
public class MoniteurController {

    @Autowired
    IMoniteurService moniteurService;

    @PostMapping
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.addMoniteur(moniteur);
    }

    @GetMapping
    public List<Moniteur> getAllMoniteurs() {
        return moniteurService.getAll();
    }

    @GetMapping("/{id}")
    public Moniteur getMoniteurById(@PathVariable("id") Long id) {
        return moniteurService.getMoniteurbyId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMoniteur(@PathVariable("id") Long id) {
        moniteurService.deleteMoniteur(id);
    }

    @PutMapping("/{id}")
    public Moniteur updateMoniteur(@PathVariable("id") Long id) {
        return moniteurService.updateMoniteur(id);
    }

    @PostMapping("/{numCours}")
    public Moniteur addMoniteurAndAssignToCours(@RequestBody Moniteur moniteur, @PathVariable("numCours") Long numCours) {
        return moniteurService.addMoniteurAndAssignToCours(moniteur, numCours);
    }
}
