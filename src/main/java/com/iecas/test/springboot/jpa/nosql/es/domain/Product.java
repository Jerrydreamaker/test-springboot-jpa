package com.iecas.testspringboot.nosql.es.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Document(indexName = "test",type = "product")
public class Product {
    @Id
    private int id;
    private String productName;
    private String productBand;
    private String productCategory;

    public Product() {

    }

    public Product(int id, String productName, String productBand, String productCategory) {
        this.id = id;
        this.productName = productName;
        this.productBand = productBand;
        this.productCategory = productCategory;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductBand() {
        return productBand;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductBand(String productBand) {
        this.productBand = productBand;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
}
