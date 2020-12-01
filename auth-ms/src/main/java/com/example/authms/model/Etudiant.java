package com.example.authms.model;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.Collection;

@Entity
@DiscriminatorValue("ETUDIANT")
@Setter @Getter @ToString
public class Etudiant extends User{

    public Etudiant() {
    }

    public Etudiant(Long id, @NotEmpty String username, Instant dateNaissance, @NotEmpty String nom, @NotEmpty String prenom, String email, String password, String tel, boolean activated, Collection<Role> roles) {
        super(id, username, dateNaissance, nom, prenom, email, password, tel, activated, roles);
    }
}
