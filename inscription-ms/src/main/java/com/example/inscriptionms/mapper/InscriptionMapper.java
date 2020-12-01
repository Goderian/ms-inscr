package com.example.inscriptionms.mapper;

import com.example.inscriptionms.dto.InscriptionDto;
import com.example.inscriptionms.model.Cour;
import com.example.inscriptionms.model.Inscription;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.Period;

@Component
public class InscriptionMapper {

    public InscriptionDto mapToDto(Inscription inscription) {
        if (inscription == null) return null;

        return InscriptionDto.builder()
                .courName(inscription.getCour().getNomCour())
                .dateInscription(inscription.getDateInscription())
                .dateFinInscription(inscription.getDateFinInscription())
                .etudiantUN(inscription.getEtudiantUN())
                .valide(inscription.isValide())
                .build();
    }

    public Inscription map(InscriptionDto inscriptionDto, Cour cour) {
        if (inscriptionDto == null) return null;

        return Inscription.builder()
                .dateFinInscription(inscriptionDto.getDateInscription().plus(Period.ofDays(365)))
                .dateInscription(inscriptionDto.getDateInscription())
                .cour(cour)
                .etudiantUN(inscriptionDto.getEtudiantUN())
                .valide(true)
                .build();
    }
}
