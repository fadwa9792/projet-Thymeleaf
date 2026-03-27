package com.clinique.rdv.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateHeure;
    private String motif;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Medecin medecin;
}