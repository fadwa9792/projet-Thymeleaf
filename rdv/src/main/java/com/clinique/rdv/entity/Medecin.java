package com.clinique.rdv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String specialite;

    @OneToMany(mappedBy = "medecin")
    @JsonIgnore
    private List<RendezVous> rendezVous;
}