package com.egis.sbmongo.Repository;

import com.egis.sbmongo.models.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProduitRepository extends MongoRepository<Produit, String> {
}
