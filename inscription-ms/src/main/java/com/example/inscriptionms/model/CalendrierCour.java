package com.example.inscriptionms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CalendrierCour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant date_debut;
    private Instant date_fin;
    private Integer volume_horaire;

    @OneToOne(mappedBy = "calendrierCour")
    private Cour cour;

}
