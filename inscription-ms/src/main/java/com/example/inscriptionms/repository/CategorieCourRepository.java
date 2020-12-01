package com.example.inscriptionms.repository;

import com.example.inscriptionms.model.CategorieCour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface CategorieCourRepository extends JpaRepository<CategorieCour, Long> {

    Optional<CategorieCour> findByType(String type);
}
