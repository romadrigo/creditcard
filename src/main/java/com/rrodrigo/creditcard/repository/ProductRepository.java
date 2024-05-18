package com.rrodrigo.creditcard.repository;

import com.rrodrigo.creditcard.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
