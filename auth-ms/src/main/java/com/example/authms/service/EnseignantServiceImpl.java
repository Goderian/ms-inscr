package com.example.authms.service;


import com.example.authms.exception.EnseignantNotFoundException;
import com.example.authms.exception.EtudiantNotFoundException;
import com.example.authms.model.Enseignant;
import com.example.authms.model.Etudiant;
import com.example.authms.repository.EnseignantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class EnseignantServiceImpl implements EnseignantService{

    private final AuthService authService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final EnseignantRepository enseignantRepository;

    public void save(Enseignant enseignant) {
        enseignant.setPassword(bCryptPasswordEncoder.encode(enseignant.getPassword()));
        enseignant.setActivated(true);
        enseignantRepository.save(enseignant);
        System.out.println(enseignant);
        authService.addRoleToUser(enseignant.getUsername(), "ENSEIGNANT");
        authService.addRoleToUser(enseignant.getUsername(), "USER");
    }

    @Transactional(readOnly = true)
    public Enseignant getEnseignant(Long id){

        return enseignantRepository.findById(id)
                .orElseThrow(() -> new EnseignantNotFoundException("enseignant d'ID = " + id + " n'est pas trouvé"));
    }

    @Transactional(readOnly = true)
    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }


    public void delete(Long id) {
        enseignantRepository.deleteById(id);
    }

}
