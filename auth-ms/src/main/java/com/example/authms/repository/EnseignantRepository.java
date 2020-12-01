package com.example.authms.repository;

import com.example.authms.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
}
