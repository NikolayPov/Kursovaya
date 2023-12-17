package com.example.springmodels.repos;


import com.example.springmodels.models.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer>{

}
