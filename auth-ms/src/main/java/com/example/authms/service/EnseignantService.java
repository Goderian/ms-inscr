package com.example.authms.service;

import com.example.authms.model.Enseignant;

import java.util.List;

public interface EnseignantService {

    void save(Enseignant enseignant);

    List<Enseignant> getAllEnseignants();

    Enseignant getEnseignant(Long id);

    void delete(Long id);
}
