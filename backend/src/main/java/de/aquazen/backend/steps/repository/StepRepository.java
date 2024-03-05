package de.aquazen.backend.steps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StepRepository extends JpaRepository<StepEntity, Long> {
    Optional<StepEntity> findById(Long id);
}
