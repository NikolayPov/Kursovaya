package com.example.springmodels.repos;

import com.example.springmodels.models.ExecutionStage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecutionStageRepository extends JpaRepository<ExecutionStage, Integer> {
}
