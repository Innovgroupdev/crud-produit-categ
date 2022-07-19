package com.egis.sbmongo.Repository;

import com.egis.sbmongo.models.Categorie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategorieRepository extends MongoRepository<Categorie, String> {
}
