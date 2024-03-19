package com.codesmell.thef.service;

import com.codesmell.thef.model.Product;
import com.codesmell.thef.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    public Product updateProduct(Long id, Product newProd){
        Product prod = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        prod.setName(newProd.getName());
        prod.setPrice(newProd.getPrice());
        prod.setQuantity(newProd.getQuantity());
        return productRepository.save(prod);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
