package com.example.inscriptionms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant dateFinInscription;
    private Instant dateInscription;
    private boolean valide;

    @ManyToOne
    @JoinColumn(name = "cour_id")
    private Cour cour;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String etudiantUN;
}
