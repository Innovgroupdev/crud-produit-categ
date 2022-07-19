package com.egis.sbmongo.service;

import com.egis.sbmongo.models.Categorie;

import java.util.List;
import java.util.Optional;

public interface CategorieService {
    public Categorie saveCategorie(Categorie c);
    public Optional<Categorie> findById(String id);
    public List<Categorie> findAll();
    public void deleteCategorie(String id);
}
