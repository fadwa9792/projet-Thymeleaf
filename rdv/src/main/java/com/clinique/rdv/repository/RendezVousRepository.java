package com.clinique.rdv.repository;

import com.clinique.rdv.entity.RendezVous;
import com.clinique.rdv.entity.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

    List<RendezVous> findByStatut(Statut statut);

    List<RendezVous> findByMedecinId(Long id);

    List<RendezVous> findByMedecinSpecialite(String specialite);

    @Query("SELECT r.medecin.specialite, COUNT(r) FROM RendezVous r GROUP BY r.medecin.specialite")
    List<Object[]> countBySpecialite();
    List<RendezVous> findByDateHeureBetween(LocalDateTime d1, LocalDateTime d2);
    @Query("SELECT MONTH(r.dateHeure), COUNT(r) FROM RendezVous r GROUP BY MONTH(r.dateHeure)")
    List<Object[]> countByMonth();

}