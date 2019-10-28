package com.api.java.spring.api_java_spring_boot.services;

import com.api.java.spring.api_java_spring_boot.models.Product;
import com.api.java.spring.api_java_spring_boot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    private ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String save(Product product) {
        productRepository.save(product);
        return "Product Saved";
    }

    public String update(Product product) {
        Product product1Founded = productRepository.findById(product.getId()).get();
        product1Founded.setName(product.getName());
        product1Founded.setDescription(product.getDescription());
        product1Founded.setPrice(product.getPrice());
        product1Founded.setStock(product.getStock());

        productRepository.save(product1Founded);
        return "Product Updated";
    }

    public List<Product> all() {
        return (List<Product>) productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }
    
    public void delete(Long id) {
    	productRepository.deleteById(id);
    }
}
