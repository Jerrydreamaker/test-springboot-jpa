package com.iecas.testspringboot.nosql.es.service.impl;

import com.iecas.testspringboot.nosql.es.domain.Product;
import com.iecas.testspringboot.nosql.es.repo.ProductRepository;
import com.iecas.testspringboot.nosql.es.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }

    @Override
    public void deleteByProductId(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findByProductId(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Page<Product> findByProductName(String name, PageRequest pageRequest) {
        return productRepository.findByProductName(name,pageRequest);
    }

    @Override
    public List<Product> findByProductCategory(String category) {
        return productRepository.findByProductCategory(category);
    }
}
