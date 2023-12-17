package com.example.springmodels.repos;

import com.example.springmodels.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CarModelRepository extends JpaRepository<CarModel, Integer> {
}
