package com.egis.sbmongo.service;

import com.egis.sbmongo.models.Categorie;
import com.egis.sbmongo.models.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {

    public Produit saveProduit(Produit p);
    public Optional<Produit> findById(String id);
    public List<Produit> findAll();
    public void deleteProduit(String id);
}
