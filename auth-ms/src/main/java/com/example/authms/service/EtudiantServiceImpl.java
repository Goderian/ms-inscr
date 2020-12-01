package com.example.authms.service;

import com.example.authms.exception.EtudiantNotFoundException;
import com.example.authms.model.Etudiant;
import com.example.authms.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.support.CompositeUriComponentsContributor;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class EtudiantServiceImpl implements EtudiantService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final EtudiantRepository etudiantRepository;
    private final AuthService authService;

    public void save(Etudiant etudiant) {
        etudiant.setPassword(bCryptPasswordEncoder.encode(etudiant.getPassword()));
        etudiant.setActivated(true);
        etudiantRepository.save(etudiant);
        authService.addRoleToUser(etudiant.getUsername(), "ETUDIANT");
        authService.addRoleToUser(etudiant.getUsername(), "USER");
    }

    @Transactional(readOnly = true)
    public Etudiant getEtudiant(Long id){

        return etudiantRepository.findById(id)
                .orElseThrow(() -> new EtudiantNotFoundException("etudiant d'ID = " + id + " n'est pas trouvé"));
    }

    @Transactional(readOnly = true)
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }


}
