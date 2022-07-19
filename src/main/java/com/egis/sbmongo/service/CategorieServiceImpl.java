package com.egis.sbmongo.service;

import com.egis.sbmongo.Repository.CategorieRepository;
import com.egis.sbmongo.models.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService{
    @Autowired
    private CategorieRepository categorieRepository;
    @Override
    public Categorie saveCategorie(Categorie c) {
        return categorieRepository.save(c);
    }

    @Override
    public Optional<Categorie> findById(String id) {
        return categorieRepository.findById(id);
    }

    @Override
    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    @Override
    public void deleteCategorie(String id) {
        Optional<Categorie> data = findById(id);
        if(data.isPresent()){
            categorieRepository.deleteById(id);
        }

    }
}
