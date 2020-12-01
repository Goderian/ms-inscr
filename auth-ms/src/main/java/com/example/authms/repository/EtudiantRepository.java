package com.example.authms.repository;

import com.example.authms.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
