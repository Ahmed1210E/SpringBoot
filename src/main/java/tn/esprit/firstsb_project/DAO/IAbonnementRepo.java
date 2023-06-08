package tn.esprit.firstsb_project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.firstsb_project.entities.Abonnement;
import tn.esprit.firstsb_project.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAbonnementRepo extends JpaRepository<Abonnement,Long> {


    @Query("select a from Abonnement a where a.typeAbon= :typeA order by a.dateDebut")
    List<Abonnement> abonnementList(@Param("typeA")TypeAbonnement typeAbonnement);

    List<Abonnement> findByDateDebutBetween(LocalDate dateD,LocalDate dateF);


}
