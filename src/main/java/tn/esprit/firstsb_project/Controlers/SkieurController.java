package tn.esprit.firstsb_project.Controlers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstsb_project.Services.ISkieurService;
import tn.esprit.firstsb_project.entities.Abonnement;
import tn.esprit.firstsb_project.entities.Skieur;
import tn.esprit.firstsb_project.entities.TypeAbonnement;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/Skieur")
public class SkieurController {


    private ISkieurService skieurService;


    @PostMapping("/addSkieur")
    public Skieur addSkieur(@RequestBody Skieur sk){
        return skieurService.addSkieur(sk);
    }

    @GetMapping("/get/{id}")
    public Skieur getSkieurbuId(@PathVariable("id") Long id){
        return skieurService.getSkieurbyId(id);
    }

    @GetMapping("/getAll")
    public List<Skieur> skieurList (){
        return  skieurService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id ){
        this.skieurService.deleteSkieur(id);
    }

    @GetMapping("/get/{nom}/{prenom}")
    public Skieur getbyNomAndPrenom(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom){
        return skieurService.getSkieurByNameAndLastName(nom,prenom);
    }

    @GetMapping("/search")
    public Skieur getSkieurByNameAndLastName(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom) {
        return skieurService.getSkieurByNameAndLastName(nom, prenom);
    }

    @PostMapping("/{numCours}")
    @ResponseStatus(HttpStatus.CREATED)
    public Skieur addSkieurAndAssignToCours(@RequestBody Skieur skieur, @PathVariable("numCours") Long numCours) {
        return skieurService.addSkieurAndAssignToCours(skieur, numCours);
    }


    @GetMapping("/type")
    public List<Skieur> retrieveSkieursByTypeAbonnement(@RequestParam("typeAbonnement") TypeAbonnement typeAbonnement) {
        return skieurService.retrieveSkieursByTypeAbonnement(typeAbonnement);
    }

    @GetMapping("/abonnements")
    public Set<Abonnement> getAbonnementByType(@RequestParam("type") TypeAbonnement type) {
        return skieurService.getAbonnementByType(type);
    }

}
