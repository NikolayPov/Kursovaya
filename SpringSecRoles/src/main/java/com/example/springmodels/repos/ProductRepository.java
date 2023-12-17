package com.example.springmodels.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springmodels.models.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    List<Product> findByProductname(String productname);
}
