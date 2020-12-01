package com.example.inscriptionms.proxy;


import lombok.*;

import java.time.Instant;

@Setter
@Getter
@ToString
public class Enseignant extends User{
    private Grade grade;

    public Enseignant(Long id, String username, Instant dateNaissance, String nom, String prenom, String email, String password, String tel, boolean activated) {
        super(id, username, dateNaissance, nom, prenom, email, password, tel, activated);
    }
}
