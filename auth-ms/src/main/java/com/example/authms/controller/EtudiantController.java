package com.example.authms.controller;


import com.example.authms.model.Etudiant;
import com.example.authms.service.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/etudiants")
@AllArgsConstructor
@CrossOrigin("*")
public class EtudiantController {

        private final EtudiantService etudiantService;

        @PostMapping("/signup")
        public ResponseEntity<Void> createEtudiant(@RequestBody Etudiant etudiant) {
            etudiantService.save(etudiant);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @GetMapping
        public ResponseEntity<List<Etudiant>> getAllEtudiants() {
            return status(HttpStatus.OK).body(etudiantService.getAllEtudiants());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Etudiant> getEtudiant(@PathVariable Long id) {
            return status(HttpStatus.OK).body(etudiantService.getEtudiant(id));
        }
}
