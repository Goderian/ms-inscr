package com.example.inscriptionms.controller;

import com.example.inscriptionms.dto.InscriptionDto;
import com.example.inscriptionms.service.InscriptionService;
import feign.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.status;

@RestController
@AllArgsConstructor
@RequestMapping("/api/inscriptions")
public class InscriptionController {

    private final InscriptionService inscriptionService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody InscriptionDto inscriptionDto) {
        System.out.println(inscriptionDto);
        inscriptionService.save(inscriptionDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}/{username}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id,
                                         @PathVariable(name = "username") String username) {
        System.out.println("heroro");
        inscriptionService.deleteInscription(id, username);
        return status(HttpStatus.OK).body("inscription supprimer");
    }
}
