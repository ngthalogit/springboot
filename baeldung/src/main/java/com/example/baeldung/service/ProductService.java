package com.example.baeldung.service;

import com.example.baeldung.model.Product;

import java.util.List;

public interface ProductService {
    Object getAllProduct();

    Object getProductById(String id);

    Object saveProduct(Product p);

    Object updateProduct(Product p, String id);

    Object deleteProduct(String id);
}
