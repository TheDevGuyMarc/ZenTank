package de.aquazen.backend.temperature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TemperatureRepository extends JpaRepository<TemperatureEntity, Long> {
    Optional<TemperatureEntity> findById(Long id);
}
