package com.kusitms.HackathonA.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, Long> {
    Product findByProductId(Long productId);
    List<Product> findByCategory(String category);

}
