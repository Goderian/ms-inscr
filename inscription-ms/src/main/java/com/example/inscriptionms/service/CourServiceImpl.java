package com.example.inscriptionms.service;

import com.example.inscriptionms.dto.CourDto;
import com.example.inscriptionms.exception.CategorieNotFoundException;
import com.example.inscriptionms.exception.CourNotFoundException;
import com.example.inscriptionms.mapper.CourMapper;
import com.example.inscriptionms.model.CategorieCour;
import com.example.inscriptionms.model.Cour;
import com.example.inscriptionms.model.Difficulte;
import com.example.inscriptionms.model.Inscription;
import com.example.inscriptionms.repository.CategorieCourRepository;
import com.example.inscriptionms.repository.CourRepository;
import com.example.inscriptionms.repository.InscriptionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CourServiceImpl implements CourService{

    private final CourRepository courRepository;
    private final CategorieCourRepository categorieCourRepository;
    private final CourMapper courMapper;
    private final InscriptionRepository inscriptionRepository;

    public void save(CourDto courDto){
        CategorieCour categorieCour = categorieCourRepository.findByType(courDto.getCategorieCour())
                .orElseThrow(() -> new CategorieNotFoundException("This category does not exist"));
        Difficulte difficulte = Difficulte.valueOf(courDto.getDifficulte());

        Cour cour = courMapper.map(courDto, difficulte, categorieCour);

        courRepository.save(cour);
    }

    public CourDto getCour(Long id) {
        Cour cour = courRepository.findById(id)
                .orElseThrow(() -> new CourNotFoundException("The course with ID: " + id + " does not exist"));

        return courMapper.mapToDto(cour);
    }

    public List<CourDto> getCourByCategoryName(String categorie) {
        return courRepository.findAllByCategorieCourType(categorie)
                .stream()
                .map(courMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<CourDto> getAllCours() {
        return courRepository.findAll()
                .stream()
                .map(courMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<CourDto> getAllCoursContains(String keyword) {
        return courRepository.findByNomCourContainingIgnoreCase(keyword)
                .stream()
                .map(courMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourDto> getCourByEtudiant(String username) {
        List<Inscription> inscriptions = inscriptionRepository.findByEtudiantUN(username);
        return parsingCour(inscriptions)
                .stream()
                .map(courMapper::mapToDto)
                .collect(Collectors.toList());

    }

    private List<Cour> parsingCour(List<Inscription> inscriptions){
        return inscriptions.stream()
                .map(Inscription::getCour)
                .collect(Collectors.toList());
    }


    public void deleteCour(Long id) {
        courRepository.deleteById(id);
    }

    public CourDto getCourByName(String courName) {
        return courMapper.mapToDto(courRepository.findByNomCour(courName));
    }
}
