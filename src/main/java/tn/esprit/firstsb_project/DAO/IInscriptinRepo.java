package tn.esprit.firstsb_project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.firstsb_project.entities.Inscription;
import tn.esprit.firstsb_project.entities.Support;

import java.util.List;

@Repository
public interface IInscriptinRepo  extends JpaRepository<Inscription,Long> {

    @Query("SELECT i.numSemaine FROM Inscription i, Moniteur m "
            + "WHERE m.numMoniteur = :numMonitor "
            + "AND i.cours.support = :support "
            + "AND i.cours IN (SELECT c FROM Moniteur mon JOIN mon.cours c WHERE mon.numMoniteur = :numMonitor)")
    List<Integer> numSemaineOfMonitorBySupport(@Param("support") Support support, @Param("numMonitor") Long numMonitor);

}