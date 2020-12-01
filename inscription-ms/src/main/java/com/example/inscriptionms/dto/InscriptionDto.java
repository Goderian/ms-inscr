package com.example.inscriptionms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InscriptionDto {

    private Long id;
    private Instant dateFinInscription;
    private Instant dateInscription;
    private boolean valide;
    private String courName;
    private String etudiantUN;

}
