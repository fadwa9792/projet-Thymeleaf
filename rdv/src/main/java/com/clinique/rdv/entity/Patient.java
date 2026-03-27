package com.clinique.rdv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String cin;
    private LocalDate dateNaissance;
    private String assurance;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<RendezVous> rendezVous;
}