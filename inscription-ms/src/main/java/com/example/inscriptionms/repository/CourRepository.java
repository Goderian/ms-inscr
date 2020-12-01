package com.example.inscriptionms.repository;

import com.example.inscriptionms.model.Cour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CourRepository extends JpaRepository<Cour, Long> {
    Cour findByNomCour(String nomCour);

    List<Cour> findAllByCategorieCourType(String type);
    List<Cour> findByNomCourContainingIgnoreCase(String keyword);


}
