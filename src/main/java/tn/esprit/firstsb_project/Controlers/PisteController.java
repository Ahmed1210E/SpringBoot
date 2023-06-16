package tn.esprit.firstsb_project.Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstsb_project.Services.IPisteService;
import tn.esprit.firstsb_project.entities.Piste;
import tn.esprit.firstsb_project.entities.Skieur;

import java.util.List;

@RestController
@RequestMapping("/piste")
public class PisteController {

    @Autowired
    IPisteService pisteService;

    @PostMapping
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.add(piste);
    }

    @GetMapping
    public List<Piste> getAllPistes() {
        return pisteService.getAll();
    }

    @GetMapping("/{id}")
    public Piste getPisteById(@PathVariable("id") Long id) {
        return pisteService.getPistebyId(id);
    }

    @DeleteMapping("/{id}")
    public void deletePiste(@PathVariable("id") Long id) {
        pisteService.deletePiste(id);
    }

    @PutMapping("/{id}")
    public Piste updatePiste(@PathVariable("id") Long id) {
        return pisteService.updatePiste(id);
    }

    @PostMapping("/{numSkieur}/{numPiste}")
    public Skieur assignSkieurToPiste(@PathVariable("numSkieur") Long numSkieur, @PathVariable("numPiste") Long numPiste) {
        return pisteService.assignSkierToPiste(numSkieur, numPiste);
    }
}
