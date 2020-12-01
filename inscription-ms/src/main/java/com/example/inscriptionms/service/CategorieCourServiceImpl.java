package com.example.inscriptionms.service;

import com.example.inscriptionms.model.CategorieCour;
import com.example.inscriptionms.repository.CategorieCourRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CategorieCourServiceImpl implements CategorieCourService{

    private final CategorieCourRepository categorieCourRepository;

    public void save(CategorieCour categorieCour) {
        CategorieCour categorieCour1 = categorieCourRepository.findByType(categorieCour.getType()).get();
        if (categorieCour1 != null) throw new RuntimeException("Category already exists");
        categorieCourRepository.save(categorieCour);
    }

    public List<CategorieCour> getAllCategories() {
        return categorieCourRepository.findAll();
    }
}
