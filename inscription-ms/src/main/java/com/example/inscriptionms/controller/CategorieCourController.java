package com.example.inscriptionms.controller;

import com.example.inscriptionms.model.CategorieCour;
import com.example.inscriptionms.service.CategorieCourService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategorieCourController {
    private final CategorieCourService categorieCourService;

    public ResponseEntity<Void> create(@RequestBody CategorieCour categorieCour) {
        categorieCourService.save(categorieCour);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategorieCour>> getAllCategories() {
        return status(HttpStatus.OK).body(categorieCourService.getAllCategories());
    }

}
