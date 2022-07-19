package com.egis.sbmongo.controller;

import com.egis.sbmongo.models.Produit;
import com.egis.sbmongo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class produitController {
    @Autowired
    private ProduitService produitService;
    @PostMapping("/create")
    public ResponseEntity<Produit> createProduit(@RequestBody Produit p) {
        try {
            Produit produit = produitService.saveProduit(p);
            return  new ResponseEntity<>(produit, HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/produits")
    public ResponseEntity<List<Produit>> getAll() {
        try {
            List<Produit> produit = produitService.findAll();
            if(produit.isEmpty()){
                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(produit, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/produits/{id}")
    public ResponseEntity<HttpStatus> deleteProd(@PathVariable("id") String id) {
        try {
            produitService.deleteProduit(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
