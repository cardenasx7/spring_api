package com.api.java.spring.api_java_spring_boot.controllers;

import com.api.java.spring.api_java_spring_boot.models.Product;
import com.api.java.spring.api_java_spring_boot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public String save(@RequestBody Product product) {
    	System.out.println(product.toString());
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id, @RequestBody Product product) {
    	product.setId(id);
        return productService.update(product);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @GetMapping
    public List<Product> all() {
        return productService.all();
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
    	productService.delete(id);
    }
}
