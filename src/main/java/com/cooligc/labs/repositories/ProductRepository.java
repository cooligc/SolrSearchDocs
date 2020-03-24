package com.cooligc.labs.repositories;

import com.cooligc.labs.model.Product;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface ProductRepository extends SolrCrudRepository<Product,String> {

    Product findByName(String name);
}
