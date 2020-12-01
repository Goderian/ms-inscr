package com.example.inscriptionms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Cour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "entrer une description!")
    private String description;
    private Difficulte difficulte;
    @NotEmpty(message = "entrer un nom pour le cour!")
    @Column(unique = true)
    private String nomCour;
    private Integer note;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long enseignantID;

    @OneToMany(mappedBy = "cour")
    private List<Inscription> inscriptions;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private CategorieCour categorieCour;

    @OneToOne
    private CalendrierCour calendrierCour;


    private String img;
}
