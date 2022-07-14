package com.example.baeldung.controller.consume;

import com.example.baeldung.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@RestController
public class ConsumeWebService {

    @Autowired
    RestTemplate restTemplate;

    // create product
    @PostMapping(value = "template/products")
    public String saveProduct(@RequestBody Product p) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(p, headers);
        return restTemplate.exchange("http:8080/products", HttpMethod.POST, entity, String.class).getBody();
    }

    // get products list
    @GetMapping(value = "/template/products")
    public String getAllProduct() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(headers);
        return restTemplate.exchange("localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
    }

    // get product by id
    @GetMapping(value = "/template/products/{id}")
    public String getProductById(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(headers);
        return restTemplate.exchange("http:8080/products/" + id, HttpMethod.GET, entity, String.class).getBody();
    }

    // update product
    @PutMapping(value = "/template/products/{id}")
    public String updateProduct(@RequestBody Product p, @PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(p, headers);
        return restTemplate.exchange("localhost:8080/products/" + id, HttpMethod.PUT, entity, String.class).getBody();
    }

    // delete product
    @DeleteMapping("/template/products/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(headers);
        return restTemplate.exchange("localhost:8080/products/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }
}
