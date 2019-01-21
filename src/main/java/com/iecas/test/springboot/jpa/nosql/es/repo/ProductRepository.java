package com.iecas.testspringboot.nosql.es.repo;

import com.iecas.testspringboot.nosql.es.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product,Integer> {
    Page<Product> findByProductName(String name, PageRequest pageRequest);
    List<Product> findByProductCategory(String category);
}
