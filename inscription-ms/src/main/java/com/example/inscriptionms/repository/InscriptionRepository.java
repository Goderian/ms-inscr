package com.example.inscriptionms.repository;


import com.example.inscriptionms.model.Cour;
import com.example.inscriptionms.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    List<Inscription> findByEtudiantUN(String username);

    Inscription findByEtudiantUNAndCourId(String username, Long id);

}
