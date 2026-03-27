package com.clinique.rdv.repository;

import com.clinique.rdv.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {}

