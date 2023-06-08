package tn.esprit.firstsb_project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstsb_project.entities.Moniteur;

@Repository
public interface IMoniteurRepo extends JpaRepository<Moniteur,Long> {
}
