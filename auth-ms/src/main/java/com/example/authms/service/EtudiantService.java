package com.example.authms.service;


import com.example.authms.model.Etudiant;

import java.util.List;

public interface EtudiantService {

    void save(Etudiant etudiant);

    List<Etudiant> getAllEtudiants();

    Etudiant getEtudiant(Long id);
}
