package com.egis.sbmongo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {
    @Id
    private String id;
    private String nom;
    private String description;
    //@DBRef
    //private List<Produit> produits;
}
