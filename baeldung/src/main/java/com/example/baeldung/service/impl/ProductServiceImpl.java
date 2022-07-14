package com.example.baeldung.service.impl;

import com.example.baeldung.exception.ProductExceptionController;
import com.example.baeldung.model.Product;
import com.example.baeldung.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private static Map<String, Product> products = new HashMap<>();

    static {
        Product prod_1 = new Product("Honey", "1");
        Product prod_2 = new Product("Almond", "2");
        Product prod_3 = new Product("Orange", "3");
        Product prod_4 = new Product("Apple", "4");
        Product prod_5 = new Product("Lemon", "5");
        products.put(prod_1.getId(), prod_1);
        products.put(prod_2.getId(), prod_2);
        products.put(prod_3.getId(), prod_3);
        products.put(prod_4.getId(), prod_4);
        products.put(prod_5.getId(), prod_5);
    }


    @Override
    public Object getAllProduct() {
        return products.values();
    }

    @Override
    public Object getProductById(String id) {
        return products.get(id);
    }

    @Override
    public Object saveProduct(Product p) {
        products.put(p.getId(), p);
        return products.values();
    }

    @Override
    public Object updateProduct(Product p, String id) {
        Product existingProduct;
        if (products.containsKey(id))
            existingProduct = products.get(id);
        else throw new ProductExceptionController();
        existingProduct.setName(p.getName());
        products.replace(id, products.get(id), existingProduct);
        return products.values();
    }

    @Override
    public Object deleteProduct(String id) {
        Product existingProduct;
        if (products.containsKey(id))
            existingProduct = products.get(id);
        else throw new ProductExceptionController();
        products.remove(id);
        return products.values();
    }
}
