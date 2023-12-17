package com.example.springmodels.repos;

import com.example.springmodels.models.modelUser;
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<modelUser,Long> {
    modelUser findByUsername(String username);
}
