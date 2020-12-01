package com.example.inscriptionms.service;


import com.example.inscriptionms.dto.CourDto;

import java.util.List;

public interface CourService{

    public void save(CourDto courDto);
    public CourDto getCour(Long id);
    public List<CourDto> getCourByCategoryName(String categorie);
    public List<CourDto> getAllCours();
//    public List<CourDto> getAllCoursForStudent(Long id);
    public void deleteCour(Long id);
    public List<CourDto> getAllCoursContains(String keyword);

    public List<CourDto> getCourByEtudiant(String username);
}

