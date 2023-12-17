package com.example.springmodels.repos;

import com.example.springmodels.models.CarCategory;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CarCategoryRepository extends JpaRepository<CarCategory, Integer>{

}
