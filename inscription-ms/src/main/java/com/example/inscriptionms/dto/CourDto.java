package com.example.inscriptionms.dto;

import com.example.inscriptionms.model.CalendrierCour;
import com.example.inscriptionms.model.CategorieCour;
import com.example.inscriptionms.model.Difficulte;
import com.example.inscriptionms.model.Inscription;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourDto {

    private Long id;
    private String description;
    private String difficulte;
    private String nomCour;
    private Integer note;
    private Long enseignantID;
    private String img;
    private String nomEnseignant;
    private String categorieCour;
    private Long idInscription;
}
