package com.egis.sbmongo.service;

import com.egis.sbmongo.Repository.ProduitRepository;
import com.egis.sbmongo.models.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl {

    @Autowired
    private ProduitRepository produitRepository;

    public Produit saveProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public Optional<Produit> findById(String id) {
        return produitRepository.findById(id);
    }

    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @Override
    public void deleteProduit(String id) {
        Optional<Produit> data = findById(id);
        if(data.isPresent()){
            produitRepository.deleteById(id);
        }

    }
}
