package tn.esprit.firstsb_project.Controlers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstsb_project.Services.ISkieurService;
import tn.esprit.firstsb_project.entities.Skieur;

import java.util.List;

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
}
