package com.example.inscriptionms.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@AllArgsConstructor
@ToString
public class User  {
    private Long id;
    private String username;
    private Instant dateNaissance;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String tel;
    private boolean activated;

}
