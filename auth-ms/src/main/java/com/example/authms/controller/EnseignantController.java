package com.example.authms.controller;

import com.example.authms.model.Enseignant;
import com.example.authms.model.Etudiant;
import com.example.authms.service.EnseignantService;
import com.example.authms.service.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;


@RestController
@RequestMapping("/api/enseignants")
@AllArgsConstructor
//@CrossOrigin("*")
public class EnseignantController {

    private final EnseignantService enseignantService;

    @PostMapping("/signup")
    public ResponseEntity<Void> createEnseignant(@RequestBody Enseignant enseignant) {

        enseignantService.save(enseignant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Enseignant>> getAllEnseignants() {
        return status(HttpStatus.OK).body(enseignantService.getAllEnseignants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enseignant> getEnseignant(@PathVariable Long id) {
        return status(HttpStatus.OK).body(enseignantService.getEnseignant(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnseignant(@PathVariable Long id) {
        enseignantService.delete(id);
        return new ResponseEntity<>("Enseignant est supprimer!", HttpStatus.OK);
    }

}
