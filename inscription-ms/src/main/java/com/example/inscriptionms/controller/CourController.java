package com.example.inscriptionms.controller;

import com.example.inscriptionms.dto.CourDto;
import com.example.inscriptionms.repository.InscriptionRepository;
import com.example.inscriptionms.service.CourService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;


@RestController
@AllArgsConstructor
@RequestMapping("/api/cours")
public class CourController {

    private final CourService courService;


    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CourDto courDto){
        courService.save(courDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourDto>> getAllCours() {
        return status(HttpStatus.OK).body(courService.getAllCours());
    }

    @GetMapping("srch/{keyword}")
    public ResponseEntity<List<CourDto>> getAllCoursContainKeyword(@PathVariable String keyword) {
        return status(HttpStatus.OK).body(courService.getAllCoursContains(keyword));
    }


    @GetMapping("by-category/{type}")
    public ResponseEntity<List<CourDto>> getCoursByCategoryName(@PathVariable String type) {
        return status(HttpStatus.OK).body(courService.getCourByCategoryName(type));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourDto> getCourById(@PathVariable Long id) {
        return status(HttpStatus.OK).body(courService.getCour(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCour(@PathVariable Long id) {
        courService.deleteCour(id);
        return status(HttpStatus.OK).body("Course has been deleted!");
    }

    @GetMapping("/cour-etudiant/{username}")
    public ResponseEntity<List<CourDto>> getCourByEtudiant(@PathVariable String username) {
        return status(HttpStatus.OK).body(courService.getCourByEtudiant(username));
    }



}
