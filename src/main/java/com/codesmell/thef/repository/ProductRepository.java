package com.codesmell.thef.repository;

import com.codesmell.thef.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
