package com.egis.sbmongo.controller;


import com.egis.sbmongo.models.Categorie;
import com.egis.sbmongo.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {
    @Autowired
    private CategorieService categoryService;

    @PostMapping("/create")
    public ResponseEntity<Categorie> createCateg(@RequestBody Categorie c) {
        try {
            Categorie categ = categoryService.saveCategorie(c);
                    return  new ResponseEntity<>(categ, HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Categorie> updateCateg(@PathVariable("id") String id, @RequestBody Categorie categorie) {
        Optional<Categorie> categData = categoryService.findById(id);
        if(categData.isPresent()){
            Categorie _categ = categData.get();
            _categ.setNom(categorie.getNom());
            _categ.setDescription(categorie.getDescription());
            return new ResponseEntity<>(categoryService.saveCategorie(_categ), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<HttpStatus> deleteCateg(@PathVariable("id") String id) {
        try {
            categoryService.deleteCategorie(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Categorie>> getAll() {
        try {
            List<Categorie> categories = categoryService.findAll();
            if(categories.isEmpty()){
                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
