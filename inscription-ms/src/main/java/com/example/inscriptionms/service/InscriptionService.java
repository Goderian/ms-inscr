package com.example.inscriptionms.service;


import com.example.inscriptionms.dto.InscriptionDto;

public interface InscriptionService {

    public void save(InscriptionDto inscriptionDto);

    public void deleteInscription(Long id, String username);
}
