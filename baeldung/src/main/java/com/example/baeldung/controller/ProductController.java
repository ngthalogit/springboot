package com.example.baeldung.controller;

import com.example.baeldung.model.Product;
import com.example.baeldung.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // get product list
    @GetMapping
    public ResponseEntity<Object> getAllProducts() {
        return new ResponseEntity<Object>(productService.getAllProduct(), HttpStatus.OK);
    }

    // get product by id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") String id) {
        return new ResponseEntity<Object>(productService.getProductById(id), HttpStatus.OK);
    }

    // create product
    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody Product p) {

        return new ResponseEntity<Object>(productService.saveProduct(p), HttpStatus.CREATED);
    }

    // update product
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@RequestBody Product p, @PathVariable("id") String id) {
        return new ResponseEntity<Object>(productService.updateProduct(p, id), HttpStatus.OK);
    }

    // delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
        return new ResponseEntity<Object>(productService.deleteProduct(id), HttpStatus.OK);
    }
}
