package com.clinique.rdv.service;

import com.clinique.rdv.entity.Medecin;
import com.clinique.rdv.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedecinService {

    @Autowired
    private MedecinRepository medecinRepo;

    public Medecin save(Medecin m) {
        return medecinRepo.save(m);
    }

    public List<Medecin> getAll() {
        return medecinRepo.findAll();
    }

    public Medecin getById(Long id) {
        return medecinRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Medecin introuvable"));
    }

    public Medecin update(Long id, Medecin m) {
        Medecin existing = getById(id);

        existing.setNom(m.getNom());
        existing.setSpecialite(m.getSpecialite());

        return medecinRepo.save(existing);
    }

    public void delete(Long id) {
        medecinRepo.deleteById(id);
    }
}