package com.example.inscriptionms.repository;

import com.example.inscriptionms.model.CalendrierCour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CalendrierCourRepository extends JpaRepository<CalendrierCour, Long> {
}
