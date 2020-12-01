package com.example.inscriptionms.service;

import com.example.inscriptionms.dto.InscriptionDto;
import com.example.inscriptionms.exception.CourNotFoundException;
import com.example.inscriptionms.mapper.InscriptionMapper;
import com.example.inscriptionms.model.Cour;
import com.example.inscriptionms.model.Inscription;
import com.example.inscriptionms.repository.CourRepository;
import com.example.inscriptionms.repository.InscriptionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class InscriptionServiceImpl implements InscriptionService {

    private final InscriptionRepository inscriptionRepository;
    private final InscriptionMapper inscriptionMapper;
    private final CourRepository courRepository;

    public void save(InscriptionDto inscriptionDto) {
        System.out.println(inscriptionDto.getCourName());
        Cour cour = courRepository.findByNomCour(inscriptionDto.getCourName());
//        System.out.println(cour);
        if (cour == null) throw new
                CourNotFoundException("the course that you want to subscribe to do not exist!");
        Inscription inscription = inscriptionMapper.map(inscriptionDto, cour);
        System.out.println(inscription.getDateFinInscription());
        inscriptionRepository.save(inscription);
    }

    @Override
    public void deleteInscription(Long id, String username) {
        Inscription inscription = inscriptionRepository.findByEtudiantUNAndCourId(username, id);
//        System.out.println(inscription);
        inscriptionRepository.deleteById(inscription.getId());
    }




}
