package com.clinique.rdv.service;

import com.clinique.rdv.entity.Medecin;
import com.clinique.rdv.entity.Patient;
import com.clinique.rdv.entity.RendezVous;
import com.clinique.rdv.entity.Statut;
import com.clinique.rdv.repository.MedecinRepository;
import com.clinique.rdv.repository.PatientRepository;
import com.clinique.rdv.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousService {

    @Autowired
    private RendezVousRepository rdvRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private MedecinRepository medecinRepo;

    public RendezVous create(Long patientId, Long medecinId, RendezVous rdv) {

        Patient p = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient introuvable"));

        Medecin m = medecinRepo.findById(medecinId)
                .orElseThrow(() -> new RuntimeException("Medecin introuvable"));

        rdv.setPatient(p);
        rdv.setMedecin(m);
        rdv.setStatut(Statut.CONFIRME);

        return rdvRepo.save(rdv);
    }

    public RendezVous annuler(Long id) {
        RendezVous rdv = rdvRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("RDV introuvable"));

        rdv.setStatut(Statut.ANNULE);
        return rdvRepo.save(rdv);
    }

    public RendezVous valider(Long id) {
        RendezVous rdv = rdvRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("RDV introuvable"));

        rdv.setStatut(Statut.CONFIRME);
        return rdvRepo.save(rdv);

    }
    public List<Object[]> getStatsBySpecialite() {
        return rdvRepo.countBySpecialite();
    }
    public double tauxNoShow() {

        long total = rdvRepo.count();

        long absent = rdvRepo.findByStatut(Statut.ABSENT).size();

        if (total == 0) return 0;

        return (double) absent / total * 100;
    }
    public List<Object[]> statsParMois() {
        return rdvRepo.countByMonth();
    }
    public List<RendezVous> getByMedecin(Long medecinId) {
        return rdvRepo.findByMedecinId(medecinId);
    }
    public RendezVous absent(Long id) {
        RendezVous rdv = rdvRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("RDV non trouvé"));

        rdv.setStatut(Statut.ABSENT);
        return rdvRepo.save(rdv);
    }

}