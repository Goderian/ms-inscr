package com.example.authms.model;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.Collection;

@Entity
@DiscriminatorValue("ENSEIGNANT")
@Setter @Getter @ToString
public class Enseignant extends User{
    private Grade grade;

    public Enseignant() {
    }

    public Enseignant(Long id, @NotEmpty String username, Grade grade, Instant dateNaissance, @NotEmpty String nom, @NotEmpty String prenom, String email, String password, String tel,boolean activated, Collection<Role> roles) {
        super(id, username, dateNaissance, nom, prenom, email, password, tel, activated, roles);
        this.grade = grade;
    }
}
