package com.clinique.rdv.controller;


import com.clinique.rdv.entity.RendezVous;
import com.clinique.rdv.entity.Statut;
import com.clinique.rdv.repository.RendezVousRepository;
import com.clinique.rdv.service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/rdv")
public class RendezVousController {

    @Autowired
    private RendezVousService service;
    @Autowired
    private RendezVousRepository rdvRepo;
    @PostMapping("/create/{patientId}/{medecinId}")
    public RendezVous create(@PathVariable Long patientId,
                             @PathVariable Long medecinId,
                             @RequestBody RendezVous rdv) {
        return service.create(patientId, medecinId, rdv);
    }

    @PutMapping("/annuler/{id}")
    public RendezVous annuler(@PathVariable Long id) {
        return service.annuler(id);
    }

    @PutMapping("/valider/{id}")
    public RendezVous valider(@PathVariable Long id) {
        return service.valider(id);
    }
    @GetMapping("/specialite/{specialite}")
    public List<RendezVous> getBySpecialite(@PathVariable String specialite) {
        return rdvRepo.findByMedecinSpecialite(specialite);
    }
    @GetMapping("/statut/{statut}")
    public List<RendezVous> getByStatut(@PathVariable Statut statut) {
        return rdvRepo.findByStatut(statut);
    }
    @GetMapping("/date")
    public List<RendezVous> getByDate(
            @RequestParam LocalDateTime d1,
            @RequestParam LocalDateTime d2) {

        return rdvRepo.findByDateHeureBetween(d1, d2);
    }
    @GetMapping("/stats/specialite")
    public List<Object[]> statsSpecialite() {
        return service.getStatsBySpecialite();
    }
    @GetMapping("/stats/noshow")
    public double getNoShow() {
        return service.tauxNoShow();
    }
    @GetMapping("/stats/mois")
    public List<Object[]> statsMois() {
        return service.statsParMois();
    }
    @GetMapping("/medecin/{id}")
    public List<RendezVous> getByMedecin(@PathVariable Long id) {
        return service.getByMedecin(id);
    }
    @PutMapping("/absent/{id}")
    public RendezVous absent(@PathVariable Long id) {
        return service.absent(id);
    }

}
