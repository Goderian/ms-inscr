package com.example.inscriptionms.service;

import com.example.inscriptionms.model.CategorieCour;

import java.util.List;

public interface CategorieCourService {

    public void save(CategorieCour categorieCour);
    public List<CategorieCour> getAllCategories();
}
