package com.clinique.rdv.repository;

import com.clinique.rdv.entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {}
