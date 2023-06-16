package tn.esprit.firstsb_project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.firstsb_project.entities.Skieur;
import tn.esprit.firstsb_project.entities.TypeAbonnement;

import java.util.Date;
import java.util.List;

@Repository
public interface ISkieurRepo extends JpaRepository<Skieur,Long> {

    public Skieur findByNomSAndPrenomS(String nom, String prenom);

    public List<Skieur> findByDateNaissanceGreaterThan(Date dateNaiss);


    public Skieur findByNomSAndPrenomSAndDateNaissance(String nom, String prenom,Date dateNaiss);



    @Query("select s from Skieur s where s.nomS= :nom and s.prenomS =:prenom")
    public Skieur getSkieurByNomSAndPrenomS(@Param("nom") String nom, @Param("prenom")String prenom);

    List<Skieur> findByAbonnement_TypeAbonnement(TypeAbonnement typeAbonnement);




}
