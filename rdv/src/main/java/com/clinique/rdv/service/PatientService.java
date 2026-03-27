package com.clinique.rdv.service;

import com.clinique.rdv.entity.Patient;
import com.clinique.rdv.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepo;

    public Patient save(Patient p) {
        return patientRepo.save(p);
    }

    public List<Patient> getAll() {
        return patientRepo.findAll();
    }

    public Patient getById(Long id) {
        return patientRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient introuvable"));
    }

    public Patient update(Long id, Patient p) {
        Patient existing = getById(id);

        existing.setNom(p.getNom());
        existing.setCin(p.getCin());
        existing.setDateNaissance(p.getDateNaissance());
        existing.setAssurance(p.getAssurance());

        return patientRepo.save(existing);
    }

    public void delete(Long id) {
        patientRepo.deleteById(id);
    }
}